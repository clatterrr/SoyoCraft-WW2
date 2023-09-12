package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.item.custom.TongueItem;
import com.example.examplemod.item.custom.ZhaItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> SMOKER_SPAWN_EGG = ITEMS.register("smiler_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SMOKER, 0x22b341, 0x19732e,
                 new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TANK_SPAWN_EGG = ITEMS.register("tank_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TANK, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SOLIDER_SPAWN_EGG = ITEMS.register("solider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SOLIDER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> TONGUE = ITEMS.register("tongue", () -> new TongueItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ZHA = ITEMS.register("zha", () -> new ZhaItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
