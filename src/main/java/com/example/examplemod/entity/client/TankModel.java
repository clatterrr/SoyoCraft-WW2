package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.TankEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TankModel extends AnimatedGeoModel<TankEntity> {

    @Override
    public ResourceLocation getModelResource(TankEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/tank.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TankEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/tank.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TankEntity  animatable) {
        return new ResourceLocation(ExampleMod.MODID, "animations/tank.animation.json");

    }


}
