package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.ChuckBirdEntity;
import com.example.examplemod.entity.custom.RedBirdEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ChuckBirdShooterItem extends Item {

    public ChuckBirdShooterItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        return InteractionResult.sidedSuccess(world.isClientSide);

    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {


        ChuckBirdEntity red_bird = new ChuckBirdEntity(ModEntityTypes.CHUCK_BIRD.get(), level);
        red_bird.setPos(player.getX(), player.getY() + 1, player.getZ());
        level.addFreshEntity(red_bird);
        ItemStack itemstack = player.getItemInHand(hand);
        itemstack.shrink(1);
        return InteractionResultHolder.consume(itemstack);


    }



}
