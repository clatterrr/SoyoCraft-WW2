package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PoolZombie.LittleZombieEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LittleZombieModel extends AnimatedGeoModel<LittleZombieEntity> {

    @Override
    public ResourceLocation getModelResource(LittleZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/little_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LittleZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/little_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LittleZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/little_zombie.animation.json");

    }


}
