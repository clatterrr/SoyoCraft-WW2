package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.JalapenoEntity;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JalapenoModel extends AnimatedGeoModel<JalapenoEntity> {

    @Override
    public ResourceLocation getModelResource(JalapenoEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/jalapeno.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JalapenoEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/jalapeno.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JalapenoEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/jalapeno.animation.json");

    }


}
