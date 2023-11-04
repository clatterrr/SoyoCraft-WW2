package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BalloonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BalloonModel extends AnimatedGeoModel<BalloonEntity> {

    @Override
    public ResourceLocation getModelResource(BalloonEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/balloon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BalloonEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/balloon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BalloonEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/balloon.animation.json");

    }


}
