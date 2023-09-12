package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SmokerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SmokerModel extends AnimatedGeoModel<SmokerEntity> {

    @Override
    public ResourceLocation getModelResource(SmokerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/smiler.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SmokerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/smiler.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SmokerEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/smiler.animation.json");

    }


}
