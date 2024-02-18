
package com.example.examplemod.entity.client.RoofZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofZombie.CatapultZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CatapultZombieModel extends AnimatedGeoModel<CatapultZombieEntity> {

    @Override
    public ResourceLocation getModelResource(CatapultZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/catapult_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CatapultZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/catapult_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CatapultZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/catapult_zombie.animation.json");

    }
}
