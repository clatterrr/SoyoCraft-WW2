package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.ThevillagerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SmallSunItem extends Item {

    public SmallSunItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                ThevillagerEntity entity = new ThevillagerEntity(ModEntityTypes.THEVILLAGER.get(), world);
                BlockPos bp = context.getClickedPos();
                entity.setPos(new Vec3(bp.getX() + i, bp.getY() + 1, bp.getZ() + j));
                world.addFreshEntity(entity);
            }
        }


        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
