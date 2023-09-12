package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.SmokerEntity;
import com.example.examplemod.entity.custom.SoliderEntity;
import com.example.examplemod.entity.custom.TankEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.SMOKER.get(), SmokerEntity.setAttributes());
            event.put(ModEntityTypes.TANK.get(), TankEntity.setAttributes());
            event.put(ModEntityTypes.SOLIDER.get(), SoliderEntity.setAttributes());
        }

    }
}
