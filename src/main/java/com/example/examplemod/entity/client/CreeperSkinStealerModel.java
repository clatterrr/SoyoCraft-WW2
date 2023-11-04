package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.CreeperSkinStealerEntity;
import com.example.examplemod.entity.custom.SmilesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CreeperSkinStealerModel extends AnimatedGeoModel<CreeperSkinStealerEntity> {

    @Override
    public ResourceLocation getModelResource(CreeperSkinStealerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/creeper_skin_stealer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CreeperSkinStealerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/creeper_skin_stealer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CreeperSkinStealerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/creeper_skin_stealer.animation.json");

    }


}
