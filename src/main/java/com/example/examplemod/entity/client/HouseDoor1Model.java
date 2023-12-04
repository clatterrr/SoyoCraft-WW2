package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.HouseDoor1Entity;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HouseDoor1Model extends AnimatedGeoModel<HouseDoor1Entity> {

    @Override
    public ResourceLocation getModelResource(HouseDoor1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/house_door_1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HouseDoor1Entity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/house_door_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HouseDoor1Entity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/house_door_1.animation.json");

    }


}
