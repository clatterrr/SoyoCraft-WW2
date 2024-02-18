
package com.example.examplemod.entity.client.FogZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogZombie.PogoZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PogoZombieModel extends AnimatedGeoModel<PogoZombieEntity> {

    @Override
    public ResourceLocation getModelResource(PogoZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pogo_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PogoZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pogo_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PogoZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pogo_zombie.animation.json");

    }
}
