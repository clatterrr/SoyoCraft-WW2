package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Car2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Car2Model extends AnimatedGeoModel<Car2Entity> {

    @Override
    public ResourceLocation getModelResource(Car2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/car2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Car2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/car2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Car2Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/car2.animation.json");
    }
}