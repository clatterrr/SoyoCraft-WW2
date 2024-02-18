
package com.example.examplemod.entity.client.RoofZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofZombie.GargantuarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GargantuarModel extends AnimatedGeoModel<GargantuarEntity> {

    @Override
    public ResourceLocation getModelResource(GargantuarEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/gargantuar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GargantuarEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/gargantuar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GargantuarEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/gargantuar.animation.json");

    }
}
