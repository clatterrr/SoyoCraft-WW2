package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GreenPig1Entity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenPig1Model extends AnimatedGeoModel<GreenPig1Entity> {

    @Override
    public ResourceLocation getModelResource(GreenPig1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/green_pig_1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenPig1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/green_pig_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenPig1Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/green_pig_1.animation.json");

    }


}
