package com.example.examplemod.entity.client.PoolPlant;

import com.example.examplemod.ExampleMod;

import com.example.examplemod.entity.custom.PoolPlant.TangleKelpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TangleKelpModel extends AnimatedGeoModel<TangleKelpEntity> {

    @Override
    public ResourceLocation getModelResource(TangleKelpEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/tangle_kelp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TangleKelpEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/tangle_kelp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TangleKelpEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/tangle_kelp.animation.json");

    }


}
