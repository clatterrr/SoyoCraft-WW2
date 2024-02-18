package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.Garden.Stone2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Stone2Model extends AnimatedGeoModel<Stone2Entity> {

    @Override
    public ResourceLocation getModelResource(Stone2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/stone2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Stone2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/stone2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Stone2Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/stone2.animation.json");

    }


}
