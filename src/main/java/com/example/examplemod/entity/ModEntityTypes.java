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

    public static final RegistryObject<EntityType<TheVillagerEntity>> THE_VILLAGER =
            ENTITY_TYPES.register("the_villager",
                    () -> EntityType.Builder.of(TheVillagerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "the_villager").toString()));

    public static final RegistryObject<EntityType<StoneBlockEntity>> STONE_BLOCK =
            ENTITY_TYPES.register("stone_block",
                    () -> EntityType.Builder.of(StoneBlockEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "stone_block").toString()));

    public static final RegistryObject<EntityType<GlassBlockEntity>> GLASS_BLOCK =
            ENTITY_TYPES.register("glass_block",
                    () -> EntityType.Builder.of(GlassBlockEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "glass_block").toString()));

    public static final RegistryObject<EntityType<SlingShotEntity>> SLING_SHOT =
            ENTITY_TYPES.register("sling_shot",
                    () -> EntityType.Builder.of(SlingShotEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "sling_shot").toString()));

    public static final RegistryObject<EntityType<WoodBlockEntity>> WOOD_BLOCK =
            ENTITY_TYPES.register("wood_block",
                    () -> EntityType.Builder.of(WoodBlockEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "wood_block").toString()));

    public static final RegistryObject<EntityType<BirdEggEntity>> BIRD_EGG =
            ENTITY_TYPES.register("bird_egg",
                    () -> EntityType.Builder.of(BirdEggEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "bird_egg").toString()));
    public static final RegistryObject<EntityType<RedBirdEntity>> RED_BIRD =
            ENTITY_TYPES.register("red_bird",
                    () -> EntityType.Builder.of(RedBirdEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "red_bird").toString()));

    public static final RegistryObject<EntityType<BlueBirdEntity>> BLUE_BIRD =
            ENTITY_TYPES.register("blue_bird",
                    () -> EntityType.Builder.of(BlueBirdEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "blue_bird").toString()));

    public static final RegistryObject<EntityType<ChuckBirdEntity>> CHUCK_BIRD =
            ENTITY_TYPES.register("chuck_bird",
                    () -> EntityType.Builder.of(ChuckBirdEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "chuck_bird").toString()));

    public static final RegistryObject<EntityType<BombBirdEntity>> BOMB_BIRD =
            ENTITY_TYPES.register("bomb_bird",
                    () -> EntityType.Builder.of(BombBirdEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "bomb_bird").toString()));

    public static final RegistryObject<EntityType<GreenPig1Entity>> GREEN_PIG_1 =
            ENTITY_TYPES.register("green_pig_1",
                    () -> EntityType.Builder.of(GreenPig1Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "green_pig_1").toString()));

    public static final RegistryObject<EntityType<GreenPig2Entity>> GREEN_PIG_2 =
            ENTITY_TYPES.register("green_pig_2",
                    () -> EntityType.Builder.of(GreenPig2Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "green_pig_2").toString()));

    public static final RegistryObject<EntityType<GreenPig3Entity>> GREEN_PIG_3 =
            ENTITY_TYPES.register("green_pig_3",
                    () -> EntityType.Builder.of(GreenPig3Entity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "green_pig_3").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
