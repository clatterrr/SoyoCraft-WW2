package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.HoundEntity;
import com.example.examplemod.entity.custom.SmilesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HoundModel extends AnimatedGeoModel<HoundEntity> {

    @Override
    public ResourceLocation getModelResource(HoundEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/hound.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HoundEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/hound.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HoundEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/hound.animation.json");

    }


}
