package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SlingShotEntity;
import com.example.examplemod.entity.custom.TheVillagerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SlingShotModel extends AnimatedGeoModel<SlingShotEntity> {

    @Override
    public ResourceLocation getModelResource(SlingShotEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/sling_shot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SlingShotEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/sling_shot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SlingShotEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/sling_shot.animation.json");

    }


}
