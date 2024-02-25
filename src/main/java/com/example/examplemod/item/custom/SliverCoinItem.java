package com.example.examplemod.item.custom;

import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.FogGeneratorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.*;

public class SliverCoinItem extends Item {

    public SliverCoinItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        Player p = context.getPlayer();

        int radius = 40;
        int inner_radius = 10;
        if(p != null){
            //

            // 200 107 700
            BlockPos bp = p.getOnPos();
            //p.sendSystemMessage(Component.literal("hey hey" + bp));
            bp = new BlockPos(-200, 107, 700);
            for(int i = -radius;i <= radius; i++){
                for(int j = -radius; j < radius;j++){

                    for(int k = 0; k < radius*2;k++){
                        if(world.getBlockState(new BlockPos(bp.getX() + i, bp.getY() + k, bp.getZ() + j)).getBlock() == ModBlocks.POOL_BRICK_1.get()){
                            world.setBlock(new BlockPos(bp.getX() + i, bp.getY() + k, bp.getZ() + j), Blocks.AIR.defaultBlockState(), 3);

                        }
                    }
                }
            }
            bp = p.getOnPos();
            FogGeneratorEntity fog = new FogGeneratorEntity(ModEntityTypes.FOG_GENEATOR.get(), world);
            fog.setPos(bp.getX(), bp.getY(), bp.getZ());
            world.addFreshEntity(fog);
        }

        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
