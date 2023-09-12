package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.BombEntity;
import com.example.examplemod.entity.custom.TankEntity;
import com.example.examplemod.entity.custom.TongueEntity;
import com.example.examplemod.entity.custom.ZhaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ZhaItem extends Item {

    public ZhaItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.getCooldowns().addCooldown(this, 40);

        if(!pLevel.isClientSide()) {
            BombEntity snowball = new BombEntity(pLevel, pPlayer);
            snowball.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(snowball);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

}
