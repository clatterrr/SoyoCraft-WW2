package com.example.examplemod.entity.client.NightPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomSleepEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PuffShroomSleepModel extends AnimatedGeoModel<PuffShroomSleepEntity> {

    @Override
    public ResourceLocation getModelResource(PuffShroomSleepEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/puff_shroom_sleep.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PuffShroomSleepEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/puff_shroom_sleep.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PuffShroomSleepEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/puff_shroom_sleep.animation.json");

    }


}
