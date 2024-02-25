package com.example.examplemod.entity.client.DayPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DayPlant.SnowPeaEntity;
import com.example.examplemod.entity.custom.DayPlant.WallnutEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class WallNutRenderer extends GeoEntityRenderer<WallnutEntity> {

    public WallNutRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WallNutModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(WallnutEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/wall_nut.png");
    }

    @Override
    public RenderType getRenderType(WallnutEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
