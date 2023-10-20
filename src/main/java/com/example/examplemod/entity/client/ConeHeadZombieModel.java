package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ConeHeadZombieEntity;
import com.example.examplemod.entity.custom.FlagZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ConeHeadZombieModel extends AnimatedGeoModel<ConeHeadZombieEntity> {

    @Override
    public ResourceLocation getModelResource(ConeHeadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cone_head_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ConeHeadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cone_head_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ConeHeadZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cone_head_zombie.animation.json");

    }


}
