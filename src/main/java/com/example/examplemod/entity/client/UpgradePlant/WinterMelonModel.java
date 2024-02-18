
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.WinterMelonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WinterMelonModel extends AnimatedGeoModel<WinterMelonEntity> {

    @Override
    public ResourceLocation getModelResource(WinterMelonEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/winter_melon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WinterMelonEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/winter_melon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WinterMelonEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/winter_melon.animation.json");

    }
}

