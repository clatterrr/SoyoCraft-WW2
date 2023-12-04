package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FenceEntity;
import com.example.examplemod.entity.custom.HouseDoor1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FenceModel extends AnimatedGeoModel<FenceEntity> {

    @Override
    public ResourceLocation getModelResource(FenceEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/fence.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FenceEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/fence.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FenceEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/fence.animation.json");

    }


}
