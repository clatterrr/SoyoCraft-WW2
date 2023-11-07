package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ScaredyShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ScaredyShroomModel extends AnimatedGeoModel<ScaredyShroomEntity> {

    @Override
    public ResourceLocation getModelResource(ScaredyShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/scaredy_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScaredyShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/scaredy_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScaredyShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/scaredy_shroom.animation.json");

    }


}
