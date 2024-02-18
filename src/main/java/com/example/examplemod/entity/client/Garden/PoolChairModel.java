package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.Garden.PoolChairEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PoolChairModel extends AnimatedGeoModel<PoolChairEntity> {

    @Override
    public ResourceLocation getModelResource(PoolChairEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pool_chair.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PoolChairEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pool_chair.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PoolChairEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pool_chair.animation.json");

    }


}
