
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.MariGoldEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MariGoldModel extends AnimatedGeoModel<MariGoldEntity> {

    @Override
    public ResourceLocation getModelResource(MariGoldEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/marigold.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MariGoldEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/marigold.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MariGoldEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/marigold.animation.json");

    }
}
