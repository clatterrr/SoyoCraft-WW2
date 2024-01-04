package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BirdEggEntity;
import com.example.examplemod.entity.custom.GreenPig3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BirdEggModel extends AnimatedGeoModel<BirdEggEntity> {

    @Override
    public ResourceLocation getModelResource(BirdEggEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/bird_egg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BirdEggEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bird_egg.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BirdEggEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/bird_egg.animation.json");

    }


}
