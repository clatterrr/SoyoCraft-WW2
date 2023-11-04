package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BacteriaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BacteriaModel extends AnimatedGeoModel<BacteriaEntity> {

    @Override
    public ResourceLocation getModelResource(BacteriaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/bacteria.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BacteriaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bacteria.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BacteriaEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/bacteria.animation.json");

    }


}
