package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.SunEntity;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.phys.Vec3;

public class SunItem extends Item {

    public SunItem(Item.Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        SunEntity sun = new SunEntity(ModEntityTypes.SUN.get(), world);
        sun.setPos(context.getPlayer().getX(), context.getPlayer().getY(), context.getPlayer().getZ());
        world.addFreshEntity(sun);

        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
