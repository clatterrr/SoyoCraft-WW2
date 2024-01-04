package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GreenPig2Entity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenPig2Model extends AnimatedGeoModel<GreenPig2Entity> {

    @Override
    public ResourceLocation getModelResource(GreenPig2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/green_pig_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenPig2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/green_pig_2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenPig2Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/model.animation.json");

    }


}
