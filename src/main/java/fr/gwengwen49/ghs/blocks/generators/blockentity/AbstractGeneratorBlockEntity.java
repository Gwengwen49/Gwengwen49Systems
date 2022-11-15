package fr.gwengwen49.ghs.blocks.generators.blockentity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.packs.PackSelectionScreen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.renderable.IRenderable;
import net.minecraftforge.common.ForgeConfig;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public abstract class AbstractGeneratorBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    protected static final int FUEL_SLOT = 0;
    public static final int DATA_LIT_TIME = 0;
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;
    public static final int BURN_TIME_STANDARD = 200;
    public static final int BURN_COOL_SPEED = 2;
    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    int gaugeProgress;
    int fuel;

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int index) {
            switch(index) {
                case 0:
                    return AbstractGeneratorBlockEntity.this.gaugeProgress;
                case 1:
                    return AbstractGeneratorBlockEntity.this.fuel;
                default:
                    return 0;
            }
        }

        public void set(int index, int value) {
            switch(index) {
                case 0:
                    AbstractGeneratorBlockEntity.this.gaugeProgress = value;
                    break;
                case 1:
                    AbstractGeneratorBlockEntity.this.fuel = value;
                    break;
            }

        }

        public int getCount() {
            return 2;
        }
    };

    protected AbstractGeneratorBlockEntity(BlockEntityType<?> p_154991_, BlockPos p_154992_, BlockState p_154993_) {
        super(p_154991_, p_154992_, p_154993_);
        this.fuel = 20;
    }


    private boolean isLit() {
        return this.fuel > 0;
    }

    public void load(CompoundTag tag) {
        super.load(tag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items);
        this.gaugeProgress = tag.getInt("GaugeStatus");
        this.fuel = tag.getShort("Fuel");


    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("GaugeStatus", this.gaugeProgress);
        tag.putShort("Fuel", (short) this.fuel);
        ContainerHelper.saveAllItems(tag, this.items);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, AbstractGeneratorBlockEntity blockEntity) {
        ItemStack itemstack = blockEntity.items.get(0);
        if (blockEntity.fuel <= 0 && itemstack.is(Items.LAVA_BUCKET)) {
            blockEntity.fuel = 20;
            itemstack.shrink(1);
            setChanged(level, blockPos, blockState);
        }
        if(blockEntity.fuel > 0){
            --blockEntity.fuel;
        }

    }

    public int[] getSlotsForFace(Direction p_58363_) {
        if (p_58363_ == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return p_58363_ == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    public boolean canPlaceItemThroughFace(int p_58336_, ItemStack p_58337_, @Nullable Direction p_58338_) {
        return this.canPlaceItem(p_58336_, p_58337_);
    }

    public boolean canTakeItemThroughFace(int p_58392_, ItemStack p_58393_, Direction p_58394_) {
        if (p_58394_ == Direction.DOWN && p_58392_ == 1) {
            return p_58393_.is(Items.WATER_BUCKET) || p_58393_.is(Items.BUCKET);
        } else {
            return true;
        }
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getItem(int p_58328_) {
        return this.items.get(p_58328_);
    }

    public ItemStack removeItem(int p_58330_, int p_58331_) {
        return ContainerHelper.removeItem(this.items, p_58330_, p_58331_);
    }

    public ItemStack removeItemNoUpdate(int p_58387_) {
        return ContainerHelper.takeItem(this.items, p_58387_);
    }

    public void setItem(int p_58333_, ItemStack p_58334_) {
        ItemStack itemstack = this.items.get(p_58333_);
        boolean flag = !p_58334_.isEmpty() && p_58334_.sameItem(itemstack) && ItemStack.tagMatches(p_58334_, itemstack);
        this.items.set(p_58333_, p_58334_);
        if (p_58334_.getCount() > this.getMaxStackSize()) {
            p_58334_.setCount(this.getMaxStackSize());
        }

    }

    public boolean stillValid(@NotNull Player p_58340_) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return p_58340_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    public boolean canPlaceItem(int p_58389_, ItemStack itemStack) {

            return itemStack.getItem() == Items.LAVA_BUCKET;
    }

    public void clearContent() {
        this.items.clear();
    }

    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override
    @SuppressWarnings("all")
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        for (int x = 0; x < handlers.length; x++)
            handlers[x].invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.handlers = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
    }
}
