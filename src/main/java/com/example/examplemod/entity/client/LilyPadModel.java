package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.LilyPadEntity;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LilyPadModel extends AnimatedGeoModel<LilyPadEntity> {

    @Override
    public ResourceLocation getModelResource(LilyPadEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/lily_pad.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LilyPadEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/lily_pad.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LilyPadEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/lily_pad.animation.json");

    }


}
