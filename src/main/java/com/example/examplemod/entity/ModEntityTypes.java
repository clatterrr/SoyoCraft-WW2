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

    public static final RegistryObject<EntityType<BacteriaEntity>> BACTERIA =
            ENTITY_TYPES.register("bacteria",
                    () -> EntityType.Builder.of(BacteriaEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "bacteria").toString()));

    public static final RegistryObject<EntityType<BalloonEntity>> BALLOON =
            ENTITY_TYPES.register("balloon",
                    () -> EntityType.Builder.of(BalloonEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "balloon").toString()));
    public static final RegistryObject<EntityType<PartyGoersEntity>> PARTY_GOERS =
            ENTITY_TYPES.register("party_goers",
                    () -> EntityType.Builder.of(PartyGoersEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "party_goers").toString()));

    public static final RegistryObject<EntityType<SmilesEntity>> SMILES =
            ENTITY_TYPES.register("smiles",
                    () -> EntityType.Builder.of(SmilesEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "smiles").toString()));
    public static final RegistryObject<EntityType<HoundEntity>> HOUND =
            ENTITY_TYPES.register("hound",
                    () -> EntityType.Builder.of(HoundEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "hound").toString()));

    public static final RegistryObject<EntityType<CowSkinStealerEntity>> COW_SKIN_STEALER =
            ENTITY_TYPES.register("cow_skin_stealer",
                    () -> EntityType.Builder.of(CowSkinStealerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "cow_skin_stealer").toString()));

    public static final RegistryObject<EntityType<VillagerSkinStealerEntity>> VILLAGER_SKIN_STEALER =
            ENTITY_TYPES.register("villager_skin_stealer",
                    () -> EntityType.Builder.of(VillagerSkinStealerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "villager_skin_stealer").toString()));

    public static final RegistryObject<EntityType<CreeperSkinStealerEntity>> CREEPER_SKIN_STEALER =
            ENTITY_TYPES.register("creeper_skin_stealer",
                    () -> EntityType.Builder.of(CreeperSkinStealerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "creeper_skin_stealer").toString()));


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
