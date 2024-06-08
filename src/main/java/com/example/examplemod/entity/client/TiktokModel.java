package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.TiktokEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TiktokModel extends AnimatedGeoModel<TiktokEntity> {

    @Override
    public ResourceLocation getModelResource(TiktokEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/tiktok.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TiktokEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/tiktok.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TiktokEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/tiktok.animation.json");
    }
}