package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.SunEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ZombieHandItem extends Item {

    public ZombieHandItem(Properties p_41383_) {
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
