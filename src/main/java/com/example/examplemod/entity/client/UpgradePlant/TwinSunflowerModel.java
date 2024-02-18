
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.TwinSunflowerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TwinSunflowerModel extends AnimatedGeoModel<TwinSunflowerEntity> {

    @Override
    public ResourceLocation getModelResource(TwinSunflowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/twin_sunflower.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TwinSunflowerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/twin_sunflower.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TwinSunflowerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/twin_sunflower.animation.json");

    }
}

