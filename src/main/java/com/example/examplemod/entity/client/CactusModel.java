package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.CactusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CactusModel extends AnimatedGeoModel<CactusEntity> {

    @Override
    public ResourceLocation getModelResource(CactusEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cactus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CactusEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cactus.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CactusEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cactus.animation.json");

    }


}
