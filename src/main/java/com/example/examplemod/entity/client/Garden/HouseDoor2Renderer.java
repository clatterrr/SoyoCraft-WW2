package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Garden.HouseDoor2Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class HouseDoor2Renderer extends GeoEntityRenderer<HouseDoor2Entity> {

    public HouseDoor2Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HouseDoor2Model());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(HouseDoor2Entity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/house_door_2.png");
    }

    @Override
    public RenderType getRenderType(HouseDoor2Entity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
