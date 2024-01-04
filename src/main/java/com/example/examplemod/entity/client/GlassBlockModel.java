package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BirdEggEntity;
import com.example.examplemod.entity.custom.GlassBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GlassBlockModel extends AnimatedGeoModel<GlassBlockEntity> {

    @Override
    public ResourceLocation getModelResource(GlassBlockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/glass_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GlassBlockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/glass_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GlassBlockEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/glass_block.animation.json");

    }


}
