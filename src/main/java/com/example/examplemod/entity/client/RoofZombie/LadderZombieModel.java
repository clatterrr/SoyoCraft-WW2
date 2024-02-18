
package com.example.examplemod.entity.client.RoofZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofZombie.LadderZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LadderZombieModel extends AnimatedGeoModel<LadderZombieEntity> {

    @Override
    public ResourceLocation getModelResource(LadderZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/ladder_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LadderZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/ladder_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LadderZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/ladder_zombie.animation.json");

    }
}
