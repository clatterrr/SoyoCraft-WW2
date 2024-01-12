package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DaveCarEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaveCarModel extends AnimatedGeoModel<DaveCarEntity> {

    @Override
    public ResourceLocation getModelResource(DaveCarEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/dave_car.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DaveCarEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/dave_car.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DaveCarEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/dave_car.animation.json");

    }


}
