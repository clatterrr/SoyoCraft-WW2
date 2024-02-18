
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.GatlingPeaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GatlingPeaModel extends AnimatedGeoModel<GatlingPeaEntity> {

    @Override
    public ResourceLocation getModelResource(GatlingPeaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/gatling_pea.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GatlingPeaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/gatling_pea.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GatlingPeaEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/gatling_pea.animation.json");

    }
}

