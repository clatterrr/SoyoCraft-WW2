package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.ModModelLayers;
import com.example.examplemod.entity.client.*;
import com.example.examplemod.entity.custom.*;
import com.example.examplemod.entity.custom.DayPlant.JalapenoEntity;
import com.example.examplemod.entity.custom.DayPlant.PeaShooterEntity;
import com.example.examplemod.entity.custom.DayPlant.RepeaterEntity;
import com.example.examplemod.entity.custom.DayPlant.SnowPeaEntity;
import com.example.examplemod.entity.custom.DayZombie.*;
import com.example.examplemod.entity.custom.Garden.*;
import com.example.examplemod.entity.custom.FogPlant.*;
import com.example.examplemod.entity.custom.FogZombie.*;
import com.example.examplemod.entity.custom.Projectile.SporeEntity;
import com.example.examplemod.entity.custom.RoofPlant.*;
import com.example.examplemod.entity.custom.RoofZombie.*;
import com.example.examplemod.entity.custom.UpgradePlant.*;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomEntity;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomSleepEntity;
import com.example.examplemod.entity.custom.NightZombie.NewspaperZombieEntity;
import com.example.examplemod.entity.custom.PoolPlant.*;
import com.example.examplemod.entity.custom.PoolZombie.*;
import com.example.examplemod.entity.custom.Projectile.FirePeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.IcePeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.PeaProjectileEntity;
import com.example.examplemod.entity.custom.DayPlant.SunflowerEntity;
import com.example.examplemod.entity.custom.DayPlant.WallnutEntity;
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

            event.put(ModEntityTypes.LAWN_MOWER.get(), LawnMowerEntity.setAttributes());
            event.put(ModEntityTypes.POOL_CLEANER.get(), PoolCleanerEntity.setAttributes());
            event.put(ModEntityTypes.GARDEN_RAKE.get(), GardenRakeEntity.setAttributes());
            event.put(ModEntityTypes.CRAZY_DAVE.get(), CrazyDaveEntity.setAttributes());
            event.put(ModEntityTypes.DAVE_CAR.get(), DaveCarEntity.setAttributes());


            event.put(ModEntityTypes.LITTLE_ZOMBIE.get(), LittleZombieEntity.setAttributes());
            event.put(ModEntityTypes.LITTLE_DUCK_TUBE_ZOMBIE.get(), LittleDuckyTubeZombieEntity.setAttributes());
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
            event.put(ModEntityTypes.SLED.get(), SledEntity.setAttributes());
            event.put(ModEntityTypes.ZOMBIE_BOBSLED_TEAM.get(), ZombieBobsledTeamEntity.setAttributes());
            event.put(ModEntityTypes.DOLPHIN_RIDER_ZOMBIE.get(), DolphinRiderZombieEntity.setAttributes());

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



            event.put(ModEntityTypes.SEA_SHROOM.get(), SeaShroomEntity.setAttributes());


            event.put(ModEntityTypes.PLANTERN.get(), PlanternEntity.setAttributes());


            event.put(ModEntityTypes.CACTUS.get(), CactusEntity.setAttributes());


            event.put(ModEntityTypes.BLOVER.get(), BloverEntity.setAttributes());


            event.put(ModEntityTypes.SPLIT_PEA.get(), SplitPeaEntity.setAttributes());


            event.put(ModEntityTypes.STAR_FRUIT.get(), StarFruitEntity.setAttributes());


            event.put(ModEntityTypes.PUMPKIN.get(), PumpkinEntity.setAttributes());


            event.put(ModEntityTypes.MAGNET_SHROOM.get(), MagnetShroomEntity.setAttributes());


            event.put(ModEntityTypes.CABBAGE_PULT.get(), CabbagePultEntity.setAttributes());


            event.put(ModEntityTypes.FLOWR_POT.get(), FlowerPotEntity.setAttributes());


            event.put(ModEntityTypes.KERNEL_PULT.get(), KernelPultEntity.setAttributes());


            event.put(ModEntityTypes.GARLIC.get(), GarlicEntity.setAttributes());


            event.put(ModEntityTypes.COFFEE_BEAN.get(), CoffeeBeanEntity.setAttributes());


            event.put(ModEntityTypes.MELON_PULT.get(), MelonPultEntity.setAttributes());


            event.put(ModEntityTypes.UMBRELLA_LEAF.get(), UmbrellaLeafEntity.setAttributes());


            event.put(ModEntityTypes.MARIGOLD.get(), MariGoldEntity.setAttributes());


            event.put(ModEntityTypes.JACK_ZOMBIE.get(), JackZombieEntity.setAttributes());


            event.put(ModEntityTypes.BALLOON_ZOMBIE.get(), BalloonZombieEntity.setAttributes());


            event.put(ModEntityTypes.DIGGER_ZOMBIE.get(), DiggerZombieEntity.setAttributes());


            event.put(ModEntityTypes.POGO_ZOMBIE.get(), PogoZombieEntity.setAttributes());


            event.put(ModEntityTypes.ZOMBIE_YETI.get(), ZombieYetiEntity.setAttributes());


            event.put(ModEntityTypes.GUNGEE_ZOMBIE.get(), BungeeZombieEntity.setAttributes());


            event.put(ModEntityTypes.LADDER_ZOMBIE.get(), LadderZombieEntity.setAttributes());


            event.put(ModEntityTypes.CATAPULT_ZOMBIE.get(), CatapultZombieEntity.setAttributes());


            event.put(ModEntityTypes.GARGANTUAR.get(), GargantuarEntity.setAttributes());


            event.put(ModEntityTypes.IMP.get(), ImpEntity.setAttributes());


            event.put(ModEntityTypes.ZOMBOSS.get(), ZomBossEntity.setAttributes());


            event.put(ModEntityTypes.GATLING_PEA.get(), GatlingPeaEntity.setAttributes());


            event.put(ModEntityTypes.TWIN_SUNFLOWER.get(), TwinSunflowerEntity.setAttributes());


            event.put(ModEntityTypes.GLOOM_SHROOM.get(), GloomShroomEntity.setAttributes());


            event.put(ModEntityTypes.CATTAIL.get(), CattailEntity.setAttributes());


            event.put(ModEntityTypes.WINTER_MELON.get(), WinterMelonEntity.setAttributes());


            event.put(ModEntityTypes.GOLD_MAGNET.get(), GoldMagnetEntity.setAttributes());


            event.put(ModEntityTypes.SPIKE_ROCK.get(), SpikeRockEntity.setAttributes());


            event.put(ModEntityTypes.COB_CANNON.get(), CobCannonEntity.setAttributes());


        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.ZOMBIE_HAND_LAYER, ZombieHandModel::createBodyLayer);

        }
    }
}
