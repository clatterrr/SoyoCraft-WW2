package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GrassGiantEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GrassGiantModel extends AnimatedGeoModel<GrassGiantEntity> {

    @Override
    public ResourceLocation getModelResource(GrassGiantEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/grass_giant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GrassGiantEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/grass_giant.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GrassGiantEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/grass_giant.animation.json");

    }


}
