
package com.example.examplemod.entity.client.RoofZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofZombie.BungeeZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BungeeZombieModel extends AnimatedGeoModel<BungeeZombieEntity> {

    @Override
    public ResourceLocation getModelResource(BungeeZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/gungee_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BungeeZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/gungee_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BungeeZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/gungee_zombie.animation.json");

    }
}
