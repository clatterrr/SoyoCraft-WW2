package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.TheplayerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TheplayerModel extends AnimatedGeoModel<TheplayerEntity> {

    @Override
    public ResourceLocation getModelResource(TheplayerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/theplayer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TheplayerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/theplayer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TheplayerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/theplayer.animation.json");
    }
}