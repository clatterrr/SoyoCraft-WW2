package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

        public static final ModelLayerLocation MAGIC_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "magic_projectile_layer"), "magic_projectile_layer");

        public static final ModelLayerLocation GRASS_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "grass_projectile_layer"), "grass_projectile_layer");

        public static final ModelLayerLocation ZOMBIE_HAND_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "zombie_hand_layer"), "zombie_hand_layer");

}