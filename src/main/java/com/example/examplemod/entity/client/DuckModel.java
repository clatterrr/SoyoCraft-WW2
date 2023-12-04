package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DuckEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DuckModel extends AnimatedGeoModel<DuckEntity> {

    @Override
    public ResourceLocation getModelResource(DuckEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/duck.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DuckEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/duck.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DuckEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/duck.animation.json");

    }


}
