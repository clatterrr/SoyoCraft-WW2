package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.MarioEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MarioModel extends AnimatedGeoModel<MarioEntity> {

    @Override
    public ResourceLocation getModelResource(MarioEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/mario.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MarioEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/mario.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MarioEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/mario.animation.json");

    }


}
