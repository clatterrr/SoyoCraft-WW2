
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.CobCannonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CobCannonModel extends AnimatedGeoModel<CobCannonEntity> {

    @Override
    public ResourceLocation getModelResource(CobCannonEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cob_cannon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CobCannonEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cob_cannon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CobCannonEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cob_cannon.animation.json");

    }
}

