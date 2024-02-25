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

    public static final RegistryObject<Item> LITTLE_ZOMBIE_SPAWN_EGG = ITEMS.register("little_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LITTLE_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> POLE_VAULTING_ZOMBIE_SPAWN_EGG = ITEMS.register("pole_vaulting_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.POLE_VAULTING_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> LITTLE_DUCK_TUBE_ZOMBIE_SPAWN_EGG = ITEMS.register("little_duck_tube_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LITTLE_DUCK_TUBE_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

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
    public static final RegistryObject<Item> LILY_PAD_SPAWN_EGG = ITEMS.register("lily_pad_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LILY_PAD, 0x22b341, 0x19732e,
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

    public static final RegistryObject<Item> SQUASH_SPAWN_EGG = ITEMS.register("squash_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SQUASH, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> THREEPEATER_SPAWN_EGG = ITEMS.register("threepeater_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.THREEPEATER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TANGLE_KELP_SPAWN_EGG = ITEMS.register("tangle_kelp_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TANGLE_KELP, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> JALAPENO_SPAWN_EGG = ITEMS.register("jalapeno_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.JALAPENO, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SPIKE_WEED_SPAWN_EGG = ITEMS.register("spike_weed_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SPIKEWEED, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TORCH_WOOD_SPAWN_EGG = ITEMS.register("torch_wood_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TORCHWOOD, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> TALL_NUT_SPAWN_EGG = ITEMS.register("tall_nut_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TALLNUT, 0x22b341, 0x19732e,
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
    public static final RegistryObject<Item> DUCK_TUBE_BUCKET_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("duck_tube_bucket_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DUCK_TUBE_BUCKET_HEAD_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DUCK_TUBE_CONE_HEAD_ZOMBIE_SPAWN_EGG = ITEMS.register("duck_tube_cone_head_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DUCK_TUBE_CONE_HEAD_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DUCK_TUBE_ZOMBIE_SPAWN_EGG = ITEMS.register("duck_tube_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DUCK_TUBE_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SNORKEL_ZOMBIE_SPAWN_EGG = ITEMS.register("snorkel_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SNORKEL_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ZOMBONI_SPAWN_EGG = ITEMS.register("zomboni_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ZOMBONI, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));


    public static final RegistryObject<Item> SLED_SPAWN_EGG = ITEMS.register("sled_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SLED, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ZOMBIE_BOBSLED_TEAM_SPAWN_EGG = ITEMS.register("zombie_bobsled_team_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ZOMBIE_BOBSLED_TEAM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DOLPHIN_RIDER_ZOMBIE_SPAWN_EGG = ITEMS.register("dolphin_rider_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DOLPHIN_RIDER_ZOMBIE, 0x22b341, 0x19732e,
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


    public static final RegistryObject<Item> SEA_SHROOM_SPAWN_EGG = ITEMS.register("sea_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SEA_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PLANTERN_SPAWN_EGG = ITEMS.register("plantern_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PLANTERN, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CACTUS_SPAWN_EGG = ITEMS.register("cactus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CACTUS, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BLOVER_SPAWN_EGG = ITEMS.register("blover_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BLOVER, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SPLIT_PEA_SPAWN_EGG = ITEMS.register("split_pea_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SPLIT_PEA, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> STAR_FRUIT_SPAWN_EGG = ITEMS.register("star_fruit_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STAR_FRUIT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> PUMPKIN_SPAWN_EGG = ITEMS.register("pumpkin_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PUMPKIN, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> MAGNET_SHROOM_SPAWN_EGG = ITEMS.register("magnet_shroom_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MAGNET_SHROOM, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CABBAGE_PULT_SPAWN_EGG = ITEMS.register("cabbage_pult_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CABBAGE_PULT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> FLOWR_POT_SPAWN_EGG = ITEMS.register("flowr_pot_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FLOWR_POT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> KERNEL_PULT_SPAWN_EGG = ITEMS.register("kernel_pult_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KERNEL_PULT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GARLIC_SPAWN_EGG = ITEMS.register("garlic_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GARLIC, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> COFFEE_BEAN_SPAWN_EGG = ITEMS.register("coffee_bean_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COFFEE_BEAN, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> MELON_PULT_SPAWN_EGG = ITEMS.register("melon_pult_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MELON_PULT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> UMBRELLA_LEAF_SPAWN_EGG = ITEMS.register("umbrella_leaf_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.UMBRELLA_LEAF, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> MARIGOLD_SPAWN_EGG = ITEMS.register("marigold_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MARIGOLD, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> JACK_ZOMBIE_SPAWN_EGG = ITEMS.register("jack_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.JACK_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> BALLOON_ZOMBIE_SPAWN_EGG = ITEMS.register("balloon_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BALLOON_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> DIGGER_ZOMBIE_SPAWN_EGG = ITEMS.register("digger_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DIGGER_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> POGO_ZOMBIE_SPAWN_EGG = ITEMS.register("pogo_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.POGO_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ZOMBIE_YETI_SPAWN_EGG = ITEMS.register("zombie_yeti_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ZOMBIE_YETI, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GUNGEE_ZOMBIE_SPAWN_EGG = ITEMS.register("gungee_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GUNGEE_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> LADDER_ZOMBIE_SPAWN_EGG = ITEMS.register("ladder_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LADDER_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> CATAPULT_ZOMBIE_SPAWN_EGG = ITEMS.register("catapult_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CATAPULT_ZOMBIE, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> GARGANTUAR_SPAWN_EGG = ITEMS.register("gargantuar_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GARGANTUAR, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> IMP_SPAWN_EGG = ITEMS.register("imp_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.IMP, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> ZOMBOSS_SPAWN_EGG = ITEMS.register("zomboss_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ZOMBOSS, 0x22b341, 0x19732e,
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

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));


    public static final RegistryObject<Item> ZOMBIE_HAND = ITEMS.register("zombie_hand", () -> new ZombieHandItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> LARGE_SUN = ITEMS.register("large_sun", () -> new LargeSunItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));


    public static final RegistryObject<Item> SMALL_SUN = ITEMS.register("small_sun", () -> new SmallSunItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> PAPER = ITEMS.register("paper", () -> new PaperItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> FOOTBALL_ITEM = ITEMS.register("football_helmet", () -> new FootballHelmetItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> LILY_PAD_ITEM = ITEMS.register("lily_pad", () -> new LilyPadItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
    public static final RegistryObject<Item> LILY_PAD_PEA_SHOOTER_ITEM = ITEMS.register("lily_pad_pea_shooter", () -> new LilyPadPeaShooterItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));

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
