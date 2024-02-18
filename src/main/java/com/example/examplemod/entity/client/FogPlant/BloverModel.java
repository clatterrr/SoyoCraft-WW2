
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.BloverEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BloverModel extends AnimatedGeoModel<BloverEntity> {

    @Override
    public ResourceLocation getModelResource(BloverEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/blover.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BloverEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/blover.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BloverEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/blover.animation.json");

    }
}
