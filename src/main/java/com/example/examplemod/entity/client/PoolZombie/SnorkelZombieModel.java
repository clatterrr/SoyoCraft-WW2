package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.PoolZombie.SnorkelZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnorkelZombieModel extends AnimatedGeoModel<SnorkelZombieEntity> {

    @Override
    public ResourceLocation getModelResource(SnorkelZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/snorkel_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SnorkelZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/snorkel_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SnorkelZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/snorkel_zombie.animation.json");

    }


}
