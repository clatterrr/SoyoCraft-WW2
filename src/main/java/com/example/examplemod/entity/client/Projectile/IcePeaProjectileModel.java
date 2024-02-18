package com.example.examplemod.entity.client.Projectile;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Projectile.IcePeaProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IcePeaProjectileModel extends AnimatedGeoModel<IcePeaProjectileEntity> {

    @Override
    public ResourceLocation getModelResource(IcePeaProjectileEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/pea_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IcePeaProjectileEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/ice_pea_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IcePeaProjectileEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/pea_projectile.animation.json");

    }


}
