package com.example.examplemod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import team.creative.cmdcam.common.math.point.CamPoint;

public class GoldenCoinItem extends Item {

    public GoldenCoinItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        CamPoint point = CamPoint.createLocal();
        System.out.println(point.x + "," + point.y + "," + point.z);
        System.out.println(point.rotationYaw + "," + point.rotationPitch + "," + point.roll);
        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
