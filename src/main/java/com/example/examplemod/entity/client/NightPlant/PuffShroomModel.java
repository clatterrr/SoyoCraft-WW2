package com.example.examplemod.entity.client.NightPlant;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.NightPlant.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PuffShroomModel extends AnimatedGeoModel<PuffShroomEntity> {

    @Override
    public ResourceLocation getModelResource(PuffShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/puff_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PuffShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/puff_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PuffShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/puff_shroom.animation.json");

    }


}
