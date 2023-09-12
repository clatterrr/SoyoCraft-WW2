package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
        public static final ModelLayerLocation BOMB_LAYER = new ModelLayerLocation(
                new ResourceLocation(ExampleMod.MODID, "bomb"), "bomb");
}
