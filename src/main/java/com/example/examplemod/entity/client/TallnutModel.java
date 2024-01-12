package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import com.example.examplemod.entity.custom.TallnutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TallnutModel extends AnimatedGeoModel<TallnutEntity> {

    @Override
    public ResourceLocation getModelResource(TallnutEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/tall_nut.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TallnutEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/tall_nut.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TallnutEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/tall_nut.animation.json");

    }


}
