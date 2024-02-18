
package com.example.examplemod.entity.client.FogZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogZombie.ZombieYetiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZombieYetiModel extends AnimatedGeoModel<ZombieYetiEntity> {

    @Override
    public ResourceLocation getModelResource(ZombieYetiEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/zombie_yeti.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZombieYetiEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/zombie_yeti.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZombieYetiEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/zombie_yeti.animation.json");

    }
}
