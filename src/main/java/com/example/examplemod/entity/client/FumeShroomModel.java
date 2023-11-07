package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FootballZombieEntity;
import com.example.examplemod.entity.custom.FumeShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FumeShroomModel extends AnimatedGeoModel<FumeShroomEntity> {

    @Override
    public ResourceLocation getModelResource(FumeShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/fume_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FumeShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/fume_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FumeShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/fume_shroom.animation.json");

    }


}
