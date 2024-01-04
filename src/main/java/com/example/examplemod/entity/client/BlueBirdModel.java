package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BlueBirdEntity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueBirdModel extends AnimatedGeoModel<BlueBirdEntity> {

    @Override
    public ResourceLocation getModelResource(BlueBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/blue_bird.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/blue_bird.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueBirdEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/model.animation.json");

    }


}
