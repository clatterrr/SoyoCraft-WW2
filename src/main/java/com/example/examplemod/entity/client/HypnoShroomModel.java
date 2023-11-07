package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.HypnoShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HypnoShroomModel extends AnimatedGeoModel<HypnoShroomEntity> {

    @Override
    public ResourceLocation getModelResource(HypnoShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/hypno_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HypnoShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/hypno_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HypnoShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/hypno_shroom.animation.json");

    }


}
