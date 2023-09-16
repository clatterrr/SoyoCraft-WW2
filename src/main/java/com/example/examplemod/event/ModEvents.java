package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.client.*;
import com.example.examplemod.entity.custom.ChomperEntity;
import com.example.examplemod.entity.custom.SmokerEntity;
import com.example.examplemod.entity.custom.SoliderEntity;
import com.example.examplemod.entity.custom.TankEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.SMOKER.get(), SmokerEntity.setAttributes());
            event.put(ModEntityTypes.CHOMPER.get(), ChomperEntity.setAttributes());
            event.put(ModEntityTypes.TANK.get(), TankEntity.setAttributes());
            event.put(ModEntityTypes.PLANE.get(), TankEntity.setAttributes());
            event.put(ModEntityTypes.SOLIDER.get(), SoliderEntity.setAttributes());
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.MAGIC_PROJECTILE_LAYER, MagicProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.CREEPER_PROJECTILE_LAYER, CreeperProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.BULLET_PROJECTILE_LAYER, BulletProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.PLANE_BOMB_LAYER, PlaneBombModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.TANK_BOMB_LAYER, TankBombModel::createBodyLayer);
        }
    }
}
