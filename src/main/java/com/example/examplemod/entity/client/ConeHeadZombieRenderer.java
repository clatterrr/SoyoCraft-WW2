package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ConeHeadZombieEntity;
import com.example.examplemod.entity.custom.FlagZombieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ConeHeadZombieRenderer extends GeoEntityRenderer<ConeHeadZombieEntity> {

    public ConeHeadZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ConeHeadZombieModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(ConeHeadZombieEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cone_head_zombie.png");
    }

    @Override
    public RenderType getRenderType(ConeHeadZombieEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
