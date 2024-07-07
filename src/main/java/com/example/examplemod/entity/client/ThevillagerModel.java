package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ThevillagerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ThevillagerModel extends AnimatedGeoModel<ThevillagerEntity> {

    @Override
    public ResourceLocation getModelResource(ThevillagerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/thevillager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThevillagerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/thevillager.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThevillagerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/thevillager.animation.json");
    }
}