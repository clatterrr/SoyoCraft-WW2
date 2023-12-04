package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AshZombieModel extends AnimatedGeoModel<AshZombieEntity> {

    @Override
    public ResourceLocation getModelResource(AshZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/ash_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AshZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/ash_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AshZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/ash_zombie.animation.json");

    }


}
