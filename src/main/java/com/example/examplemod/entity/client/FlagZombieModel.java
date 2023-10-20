package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FlagZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FlagZombieModel extends AnimatedGeoModel<FlagZombieEntity> {

    @Override
    public ResourceLocation getModelResource(FlagZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/flag_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FlagZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/flag_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FlagZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/flag_zombie.animation.json");

    }


}
