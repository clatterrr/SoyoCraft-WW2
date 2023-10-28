package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.EyeWormEntity;
import com.example.examplemod.entity.custom.SnowArmEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnowArmModel extends AnimatedGeoModel<SnowArmEntity> {

    @Override
    public ResourceLocation getModelResource(SnowArmEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/snow_arm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SnowArmEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/snow_arm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SnowArmEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/snow_arm.animation.json");

    }


}
