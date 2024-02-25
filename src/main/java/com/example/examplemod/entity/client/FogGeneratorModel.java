package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.FogGeneratorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FogGeneratorModel extends AnimatedGeoModel<FogGeneratorEntity> {

    @Override
    public ResourceLocation getModelResource(FogGeneratorEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/fog_generator.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FogGeneratorEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/fog_generator.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FogGeneratorEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/fog_generator.animation.json");

    }


}
