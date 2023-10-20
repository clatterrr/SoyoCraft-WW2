package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.ChomperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChomperModel extends AnimatedGeoModel<ChomperEntity> {

    @Override
    public ResourceLocation getModelResource(ChomperEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/chomper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChomperEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/chomper.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChomperEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/chomper.animation.json");

    }


}
