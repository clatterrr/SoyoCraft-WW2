package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Garden.LawnMowerEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LawnMowerModel extends AnimatedGeoModel<LawnMowerEntity> {

    @Override
    public ResourceLocation getModelResource(LawnMowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/lawn_mower.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LawnMowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/lawn_mower.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LawnMowerEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/lawn_mower.animation.json");

    }


}
