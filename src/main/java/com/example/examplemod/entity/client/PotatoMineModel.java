package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PotatoMineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PotatoMineModel extends AnimatedGeoModel<PotatoMineEntity> {

    @Override
    public ResourceLocation getModelResource(PotatoMineEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/potato_mine.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PotatoMineEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/potato_mine.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PotatoMineEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/potato_mine.animation.json");

    }


}
