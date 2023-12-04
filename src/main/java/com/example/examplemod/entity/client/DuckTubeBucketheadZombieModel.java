package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.DuckTubeBucketHeadZombieEntity;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DuckTubeBucketheadZombieModel extends AnimatedGeoModel<DuckTubeBucketHeadZombieEntity> {

    @Override
    public ResourceLocation getModelResource(DuckTubeBucketHeadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/duck_tube_bucket_head_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DuckTubeBucketHeadZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/duck_tube_bucket_head_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DuckTubeBucketHeadZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/duck_tube_bucket_head_zombie.animation.json");

    }


}
