package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

        public static final ModelLayerLocation MAGIC_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "magic_projectile_layer"), "magic_projectile_layer");

        public static final ModelLayerLocation CREEPER_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "creeper_projectile_layer"), "creeper_projectile_layer");

        public static final ModelLayerLocation BULLET_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "bullet_projectile_layer"), "bullet_projectile_layer");
}