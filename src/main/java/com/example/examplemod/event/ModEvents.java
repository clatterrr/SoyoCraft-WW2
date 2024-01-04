package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.client.*;
import com.example.examplemod.entity.custom.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {

    @Mod.EventBusSubscriber(modid = ExampleMod.MODID)
    public static class ForgeEvents {


    }

    @Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {


        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.THE_VILLAGER.get(), TheVillagerEntity.setAttributes());
            event.put(ModEntityTypes.STONE_BLOCK.get(), StoneBlockEntity.setAttributes());
            event.put(ModEntityTypes.WOOD_BLOCK.get(), WoodBlockEntity.setAttributes());
            event.put(ModEntityTypes.GLASS_BLOCK.get(), GlassBlockEntity.setAttributes());
            event.put(ModEntityTypes.SLING_SHOT.get(), SlingShotEntity.setAttributes());

            event.put(ModEntityTypes.BIRD_EGG.get(), BirdEggEntity.setAttributes());
            event.put(ModEntityTypes.RED_BIRD.get(), RedBirdEntity.setAttributes());
            event.put(ModEntityTypes.BOMB_BIRD.get(), BombBirdEntity.setAttributes());
            event.put(ModEntityTypes.BLUE_BIRD.get(), BlueBirdEntity.setAttributes());
            event.put(ModEntityTypes.CHUCK_BIRD.get(), ChuckBirdEntity.setAttributes());

            event.put(ModEntityTypes.GREEN_PIG_1.get(), GreenPig1Entity.setAttributes());
            event.put(ModEntityTypes.GREEN_PIG_2.get(), GreenPig2Entity.setAttributes());
            event.put(ModEntityTypes.GREEN_PIG_3.get(), GreenPig3Entity.setAttributes());

        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        }
    }
}
