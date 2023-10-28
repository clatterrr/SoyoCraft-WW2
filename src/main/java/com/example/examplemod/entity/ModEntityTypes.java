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

    public static final RegistryObject<EntityType<GrassGiantEntity>> GRASS_GIANT =
            ENTITY_TYPES.register("grass_giant",
                    () -> EntityType.Builder.of(GrassGiantEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "grass_giant").toString()));

    public static final RegistryObject<EntityType<SnowArmEntity>> SNOW_ARM =
            ENTITY_TYPES.register("snow_arm",
                    () -> EntityType.Builder.of(SnowArmEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "snow_arm").toString()));

    public static final RegistryObject<EntityType<EyeWormEntity>> EYE_WORM =
            ENTITY_TYPES.register("eye_worm",
                    () -> EntityType.Builder.of(EyeWormEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "eye_worm").toString()));

    public static final RegistryObject<EntityType<MagicProjectileEntity>> MAGIC_PROJECTILE =
            ENTITY_TYPES.register("magic_projectile",
                    () -> EntityType.Builder.<MagicProjectileEntity>of(MagicProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("magic_projectile"));

    public static final RegistryObject<EntityType<ZombieHandEntity>> ZOMBIE_HAND =
            ENTITY_TYPES.register("zombie_hand",
                    () -> EntityType.Builder.<ZombieHandEntity>of(ZombieHandEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("zombie_hand"));
    public static final RegistryObject<EntityType<GrassProjectileEntity>> GRASS_PROJECTILE =
            ENTITY_TYPES.register("grass_projectile",
                    () -> EntityType.Builder.<GrassProjectileEntity>of(GrassProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("grass_projectile"));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
