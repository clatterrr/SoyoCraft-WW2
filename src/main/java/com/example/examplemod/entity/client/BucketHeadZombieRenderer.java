package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BucketHeadZombieEntity;
import com.example.examplemod.entity.custom.FlagZombieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class BucketHeadZombieRenderer extends GeoEntityRenderer<BucketHeadZombieEntity> {

    public BucketHeadZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BucketHeadZombieModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(BucketHeadZombieEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bucket_head_zombie.png");
    }

    @Override
    public RenderType getRenderType(BucketHeadZombieEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
