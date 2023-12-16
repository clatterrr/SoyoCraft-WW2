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


            event.put(ModEntityTypes.HOUSE_DOOR_1.get(), HouseDoor1Entity.setAttributes());
            event.put(ModEntityTypes.HOUSE_DOOR_2.get(), HouseDoor2Entity.setAttributes());
            event.put(ModEntityTypes.POOL_CHAIR.get(), PoolChairEntity.setAttributes());
            event.put(ModEntityTypes.LIFE_GUARD_TOWER.get(), LifeGuradTowerEntity.setAttributes());
            event.put(ModEntityTypes.DUCK.get(), DuckEntity.setAttributes());
            event.put(ModEntityTypes.STONE1.get(), Stone1Entity.setAttributes());
            event.put(ModEntityTypes.STONE2.get(), Stone2Entity.setAttributes());
            event.put(ModEntityTypes.FENCE.get(), FenceEntity.setAttributes());
            event.put(ModEntityTypes.SUB_MARINE.get(), SubmarineEntity.setAttributes());

            event.put(ModEntityTypes.NORMAL_ZOMBIE.get(), NormalZombieEntity.setAttributes());
            event.put(ModEntityTypes.CONEHEAD_ZOMBIE.get(), ConeheadZombieEntity.setAttributes());
            event.put(ModEntityTypes.BUCKETHEAD_ZOMBIE.get(), BucketheadZombieEntity.setAttributes());
            event.put(ModEntityTypes.POLE_VAULTING_ZOMBIE.get(), PoleVaultingZombieEntity.setAttributes());
            event.put(ModEntityTypes.NEWSPAPER_ZOMBIE.get(), NewspaperZombieEntity.setAttributes());
            event.put(ModEntityTypes.FOOTBALL_ZOMBIE.get(), FootballZombieEntity.setAttributes());

            event.put(ModEntityTypes.DUCK_TUBE_ZOMBIE.get(), DuckTubeZombieEntity.setAttributes());
            event.put(ModEntityTypes.DUCK_TUBE_CONE_HEAD_ZOMBIE.get(), DuckTubeConeHeadZombieEntity.setAttributes());
            event.put(ModEntityTypes.DUCK_TUBE_BUCKET_HEAD_ZOMBIE.get(), DuckTubeBucketHeadZombieEntity.setAttributes());
            event.put(ModEntityTypes.SNORKEL_ZOMBIE.get(), SnorkelZombieEntity.setAttributes());
            event.put(ModEntityTypes.ZOMBONI.get(), ZomboniEntity.setAttributes());
            event.put(ModEntityTypes.ZOMBIE_BOBSLED_TEAM.get(), ZombieBobsledTeamEntity.setAttributes());
            event.put(ModEntityTypes.DOLPHIN_RIDER_ZOMBIE.get(), DolphinRiderZombieEntity.setAttributes());

            event.put(ModEntityTypes.PEA_SHOOTER.get(), PeaShooterEntity.setAttributes());
            event.put(ModEntityTypes.SUNFLOWER.get(), SunflowerEntity.setAttributes());
            event.put(ModEntityTypes.WALLNUT.get(), WallnutEntity.setAttributes());
            event.put(ModEntityTypes.PUFF_SHROOM.get(), PuffShroomEntity.setAttributes());
            event.put(ModEntityTypes.PUFF_SHROOM_SLEEP.get(), PuffShroomSleepEntity.setAttributes());
            event.put(ModEntityTypes.PEA_PROJECTILE.get(), PeaProjectileEntity.setAttributes());

            event.put(ModEntityTypes.LILY_PAD.get(), LilyPadEntity.setAttributes());
            event.put(ModEntityTypes.SQUASH.get(), SquashEntity.setAttributes());
            event.put(ModEntityTypes.THREEPEATER.get(), ThreepeaterEntity.setAttributes());
            event.put(ModEntityTypes.TANGLE_KELP.get(), TangleKelpEntity.setAttributes());
            event.put(ModEntityTypes.JALAPENO.get(), JalapenoEntity.setAttributes());
            event.put(ModEntityTypes.SPIKEWEED.get(), SpikeweedEntity.setAttributes());
            event.put(ModEntityTypes.TORCHWOOD.get(), TorchwoodEntity.setAttributes());
            event.put(ModEntityTypes.TALLNUT.get(), TallnutEntity.setAttributes());

            event.put(ModEntityTypes.FREEZE_ZOMBIE.get(), FreezeZombieEntity.setAttributes());
            event.put(ModEntityTypes.ASH_ZOMBIE.get(), AshZombieEntity.setAttributes());
            event.put(ModEntityTypes.GRAVE1.get(), Grave1Entity.setAttributes());
            event.put(ModEntityTypes.GRAVE2.get(), Grave2Entity.setAttributes());
            event.put(ModEntityTypes.GRAVE3.get(), Grave3Entity.setAttributes());
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.ZOMBIE_HAND_LAYER, ZombieHandModel::createBodyLayer);

        }
    }
}
