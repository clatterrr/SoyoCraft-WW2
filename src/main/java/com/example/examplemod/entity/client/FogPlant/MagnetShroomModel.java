
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.MagnetShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MagnetShroomModel extends AnimatedGeoModel<MagnetShroomEntity> {

    @Override
    public ResourceLocation getModelResource(MagnetShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/magent_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MagnetShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/magent_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MagnetShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/magent_shroom.animation.json");

    }
}
