package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.item.custom.*;
import com.example.examplemod.item.custom.BucketItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);
    public static final RegistryObject<Item> CACTUS_SPAWN_EGG = ITEMS.register("cactus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CACTUS, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> SUN_FLOWER_SPAWN_EGG = ITEMS.register("sun_flower_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SUN_FLOWER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PEA_SHOOTER_SPAWN_EGG = ITEMS.register("pea_shooter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PEA_SHOOTER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CHERRY_BOMB_SPAWN_EGG = ITEMS.register("cherry_bomb_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHERRY_BOMB, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> WALL_NUT_SPAWN_EGG = ITEMS.register("wall_nut_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WALL_NUT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CHOMPER_SPAWN_EGG = ITEMS.register("chomper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHOMPER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SNOW_PEA_SPAWN_EGG = ITEMS.register("snow_pea_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SNOW_PEA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> REPEATER_SPAWN_EGG = ITEMS.register("repeater_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.REPEATER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> POTATO_MINE_SPAWN_EGG = ITEMS.register("potato_mine_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.POTATO_MINE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> NORMAL_ZOMBIE_SPAWN_EGG = ITEMS.register("normal_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NORMAL_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> FLAG_ZOMBIE_SPAWN_EGG = ITEMS.register("flag_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FLAG_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CONE_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("cone_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CONE_HEAD_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BUCKET_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("bucket_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BUCKET_HEAD_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> POLE_VAULTING_ZOMBIE_SPAWN_EGG = ITEMS.register("pole_vaulting_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.POLE_VAULTING_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> TONGUE = ITEMS.register("tongue", () -> new TongueItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> SUN = ITEMS.register("sun", () -> new SunItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> CONE = ITEMS.register("cone", () -> new ConeItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> BUCKET = ITEMS.register("bucket", () -> new BucketItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> ZOMBIE_HAND = ITEMS.register("zombie_hand", () -> new ZombieHandItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PEA_CROP = ITEMS.register("pea_crop", () -> new PeaCropItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
