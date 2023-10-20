package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.CherryBombEntity;
import com.example.examplemod.entity.custom.PeaShooterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CherryBombModel extends AnimatedGeoModel<CherryBombEntity> {

    @Override
    public ResourceLocation getModelResource(CherryBombEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cherry_bomb.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CherryBombEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cherry_bomb.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CherryBombEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cherry_bomb.animation.json");

    }


}
