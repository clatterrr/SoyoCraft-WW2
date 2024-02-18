package com.example.examplemod.entity.client.PoolPlant;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.PoolPlant.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ThreepeaterModel extends AnimatedGeoModel<ThreepeaterEntity> {

    @Override
    public ResourceLocation getModelResource(ThreepeaterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/threepeater.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThreepeaterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/threepeater.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThreepeaterEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/threepeater.animation.json");

    }


}
