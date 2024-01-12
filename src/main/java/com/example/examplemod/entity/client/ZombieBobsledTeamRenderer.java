package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import com.example.examplemod.entity.custom.ZombieBobsledTeamEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ZombieBobsledTeamRenderer extends GeoEntityRenderer<ZombieBobsledTeamEntity> {

    public ZombieBobsledTeamRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ZombieBobsledTeamModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(ZombieBobsledTeamEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/zombie_bobsled_team.png");
    }

    @Override
    public RenderType getRenderType(ZombieBobsledTeamEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
