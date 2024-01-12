package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import com.example.examplemod.entity.custom.ZomboniEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZomboniModel extends AnimatedGeoModel<ZomboniEntity> {

    @Override
    public ResourceLocation getModelResource(ZomboniEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/zomboni.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZomboniEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/zomboni.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZomboniEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/zomboni.animation.json");

    }


}
