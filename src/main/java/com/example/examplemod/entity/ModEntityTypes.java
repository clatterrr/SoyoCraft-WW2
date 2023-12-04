package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.*;
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


    public static final RegistryObject<EntityType<NormalZombieEntity>> NORMAL_ZOMBIE =
            ENTITY_TYPES.register("normal_zombie",
                    () -> EntityType.Builder.of(NormalZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "normal_zombie").toString()));

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

    public static final RegistryObject<EntityType<LilyPadEntity>> LILY_PAD =
            ENTITY_TYPES.register("lily_pad",
                    () -> EntityType.Builder.of(LilyPadEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "lily_pad").toString()));
    public static final RegistryObject<EntityType<SquashEntity>> SQUASH =
            ENTITY_TYPES.register("squash",
                    () -> EntityType.Builder.of(SquashEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "squash").toString()));

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

    public static final RegistryObject<EntityType<ThreepeaterEntity>> THREEPEATER =
                ENTITY_TYPES.register("threepeater",
                    () -> EntityType.Builder.of(ThreepeaterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "threepeater").toString()));
    public static final RegistryObject<EntityType<TangleKelpEntity>> TANGLE_KELP =
            ENTITY_TYPES.register("tangle_kelp",
                    () -> EntityType.Builder.of(TangleKelpEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "tangle_kelp").toString()));

    public static final RegistryObject<EntityType<JalapenoEntity>> JALAPENO =
            ENTITY_TYPES.register("jalapeno",
                    () -> EntityType.Builder.of(JalapenoEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "jalapeno").toString()));

    public static final RegistryObject<EntityType<SpikeweedEntity>> SPIKEWEED =
            ENTITY_TYPES.register("spikeweed",
                    () -> EntityType.Builder.of(SpikeweedEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "spikeweed").toString()));

    public static final RegistryObject<EntityType<TorchwoodEntity>> TORCHWOOD =
            ENTITY_TYPES.register("torchwood",
                    () -> EntityType.Builder.of(TorchwoodEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "torchwood").toString()));

    public static final RegistryObject<EntityType<TallnutEntity>> TALLNUT =
            ENTITY_TYPES.register("tallnut",
                    () -> EntityType.Builder.of(TallnutEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "tallnut").toString()));

    public static final RegistryObject<EntityType<PeaShooterEntity>> PEA_SHOOTER =
            ENTITY_TYPES.register("pea_shooter",
                    () -> EntityType.Builder.of(PeaShooterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pea_shooter").toString()));

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


    public static final RegistryObject<EntityType<FootballZombieEntity>> FOOTBALL_ZOMBIE =
            ENTITY_TYPES.register("football_zombie",
                    () -> EntityType.Builder.of(FootballZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "football_zombie").toString()));
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

    public static final RegistryObject<EntityType<DuckTubeZombieEntity>> DUCK_TUBE_ZOMBIE =
            ENTITY_TYPES.register("duck_tube_zombie",
                    () -> EntityType.Builder.of(DuckTubeZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "duck_tube_zombie").toString()));

    public static final RegistryObject<EntityType<DuckTubeConeHeadZombieEntity>> DUCK_TUBE_CONE_HEAD_ZOMBIE =
            ENTITY_TYPES.register("duck_tube_cone_head_zombie",
                    () -> EntityType.Builder.of(DuckTubeConeHeadZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "duck_tube_cone_head_zombie").toString()));

    public static final RegistryObject<EntityType<DuckTubeBucketHeadZombieEntity>> DUCK_TUBE_BUCKET_HEAD_ZOMBIE =
            ENTITY_TYPES.register("duck_tube_bucket_head_zombie",
                    () -> EntityType.Builder.of(DuckTubeBucketHeadZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "duck_tube_bucket_head_zombie").toString()));

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

    public static final RegistryObject<EntityType<MagicProjectileEntity>> MAGIC_PROJECTILE =
            ENTITY_TYPES.register("magic_projectile",
                    () -> EntityType.Builder.<MagicProjectileEntity>of(MagicProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("magic_projectile"));

    public static final RegistryObject<EntityType<SporesProjectileEntity>> SPORES_PROJECTILE =
            ENTITY_TYPES.register("spores_projectile",
                    () -> EntityType.Builder.<SporesProjectileEntity>of(SporesProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("spores_projectile"));

    public static final RegistryObject<EntityType<HurtProjectileEntity>> HURT_PROJECTILE =
            ENTITY_TYPES.register("hurt_projectile",
                    () -> EntityType.Builder.<HurtProjectileEntity>of(HurtProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("hurt_projectile"));

    public static final RegistryObject<EntityType<ZombieHandEntity>> ZOMBIE_HAND =
            ENTITY_TYPES.register("zombie_hand",
                    () -> EntityType.Builder.<ZombieHandEntity>of(ZombieHandEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("zombie_hand"));

    public static final RegistryObject<EntityType<PoleVaultingZombieEntity>> POLE_VAULTING_ZOMBIE =
            ENTITY_TYPES.register("pole_vaulting_zombie",
                    () -> EntityType.Builder.of(PoleVaultingZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pole_vaulting_zombie").toString()));

    public static final RegistryObject<EntityType<NewspaperZombieEntity>> NEWSPAPER_ZOMBIE =
            ENTITY_TYPES.register("newspaper_zombie",
                    () -> EntityType.Builder.of(NewspaperZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "newspaper_zombie").toString()));

    public static final RegistryObject<EntityType<SnorkelZombieEntity>> SNORKEL_ZOMBIE =
            ENTITY_TYPES.register("snorkel_zombie",
                    () -> EntityType.Builder.of(SnorkelZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "snorkel_zombie").toString()));

    public static final RegistryObject<EntityType<ZomboniEntity>> ZOMBONI =
            ENTITY_TYPES.register("zomboni",
                    () -> EntityType.Builder.of(ZomboniEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "zomboni").toString()));

    public static final RegistryObject<EntityType<ZombieBobsledTeamEntity>> ZOMBIE_BOBSLED_TEAM =
            ENTITY_TYPES.register("zombie_bobsled_team",
                    () -> EntityType.Builder.of(ZombieBobsledTeamEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "zombie_bobsled_team").toString()));

    public static final RegistryObject<EntityType<DolphinRiderZombieEntity>> DOLPHIN_RIDER_ZOMBIE =
            ENTITY_TYPES.register("dolphin_rider_zombie",
                    () -> EntityType.Builder.of(DolphinRiderZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "dolphin_rider_zombie").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
