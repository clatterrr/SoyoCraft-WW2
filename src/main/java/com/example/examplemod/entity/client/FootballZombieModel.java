package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FootballZombieModel extends AnimatedGeoModel<NormalZombieEntity> {

    @Override
    public ResourceLocation getModelResource(NormalZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/normal_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NormalZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/normal_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NormalZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/normal_zombie.animation.json");

    }


}
