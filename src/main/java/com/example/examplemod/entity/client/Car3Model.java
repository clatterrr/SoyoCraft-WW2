package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Car3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Car3Model extends AnimatedGeoModel<Car3Entity> {

    @Override
    public ResourceLocation getModelResource(Car3Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/car3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Car3Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/car3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Car3Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/car3.animation.json");
    }
}