package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Car1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Car1Model extends AnimatedGeoModel<Car1Entity> {

    @Override
    public ResourceLocation getModelResource(Car1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/car1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Car1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/car1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Car1Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/car1.animation.json");
    }
}