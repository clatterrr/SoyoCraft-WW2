package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BombBirdEntity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BombBirdModel extends AnimatedGeoModel<BombBirdEntity> {

    @Override
    public ResourceLocation getModelResource(BombBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/bomb_bird.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BombBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bomb_bird.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BombBirdEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/model.animation.json");

    }


}
