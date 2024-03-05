package com.example.examplemod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import team.creative.cmdcam.client.CMDCamClient;
import team.creative.cmdcam.common.math.point.CamPoint;
import team.creative.cmdcam.common.scene.CamScene;
import team.creative.creativecore.common.util.registry.exception.RegistryException;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("sethome")
                        .then(Commands.argument("number", IntegerArgumentType.integer(1, 10)).executes(commandContext -> setHome(commandContext.getSource(), IntegerArgumentType.getInteger(commandContext, "number")))
                        )
        );
    }

    private int setHome(CommandSourceStack source, int number) throws CommandSyntaxException {
        System.out.println("test");
        ServerPlayer player = source.getPlayer();
        BlockPos playerPos = player.getOnPos();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + "," + playerPos.getZ() + ")";

        //player.getPersistentData().putIntArray(GoggleUtils.MODID + String.valueOf(number) + "home", new int[]{playerPos.getX(), playerPos.getY(), playerPos.getZ()});

       // source.sendFeedback(new StringTextComponent("Set home at " + pos), true);
        return 1;
    }
}