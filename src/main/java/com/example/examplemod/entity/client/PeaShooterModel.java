package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PeaShooterEntity;
import com.example.examplemod.entity.custom.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PeaShooterModel extends AnimatedGeoModel<PeaShooterEntity> {

    @Override
    public ResourceLocation getModelResource(PeaShooterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pea_shooter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PeaShooterEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pea_shooter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PeaShooterEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pea_shooter.animation.json");

    }


}
