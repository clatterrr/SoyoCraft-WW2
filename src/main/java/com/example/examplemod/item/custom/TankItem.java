package com.example.examplemod.item.custom;

import com.example.examplemod.entity.custom.ZhaEntity;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class TankItem extends Item {
    public TankItem(Item.Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        if (!world.isClientSide) {
            ItemStack itemstack = context.getItemInHand();
            Vec3 vector3d = context.getClickLocation();
            Direction direction = context.getClickedFace();



            if(!context.getPlayer().isCreative()){
                itemstack.shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            player.sendSystemMessage(Component.literal(" use"));
        }
        return super.use(level, player, hand);
    }
}
