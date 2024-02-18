
package com.example.examplemod.entity.client.FogZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogZombie.BalloonZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BalloonZombieModel extends AnimatedGeoModel<BalloonZombieEntity> {

    @Override
    public ResourceLocation getModelResource(BalloonZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/balloon_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BalloonZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/balloon_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BalloonZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/balloon_zombie.animation.json");

    }
}
