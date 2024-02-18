package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.PoolZombie.ZombieBobsledTeamEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZombieBobsledTeamModel extends AnimatedGeoModel<ZombieBobsledTeamEntity> {

    @Override
    public ResourceLocation getModelResource(ZombieBobsledTeamEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/zombie_bobsled_team.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZombieBobsledTeamEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/zombie_bobsled_team.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZombieBobsledTeamEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/zombie_bobsled_team.animation.json");

    }


}
