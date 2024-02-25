package com.example.examplemod.entity.client.Projectile;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.Projectile.PeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.SporeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SporeModel extends AnimatedGeoModel<SporeEntity> {

    @Override
    public ResourceLocation getModelResource(SporeEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/spore.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SporeEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/spore.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SporeEntity  animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/spore.animation.json");

    }


}
