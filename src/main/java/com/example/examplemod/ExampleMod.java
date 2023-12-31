package com.example.examplemod;

import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.client.*;
import com.example.examplemod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "examplemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public ExampleMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntityTypes.register(modEventBus);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        GeckoLib.initialize();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());


            EntityRenderers.register(ModEntityTypes.CACTUS.get(), CactusRenderer::new);
            EntityRenderers.register(ModEntityTypes.SUN_FLOWER.get(), SunFlowerRenderer::new);
            EntityRenderers.register(ModEntityTypes.PEA_SHOOTER.get(), PeaShooterRenderer::new);
            EntityRenderers.register(ModEntityTypes.CHERRY_BOMB.get(), CherryBombRenderer::new);
            EntityRenderers.register(ModEntityTypes.WALL_NUT.get(), WallNutRenderer::new);
            EntityRenderers.register(ModEntityTypes.SNOW_PEA.get(), SnowPeaRenderer::new);
            EntityRenderers.register(ModEntityTypes.REPEATER.get(), RepeaterRenderer::new);
            EntityRenderers.register(ModEntityTypes.CHOMPER.get(), ChomperRenderer::new);
            EntityRenderers.register(ModEntityTypes.POTATO_MINE.get(), PotatoMineRenderer::new);
            EntityRenderers.register(ModEntityTypes.NORMAL_ZOMBIE.get(), NormalZombieRenderer::new);
            EntityRenderers.register(ModEntityTypes.CONE_HEAD_ZOMBIE.get(), ConeHeadZombieRenderer::new);
            EntityRenderers.register(ModEntityTypes.BUCKET_HEAD_ZOMBIE.get(), BucketHeadZombieRenderer::new);
            EntityRenderers.register(ModEntityTypes.POLE_VAULTING_ZOMBIE.get(), PoleVaultingZombieRenderer::new);
            EntityRenderers.register(ModEntityTypes.FLAG_ZOMBIE.get(), FlagZombieRenderer::new);
            EntityRenderers.register(ModEntityTypes.MAGIC_PROJECTILE.get(), MagicProjectileRenderer::new);
            EntityRenderers.register(ModEntityTypes.BULLET_PROJECTILE.get(), BulletProjectileRenderer::new);
            EntityRenderers.register(ModEntityTypes.PEA_PROJECTILE.get(), PeaProjectileRenderer::new);
            EntityRenderers.register(ModEntityTypes.ICE_PEA_PROJECTILE.get(), IcePeaProjectileRenderer::new);
            EntityRenderers.register(ModEntityTypes.SUN.get(), SunRenderer::new);
            EntityRenderers.register(ModEntityTypes.Cone.get(), ConeRenderer::new);
            EntityRenderers.register(ModEntityTypes.ZOMBIE_HAND.get(), ZombieHandRenderer::new);
            EntityRenderers.register(ModEntityTypes.BUCKET.get(), BucketRenderer::new);
            EntityRenderers.register(ModEntityTypes.PEA_CROP.get(), PeaCropRenderer::new);
        }
    }
}
