package com.example.examplemod.entity.client.PoolZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PoolZombie.SledEntity;
import com.example.examplemod.entity.custom.PoolZombie.ZombieBobsledTeamEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SledModel extends AnimatedGeoModel<SledEntity> {

    @Override
    public ResourceLocation getModelResource(SledEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/sled.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SledEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/sled.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SledEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/sled.animation.json");

    }


}
