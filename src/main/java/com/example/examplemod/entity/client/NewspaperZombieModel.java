package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.NewspaperZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NewspaperZombieModel extends AnimatedGeoModel<NewspaperZombieEntity> {

    @Override
    public ResourceLocation getModelResource(NewspaperZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/newspaper_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NewspaperZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/newspaper_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NewspaperZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/newspaper_zombie.animation.json");

    }


}
