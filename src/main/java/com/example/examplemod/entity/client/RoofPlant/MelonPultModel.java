
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.MelonPultEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MelonPultModel extends AnimatedGeoModel<MelonPultEntity> {

    @Override
    public ResourceLocation getModelResource(MelonPultEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/melon_pult.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MelonPultEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/melon_pult.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MelonPultEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/melon_pult.animation.json");

    }
}
