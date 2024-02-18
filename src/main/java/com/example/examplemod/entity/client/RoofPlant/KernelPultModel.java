
package com.example.examplemod.entity.client.RoofPlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.RoofPlant.KernelPultEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KernelPultModel extends AnimatedGeoModel<KernelPultEntity> {

    @Override
    public ResourceLocation getModelResource(KernelPultEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/kernel_pult.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KernelPultEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/kernel_pult.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KernelPultEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/kernel_pult.animation.json");

    }
}
