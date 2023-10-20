package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PeaShooterEntity;
import com.example.examplemod.entity.custom.WallNutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WallNutModel extends AnimatedGeoModel<WallNutEntity> {

    @Override
    public ResourceLocation getModelResource(WallNutEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/wall_nut.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WallNutEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/wall_nut.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WallNutEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/wall_nut.animation.json");

    }


}
