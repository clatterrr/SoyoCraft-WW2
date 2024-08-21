package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BigzombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BigzombieModel extends AnimatedGeoModel<BigzombieEntity> {

    @Override
    public ResourceLocation getModelResource(BigzombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/bigzombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BigzombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bigzombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BigzombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/bigzombie.animation.json");
    }
}