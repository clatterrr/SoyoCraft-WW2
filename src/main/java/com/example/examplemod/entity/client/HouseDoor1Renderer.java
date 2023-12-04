package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Grave3Entity;
import com.example.examplemod.entity.custom.HouseDoor1Entity;
import com.example.examplemod.entity.custom.HouseDoor2Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class HouseDoor1Renderer extends GeoEntityRenderer<HouseDoor1Entity> {

    public HouseDoor1Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HouseDoor1Model());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(HouseDoor1Entity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/house_door_1.png");
    }

    @Override
    public RenderType getRenderType(HouseDoor1Entity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }



}
