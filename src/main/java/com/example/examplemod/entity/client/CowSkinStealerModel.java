package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.CowSkinStealerEntity;
import com.example.examplemod.entity.custom.SmilesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CowSkinStealerModel extends AnimatedGeoModel<CowSkinStealerEntity> {

    @Override
    public ResourceLocation getModelResource(CowSkinStealerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/cow_skin_stealer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CowSkinStealerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/cow_skin_stealer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CowSkinStealerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/cow_skin_stealer.animation.json");

    }


}
