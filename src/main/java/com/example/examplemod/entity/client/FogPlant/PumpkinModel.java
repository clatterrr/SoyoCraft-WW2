
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.PumpkinEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PumpkinModel extends AnimatedGeoModel<PumpkinEntity> {

    @Override
    public ResourceLocation getModelResource(PumpkinEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pumpkin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PumpkinEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pumpkin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PumpkinEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pumpkin.animation.json");

    }
}
