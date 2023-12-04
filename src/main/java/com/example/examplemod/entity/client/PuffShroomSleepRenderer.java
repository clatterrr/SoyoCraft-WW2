package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.LilyPadEntity;
import com.example.examplemod.entity.custom.PuffShroomSleepEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class PuffShroomSleepRenderer extends GeoEntityRenderer<PuffShroomSleepEntity> {
    public PuffShroomSleepRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new PuffShroomSleepModel());
    }

    @Override
    public ResourceLocation getTextureLocation(PuffShroomSleepEntity p_114482_) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/puff_shroom_sleep.png");
    }

    @Override
    public RenderType getRenderType(PuffShroomSleepEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}