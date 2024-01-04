package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BirdEggEntity;
import com.example.examplemod.entity.custom.TheVillagerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TheVillagerModel extends AnimatedGeoModel<TheVillagerEntity> {

    @Override
    public ResourceLocation getModelResource(TheVillagerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/the_villager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TheVillagerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/the_villager.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TheVillagerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/the_villager.animation.json");

    }


}
