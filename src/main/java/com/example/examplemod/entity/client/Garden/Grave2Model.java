package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Garden.Grave2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Grave2Model extends AnimatedGeoModel<Grave2Entity> {

    @Override
    public ResourceLocation getModelResource(Grave2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/grave2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Grave2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/grave2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Grave2Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/grave.animation.json");

    }


}
