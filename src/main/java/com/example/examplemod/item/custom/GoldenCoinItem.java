package com.example.examplemod.item.custom;

import com.example.examplemod.entity.custom.TheplayerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import team.creative.cmdcam.common.math.point.CamPoint;

import java.util.List;

public class GoldenCoinItem extends Item {

    public GoldenCoinItem(Properties p_41383_) {
        super(p_41383_);
    }


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        CamPoint point = CamPoint.createLocal();
        System.out.println(point.x + "," + point.y + "," + point.z);
        System.out.println(point.rotationYaw + "," + point.rotationPitch + "," + point.roll);


        List<TheplayerEntity> lily_pads = world.getEntitiesOfClass(TheplayerEntity.class, context.getPlayer().getBoundingBox().inflate(12));
        for(int i = 0; i < lily_pads.size(); i++){
            lily_pads.get(i).discard();
        }

  /*
        Level world = context.getLevel();
        BlockPos bp =  context.getPlayer().getOnPos();
        ItemStack potion = new ItemStack(Items.SPLASH_POTION);
        ThrownPotion thrownPotion = new ThrownPotion( world, context.getPlayer());
        thrownPotion.setNoGravity(true);
        thrownPotion.setItem(potion);
        thrownPotion.shoot( 5.0, -0.1, 0, 0.2F, 0.0F );

        world.addFreshEntity( thrownPotion );
*/
        return InteractionResult.sidedSuccess(world.isClientSide);

    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        CamPoint point = CamPoint.createLocal();
        System.out.println(point.x + "," + point.y + "," + point.z);
        System.out.println(point.rotationYaw + "," + point.rotationPitch + "," + point.roll);
       return  super.use(level, player, hand);
    }

}
