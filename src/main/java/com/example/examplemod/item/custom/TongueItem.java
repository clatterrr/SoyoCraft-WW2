package com.example.examplemod.item.custom;

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

public class TongueItem extends Item {

    public TongueItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        if (!world.isClientSide) {
            ItemStack itemstack = context.getItemInHand();
            Vec3 vector3d = context.getClickLocation();
            Direction direction = context.getClickedFace();

            /*
            FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(world, context.getPlayer(), vector3d.x + (double)direction.getStepX() * 0.15D, vector3d.y + (double)direction.getStepY() * 0.15D, vector3d.z + (double)direction.getStepZ() * 0.15D, itemstack);

            TongueEntity ton = new TongueEntity(world,  vector3d.x + (double)direction.getStepX() * 0.15D, vector3d.y + (double)direction.getStepY() * 0.15D, vector3d.z + (double)direction.getStepZ() * 0.15D, itemstack);

            context.getPlayer().sendSystemMessage(Component.literal(" use n"));
            Block bc = world.getBlockState(context.getClickedPos()).getBlock();
            if (bc == Blocks.IRON_BLOCK){
                context.getPlayer().sendSystemMessage(Component.literal(" use on dirt"));
            }else{
                context.getPlayer().sendSystemMessage(Component.literal(" use on chest" + bc.toString()));
            }
            */

/*
* 	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BLAST_FURNACE) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BLAST_FURNACE && (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.IRON_BLOCK
					&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.IRON_BLOCK) {
				if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.IRON_BLOCK) {
					world.destroyBlock(new BlockPos(x, y, z), false);
					world.destroyBlock(new BlockPos(x, y - 1, z), false);
					world.destroyBlock(new BlockPos(x, y - 2, z), false);*/

            //BombEntity tk = new BombEntity(world, context.getPlayer());
            //tk.shootFromRotation(context.getPlayer(), context.getPlayer().getXRot(), context.getPlayer().getYRot(), 0.0F, 1.5F, 0.25F);
            //TongueEntity ton = new TongueEntity(world,  vector3d.x + (double)direction.getStepX() * 0.15D, vector3d.y + (double)direction.getStepY() * 0.15D, vector3d.z + (double)direction.getStepZ() * 0.15D, itemstack);
            //ZhaEntity zha = new ZhaEntity(world,  vector3d.x + (double)direction.getStepX() * 0.15D, vector3d.y + (double)direction.getStepY() * 0.15D, vector3d.z + (double)direction.getStepZ() * 0.15D, itemstack);
            //world.addFreshEntity(zha);
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
