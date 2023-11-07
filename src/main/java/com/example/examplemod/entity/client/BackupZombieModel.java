package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BackupZombieEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BackupZombieModel extends AnimatedGeoModel<BackupZombieEntity> {

    @Override
    public ResourceLocation getModelResource(BackupZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/backup_zombie.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BackupZombieEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/backup_zombie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BackupZombieEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/backup_zombie.animation.json");

    }
}
