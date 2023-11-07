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

    public static final RegistryObject<EntityType<SunShroomEntity>> SUN_SHROOM =
            ENTITY_TYPES.register("sun_shroom",
                    () -> EntityType.Builder.of(SunShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "sun_shroom").toString()));
    public static final RegistryObject<EntityType<FumeShroomEntity>> FUME_SHROOM =
            ENTITY_TYPES.register("fume_shroom",
                    () -> EntityType.Builder.of(FumeShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "fume_shroom").toString()));

    public static final RegistryObject<EntityType<GraveBusterEntity>> GRAVE_BUSTER =
                ENTITY_TYPES.register("grave_buster",
                    () -> EntityType.Builder.of(GraveBusterEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "grave_buster").toString()));
    public static final RegistryObject<EntityType<HypnoShroomEntity>> HYPNO_SHROOM =
            ENTITY_TYPES.register("hypno_shroom",
                    () -> EntityType.Builder.of(HypnoShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "hypno_shroom").toString()));

    public static final RegistryObject<EntityType<ScaredyShroomEntity>> SCAREDY_SHROOM =
            ENTITY_TYPES.register("scaredy_shroom",
                    () -> EntityType.Builder.of(ScaredyShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "scaredy_shroom").toString()));

    public static final RegistryObject<EntityType<IceShroomEntity>> ICE_SHROOM =
            ENTITY_TYPES.register("ice_shroom",
                    () -> EntityType.Builder.of(IceShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "ice_shroom").toString()));

    public static final RegistryObject<EntityType<DoomShroomEntity>> DOOM_SHROOM =
            ENTITY_TYPES.register("doom_shroom",
                    () -> EntityType.Builder.of(DoomShroomEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "doom_shroom").toString()));

    public static final RegistryObject<EntityType<NewspaperZombieEntity>> NEWSPAPER_ZOMBIE =
            ENTITY_TYPES.register("newspaper_zombie",
                    () -> EntityType.Builder.of(NewspaperZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "newspaper_zombie").toString()));
    public static final RegistryObject<EntityType<ScreenDoorZombieEntity>> SCREEN_DOOR_ZOMBIE =
            ENTITY_TYPES.register("screen_door_zombie",
                    () -> EntityType.Builder.of(ScreenDoorZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "screen_door_zombie").toString()));

    public static final RegistryObject<EntityType<FootballZombieEntity>> FOOTBALL_ZOMBIE =
            ENTITY_TYPES.register("football_zombie",
                    () -> EntityType.Builder.of(FootballZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "football_zombie").toString()));

    public static final RegistryObject<EntityType<DancingZombieEntity>> DANCING_ZOMBIE =
            ENTITY_TYPES.register("dancing_zombie",
                    () -> EntityType.Builder.of(DancingZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "dancing_zombie").toString()));

    public static final RegistryObject<EntityType<BackupZombieEntity>> BACKUP_ZOMBIE =
            ENTITY_TYPES.register("backup_zombie",
                    () -> EntityType.Builder.of(BackupZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "backup_zombie").toString()));




    public static final RegistryObject<EntityType<ZombieHandEntity>> ZOMBIE_HAND =
            ENTITY_TYPES.register("zombie_hand",
                    () -> EntityType.Builder.<ZombieHandEntity>of(ZombieHandEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("zombie_hand"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
