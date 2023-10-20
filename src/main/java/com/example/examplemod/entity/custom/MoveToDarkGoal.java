package com.example.examplemod.entity.custom;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;

public class MoveToDarkGoal extends Goal {


    private final Monster mob;

    public MoveToDarkGoal(Monster mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        //return this.mob.getTarget() != null;
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        int s = 5;
        Player player = this.mob.getLevel().getNearestPlayer(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 4.0D, false);



        /*
        BlockPos p = this.mob.getOnPos();
        for(int i = -s;i < s;i++){
            for(int j = -s;j < s;j ++){
                for(int k = -s; k < s;k++){
                    if(player != null){
                        BlockPos n = new BlockPos(p.getX() + i, p.getY() + j, p.getZ() + k);
                        if(this.mob.getLevel().getBlockState(n).getBlock() == Blocks.IRON_BLOCK)
                        {
                            //this.mob.getMoveControl().setWantedPosition(n.getX(),n.getY(),n.getZ(), 1f);
                            this.mob.getNavigation().moveTo()

                        }

                    }
                }
            }
        }

        if (this.mob.getTarget() != null) {
            this.mob.getLookControl().setLookAt(this.mob.getTarget(), 100.0F, 100.0F);

        }
        */
    }
}
