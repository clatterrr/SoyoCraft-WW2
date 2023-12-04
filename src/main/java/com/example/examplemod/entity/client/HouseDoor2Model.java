package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.HouseDoor2Entity;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HouseDoor2Model extends AnimatedGeoModel<HouseDoor2Entity> {

    @Override
    public ResourceLocation getModelResource(HouseDoor2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/house_door_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HouseDoor2Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/house_door_2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HouseDoor2Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/house_door_2.animation.json");

    }


}
