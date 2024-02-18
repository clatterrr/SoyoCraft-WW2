
package com.example.examplemod.entity.client.FogPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.FogPlant.SplitPeaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SplitPeaModel extends AnimatedGeoModel<SplitPeaEntity> {

    @Override
    public ResourceLocation getModelResource(SplitPeaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/split_pea.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SplitPeaEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/split_pea.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SplitPeaEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/split_pea.animation.json");

    }
}
