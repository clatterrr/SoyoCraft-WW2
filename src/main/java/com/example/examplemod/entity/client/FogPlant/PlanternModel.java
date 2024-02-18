
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.PlanternEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlanternModel extends AnimatedGeoModel<PlanternEntity> {

    @Override
    public ResourceLocation getModelResource(PlanternEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/plantern.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlanternEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/plantern.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlanternEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/plantern.animation.json");

    }
}
