package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.ChuckBirdEntity;
import com.example.examplemod.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> THE_VILLAGER_SPAWN_EGG = ITEMS.register("the_villager_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.THE_VILLAGER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> STONE_BLOCK_SPAWN_EGG = ITEMS.register("stone_block_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BIRD_EGG, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GLASS_BLOCK_SPAWN_EGG = ITEMS.register("glass_block_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BIRD_EGG, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> WOOD_BLOCK_SPAWN_EGG = ITEMS.register("wood_block_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BIRD_EGG, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> BIRD_EGG_SPAWN_EGG = ITEMS.register("bird_egg_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BIRD_EGG, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> RED_BIRD_SPAWN_EGG = ITEMS.register("red_bird_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.RED_BIRD, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BLUE_BIRD_SPAWN_EGG = ITEMS.register("blue_bird_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BLUE_BIRD, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CHUCK_BIRD_SPAWN_EGG = ITEMS.register("chuck_bird_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHUCK_BIRD, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BOMB_BIRD_SPAWN_EGG = ITEMS.register("bomb_bird_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BOMB_BIRD, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GREEN_PIG_1_SPAWN_EGG = ITEMS.register("green_pig_1_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GREEN_PIG_1, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> GREEN_PIG_2_SPAWN_EGG = ITEMS.register("green_pig_2_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GREEN_PIG_2, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GREEN_PIG_3_SPAWN_EGG = ITEMS.register("green_pig_3_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GREEN_PIG_3, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SLING_SHOT_SPAWN_EGG = ITEMS.register("sling_shot_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SLING_SHOT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<RedBirdShooterItem> RED_BIRD_SHOOTER = ITEMS.register("red_bird_shooter", () -> new RedBirdShooterItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<ChuckBirdShooterItem> CHUCK_BIRD_SHOOTER = ITEMS.register("chuck_bird_shooter", () -> new ChuckBirdShooterItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<BombBirdShooterItem> BOMB_BIRD_SHOOTER = ITEMS.register("bomb_bird_shooter", () -> new BombBirdShooterItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
