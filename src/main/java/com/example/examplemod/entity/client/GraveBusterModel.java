package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GraveBusterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GraveBusterModel extends AnimatedGeoModel<GraveBusterEntity> {

    @Override
    public ResourceLocation getModelResource(GraveBusterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/grave_buster.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GraveBusterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/grave_buster.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GraveBusterEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/grave_buster.animation.json");

    }


}
