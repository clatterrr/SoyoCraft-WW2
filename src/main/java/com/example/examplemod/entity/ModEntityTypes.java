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

        public static final RegistryObject<EntityType<ChomperEntity>> CHOMPER =
            ENTITY_TYPES.register("chomper",
                    () -> EntityType.Builder.of(ChomperEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "chomper").toString()));

    public static final RegistryObject<EntityType<SmokerEntity>> SMOKER =
            ENTITY_TYPES.register("smiler",
                    () -> EntityType.Builder.of(SmokerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "smiler").toString()));

    public static final RegistryObject<EntityType<TankEntity>> TANK =
            ENTITY_TYPES.register("tank",
                    () -> EntityType.Builder.of(TankEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "tank").toString()));

    public static final RegistryObject<EntityType<PlaneEntity>> PLANE =
            ENTITY_TYPES.register("plane",
                    () -> EntityType.Builder.of(PlaneEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "plane").toString()));

    public static final RegistryObject<EntityType<SoliderEntity>> SOLIDER =
            ENTITY_TYPES.register("solider_ak47",
                    () -> EntityType.Builder.of(SoliderEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "solider_ak47").toString()));

    public static final RegistryObject<EntityType<MagicProjectileEntity>> MAGIC_PROJECTILE =
            ENTITY_TYPES.register("magic_projectile",
                    () -> EntityType.Builder.<MagicProjectileEntity>of(MagicProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("magic_projectile"));

    public static final RegistryObject<EntityType<CreeperProjectileEntity>> CREEPER_PROJECTILE =
            ENTITY_TYPES.register("creeper_projectile",
                    () -> EntityType.Builder.<CreeperProjectileEntity>of(CreeperProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("creeper_projectile"));

    public static final RegistryObject<EntityType<BulletProjectileEntity>> BULLET_PROJECTILE =
            ENTITY_TYPES.register("bullet_projectile",
                    () -> EntityType.Builder.<BulletProjectileEntity>of(BulletProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("bullet_projectile"));

    public static final RegistryObject<EntityType<PlaneBombEntity>> PLANE_BOMB =
            ENTITY_TYPES.register("plane_bomb",
                    () -> EntityType.Builder.<PlaneBombEntity>of(PlaneBombEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("plane_bomb"));

    public static final RegistryObject<EntityType<TankBombEntity>> TANK_BOMB =
            ENTITY_TYPES.register("tank_bomb",
                    () -> EntityType.Builder.<TankBombEntity>of(TankBombEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("tank_bomb"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
