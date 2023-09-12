package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.SmokerEntity;
import com.example.examplemod.entity.custom.BombEntity;
import com.example.examplemod.entity.custom.SoliderEntity;
import com.example.examplemod.entity.custom.TankEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);



    public static final RegistryObject<EntityType<SmokerEntity>> SMOKER =
            ENTITY_TYPES.register("smiler",
                    () -> EntityType.Builder.of(SmokerEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "smiler").toString()));

    public static final RegistryObject<EntityType<TankEntity>> TANK =
            ENTITY_TYPES.register("tank",
                    () -> EntityType.Builder.of(TankEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "tank").toString()));

    public static final RegistryObject<EntityType<SoliderEntity>> SOLIDER =
            ENTITY_TYPES.register("solider",
                    () -> EntityType.Builder.of(SoliderEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(ExampleMod.MODID, "solider").toString()));

    public static final RegistryObject<EntityType<BombEntity>> BOMB =
            ENTITY_TYPES.register("bomb",
                    () -> EntityType.Builder.<BombEntity>of(BombEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("bomb"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
