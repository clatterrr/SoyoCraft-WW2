
package com.example.examplemod.entity.client.RoofZombie;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofZombie.ImpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ImpModel extends AnimatedGeoModel<ImpEntity> {

    @Override
    public ResourceLocation getModelResource(ImpEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/imp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ImpEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/imp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ImpEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/imp.animation.json");

    }
}
