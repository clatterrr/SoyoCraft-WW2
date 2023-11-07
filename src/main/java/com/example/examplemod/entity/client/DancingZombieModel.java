package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DancingZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DancingZombieModel extends AnimatedGeoModel<DancingZombieEntity> {

    @Override
    public ResourceLocation getModelResource(DancingZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/dancing_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DancingZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/dancing_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DancingZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/dancing_zombie.animation.json");

    }


}
