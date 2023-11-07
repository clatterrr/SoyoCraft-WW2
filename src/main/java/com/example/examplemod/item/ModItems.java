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

    public static final RegistryObject<Item> SUN_SHROOM_SPAWN_EGG = ITEMS.register("sun_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SUN_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PUFF_SHROOM_SPAWN_EGG = ITEMS.register("puff_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PUFF_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> FUME_SHROOM_SPAWN_EGG = ITEMS.register("fume_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FUME_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GRAVE_BUSTER_SPAWN_EGG = ITEMS.register("grave_buster_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRAVE_BUSTER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> HYPNO_SHROOM_SPAWN_EGG = ITEMS.register("hypno_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HYPNO_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SCAREDY_SHROOM_SPAWN_EGG = ITEMS.register("scaredy_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SCAREDY_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ICE_SHROOM_SPAWN_EGG = ITEMS.register("ice_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ICE_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DOOM_SHROOM_SPAWN_EGG = ITEMS.register("doom_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DOOM_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> NEWSPAPER_ZOMBIE_SPAWN_EGG = ITEMS.register("newspaper_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NEWSPAPER_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SCREEN_DOOR_ZOMBIE_SPAWN_EGG = ITEMS.register("screen_door_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SCREEN_DOOR_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> FOOTBALL_ZOMBIE_SPAWN_EGG = ITEMS.register("football_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FOOTBALL_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DANCING_ZOMBIE_SPAWN_EGG = ITEMS.register("dancing_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DANCING_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BACKUP_ZOMBIE_SPAWN_EGG = ITEMS.register("backup_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BACKUP_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));


    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));


    public static final RegistryObject<Item> ZOMBIE_HAND = ITEMS.register("zombie_hand", () -> new ZombieHandItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
