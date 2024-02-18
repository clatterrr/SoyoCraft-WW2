package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PoolZombie.LittleDuckyTubeZombieEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LittleDuckTubeZombieModel extends AnimatedGeoModel<LittleDuckyTubeZombieEntity> {

    @Override
    public ResourceLocation getModelResource(LittleDuckyTubeZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/little_duck_tube_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LittleDuckyTubeZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/little_duck_tube_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LittleDuckyTubeZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/little_duck_tube_zombie.animation.json");

    }


}
