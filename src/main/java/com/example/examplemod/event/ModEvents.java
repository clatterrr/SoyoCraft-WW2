package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.client.*;
import com.example.examplemod.entity.custom.*;
import net.minecraft.client.player.LocalPlayer;
import com.example.examplemod.entity.custom.DayPlant.JalapenoEntity;
import com.example.examplemod.entity.custom.DayPlant.PeaShooterEntity;
import com.example.examplemod.entity.custom.DayPlant.RepeaterEntity;
import com.example.examplemod.entity.custom.DayPlant.SnowPeaEntity;
import com.example.examplemod.entity.custom.DayZombie.*;
import com.example.examplemod.entity.custom.Garden.*;
import com.example.examplemod.entity.custom.Projectile.SporeEntity;
import com.example.examplemod.entity.custom.UpgradePlant.*;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomEntity;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomSleepEntity;
import com.example.examplemod.entity.custom.NightZombie.NewspaperZombieEntity;
import com.example.examplemod.entity.custom.Projectile.FirePeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.IcePeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.PeaProjectileEntity;
import com.example.examplemod.entity.custom.DayPlant.SunflowerEntity;
import com.example.examplemod.entity.custom.DayPlant.WallnutEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

public class ModEvents {

    @Mod.EventBusSubscriber(modid = ExampleMod.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
            if (event.getEntity() instanceof LocalPlayer ) {
                LocalPlayer player = (LocalPlayer)event.getEntity();
                if (player.input.jumping ) {
                    player.setDeltaMovement(player.getDeltaMovement().add(0.0D, 0.5D, 0.0D));
                }
            }

        }

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

            event.put(ModEntityTypes.LAWN_MOWER.get(), LawnMowerEntity.setAttributes());
            event.put(ModEntityTypes.POOL_CLEANER.get(), PoolCleanerEntity.setAttributes());
            event.put(ModEntityTypes.GARDEN_RAKE.get(), GardenRakeEntity.setAttributes());
            event.put(ModEntityTypes.CRAZY_DAVE.get(), CrazyDaveEntity.setAttributes());
            event.put(ModEntityTypes.DAVE_CAR.get(), DaveCarEntity.setAttributes());


            event.put(ModEntityTypes.NORMAL_ZOMBIE.get(), NormalZombieEntity.setAttributes());
            event.put(ModEntityTypes.CONEHEAD_ZOMBIE.get(), ConeheadZombieEntity.setAttributes());
            event.put(ModEntityTypes.BUCKETHEAD_ZOMBIE.get(), BucketheadZombieEntity.setAttributes());
            event.put(ModEntityTypes.NEWSPAPER_ZOMBIE.get(), NewspaperZombieEntity.setAttributes());
            event.put(ModEntityTypes.FOOTBALL_ZOMBIE.get(), FootballZombieEntity.setAttributes());

            event.put(ModEntityTypes.PEA_SHOOTER.get(), PeaShooterEntity.setAttributes());
            event.put(ModEntityTypes.SUNFLOWER.get(), SunflowerEntity.setAttributes());
            event.put(ModEntityTypes.WALLNUT.get(), WallnutEntity.setAttributes());
            event.put(ModEntityTypes.PUFF_SHROOM.get(), PuffShroomEntity.setAttributes());
            event.put(ModEntityTypes.PUFF_SHROOM_SLEEP.get(), PuffShroomSleepEntity.setAttributes());
            event.put(ModEntityTypes.PEA_PROJECTILE.get(), PeaProjectileEntity.setAttributes());
            event.put(ModEntityTypes.SPORE.get(), SporeEntity.setAttributes());
            event.put(ModEntityTypes.FOG_GENEATOR.get(), FogGeneratorEntity.setAttributes());

            event.put(ModEntityTypes.ICE_PEA_PROJECTILE.get(), IcePeaProjectileEntity.setAttributes());
            event.put(ModEntityTypes.FIRE_PEA_PROJECTILE.get(), FirePeaProjectileEntity.setAttributes());
            event.put(ModEntityTypes.SNOW_PEA.get(), SnowPeaEntity.setAttributes());
            event.put(ModEntityTypes.REPEATER.get(), RepeaterEntity.setAttributes());


            event.put(ModEntityTypes.FREEZE_ZOMBIE.get(), FreezeZombieEntity.setAttributes());
            event.put(ModEntityTypes.ASH_ZOMBIE.get(), AshZombieEntity.setAttributes());
            event.put(ModEntityTypes.GRAVE1.get(), Grave1Entity.setAttributes());
            event.put(ModEntityTypes.GRAVE2.get(), Grave2Entity.setAttributes());
            event.put(ModEntityTypes.GRAVE3.get(), Grave3Entity.setAttributes());

            event.put(ModEntityTypes.GOOMBA.get(), GoombaEntity.setAttributes());
            event.put(ModEntityTypes.KOOPA.get(), KoopaEntity.setAttributes());
            event.put(ModEntityTypes.PIRANHA.get(), PiranhaEntity.setAttributes());
            event.put(ModEntityTypes.MARIO.get(), MarioEntity.setAttributes());
            event.put(ModEntityTypes.MARIO_SMALL.get(), MarioSmallEntity.setAttributes());




            event.put(ModEntityTypes.GATLING_PEA.get(), GatlingPeaEntity.setAttributes());


            event.put(ModEntityTypes.TWIN_SUNFLOWER.get(), TwinSunflowerEntity.setAttributes());


            event.put(ModEntityTypes.GLOOM_SHROOM.get(), GloomShroomEntity.setAttributes());


            event.put(ModEntityTypes.CATTAIL.get(), CattailEntity.setAttributes());


            event.put(ModEntityTypes.WINTER_MELON.get(), WinterMelonEntity.setAttributes());


            event.put(ModEntityTypes.GOLD_MAGNET.get(), GoldMagnetEntity.setAttributes());


            event.put(ModEntityTypes.SPIKE_ROCK.get(), SpikeRockEntity.setAttributes());


            event.put(ModEntityTypes.COB_CANNON.get(), CobCannonEntity.setAttributes());


        }

    }


    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ZOMBIE_HAND_LAYER, ZombieHandModel::createBodyLayer);

    }

    @SubscribeEvent
    public void onLivingJumpEvent(LivingEvent.LivingJumpEvent event)
    {
        float jumpMultiplier = 1.0F;

        if (event.getEntity() instanceof Player player){
            player.sendSystemMessage(Component.literal("jump"));
            player.push(0,jumpMultiplier,0);
        }
    }

}
