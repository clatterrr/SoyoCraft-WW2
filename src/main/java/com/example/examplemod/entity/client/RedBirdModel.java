package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RedBirdEntity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedBirdModel extends AnimatedGeoModel<RedBirdEntity> {

    @Override
    public ResourceLocation getModelResource(RedBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/red_bird.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/red_bird.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedBirdEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/red_bird.animation.json");

    }


}
