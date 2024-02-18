package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.Garden.SubmarineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SubMarineModel extends AnimatedGeoModel<SubmarineEntity> {

    @Override
    public ResourceLocation getModelResource(SubmarineEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/submarine.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SubmarineEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/submarine.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SubmarineEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/submarine.animation.json");

    }


}
