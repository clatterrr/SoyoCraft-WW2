package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GreenPig3Entity;
import com.example.examplemod.entity.custom.ThreepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenPig3Model extends AnimatedGeoModel<GreenPig3Entity> {

    @Override
    public ResourceLocation getModelResource(GreenPig3Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/green_pig_3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenPig3Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/green_pig_3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenPig3Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/model.animation.json");

    }


}
