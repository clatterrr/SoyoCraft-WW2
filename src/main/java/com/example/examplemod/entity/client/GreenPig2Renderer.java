package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ChuckBirdEntity;
import com.example.examplemod.entity.custom.GreenPig2Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class GreenPig2Renderer extends GeoEntityRenderer<GreenPig2Entity> {
    public GreenPig2Renderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new GreenPig2Model());
    }

    @Override
    public ResourceLocation getTextureLocation(GreenPig2Entity p_114482_) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/green_pig_2.png");
    }

    @Override
    public RenderType getRenderType(GreenPig2Entity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}