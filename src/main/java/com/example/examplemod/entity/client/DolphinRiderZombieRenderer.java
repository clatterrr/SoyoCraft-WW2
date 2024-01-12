package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DolphinRiderZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class DolphinRiderZombieRenderer extends GeoEntityRenderer<DolphinRiderZombieEntity> {

    public DolphinRiderZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DolphinRiderZombieModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(DolphinRiderZombieEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/dolphin_rider_zombie.png");
    }

    @Override
    public RenderType getRenderType(DolphinRiderZombieEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
