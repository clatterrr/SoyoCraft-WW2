package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SunShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SunShroomModel extends AnimatedGeoModel<SunShroomEntity> {

    @Override
    public ResourceLocation getModelResource(SunShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/sun_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SunShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/sun_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SunShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/sun_shroom.animation.json");

    }


}
