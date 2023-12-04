package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ConeheadZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ConeheadZombieModel extends AnimatedGeoModel<ConeheadZombieEntity> {

    @Override
    public ResourceLocation getModelResource(ConeheadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cone_head_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ConeheadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cone_head_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ConeheadZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cone_head_zombie.animation.json");

    }


}
