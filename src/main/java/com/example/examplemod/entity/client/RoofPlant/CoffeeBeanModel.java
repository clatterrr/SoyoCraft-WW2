
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.CoffeeBeanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CoffeeBeanModel extends AnimatedGeoModel<CoffeeBeanEntity> {

    @Override
    public ResourceLocation getModelResource(CoffeeBeanEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/coffee_bean.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoffeeBeanEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/coffee_bean.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoffeeBeanEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/coffee_bean.animation.json");

    }
}
