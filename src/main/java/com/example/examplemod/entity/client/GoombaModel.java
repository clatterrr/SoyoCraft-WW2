package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.GoombaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoombaModel extends AnimatedGeoModel<GoombaEntity> {

    @Override
    public ResourceLocation getModelResource(GoombaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/goomba.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoombaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/goomba.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoombaEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/goomba.animation.json");

    }


}
