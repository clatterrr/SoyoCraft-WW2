package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PlaneEntity;
import com.example.examplemod.entity.custom.TankEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlaneModel extends AnimatedGeoModel<PlaneEntity> {

    @Override
    public ResourceLocation getModelResource(PlaneEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/plane.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlaneEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/plane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlaneEntity  animatable) {
        return new ResourceLocation(ExampleMod.MODID, "animations/plane.animation.json");

    }


}
