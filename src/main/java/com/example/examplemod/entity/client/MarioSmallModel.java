package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.MarioSmallEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MarioSmallModel extends AnimatedGeoModel<MarioSmallEntity> {

    @Override
    public ResourceLocation getModelResource(MarioSmallEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/mario_small.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MarioSmallEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/mario_small.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MarioSmallEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/mario_small.animation.json");

    }


}
