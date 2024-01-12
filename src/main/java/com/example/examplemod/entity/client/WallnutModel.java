package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import com.example.examplemod.entity.custom.WallnutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WallnutModel extends AnimatedGeoModel<WallnutEntity> {

    @Override
    public ResourceLocation getModelResource(WallnutEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/wall_nut.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WallnutEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/wall_nut.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WallnutEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/wall_nut.animation.json");

    }


}
