package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.CactusEntity;
import com.example.examplemod.entity.custom.SunFlowerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SunFlowerModel extends AnimatedGeoModel<SunFlowerEntity> {

    @Override
    public ResourceLocation getModelResource(SunFlowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/sun_flower.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SunFlowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/sun_flower.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SunFlowerEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/sun_flower.animation.json");

    }


}
