package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SubsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SubsModel extends AnimatedGeoModel<SubsEntity> {

    @Override
    public ResourceLocation getModelResource(SubsEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/subs.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SubsEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/subs.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SubsEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/subs.animation.json");
    }
}