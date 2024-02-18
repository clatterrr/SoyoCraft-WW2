
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.SeaShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeaShroomModel extends AnimatedGeoModel<SeaShroomEntity> {

    @Override
    public ResourceLocation getModelResource(SeaShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/sea_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SeaShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/sea_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SeaShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/sea_shroom.animation.json");

    }
}
