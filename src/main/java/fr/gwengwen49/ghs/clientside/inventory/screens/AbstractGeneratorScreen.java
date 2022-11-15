package fr.gwengwen49.ghs.clientside.inventory.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import fr.gwengwen49.ghs.blocks.generators.inventory.AbstractGeneratorMenu;
import fr.gwengwen49.ghs.core.fluid.BasicContainerFluid;
import fr.gwengwen49.ghs.core.fluid.FluidContainerScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;

public abstract class AbstractGeneratorScreen <T extends AbstractGeneratorMenu> extends AbstractContainerScreen<T> {


    private final ResourceLocation texture;

    public AbstractGeneratorScreen(T p_97825_, Inventory p_97827_, Component p_97828_, ResourceLocation p_97829_) {
        super(p_97825_, p_97827_, p_97828_);

        this.texture = p_97829_;
    }

    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void containerTick() {
        super.containerTick();
    }

    public void render(PoseStack p_97858_, int p_97859_, int p_97860_, float p_97861_) {
        this.renderBackground(p_97858_);

        super.render(p_97858_, p_97859_, p_97860_, p_97861_);

        //rendu du nom des items dans le menu
        this.renderTooltip(p_97858_, p_97859_, p_97860_);
    }
//this.blit(poseStack, toReplaceX, toReplaceY, replacerX, replacerY, maximumToReplace, 4);

    protected void renderBg(PoseStack poseStack, float p_97854_, int p_97855_, int p_97856_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        int fuel = this.menu.getFuel();
        if(this.menu.isLit()){
            this.blit(poseStack, i + 80, j + 15 + 12 - fuel, 192, 12 - fuel, 16, fuel + 1);
        }
    }


    protected void slotClicked(Slot p_97848_, int p_97849_, int p_97850_, ClickType p_97851_) {
        super.slotClicked(p_97848_, p_97849_, p_97850_, p_97851_);
    }

    public void removed() {
        super.removed();
    }

}