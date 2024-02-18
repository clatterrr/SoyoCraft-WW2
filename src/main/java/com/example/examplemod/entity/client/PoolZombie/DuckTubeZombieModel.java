package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PoolZombie.DuckTubeZombieEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DuckTubeZombieModel extends AnimatedGeoModel<DuckTubeZombieEntity> {

    @Override
    public ResourceLocation getModelResource(DuckTubeZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/duck_tube_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DuckTubeZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/duck_tube_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DuckTubeZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/duck_tube_zombie.animation.json");

    }


}
