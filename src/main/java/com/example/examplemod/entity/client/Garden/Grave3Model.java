package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Garden.Grave3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Grave3Model extends AnimatedGeoModel<Grave3Entity> {

    @Override
    public ResourceLocation getModelResource(Grave3Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/grave3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Grave3Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/grave3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Grave3Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/grave.animation.json");

    }


}
