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
