package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BirdEggEntity;
import com.example.examplemod.entity.custom.StoneBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StoneBlockModel extends AnimatedGeoModel<StoneBlockEntity> {

    @Override
    public ResourceLocation getModelResource(StoneBlockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/stone_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StoneBlockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/stone_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StoneBlockEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/stone_block.animation.json");

    }


}
