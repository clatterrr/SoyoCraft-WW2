package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.YoutubeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YoutubeModel extends AnimatedGeoModel<YoutubeEntity> {

    @Override
    public ResourceLocation getModelResource(YoutubeEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/youtube.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(YoutubeEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/youtube.png");
    }

    @Override
    public ResourceLocation getAnimationResource(YoutubeEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/youtube.animation.json");
    }
}