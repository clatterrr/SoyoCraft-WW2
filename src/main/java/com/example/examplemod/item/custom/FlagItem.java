package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class FlagItem extends Item {

    public FlagItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        NormalZombieEntity n = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        Player p = world.players().get(0);
        n.setPos(p.getX(), p.getY(), p.getZ() - 1);
        world.addFreshEntity(n);
        return InteractionResult.sidedSuccess(world.isClientSide);

    }


}
