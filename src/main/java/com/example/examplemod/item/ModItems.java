package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.item.custom.*;
import com.example.examplemod.item.custom.IronBucketItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> CRAZY_DAVE_SPAWN_EGG = ITEMS.register("crazy_dave_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CRAZY_DAVE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DAVE_CAR_SPAWN_EGG = ITEMS.register("dave_car_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DAVE_CAR, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> LAWN_MOWER_SPAWN_EGG = ITEMS.register("lawn_mower_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LAWN_MOWER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> POOL_CLEANER_SPAWN_EGG = ITEMS.register("pool_cleaner_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.POOL_CLEANER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> GARDEN_RAKE_SPAWN_EGG = ITEMS.register("garden_rake_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GARDEN_RAKE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> NORMAL_ZOMBIE_SPAWN_EGG = ITEMS.register("normal_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NORMAL_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PEA_SHOOTER_SPAWN_EGG = ITEMS.register("pea_shooter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PEA_SHOOTER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> SUN_FLOWER_SPAWN_EGG = ITEMS.register("sun_flower_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SUNFLOWER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> WALL_NUT_SPAWN_EGG = ITEMS.register("wall_nut_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WALLNUT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> PUFF_SHROOM_SPAWN_EGG = ITEMS.register("puff_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PUFF_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PUFF_SHROOM_SLEEP_SPAWN_EGG = ITEMS.register("puff_shroom_sleep_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PUFF_SHROOM_SLEEP, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PEA_PROJECTILE_SPAWN_EGG = ITEMS.register("pea_projectile_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PEA_PROJECTILE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SNOW_PEA_SPAWN_EGG = ITEMS.register("snow_pea_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SNOW_PEA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> REPEATER_SPAWN_EGG = ITEMS.register("repeater_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.REPEATER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CONE_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("cone_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CONEHEAD_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BUCKET_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("bucket_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BUCKETHEAD_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GRAVE1_SPAWN_EGG = ITEMS.register("grave1_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRAVE1, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GRAVE2_SPAWN_EGG = ITEMS.register("grave2_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRAVE2, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> HOUSE_DOOR_1_SPAWN_EGG = ITEMS.register("house_door_1_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HOUSE_DOOR_1, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> STONE_1_SPAWN_EGG = ITEMS.register("stone1_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STONE1, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> STONE_2_SPAWN_EGG = ITEMS.register("stone2_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STONE2, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> FENCE_SPAWN_EGG = ITEMS.register("fence_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FENCE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SUBMARINE_SPAWN_EGG = ITEMS.register("submarine_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SUB_MARINE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> FOG_GENERATOR_SPAWN_EGG = ITEMS.register("fog_generator_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FOG_GENEATOR, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> HOUSE_DOOR_2_SPAWN_EGG = ITEMS.register("house_door_2_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HOUSE_DOOR_2, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> LIFE_GUARD_TOWER_SPAWN_EGG = ITEMS.register("life_guard_tower_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LIFE_GUARD_TOWER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DUCK_SPAWN_EGG = ITEMS.register("duck_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DUCK, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> POOL_CHAIR_SPAWN_EGG = ITEMS.register("pool_chair_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.POOL_CHAIR, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));


    public static final RegistryObject<Item> FREEZE_ZOMBIE_SPAWN_EGG = ITEMS.register("freeze_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FREEZE_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ASH_ZOMBIE_SPAWN_EGG = ITEMS.register("ash_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ASH_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GRAVE3_SPAWN_EGG = ITEMS.register("grave3_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRAVE3, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));



    public static final RegistryObject<Item> GATLING_PEA_SPAWN_EGG = ITEMS.register("gatling_pea_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GATLING_PEA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TWIN_SUNFLOWER_SPAWN_EGG = ITEMS.register("twin_sunflower_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TWIN_SUNFLOWER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GLOOM_SHROOM_SPAWN_EGG = ITEMS.register("gloom_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GLOOM_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CATTAIL_SPAWN_EGG = ITEMS.register("cattail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CATTAIL, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> WINTER_MELON_SPAWN_EGG = ITEMS.register("winter_melon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WINTER_MELON, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GOLD_MAGNET_SPAWN_EGG = ITEMS.register("gold_magnet_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOLD_MAGNET, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SPIKE_ROCK_SPAWN_EGG = ITEMS.register("spike_rock_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SPIKE_ROCK, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> COB_CANNON_SPAWN_EGG = ITEMS.register("cob_cannon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COB_CANNON, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> MARIO_SPAWN_EGG = ITEMS.register("mario_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MARIO, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> MARIO_SMALL_SPAWN_EGG = ITEMS.register("mario_small_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MARIO_SMALL, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GOOMBA_SPAWN_EGG = ITEMS.register("goomba_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOOMBA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> KOOPA_SPAWN_EGG = ITEMS.register("koopa_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KOOPA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PIRANHA_SPAWN_EGG = ITEMS.register("piranha_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PIRANHA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));


    public static final RegistryObject<Item> ZOMBIE_HAND = ITEMS.register("zombie_hand", () -> new ZombieHandItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> LARGE_SUN = ITEMS.register("large_sun", () -> new LargeSunItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));


    public static final RegistryObject<Item> SMALL_SUN = ITEMS.register("small_sun", () -> new SmallSunItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> PAPER = ITEMS.register("paper", () -> new PaperItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> FOOTBALL_ITEM = ITEMS.register("football_helmet", () -> new FootballHelmetItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> LILY_PAD_ITEM = ITEMS.register("lily_pad", () -> new LilyPadItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SLIVER_COIN = ITEMS.register("sliver_coin", () -> new SliverCoinItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(100)));
    public static final RegistryObject<Item> DAVE_KEY = ITEMS.register("dave_key", () -> new DaveKeyItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(100)));

    public static final RegistryObject<Item> GOLDEN_COIN = ITEMS.register("golden_coin", () -> new GoldenCoinItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(100)));
    public static final RegistryObject<Item> IRON_BUCKET = ITEMS.register("iron_bucket", () -> new IronBucketItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(100)));
    public static final RegistryObject<Item> FLAG = ITEMS.register("flag", () -> new FlagItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(100)));
    public static final RegistryObject<Item> BUCKET = ITEMS.register("bucket", () -> new IronBucketItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(100)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
