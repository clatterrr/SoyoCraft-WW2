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
            event.put(ModEntityTypes.NEWSPAPER_ZOMBIE.get(), NewspaperZombieEntity.setAttributes());
            event.put(ModEntityTypes.SCREEN_DOOR_ZOMBIE.get(), ScreenDoorZombieEntity.setAttributes());
            event.put(ModEntityTypes.FOOTBALL_ZOMBIE.get(), FootballZombieEntity.setAttributes());
            event.put(ModEntityTypes.DANCING_ZOMBIE.get(), DancingZombieEntity.setAttributes());
            event.put(ModEntityTypes.BACKUP_ZOMBIE.get(), BackupZombieEntity.setAttributes());
            event.put(ModEntityTypes.PUFF_SHROOM.get(), PuffShroomEntity.setAttributes());
            event.put(ModEntityTypes.SUN_SHROOM.get(), SunShroomEntity.setAttributes());
            event.put(ModEntityTypes.FUME_SHROOM.get(), FumeShroomEntity.setAttributes());
            event.put(ModEntityTypes.GRAVE_BUSTER.get(), GraveBusterEntity.setAttributes());
            event.put(ModEntityTypes.HYPNO_SHROOM.get(), HypnoShroomEntity.setAttributes());
            event.put(ModEntityTypes.SCAREDY_SHROOM.get(), ScaredyShroomEntity.setAttributes());
            event.put(ModEntityTypes.ICE_SHROOM.get(), IceShroomEntity.setAttributes());
            event.put(ModEntityTypes.DOOM_SHROOM.get(), DoomShroomEntity.setAttributes());
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.ZOMBIE_HAND_LAYER, ZombieHandModel::createBodyLayer);
            //event.registerLayerDefinition(ModModelLayers.MAGIC_PROJECTILE_LAYER, MagicProjectileModel::createBodyLayer);
           // event.registerLayerDefinition(ModModelLayers.GRASS_PROJECTILE_LAYER, GrassProjectileModel::createBodyLayer);
        }
    }
}
