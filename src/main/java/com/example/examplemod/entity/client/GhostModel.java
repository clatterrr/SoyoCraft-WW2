package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.GhostEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhostModel extends AnimatedGeoModel<GhostEntity> {

    @Override
    public ResourceLocation getModelResource(GhostEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/ghost.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GhostEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/ghost.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GhostEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/ghost.animation.json");
    }
}