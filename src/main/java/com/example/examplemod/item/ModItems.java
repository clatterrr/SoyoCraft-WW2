package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);


    public static final RegistryObject<Item> NORMAL_ZOMBIE_SPAWN_EGG = ITEMS.register("normal_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NORMAL_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BACTERIA_SPAWN_EGG = ITEMS.register("bacteria_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BACTERIA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PARTY_GOERS_SPAWN_EGG = ITEMS.register("party_goers_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PARTY_GOERS, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BALLOON_SPAWN_EGG = ITEMS.register("balloon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BALLOON, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SMILES_SPAWN_EGG = ITEMS.register("smiles_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SMILES, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> HOUND_SPAWN_EGG = ITEMS.register("hound_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HOUND, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> VILLAGER_SKIN_STEALER = ITEMS.register("villager_skin_stealer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.VILLAGER_SKIN_STEALER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CREEPER_SKIN_STEALER = ITEMS.register("creeper_skin_stealer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CREEPER_SKIN_STEALER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> COW_SKIN_STEALER = ITEMS.register("cow_skin_stealer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COW_SKIN_STEALER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));



    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));


    public static final RegistryObject<Item> ZOMBIE_HAND = ITEMS.register("zombie_hand", () -> new ZombieHandItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
