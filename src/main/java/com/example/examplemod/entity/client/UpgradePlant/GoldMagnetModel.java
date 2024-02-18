
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.GoldMagnetEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldMagnetModel extends AnimatedGeoModel<GoldMagnetEntity> {

    @Override
    public ResourceLocation getModelResource(GoldMagnetEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/gold_maget.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldMagnetEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/gold_maget.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldMagnetEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/gold_maget.animation.json");

    }
}

