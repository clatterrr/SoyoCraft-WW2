package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import com.example.examplemod.entity.custom.SquashEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SquashModel extends AnimatedGeoModel<SquashEntity> {

    @Override
    public ResourceLocation getModelResource(SquashEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/squash.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SquashEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/squash.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SquashEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/squash.animation.json");

    }


}
