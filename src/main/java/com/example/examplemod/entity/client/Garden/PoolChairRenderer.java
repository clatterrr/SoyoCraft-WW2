package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.Garden.PoolChairEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class PoolChairRenderer extends GeoEntityRenderer<PoolChairEntity> {

    public PoolChairRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PoolChairModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(PoolChairEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pool_chair.png");
    }

    @Override
    public RenderType getRenderType(PoolChairEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
