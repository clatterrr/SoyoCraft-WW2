package com.example.examplemod.entity.client.PoolPlant;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.PoolPlant.SquashEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class SquashRenderer extends GeoEntityRenderer<SquashEntity> {
    public SquashRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new SquashModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SquashEntity p_114482_) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/squash.png");
    }

    @Override
    public RenderType getRenderType(SquashEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}