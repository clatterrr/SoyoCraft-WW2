package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SmokerEntity;
import com.example.examplemod.entity.custom.SoliderEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class SoliderRenderer extends GeoEntityRenderer<SoliderEntity> {

    public SoliderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoliderModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(SoliderEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/solider.png");
    }

    @Override
    public RenderType getRenderType(SoliderEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
