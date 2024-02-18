package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.Garden.Stone1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Stone1Model extends AnimatedGeoModel<Stone1Entity> {

    @Override
    public ResourceLocation getModelResource(Stone1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/stone1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Stone1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/stone1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Stone1Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/stone1.animation.json");

    }


}
