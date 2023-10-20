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

    public static final RegistryObject<EntityType<CactusEntity>> CACTUS =
            ENTITY_TYPES.register("cactus",
                    () -> EntityType.Builder.of(CactusEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "cactus").toString()));

    public static final RegistryObject<EntityType<SunFlowerEntity>> SUN_FLOWER =
            ENTITY_TYPES.register("sun_flower",
                    () -> EntityType.Builder.of(SunFlowerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "sun_flower").toString()));



    public static final RegistryObject<EntityType<PeaShooterEntity>> PEA_SHOOTER =
            ENTITY_TYPES.register("pea_shooter",
                    () -> EntityType.Builder.of(PeaShooterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pea_shooter").toString()));

    public static final RegistryObject<EntityType<CherryBombEntity>> CHERRY_BOMB =
            ENTITY_TYPES.register("cherry_bomb",
                    () -> EntityType.Builder.of(CherryBombEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "cherry_bomb").toString()));

    public static final RegistryObject<EntityType<WallNutEntity>> WALL_NUT =
            ENTITY_TYPES.register("wall_nut",
                    () -> EntityType.Builder.of(WallNutEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "wall_nut").toString()));

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

    public static final RegistryObject<EntityType<PotatoMineEntity>> POTATO_MINE =
            ENTITY_TYPES.register("potato_mine",
                    () -> EntityType.Builder.of(PotatoMineEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "potato_mine").toString()));

    public static final RegistryObject<EntityType<ChomperEntity>> CHOMPER =
            ENTITY_TYPES.register("chomper",
                    () -> EntityType.Builder.of(ChomperEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "chomper").toString()));

    public static final RegistryObject<EntityType<NormalZombieEntity>> NORMAL_ZOMBIE =
            ENTITY_TYPES.register("normal_zombie",
                    () -> EntityType.Builder.of(NormalZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "normal_zombie").toString()));

    public static final RegistryObject<EntityType<FlagZombieEntity>> FLAG_ZOMBIE =
            ENTITY_TYPES.register("flag_zombie",
                    () -> EntityType.Builder.of(FlagZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "flag_zombie").toString()));

    public static final RegistryObject<EntityType<ConeHeadZombieEntity>> CONE_HEAD_ZOMBIE =
            ENTITY_TYPES.register("cone_head_zombie",
                    () -> EntityType.Builder.of(ConeHeadZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "cone_head_zombie").toString()));

    public static final RegistryObject<EntityType<BucketHeadZombieEntity>> BUCKET_HEAD_ZOMBIE =
            ENTITY_TYPES.register("bucket_head_zombie",
                    () -> EntityType.Builder.of(BucketHeadZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "bucket_head_zombie").toString()));

    public static final RegistryObject<EntityType<PoleVaultingZombieEntity>> POLE_VAULTING_ZOMBIE =
            ENTITY_TYPES.register("pole_vaulting_zombie",
                    () -> EntityType.Builder.of(PoleVaultingZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "pole_vaulting_zombie").toString()));

    public static final RegistryObject<EntityType<MagicProjectileEntity>> MAGIC_PROJECTILE =
            ENTITY_TYPES.register("magic_projectile",
                    () -> EntityType.Builder.<MagicProjectileEntity>of(MagicProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("magic_projectile"));

    public static final RegistryObject<EntityType<SunEntity>> SUN =
            ENTITY_TYPES.register("sun",
                    () -> EntityType.Builder.<SunEntity>of(SunEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("sun"));

    public static final RegistryObject<EntityType<ConeEntity>> Cone =
            ENTITY_TYPES.register("cone",
                    () -> EntityType.Builder.<ConeEntity>of(ConeEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("cone"));

    public static final RegistryObject<EntityType<BucketEntity>> BUCKET =
            ENTITY_TYPES.register("bucket",
                    () -> EntityType.Builder.<BucketEntity>of(BucketEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("bucket"));

    public static final RegistryObject<EntityType<ZombieHandEntity>> ZOMBIE_HAND =
            ENTITY_TYPES.register("zombie_hand",
                    () -> EntityType.Builder.<ZombieHandEntity>of(ZombieHandEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("zombie_hand"));

    public static final RegistryObject<EntityType<PeaCropEntity>> PEA_CROP =
            ENTITY_TYPES.register("pea_crop",
                    () -> EntityType.Builder.<PeaCropEntity>of(PeaCropEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("pea_crop"));
    public static final RegistryObject<EntityType<BulletProjectileEntity>> BULLET_PROJECTILE =
            ENTITY_TYPES.register("bullet_projectile",
                    () -> EntityType.Builder.<BulletProjectileEntity>of(BulletProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("bullet_projectile"));

    public static final RegistryObject<EntityType<PeaProjectileEntity>> PEA_PROJECTILE =
            ENTITY_TYPES.register("pea_projectile",
                    () -> EntityType.Builder.<PeaProjectileEntity>of(PeaProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("pea_projectile"));

    public static final RegistryObject<EntityType<IcePeaProjectileEntity>> ICE_PEA_PROJECTILE =
            ENTITY_TYPES.register("ice_pea_projectile",
                    () -> EntityType.Builder.<IcePeaProjectileEntity>of(IcePeaProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("ice_pea_projectile"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
