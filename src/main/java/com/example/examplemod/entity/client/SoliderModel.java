package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SmokerEntity;
import com.example.examplemod.entity.custom.SoliderEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SoliderModel extends AnimatedGeoModel<SoliderEntity> {

    @Override
    public ResourceLocation getModelResource(SoliderEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/solider_ak47.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoliderEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/solider_ak47.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoliderEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/solider_ak47.animation.json");

    }


}
