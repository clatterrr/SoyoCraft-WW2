package com.example.examplemod.item.custom;

import com.example.examplemod.entity.custom.CreeperProjectileEntity;
import com.example.examplemod.entity.custom.MagicProjectileEntity;
import com.example.examplemod.entity.custom.ZhaEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ZhaItem extends Item {

    public ZhaItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        /*
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.NEUTRAL,
                1.5F, 1F);
        */
        pPlayer.getCooldowns().addCooldown(this, 10);

        if(!pLevel.isClientSide()) {
            CreeperProjectileEntity magicProjectile = new CreeperProjectileEntity(pLevel, pPlayer);
            magicProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0.25F);

            pLevel.addFreshEntity(magicProjectile);

            pPlayer.sendSystemMessage(Component.literal(" x rot" + pPlayer.getXRot() + " y rot " + pPlayer.getYRot()));
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

}
