package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ChuckBirdEntity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChuckBirdModel extends AnimatedGeoModel<ChuckBirdEntity> {

    @Override
    public ResourceLocation getModelResource(ChuckBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/chuck_bird.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChuckBirdEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/chuck_bird.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChuckBirdEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/model.animation.json");

    }


}
