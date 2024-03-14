package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.PiranhaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PiranhaModel extends AnimatedGeoModel<PiranhaEntity> {

    @Override
    public ResourceLocation getModelResource(PiranhaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/piranha.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PiranhaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/piranha.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PiranhaEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/piranha.animation.json");

    }


}
