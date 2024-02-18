package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Garden.Grave1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Grave1Model extends AnimatedGeoModel<Grave1Entity> {

    @Override
    public ResourceLocation getModelResource(Grave1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/grave1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Grave1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/grave1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Grave1Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/grave.animation.json");

    }


}
