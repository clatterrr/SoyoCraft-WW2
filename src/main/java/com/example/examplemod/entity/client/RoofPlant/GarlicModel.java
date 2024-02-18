
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.GarlicEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GarlicModel extends AnimatedGeoModel<GarlicEntity> {

    @Override
    public ResourceLocation getModelResource(GarlicEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/garlic.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GarlicEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/garlic.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GarlicEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/garlic.animation.json");

    }
}
