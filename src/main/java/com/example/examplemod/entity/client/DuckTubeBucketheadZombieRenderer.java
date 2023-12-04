package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DuckTubeBucketHeadZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class DuckTubeBucketheadZombieRenderer extends GeoEntityRenderer<DuckTubeBucketHeadZombieEntity> {

    public DuckTubeBucketheadZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DuckTubeBucketheadZombieModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(DuckTubeBucketHeadZombieEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/duck_tube_bucket_head_zombie.png");
    }

    @Override
    public RenderType getRenderType(DuckTubeBucketHeadZombieEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
