
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.GloomShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GloomShroomModel extends AnimatedGeoModel<GloomShroomEntity> {

    @Override
    public ResourceLocation getModelResource(GloomShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/gloom_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GloomShroomEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/gloom_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GloomShroomEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/gloom_shroom.animation.json");

    }
}

