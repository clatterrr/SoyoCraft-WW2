package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FlagZombieEntity;
import com.example.examplemod.entity.custom.PoleVaultingZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PoleVaultingZombieModel extends AnimatedGeoModel<PoleVaultingZombieEntity> {

    @Override
    public ResourceLocation getModelResource(PoleVaultingZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pole_vaulting_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PoleVaultingZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pole_vaulting_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PoleVaultingZombieEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pole_vaulting_zombie.animation.json");

    }


}
