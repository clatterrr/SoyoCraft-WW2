
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.StarFruitEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StarFruitModel extends AnimatedGeoModel<StarFruitEntity> {

    @Override
    public ResourceLocation getModelResource(StarFruitEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/star_fruit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarFruitEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/star_fruit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StarFruitEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/star_fruit.animation.json");

    }
}
