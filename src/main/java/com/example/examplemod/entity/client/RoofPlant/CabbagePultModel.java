
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.CabbagePultEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CabbagePultModel extends AnimatedGeoModel<CabbagePultEntity> {

    @Override
    public ResourceLocation getModelResource(CabbagePultEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cabbage_pult.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CabbagePultEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cabbage_pult.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CabbagePultEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cabbage_pult.animation.json");

    }
}
