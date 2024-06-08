package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.InstagramEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class InstagramModel extends AnimatedGeoModel<InstagramEntity> {

    @Override
    public ResourceLocation getModelResource(InstagramEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/instagram.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(InstagramEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/instagram.png");
    }

    @Override
    public ResourceLocation getAnimationResource(InstagramEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/instagram.animation.json");
    }
}