package com.example.examplemod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import team.creative.cmdcam.common.math.point.CamPoint;

public class GoldenCoinItem extends Item {

    public GoldenCoinItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        return InteractionResult.sidedSuccess(world.isClientSide);

    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        CamPoint point = CamPoint.createLocal();
        System.out.println(point.x + "," + point.y + "," + point.z);
        System.out.println(point.rotationYaw + "," + point.rotationPitch + "," + point.roll);
       return  super.use(level, player, hand);
    }

}
