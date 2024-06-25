package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.EnemyzombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnemyzombieModel extends AnimatedGeoModel<EnemyzombieEntity> {

    @Override
    public ResourceLocation getModelResource(EnemyzombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/enemyzombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnemyzombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/enemyzombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnemyzombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/enemyzombie.animation.json");
    }
}