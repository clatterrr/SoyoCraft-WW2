package com.example.examplemod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WhatUp {
    private static LiteralArgumentBuilder<CommandSourceStack> cLiteral(String test) {
        return LiteralArgumentBuilder.literal(test);
    }
    @SubscribeEvent
    public static void onRegisterCommandEvent(RegisterCommandsEvent event){
        cRegister(event.getDispatcher());
    }

    private static void cRegister(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                cLiteral("test")
                        .executes(context -> {
                            ( Minecraft.getInstance().player).sendSystemMessage(Component.literal("123"));
                            return 1;
                        })

        );
    }
}
