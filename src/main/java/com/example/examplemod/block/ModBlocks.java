package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.custom.*;
import com.example.examplemod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);


    public static final RegistryObject<Block> ICE_SPIKE = registerBlock("ice_spike",
            () -> new IceSpikeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> VINE = registerBlock("vine",
            () -> new VineBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> P0 = registerBlock("p0",
            () -> new p0Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> P1 = registerBlock("p1",
            () -> new p1Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> BLUEBRICK = registerBlock("bluebrick",
            () -> new BlueBrickBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> ROD = registerBlock("rod",
            () -> new RodBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> BLUEROAD = registerBlock("blueroad",
            () -> new BlueRoadBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> GRASS = registerBlock("grass",
            () -> new GrassBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> CLOUDS = registerBlock("clouds",
            () -> new CloudsBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> SOUL_HEAD = registerBlock("soul_head",
            () -> new SoulHeadBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);
    public static final RegistryObject<Block> POOL_BRICK_1 = registerBlock("pool_brick_1",
            () -> new PoolBrick1Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> POOL_BRICK_2 = registerBlock("pool_brick_2",
            () -> new PoolBrick2Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);
    public static final RegistryObject<Block> POOL_BRICK_3 = registerBlock("pool_brick_3",
            () -> new PoolBrick3Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> POOL_BRICK_4 = registerBlock("pool_brick_4",
            () -> new PoolBrick4Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> DUCK = registerBlock("duck",
            () -> new DuckBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> LILY_PAD_BLOCK = registerBlock("lily_pad_block",
            () -> new LilyPadBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);
    public static final RegistryObject<Block> SOUL_DECO = registerBlock("soul_deco",
            () -> new SoulHeadBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> BRICK = registerBlock("brick",
            () -> new BrickBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> QUESTION = registerBlock("question",
            () -> new QuestionBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> QUESTION2 = registerBlock("question2",
            () -> new Question2Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> ROAD = registerBlock("road",
            () -> new RoadBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);
    public static final RegistryObject<Block> STAIR = registerBlock("stair",
            () -> new StairBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_FOOD);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
