package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BacteriaEntity;
import com.example.examplemod.entity.custom.SmilesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SmilesModel extends AnimatedGeoModel<SmilesEntity> {

    @Override
    public ResourceLocation getModelResource(SmilesEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/smiles.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SmilesEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/smiles.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SmilesEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/smiles.animation.json");

    }


}
