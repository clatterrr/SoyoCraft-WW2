package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.BacteriaEntity;
import com.example.examplemod.entity.custom.PartyGoersEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PartyGoersModel extends AnimatedGeoModel<PartyGoersEntity> {

    @Override
    public ResourceLocation getModelResource(PartyGoersEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/party_goers.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PartyGoersEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/party_goers.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PartyGoersEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/party_goers.animation.json");

    }


}
