package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.TankEntity;
import com.example.examplemod.entity.custom.TongueEntity;
import com.example.examplemod.entity.custom.ZhaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
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

    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        if (!world.isClientSide) {
            BlockPos p = context.getPlayer().blockPosition();
            Entity entityToSpawn = new TankEntity(ModEntityTypes.TANK.get(), world);
            entityToSpawn.moveTo(p.getX(), p.getY(), p.getZ(), 0F, 0F);
            //entityToSpawn.setYBodyRot(entity.getYRot());
           // entityToSpawn.setYHeadRot(entity.getYRot());
        //    entityToSpawn.setDeltaMovement((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
            if (entityToSpawn instanceof Mob _mobToSpawn)
                _mobToSpawn.finalizeSpawn((ServerLevelAccessor) context.getLevel(), world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
            world.addFreshEntity(entityToSpawn);
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
