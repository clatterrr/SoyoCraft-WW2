
package com.example.examplemod.entity.client.FogZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogZombie.DiggerZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DiggerZombieModel extends AnimatedGeoModel<DiggerZombieEntity> {

    @Override
    public ResourceLocation getModelResource(DiggerZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/digger_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiggerZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/digger_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiggerZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/digger_zombie.animation.json");

    }
}
