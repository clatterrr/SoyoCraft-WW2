package com.example.examplemod.entity.client.Garden;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Garden.GardenRakeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GardenRakeModel extends AnimatedGeoModel<GardenRakeEntity> {

    @Override
    public ResourceLocation getModelResource(GardenRakeEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/garden_rake.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GardenRakeEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/garden_rake.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GardenRakeEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/garden_rake.animation.json");

    }


}
