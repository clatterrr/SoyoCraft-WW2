package com.example.examplemod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import team.creative.cmdcam.client.CMDCamClient;
import team.creative.cmdcam.common.math.point.CamPoint;
import team.creative.cmdcam.common.scene.CamScene;
import team.creative.creativecore.common.util.registry.exception.RegistryException;

public class SceneSetup {

    public SceneSetup(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes(this::execute)));
    }


    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 4000L);
        CamPoint p1 = CamPoint.createLocal();
        CamPoint p2 = ForwardSteps(p1, -5.0);
        try {
            CamScene path = new CamScene(nbt);
            path.points.add(p1);
            path.points.add(p2);
            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        if (player != null) {
            //player.sendSystemMessage(Component.literal(nbt.toString()));
        }
        return 1;
    }
    CamPoint ForwardSteps(CamPoint p, double distance){
        double yaw = p.rotationYaw * Math.PI / 180.0;
        double pitch = p.rotationPitch * Math.PI / 180.0;
        double new_x = p.x - distance * Math.sin(yaw) * Math.cos(pitch);
        double new_y = p.y - distance * Math.sin(pitch);
        double new_z = p.z + distance * Math.cos(yaw) * Math.cos(pitch);
        return new CamPoint(new_x, new_y, new_z, p.rotationYaw, p.rotationPitch, p.roll, p.zoom);
    }

}
