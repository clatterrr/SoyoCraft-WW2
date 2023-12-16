package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.PeaProjectileEntity;
import com.example.examplemod.entity.custom.SnorkelZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PeaProjectileModel extends AnimatedGeoModel<PeaProjectileEntity> {

    @Override
    public ResourceLocation getModelResource(PeaProjectileEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pea_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PeaProjectileEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/pea_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PeaProjectileEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pea_projectile.animation.json");

    }


}
