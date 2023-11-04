package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.client.*;
import com.example.examplemod.entity.custom.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

            event.put(ModEntityTypes.NORMAL_ZOMBIE.get(), NormalZombieEntity.setAttributes());
            event.put(ModEntityTypes.BACTERIA.get(), BacteriaEntity.setAttributes());
            event.put(ModEntityTypes.PARTY_GOERS.get(), PartyGoersEntity.setAttributes());
            event.put(ModEntityTypes.BALLOON.get(), BalloonEntity.setAttributes());
            event.put(ModEntityTypes.SMILES.get(), SmilesEntity.setAttributes());
            event.put(ModEntityTypes.COW_SKIN_STEALER.get(), CowSkinStealerEntity.setAttributes());
            event.put(ModEntityTypes.VILLAGER_SKIN_STEALER.get(), VillagerSkinStealerEntity.setAttributes());
            event.put(ModEntityTypes.CREEPER_SKIN_STEALER.get(), CreeperSkinStealerEntity.setAttributes());
            event.put(ModEntityTypes.HOUND.get(), HoundEntity.setAttributes());
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.ZOMBIE_HAND_LAYER, ZombieHandModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.MAGIC_PROJECTILE_LAYER, MagicProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.GRASS_PROJECTILE_LAYER, GrassProjectileModel::createBodyLayer);
        }
    }
}
