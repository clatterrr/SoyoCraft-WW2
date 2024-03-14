package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.AshZombieEntity;
import com.example.examplemod.entity.custom.KoopaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KoopaModel extends AnimatedGeoModel<KoopaEntity> {

    @Override
    public ResourceLocation getModelResource(KoopaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/koopa.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KoopaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/koopa.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KoopaEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/koopa.animation.json");

    }


}
