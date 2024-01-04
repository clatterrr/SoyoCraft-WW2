package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BirdEggEntity;
import com.example.examplemod.entity.custom.WoodBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WoodBlockModel extends AnimatedGeoModel<WoodBlockEntity> {

    @Override
    public ResourceLocation getModelResource(WoodBlockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/wood_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WoodBlockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/wood_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WoodBlockEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/wood_block.animation.json");

    }


}
