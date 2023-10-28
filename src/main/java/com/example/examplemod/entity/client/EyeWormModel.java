package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.EyeWormEntity;
import com.example.examplemod.entity.custom.GrassGiantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EyeWormModel extends AnimatedGeoModel<EyeWormEntity> {

    @Override
    public ResourceLocation getModelResource(EyeWormEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/eye_worm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EyeWormEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/eye_worm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EyeWormEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/eye_worm.animation.json");

    }


}
