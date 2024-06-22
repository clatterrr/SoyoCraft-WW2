package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PlayerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlayerModel extends AnimatedGeoModel<PlayerEntity> {

    @Override
    public ResourceLocation getModelResource(PlayerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/player.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlayerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/player.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/player.animation.json");
    }
}