package com.example.examplemod.entity.client.DayPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DayPlant.RepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RepeaterModel extends AnimatedGeoModel<RepeaterEntity> {

    @Override
    public ResourceLocation getModelResource(RepeaterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/repeater.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RepeaterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/repeater.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RepeaterEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/repeater.animation.json");

    }


}
