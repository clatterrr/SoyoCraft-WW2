package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.IceShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IceShroomModel extends AnimatedGeoModel<IceShroomEntity> {

    @Override
    public ResourceLocation getModelResource(IceShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/ice_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/ice_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/ice_shroom.animation.json");

    }


}
