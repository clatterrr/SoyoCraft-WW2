package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PoolZombie.DolphinRiderZombieEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DolphinRiderZombieModel extends AnimatedGeoModel<DolphinRiderZombieEntity> {

    @Override
    public ResourceLocation getModelResource(DolphinRiderZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/dolphin_rider_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DolphinRiderZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/dolphin_rider_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DolphinRiderZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/dolphin_rider_zombie.animation.json");

    }


}
