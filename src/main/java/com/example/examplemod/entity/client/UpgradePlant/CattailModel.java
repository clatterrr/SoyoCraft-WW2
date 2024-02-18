
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.CattailEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CattailModel extends AnimatedGeoModel<CattailEntity> {

    @Override
    public ResourceLocation getModelResource(CattailEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cattail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CattailEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cattail.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CattailEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cattail.animation.json");

    }
}

