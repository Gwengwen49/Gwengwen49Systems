package fr.gwengwen49.ghs.core.fluid;

import com.mojang.blaze3d.platform.TextureUtil;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.function.Supplier;

public abstract class ContainerFluidBlock extends LiquidBlock {

    private final ResourceLocation containerTextureLocation;

    public ContainerFluidBlock(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_, ResourceLocation containerTextureLocation) {
        super(p_54694_, p_54695_);
        this.containerTextureLocation = containerTextureLocation;
    }


    public ResourceLocation getFluidContainerTextureLocation() {
        return containerTextureLocation;
    }


}
