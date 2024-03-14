package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.*;
import com.example.examplemod.entity.custom.DayPlant.JalapenoEntity;
import com.example.examplemod.entity.custom.DayPlant.PeaShooterEntity;
import com.example.examplemod.entity.custom.DayPlant.RepeaterEntity;
import com.example.examplemod.entity.custom.DayZombie.*;
import com.example.examplemod.entity.custom.Garden.*;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomEntity;
import com.example.examplemod.entity.custom.NightPlant.PuffShroomSleepEntity;
import com.example.examplemod.entity.custom.NightZombie.NewspaperZombieEntity;
import com.example.examplemod.entity.custom.Projectile.FirePeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.IcePeaProjectileEntity;
import com.example.examplemod.entity.custom.Projectile.PeaProjectileEntity;
import com.example.examplemod.entity.custom.DayPlant.SnowPeaEntity;
import com.example.examplemod.entity.custom.DayPlant.SunflowerEntity;
import com.example.examplemod.entity.custom.DayPlant.WallnutEntity;
import com.example.examplemod.entity.custom.Projectile.SporeEntity;
import com.example.examplemod.entity.custom.UpgradePlant.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);

    // DayPlant
    public static final RegistryObject<EntityType<SunflowerEntity>> SUNFLOWER =
            ENTITY_TYPES.register("sunflower",
                    () -> EntityType.Builder.of(SunflowerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "sunflower").toString()));

    public static final RegistryObject<EntityType<WallnutEntity>> WALLNUT =
            ENTITY_TYPES.register("wallnut",
                    () -> EntityType.Builder.of(WallnutEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "wallnut").toString()));

    // DayZombie

    public static final RegistryObject<EntityType<NormalZombieEntity>> NORMAL_ZOMBIE =
            ENTITY_TYPES.register("normal_zombie",
                    () -> EntityType.Builder.of(NormalZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "normal_zombie").toString()));



    // NightPlant

    public static final RegistryObject<EntityType<PuffShroomEntity>> PUFF_SHROOM =
            ENTITY_TYPES.register("puff_shroom",
                    () -> EntityType.Builder.of(PuffShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "puff_shroom").toString()));

    public static final RegistryObject<EntityType<PuffShroomSleepEntity>> PUFF_SHROOM_SLEEP =
            ENTITY_TYPES.register("puff_shroom_sleep",
                    () -> EntityType.Builder.of(PuffShroomSleepEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "puff_shroom_sleep").toString()));

    // NightZombie
    public static final RegistryObject<EntityType<FootballZombieEntity>> FOOTBALL_ZOMBIE =
            ENTITY_TYPES.register("football_zombie",
                    () -> EntityType.Builder.of(FootballZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "football_zombie").toString()));

    // PoolPlant


    // Garden

    public static final RegistryObject<EntityType<CrazyDaveEntity>> CRAZY_DAVE =
            ENTITY_TYPES.register("crazy_dave",
                    () -> EntityType.Builder.of(CrazyDaveEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "crazy_dave").toString()));
    public static final RegistryObject<EntityType<DaveCarEntity>> DAVE_CAR =
            ENTITY_TYPES.register("dave_car",
                    () -> EntityType.Builder.of(DaveCarEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "dave_car").toString()));

    public static final RegistryObject<EntityType<LawnMowerEntity>> LAWN_MOWER =
            ENTITY_TYPES.register("lawn_mower",
                    () -> EntityType.Builder.of(LawnMowerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "lawn_mower").toString()));

    public static final RegistryObject<EntityType<PoolCleanerEntity>> POOL_CLEANER =
            ENTITY_TYPES.register("pool_cleaner",
                    () -> EntityType.Builder.of(PoolCleanerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pool_cleaner").toString()));

    public static final RegistryObject<EntityType<GardenRakeEntity>> GARDEN_RAKE =
            ENTITY_TYPES.register("garden_rake",
                    () -> EntityType.Builder.of(GardenRakeEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "garden_rake").toString()));

    // Projectile
    public static final RegistryObject<EntityType<PeaProjectileEntity>> PEA_PROJECTILE =
            ENTITY_TYPES.register("pea_projectile",
                    () -> EntityType.Builder.of(PeaProjectileEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pea_projectile").toString()));

    public static final RegistryObject<EntityType<IcePeaProjectileEntity>> ICE_PEA_PROJECTILE =
            ENTITY_TYPES.register("ice_pea_projectile",
                    () -> EntityType.Builder.of(IcePeaProjectileEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "ice_pea_projectile").toString()));

    public static final RegistryObject<EntityType<FirePeaProjectileEntity>> FIRE_PEA_PROJECTILE =
            ENTITY_TYPES.register("fire_pea_projectile",
                    () -> EntityType.Builder.of(FirePeaProjectileEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "fire_pea_projectile").toString()));

    public static final RegistryObject<EntityType<SporeEntity>> SPORE =
            ENTITY_TYPES.register("spore",
                    () -> EntityType.Builder.of(SporeEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "spore").toString()));







    public static final RegistryObject<EntityType<HouseDoor1Entity>> HOUSE_DOOR_1 =
            ENTITY_TYPES.register("house_door_1",
                    () -> EntityType.Builder.of(HouseDoor1Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "house_door_1").toString()));
    public static final RegistryObject<EntityType<HouseDoor2Entity>> HOUSE_DOOR_2 =
            ENTITY_TYPES.register("house_door_2",
                    () -> EntityType.Builder.of(HouseDoor2Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "house_door_2").toString()));

    public static final RegistryObject<EntityType<DuckEntity>> DUCK =
            ENTITY_TYPES.register("duck",
                    () -> EntityType.Builder.of(DuckEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "duck").toString()));

    public static final RegistryObject<EntityType<FogGeneratorEntity>> FOG_GENEATOR =
            ENTITY_TYPES.register("fog_generator",
                    () -> EntityType.Builder.of(FogGeneratorEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "fog_generator").toString()));

    public static final RegistryObject<EntityType<PoolChairEntity>> POOL_CHAIR =
            ENTITY_TYPES.register("pool_chair",
                    () -> EntityType.Builder.of(PoolChairEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pool_chair").toString()));

    public static final RegistryObject<EntityType<FenceEntity>> FENCE =
            ENTITY_TYPES.register("fence",
                    () -> EntityType.Builder.of(FenceEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "fence").toString()));

    public static final RegistryObject<EntityType<Stone1Entity>> STONE1 =
            ENTITY_TYPES.register("stone1",
                    () -> EntityType.Builder.of(Stone1Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "stone1").toString()));

    public static final RegistryObject<EntityType<Stone2Entity>> STONE2 =
            ENTITY_TYPES.register("stone2",
                    () -> EntityType.Builder.of(Stone2Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "stone2").toString()));

    public static final RegistryObject<EntityType<SubmarineEntity>> SUB_MARINE =
            ENTITY_TYPES.register("submarine",
                    () -> EntityType.Builder.of(SubmarineEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "submarine").toString()));
    public static final RegistryObject<EntityType<LifeGuradTowerEntity>> LIFE_GUARD_TOWER =
            ENTITY_TYPES.register("life_guard_tower",
                    () -> EntityType.Builder.of(LifeGuradTowerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "life_guard_tower").toString()));



    public static final RegistryObject<EntityType<PeaShooterEntity>> PEA_SHOOTER =
            ENTITY_TYPES.register("pea_shooter",
                    () -> EntityType.Builder.of(PeaShooterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pea_shooter").toString()));

    public static final RegistryObject<EntityType<SnowPeaEntity>> SNOW_PEA =
            ENTITY_TYPES.register("snow_pea",
                    () -> EntityType.Builder.of(SnowPeaEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "snow_pea").toString()));

    public static final RegistryObject<EntityType<RepeaterEntity>> REPEATER =
            ENTITY_TYPES.register("repeater",
                    () -> EntityType.Builder.of(RepeaterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "repeater").toString()));





    public static final RegistryObject<EntityType<FreezeZombieEntity>> FREEZE_ZOMBIE =
            ENTITY_TYPES.register("freeze_zombie",
                    () -> EntityType.Builder.of(FreezeZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "freeze_zombie").toString()));

    public static final RegistryObject<EntityType<AshZombieEntity>> ASH_ZOMBIE =
            ENTITY_TYPES.register("ash_zombie",
                    () -> EntityType.Builder.of(AshZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "ash_zombie").toString()));



    public static final RegistryObject<EntityType<ConeheadZombieEntity>> CONEHEAD_ZOMBIE =
            ENTITY_TYPES.register("conehead_zombie",
                    () -> EntityType.Builder.of(ConeheadZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "conehead_zombie").toString()));

    public static final RegistryObject<EntityType<BucketheadZombieEntity>> BUCKETHEAD_ZOMBIE =
            ENTITY_TYPES.register("buckethead_zombie",
                    () -> EntityType.Builder.of(BucketheadZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "buckethead_zombie").toString()));

    public static final RegistryObject<EntityType<Grave1Entity>> GRAVE1 =
            ENTITY_TYPES.register("grave1",
                    () -> EntityType.Builder.of(Grave1Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "grave1").toString()));

    public static final RegistryObject<EntityType<Grave2Entity>> GRAVE2 =
            ENTITY_TYPES.register("grave2",
                    () -> EntityType.Builder.of(Grave2Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "grave2").toString()));

    public static final RegistryObject<EntityType<Grave3Entity>> GRAVE3 =
            ENTITY_TYPES.register("grave3",
                    () -> EntityType.Builder.of(Grave3Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "grave3").toString()));

    public static final RegistryObject<EntityType<ZombieHandEntity>> ZOMBIE_HAND =
            ENTITY_TYPES.register("zombie_hand",
                    () -> EntityType.Builder.<ZombieHandEntity>of(ZombieHandEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("zombie_hand"));



    public static final RegistryObject<EntityType<NewspaperZombieEntity>> NEWSPAPER_ZOMBIE =
            ENTITY_TYPES.register("newspaper_zombie",
                    () -> EntityType.Builder.of(NewspaperZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "newspaper_zombie").toString()));






    public static final RegistryObject<EntityType<GatlingPeaEntity>> GATLING_PEA =
            ENTITY_TYPES.register("gatling_pea",
                    () -> EntityType.Builder.of(GatlingPeaEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "gatling_pea").toString()));




    public static final RegistryObject<EntityType<TwinSunflowerEntity>> TWIN_SUNFLOWER =
            ENTITY_TYPES.register("twin_sunflower",
                    () -> EntityType.Builder.of(TwinSunflowerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "twin_sunflower").toString()));




    public static final RegistryObject<EntityType<GloomShroomEntity>> GLOOM_SHROOM =
            ENTITY_TYPES.register("gloom_shroom",
                    () -> EntityType.Builder.of(GloomShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "gloom_shroom").toString()));




    public static final RegistryObject<EntityType<CattailEntity>> CATTAIL =
            ENTITY_TYPES.register("cattail",
                    () -> EntityType.Builder.of(CattailEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "cattail").toString()));




    public static final RegistryObject<EntityType<WinterMelonEntity>> WINTER_MELON =
            ENTITY_TYPES.register("winter_melon",
                    () -> EntityType.Builder.of(WinterMelonEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "winter_melon").toString()));




    public static final RegistryObject<EntityType<GoldMagnetEntity>> GOLD_MAGNET =
            ENTITY_TYPES.register("gold_magnet",
                    () -> EntityType.Builder.of(GoldMagnetEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "gold_magnet").toString()));




    public static final RegistryObject<EntityType<SpikeRockEntity>> SPIKE_ROCK =
            ENTITY_TYPES.register("spike_rock",
                    () -> EntityType.Builder.of(SpikeRockEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "spike_rock").toString()));




    public static final RegistryObject<EntityType<CobCannonEntity>> COB_CANNON =
            ENTITY_TYPES.register("cob_cannon",
                    () -> EntityType.Builder.of(CobCannonEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "cob_cannon").toString()));

    public static final RegistryObject<EntityType<MarioEntity>> MARIO =
            ENTITY_TYPES.register("mario",
                    () -> EntityType.Builder.of(MarioEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "mario").toString()));

    public static final RegistryObject<EntityType<MarioSmallEntity>> MARIO_SMALL =
            ENTITY_TYPES.register("mario_small",
                    () -> EntityType.Builder.of(MarioSmallEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "mario_small").toString()));

    public static final RegistryObject<EntityType<GoombaEntity>> GOOMBA =
            ENTITY_TYPES.register("goomba",
                    () -> EntityType.Builder.of(GoombaEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "goomba").toString()));

    public static final RegistryObject<EntityType<KoopaEntity>> KOOPA =
            ENTITY_TYPES.register("koopa",
                    () -> EntityType.Builder.of(KoopaEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "koopa").toString()));

    public static final RegistryObject<EntityType<PiranhaEntity>> PIRANHA =
            ENTITY_TYPES.register("piranha",
                    () -> EntityType.Builder.of(PiranhaEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "piranha").toString()));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
