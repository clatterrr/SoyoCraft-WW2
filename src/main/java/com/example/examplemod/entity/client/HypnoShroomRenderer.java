package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GraveBusterEntity;
import com.example.examplemod.entity.custom.HypnoShroomEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class HypnoShroomRenderer extends GeoEntityRenderer<HypnoShroomEntity> {
    public HypnoShroomRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new HypnoShroomModel());
    }

    @Override
    public ResourceLocation getTextureLocation(HypnoShroomEntity p_114482_) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/hypno_shroom.png");
    }

    @Override
    public RenderType getRenderType(HypnoShroomEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}