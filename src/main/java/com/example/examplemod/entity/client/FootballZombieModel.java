package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FootballZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FootballZombieModel extends AnimatedGeoModel<FootballZombieEntity> {

    @Override
    public ResourceLocation getModelResource(FootballZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/football_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FootballZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/football_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FootballZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/football_zombie.animation.json");

    }


}
