package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.InsLikesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class InsLikesModel extends AnimatedGeoModel<InsLikesEntity> {

    @Override
    public ResourceLocation getModelResource(InsLikesEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/inslikes.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(InsLikesEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/inslikes.png");
    }

    @Override
    public ResourceLocation getAnimationResource(InsLikesEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/inslikes.animation.json");
    }
}