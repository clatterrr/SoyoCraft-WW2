package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.TiktokLikesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TiktokLikesModel extends AnimatedGeoModel<TiktokLikesEntity> {

    @Override
    public ResourceLocation getModelResource(TiktokLikesEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/tiktoklikes.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TiktokLikesEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/tiktoklikes.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TiktokLikesEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/tiktoklikes.animation.json");
    }
}