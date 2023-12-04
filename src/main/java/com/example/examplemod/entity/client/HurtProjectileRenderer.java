package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.custom.HurtProjectileEntity;
import com.example.examplemod.entity.custom.SporesProjectileEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class HurtProjectileRenderer extends EntityRenderer<HurtProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MODID, "textures/entity/hurtt_projectile.png");
    protected HurtProjectileModel model;

    public HurtProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new HurtProjectileModel(pContext.bakeLayer(ModModelLayers.HURT_PROJECTILE_LAYER));
        this.shadowRadius = 0.5f;
    }

    public void render(HurtProjectileEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
       /*
        pPoseStack.pushPose();
        //pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot()) - 90.0F));
        //pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), true, true);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.RED_OVERLAY_V, 0.0f, 0.0f, 0.0f, 0f);
        pPoseStack.popPose();
        */
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }


    @Override
    public ResourceLocation getTextureLocation(HurtProjectileEntity pEntity) {
        return TEXTURE;
    }
}