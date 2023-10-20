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

            event.put(ModEntityTypes.CACTUS.get(), CactusEntity.setAttributes());
            event.put(ModEntityTypes.SUN_FLOWER.get(), SunFlowerEntity.setAttributes());
            event.put(ModEntityTypes.PEA_SHOOTER.get(), PeaShooterEntity.setAttributes());
            event.put(ModEntityTypes.CHERRY_BOMB.get(), CherryBombEntity.setAttributes());
            event.put(ModEntityTypes.WALL_NUT.get(), WallNutEntity.setAttributes());
            event.put(ModEntityTypes.SNOW_PEA.get(), SnowPeaEntity.setAttributes());
            event.put(ModEntityTypes.REPEATER.get(), RepeaterEntity.setAttributes());
            event.put(ModEntityTypes.CHOMPER.get(), ChomperEntity.setAttributes());
            event.put(ModEntityTypes.POTATO_MINE.get(), PotatoMineEntity.setAttributes());
            event.put(ModEntityTypes.NORMAL_ZOMBIE.get(), NormalZombieEntity.setAttributes());
            event.put(ModEntityTypes.FLAG_ZOMBIE.get(), FlagZombieEntity.setAttributes());
            event.put(ModEntityTypes.CONE_HEAD_ZOMBIE.get(), ConeHeadZombieEntity.setAttributes());
            event.put(ModEntityTypes.BUCKET_HEAD_ZOMBIE.get(), BucketHeadZombieEntity.setAttributes());
            event.put(ModEntityTypes.POLE_VAULTING_ZOMBIE.get(), PoleVaultingZombieEntity.setAttributes());
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.PEA_CROP_LAYER, PeaCropModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.SUN_LAYER, SunModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.CONE_LAYER, ConeModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.BUCKET_LAYER, BucketModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.ZOMBIE_HAND_LAYER, ZombieHandModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.MAGIC_PROJECTILE_LAYER, MagicProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.BULLET_PROJECTILE_LAYER, BulletProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.PEA_PROJECTILE_LAYER, PeaProjectileModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.ICE_PEA_PROJECTILE_LAYER, IcePeaProjectileModel::createBodyLayer);
        }
    }
}
