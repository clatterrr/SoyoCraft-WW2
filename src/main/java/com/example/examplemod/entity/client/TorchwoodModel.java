package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import com.example.examplemod.entity.custom.TorchwoodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TorchwoodModel extends AnimatedGeoModel<TorchwoodEntity> {

    @Override
    public ResourceLocation getModelResource(TorchwoodEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/torch_wood.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TorchwoodEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/torch_wood.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TorchwoodEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/torch_wood.animation.json");

    }


}
