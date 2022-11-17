package fr.gwengwen49.ghs.clientside.render.level;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.*;
import net.minecraft.core.Registry;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.jfr.event.PacketReceivedEvent;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

@SuppressWarnings("all")
public abstract class SolarSystemPlanetEffects extends DimensionSpecialEffects {

    private VertexBuffer darkBuffer;
    private VertexBuffer skyBuffer;
    private VertexBuffer starBuffer;
    public SolarSystemPlanetEffects(int distanceToSun) {
        super(192.0f, true, SkyType.NORMAL, false, false);
        createLightSky();
        createDarkSky();
        createStars();
    }
    private static BufferBuilder.RenderedBuffer buildSkyDisc(BufferBuilder p_234268_, float p_234269_) {
        float f = Math.signum(p_234269_) * 512.0F;
        float f1 = 512.0F;

        RenderSystem.setShader(GameRenderer::getPositionShader);
        p_234268_.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
        p_234268_.vertex(0.0D, (double)p_234269_, 0.0D).endVertex();

        for(int i = -180; i <= 180; i += 45) {
            p_234268_.vertex((double)(f * Mth.cos((float)i * ((float)Math.PI / 180F))), (double)p_234269_, (double)(512.0F * Mth.sin((float)i * ((float)Math.PI / 180F)))).endVertex();
        }

        return p_234268_.end();
    }

    private void createStars() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionShader);
        if (this.starBuffer != null) {
            this.starBuffer.close();
        }

        this.starBuffer = new VertexBuffer();
        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = this.drawStars(bufferbuilder);
        this.starBuffer.bind();
        this.starBuffer.upload(bufferbuilder$renderedbuffer);
        VertexBuffer.unbind();
    }

    private BufferBuilder.RenderedBuffer drawStars(BufferBuilder p_234260_) {
        RandomSource randomsource = RandomSource.create(10842L);
        p_234260_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

        for(int i = 0; i < 1500; ++i) {
            Random random = new Random();
            double d0 = (double)(randomsource.nextFloat()* random.nextFloat(1.0f, 2.0F) - 1.0F);
            double d1 = (double)(randomsource.nextFloat()* random.nextFloat(1.0f, 2.0F) - 1.0F);
            double d2 = (double)(randomsource.nextFloat() * random.nextFloat(1.0f, 2.0F) - 1.0F);
            double d3 = (double)(0.15F + randomsource.nextFloat() * 0.1F);
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d4 < 1.0D && d4 > 0.01D) {
                d4 = 1.0D / Math.sqrt(d4);
                d0 *= d4;
                d1 *= d4;
                d2 *= d4;
                double d5 = d0 * 70.0D+randomsource.nextDouble();
                double d6 = d1 * 70.0D+randomsource.nextDouble();
                double d7 = d2 * 70.0D+randomsource.nextDouble();
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = randomsource.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for(int j = 0; j < 16; ++j) {
                    double d17 = 0.0D;
                    double d18 = (double)((j & 2) - 1) * d3;
                    double d19 = (double)((j + 1 & 2) - 1) * d3;
                    double d20 = 0.0D;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    p_234260_.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }


        return p_234260_.end();
    }
    private void createDarkSky() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        if (this.darkBuffer != null) {
            this.darkBuffer.close();
        }

        this.darkBuffer = new VertexBuffer();
        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = buildSkyDisc(bufferbuilder, -20.0F);
        this.darkBuffer.bind();
        this.darkBuffer.upload(bufferbuilder$renderedbuffer);
        VertexBuffer.unbind();
    }

    private void createLightSky() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        if (this.skyBuffer != null) {
            this.skyBuffer.close();
        }

        this.skyBuffer = new VertexBuffer();
        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = buildSkyDisc(bufferbuilder, 16.0F);
        this.skyBuffer.bind();
        this.skyBuffer.upload(bufferbuilder$renderedbuffer);
        VertexBuffer.unbind();
    }
    @Override
    public boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {

        if (!isFoggy) {
                    RenderSystem.disableTexture();
                    Vec3 vec3 = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().multiply(0.0f, 0.0f, 0.0f);
                    float f = (float)vec3.x;
                    float f1 = (float)vec3.y;
                    float f2 = (float)vec3.z;
                    BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
                    RenderSystem.depthMask(false);
                    RenderSystem.setShaderColor(f, f1, f2, 1.0F);
                    ShaderInstance shaderinstance = RenderSystem.getShader();
                    skyBuffer.bind();
                    skyBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, shaderinstance);
                    VertexBuffer.unbind();
                    RenderSystem.enableBlend();
                    RenderSystem.defaultBlendFunc();
                        RenderSystem.setShader(GameRenderer::getPositionColorShader);
                        RenderSystem.disableTexture();
                        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                        poseStack.pushPose();
                        poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                        poseStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                        Matrix4f matrix4f = poseStack.last().pose();
                        bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(0.0f, 0.0f, 0.0f, 0.0f).endVertex();
                        BufferUploader.drawWithShader(bufferbuilder.end());
                        poseStack.popPose();

                    RenderSystem.enableTexture();
                    RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    poseStack.pushPose();
                    poseStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
                    poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
                    Matrix4f matrix4f1 = poseStack.last().pose();
                    float f12 = 30.0F;
                    RenderSystem.setShader(GameRenderer::getPositionTexShader);
                    RenderSystem.setShaderTexture(0, new ResourceLocation("ghs","textures/environment/earth.png"));
                    bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferbuilder.vertex(matrix4f1, -f12, 150.0f, -f12).uv(0.0F, 0.0F).endVertex();
                    bufferbuilder.vertex(matrix4f1, f12, 150.0F, -f12).uv(1.0F, 0.0F).endVertex();
                    bufferbuilder.vertex(matrix4f1, f12, 150.0F, f12).uv(1.0F, 1.0F).endVertex();
                    bufferbuilder.vertex(matrix4f1, -f12, 150.0F, f12).uv(0.0F, 1.0F).endVertex();
                    BufferUploader.drawWithShader(bufferbuilder.end());
                        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
                        starBuffer.bind();
                        starBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
                        VertexBuffer.unbind();


                    RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 0.0F);
                    RenderSystem.disableBlend();
                    poseStack.popPose();
                    RenderSystem.disableTexture();
                    RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);
                    double d0 = Minecraft.getInstance().player.getEyePosition(partialTick).y - level.getLevelData().getHorizonHeight(level);
                    if (d0 < 0.0D) {
                        poseStack.pushPose();
                        darkBuffer.bind();
                        darkBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, shaderinstance);
                        VertexBuffer.unbind();
                        poseStack.popPose();
                    }

                    if (level.effects().hasGround()) {
                        RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
                    }

                    RenderSystem.enableTexture();
                    RenderSystem.depthMask(true);
                }
        return true;
    }

    @Override
    public boolean renderClouds(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, double camX, double camY, double camZ, Matrix4f projectionMatrix) {
        return true;
    }

    @Override
    public boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 vec3, float f) {
        return vec3.multiply(0.0F, 0.0F, 0.0F);
    }

    @Override
    public boolean isFoggyAt(int p_108874_, int p_108875_) {
        return false;
    }
}
