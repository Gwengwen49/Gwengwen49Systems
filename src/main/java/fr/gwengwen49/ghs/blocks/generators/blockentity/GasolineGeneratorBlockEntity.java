package fr.gwengwen49.ghs.blocks.generators.blockentity;

import fr.gwengwen49.ghs.blocks.generators.inventory.GasolineGeneratorMenu;
import fr.gwengwen49.ghs.registry.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
public class GasolineGeneratorBlockEntity extends AbstractGeneratorBlockEntity
{
    public GasolineGeneratorBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
        super(BlockEntityTypes.GASOLINE_GENERATOR_BLOCK_ENTITY.get(), p_155545_, p_155546_);
    }

    protected Component getDefaultName() {
        return Component.translatable("container.gasoline_generator");
    }

    protected AbstractContainerMenu createMenu(int p_59293_, Inventory p_59294_) {
        return new GasolineGeneratorMenu(p_59293_, p_59294_, this, this.dataAccess);

    }
}
