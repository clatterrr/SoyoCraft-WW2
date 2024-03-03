package com.example.examplemod.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import team.creative.cmdcam.CMDCam.*;
import team.creative.cmdcam.client.CMDCamClient;
import team.creative.creativecore.common.util.registry.exception.RegistryException;

public class SliverCoinItem extends Item {

    public SliverCoinItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        try {
            CamScene path = new CamScene(nbt);
            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        if(p != null) {
            p.sendSystemMessage(Component.literal(nbt.toString()));
        }

        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
