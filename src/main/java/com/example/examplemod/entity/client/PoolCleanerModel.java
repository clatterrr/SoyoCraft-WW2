package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import com.example.examplemod.entity.custom.PoolCleanerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PoolCleanerModel extends AnimatedGeoModel<PoolCleanerEntity> {

    @Override
    public ResourceLocation getModelResource(PoolCleanerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pool_cleaner.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PoolCleanerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pool_cleaner.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PoolCleanerEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pool_cleaner.animation.json");

    }


}
