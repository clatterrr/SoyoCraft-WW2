package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Grave1Entity;
import com.example.examplemod.entity.custom.LifeGuradTowerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LifeGuardTowerModel extends AnimatedGeoModel<LifeGuradTowerEntity> {

    @Override
    public ResourceLocation getModelResource(LifeGuradTowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/life_guard_tower.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LifeGuradTowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/life_guard_tower.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LifeGuradTowerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/life_guard_tower.animation.json");

    }


}
