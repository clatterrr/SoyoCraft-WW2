package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BucketheadZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BucketheadModel extends AnimatedGeoModel<BucketheadZombieEntity> {

    @Override
    public ResourceLocation getModelResource(BucketheadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/bucket_head_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BucketheadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bucket_head_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BucketheadZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/bucket_head_zombie.animation.json");

    }


}
