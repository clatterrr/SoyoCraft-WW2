package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SnowPeaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnowPeaModel extends AnimatedGeoModel<SnowPeaEntity> {

    @Override
    public ResourceLocation getModelResource(SnowPeaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/snow_pea.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SnowPeaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/snow_pea.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SnowPeaEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/snow_pea.animation.json");

    }


}
