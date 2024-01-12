package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.CrazyDaveEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrazyDaveModel extends AnimatedGeoModel<CrazyDaveEntity> {

    @Override
    public ResourceLocation getModelResource(CrazyDaveEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/crazy_dave.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrazyDaveEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/crazy_dave.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrazyDaveEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/crazy_dave.animation.json");

    }


}
