package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SmilesEntity;
import com.example.examplemod.entity.custom.VillagerSkinStealerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VillagerSkinStealerModel extends AnimatedGeoModel<VillagerSkinStealerEntity> {

    @Override
    public ResourceLocation getModelResource(VillagerSkinStealerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/villager_skin_stealer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VillagerSkinStealerEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/villager_skin_stealer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VillagerSkinStealerEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/villager_skin_stealer.animation.json");

    }


}
