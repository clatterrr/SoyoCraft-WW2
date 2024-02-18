package com.example.examplemod.entity.client.Projectile;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Projectile.FirePeaProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FirePeaProjectileModel extends AnimatedGeoModel<FirePeaProjectileEntity> {

    @Override
    public ResourceLocation getModelResource(FirePeaProjectileEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pea_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FirePeaProjectileEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/fire_pea_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FirePeaProjectileEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pea_projectile.animation.json");

    }


}
