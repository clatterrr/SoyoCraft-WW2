
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.FlowerPotEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FlowerPotModel extends AnimatedGeoModel<FlowerPotEntity> {

    @Override
    public ResourceLocation getModelResource(FlowerPotEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/flowr_pot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FlowerPotEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/flowr_pot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FlowerPotEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/flowr_pot.animation.json");

    }
}
