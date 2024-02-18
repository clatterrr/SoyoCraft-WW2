
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.UmbrellaLeafEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UmbrellaLeafModel extends AnimatedGeoModel<UmbrellaLeafEntity> {

    @Override
    public ResourceLocation getModelResource(UmbrellaLeafEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/umbrella_leaf.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UmbrellaLeafEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/umbrella_leaf.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UmbrellaLeafEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/umbrella_leaf.animation.json");

    }
}
