package com.example.examplemod.item.custom;

import com.example.examplemod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class GoldenCoinItem extends Item {

    public GoldenCoinItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        Player p = context.getPlayer();

        int radius = 5;
        int inner_radius = 2;
        if(p != null){
            //

            // 200 107 700
            BlockPos bp = p.getOnPos();
            for(int i = -radius;i <= radius; i++){
                for(int j = -radius; j < radius;j++){

                    for(int k = 0; k < radius*2;k++){
                        if(k <= 50)
                        {
                            if ((i * i + j * j) < inner_radius * inner_radius ) {
                                world.setBlock(new BlockPos(bp.getX() + i, bp.getY() + k, bp.getZ() + j), Blocks.LAVA.defaultBlockState(), 3);
                            }
                        }else if((i * i + j * j + (k - radius)*(k - radius)) < radius * radius){
                            world.setBlock(new BlockPos(bp.getX() + i, bp.getY() + k, bp.getZ() + j), Blocks.LAVA.defaultBlockState(), 3);
                        }


                    }
                }
            }
        }

        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
