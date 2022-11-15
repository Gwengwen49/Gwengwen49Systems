package fr.gwengwen49.ghs.core.fluid;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;


public interface FluidContainerScreen<T extends ContainerFluidBlock> {
    TextureManager manager = Minecraft.getInstance().getTextureManager();
    AbstractTexture fluidTexture = manager.getTexture(null);

    default <U extends AbstractContainerScreen> void createFluidGauge(U containerScreen, T fluid){
        RenderSystem.setShaderTexture(15, fluid.getFluidContainerTextureLocation());
    }
    default <U extends AbstractContainerScreen> void createFluidGauge(U containerScreen, ResourceLocation fluid){
        RenderSystem.setShaderTexture(15, fluid);
    }
    default <U extends AbstractContainerScreen> void updateFluidGauge(U containerScreen, T fluid){

    }
}
