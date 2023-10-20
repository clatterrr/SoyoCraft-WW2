package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

        public static final ModelLayerLocation MAGIC_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "magic_projectile_layer"), "magic_projectile_layer");

        public static final ModelLayerLocation BULLET_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "bullet_projectile_layer"), "bullet_projectile_layer");

        public static final ModelLayerLocation PEA_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "pea_projectile_layer"), "pea_projectile_layer");
        public static final ModelLayerLocation ICE_PEA_PROJECTILE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "ice_pea_projectile_layer"), "ice_pea_projectile_layer");
        public static final ModelLayerLocation SUN_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "sun_layer"), "sun_layer");

        public static final ModelLayerLocation CONE_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "cone_layer"), "cone_layer");

        public static final ModelLayerLocation BUCKET_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "bucket_layer"), "bucket_layer");

        public static final ModelLayerLocation ZOMBIE_HAND_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "zombie_hand_layer"), "zombie_hand_layer");

        public static final ModelLayerLocation PEA_CROP_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "pea_crop_layer"), "pea_crop_layer");
}