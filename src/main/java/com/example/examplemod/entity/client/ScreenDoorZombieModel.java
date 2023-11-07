package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ScreenDoorZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ScreenDoorZombieModel extends AnimatedGeoModel<ScreenDoorZombieEntity> {

    @Override
    public ResourceLocation getModelResource(ScreenDoorZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/screen_door_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScreenDoorZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/screen_door_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScreenDoorZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/screen_door_zombie.animation.json");

    }


}
