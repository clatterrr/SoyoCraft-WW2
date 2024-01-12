package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import com.example.examplemod.entity.custom.SpikeweedEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpikeweedModel extends AnimatedGeoModel<SpikeweedEntity> {

    @Override
    public ResourceLocation getModelResource(SpikeweedEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/spike_weed.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpikeweedEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/spike_weed.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpikeweedEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/spike_weed.animation.json");

    }


}
