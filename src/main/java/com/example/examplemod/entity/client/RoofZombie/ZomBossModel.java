
package com.example.examplemod.entity.client.RoofZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofZombie.ZomBossEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZomBossModel extends AnimatedGeoModel<ZomBossEntity> {

    @Override
    public ResourceLocation getModelResource(ZomBossEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/zomboss.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZomBossEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/zomboss.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZomBossEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/zomboss.animation.json");

    }
}
