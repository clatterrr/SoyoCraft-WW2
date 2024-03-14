package com.example.examplemod.item.custom;

import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.DayPlant.PeaShooterEntity;
import com.example.examplemod.entity.custom.Projectile.PeaProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class DaveKeyItem extends Item {

    public DaveKeyItem(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        /*
        PeaProjectileEntity pea = new PeaProjectileEntity(ModEntityTypes.PEA_PROJECTILE.get(), level);
        pea.setPos(player.position());
        level.addFreshEntity(pea);
        */

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos bp = context.getClickedPos();
        for(int i = 0; i <6;i++){
            for(int j = 0; j < 200;j ++){
                BlockPos bp1 = new BlockPos(bp.getX() + i, bp.getY(), bp.getZ() + j);
                context.getLevel().setBlock(bp1, ModBlocks.ROAD.get().defaultBlockState(), 1);
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide);

    }
}
