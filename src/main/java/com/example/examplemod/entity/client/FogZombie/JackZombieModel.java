
package com.example.examplemod.entity.client.FogZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogZombie.JackZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JackZombieModel extends AnimatedGeoModel<JackZombieEntity> {

    @Override
    public ResourceLocation getModelResource(JackZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/jack_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JackZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/jack_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JackZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/jack_zombie.animation.json");

    }
}
