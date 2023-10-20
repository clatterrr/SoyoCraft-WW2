package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BucketHeadZombieEntity;
import com.example.examplemod.entity.custom.FlagZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BucketHeadZombieModel extends AnimatedGeoModel<BucketHeadZombieEntity> {

    @Override
    public ResourceLocation getModelResource(BucketHeadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/bucket_head_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BucketHeadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/bucket_head_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BucketHeadZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/bucket_head_zombie.animation.json");

    }


}
