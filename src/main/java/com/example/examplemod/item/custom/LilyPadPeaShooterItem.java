package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.LilyPadEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class LilyPadPeaShooterItem extends Item {

    public LilyPadPeaShooterItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        Player p = context.getPlayer();
        p.sendSystemMessage(Component.literal("hey hey" + p.getBlockY()));
        LilyPadEntity lily = new LilyPadEntity(ModEntityTypes.LILY_PAD.get(), world);
        lily.setPos(p.getBlockX(), p.getBlockY(), p.getBlockZ());
        world.addFreshEntity(lily);

        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
