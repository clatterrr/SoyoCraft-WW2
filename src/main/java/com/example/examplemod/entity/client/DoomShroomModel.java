package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DoomShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoomShroomModel extends AnimatedGeoModel<DoomShroomEntity> {

    @Override
    public ResourceLocation getModelResource(DoomShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/doom_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DoomShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/doom_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DoomShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/doom_shroom.animation.json");

    }


}
