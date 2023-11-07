package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.custom.DancingZombieEntity;
import com.example.examplemod.entity.custom.DoomShroomEntity;
import com.example.examplemod.entity.custom.ZombieHandEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class DoomShroomRenderer extends GeoEntityRenderer<DoomShroomEntity> {
    public DoomShroomRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new DoomShroomModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DoomShroomEntity p_114482_) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/doom_shroom.png");
    }

    @Override
    public RenderType getRenderType(DoomShroomEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}