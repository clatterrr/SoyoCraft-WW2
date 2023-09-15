package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TankEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public TankEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setRot(0, 0);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TankDestroyGoal());
        //this.goalSelector.addGoal(1, new TankShootGoal());
        // this.goalSelector.addGoal(2, new MoveOnGoal());

        /*
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        */



    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        /*
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.smoker.walk", true));
            return PlayState.CONTINUE;
        }
        */

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tank.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "tank_controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAT_STRAY_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.DOLPHIN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    public void tick() {
        if(!this.getLevel().isClientSide()){
            if (!this.getLevel().players().isEmpty()) {
               // this.yBodyRot = 0;
            }

            /*
            float f = this.rotA;
            if (!this.getLevel().players().isEmpty()) {
                BlockPos bp = this.getOnPos();
                //this.getLevel().players().get(0).sendSystemMessage(Component.literal(" tt " + f + " tank tick " + bp));
                for(int i = -3; i <= 3; i++ ){
            //        this.getLevel().setBlockAndUpdate(new BlockPos(bp.getX() + 1, bp.getY(), bp.getZ() + i), Blocks.DIRT.defaultBlockState());
           //         this.getLevel().setBlockAndUpdate(new BlockPos(bp.getX() - 2, bp.getY(), bp.getZ() + i), Blocks.DIRT.defaultBlockState());
                }
            }

            BlockPos bp = this.getOnPos();
            double offset = 6D;

            double offsetX = - Math.sin(this.yBodyRot * 3.14D / 360.0D) * offset;
            double offsetZ = Math.cos(this.yBodyRot  * 3.14D / 360.0D) * offset;
            BlockPos newPos = new BlockPos(bp.getX() + offsetX, bp.getY() + 1, bp.getZ() + offsetZ);

            this.getLevel().setBlockAndUpdate(newPos, Blocks.DIRT.defaultBlockState());
            if (!this.getLevel().players().isEmpty()) {
                this.getLevel().players().get(0).sendSystemMessage(Component.literal(" tank pos " + bp + " yrot = " + this.getYRot() * 3.14D / 360.0D + " sin " + Math.sin(this.getYRot() * 3.14D / 360.0D) + " cos = " +  Math.cos(this.getYRot() * 3.14D / 360.0D)));
                this.getLevel().players().get(0).sendSystemMessage(Component.literal(" offsetx = " + offsetX + " offsetz = " + offsetZ + " new pos " + newPos));

            }
            */

        }
         super.tick();

    }

    public class TankShootGoal extends Goal {
        private final TankEntity tank;
        public TankShootGoal(){
            tank = TankEntity.this;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        public void tick(){
            /*
            final LivingEntity target = tank.getTarget();
            if (target != null && target.isAlive()) {
                tank.getNavigation().moveTo(target, 3f);
            }

            Level pLevel = this.tank.getLevel();
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(pLevel, this.tank, this.tank.yBodyRot);
            magicProjectile.shootFromRotation(this.tank, 0, this.tank.yBodyRot, 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(magicProjectile); */
   // this.tank.yBodyRot = 0;
    /*
            Level pLevel = this.tank.getLevel();
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(pLevel, this.tank, this.tank.yBodyRot);
            magicProjectile.shootFromRotation(this.tank, 0, this.tank.yBodyRot, 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(magicProjectile);
            */
        }


    }

    public class MoveOnGoal extends Goal {
        private final TankEntity tank;
        public MoveOnGoal(){
            tank = TankEntity.this;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        public void tick(){
            if(this.tank.yBodyRot == 0){
                //this.tank.setDeltaMovement(new Vec3(0.1F, 0F,0F));
            }
            //
            //this.tank.getNavigation().moveTo(this.tank.getX() + 0.1F, this.tank.getY(), this.tank.getZ(), 1.0F);
            /*
            this.tank.yBodyRot = 45;
            Level pLevel = this.tank.getLevel();
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(pLevel, this.tank, this.tank.yBodyRot);
            magicProjectile.shootFromRotation(this.tank, 0, this.tank.yBodyRot, 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(magicProjectile);

            BlockPos bp = this.tank.getOnPos();
            double offset = 6D;

            double offsetX = - Math.sin(this.tank.yBodyRot * 3.14D / 360.0D) * offset;
            double offsetZ = Math.cos(this.tank.yBodyRot  * 3.14D / 360.0D) * offset;
            BlockPos newPos = new BlockPos(bp.getX() + offsetX, bp.getY() + 1, bp.getZ() + offsetZ);
            if(this.tank.getLevel().isClientSide()){
                this.tank.getLevel().setBlockAndUpdate(newPos, Blocks.DIRT.defaultBlockState());
            }
            */

        }
    }

    public class TankDestroyGoal extends Goal {
        private final TankEntity tank;
        public TankDestroyGoal(){
            tank = TankEntity.this;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        public boolean BlockBlock(Level level, BlockPos centerPos, Block type){
            for(int i = -1;i <= 1;i ++){
                for(int j = -1;j <= 1;j ++){
                    BlockPos newPos = new BlockPos(centerPos.getX() + i, centerPos.getY(), centerPos.getZ() + j);
                        Block bp = level.getBlockState(newPos).getBlock();
                        if(bp == type){
                            return true;
                    }
                }
            }
            return false;
        }

        public void DestroyBlock(Level level, BlockPos centerPos){
            for(int i = -2;i <= 2;i ++){
                for(int j = -2;j <= 2;j ++){
                    for(int k = 0; k <= 3;k++){
                        BlockPos newPos = new BlockPos(centerPos.getX() + i, centerPos.getY() + k, centerPos.getZ() + j);
                        level.destroyBlock(newPos, false);
                    }

                }
            }
        }

        public void tick(){
            /*
            final LivingEntity target = tank.getTarget();
            if (target != null && target.isAlive()) {
                tank.getNavigation().moveTo(target, 3f);
            }

            Level pLevel = this.tank.getLevel();
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(pLevel, this.tank, this.tank.yBodyRot);
            magicProjectile.shootFromRotation(this.tank, 0, this.tank.yBodyRot, 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(magicProjectile); */
            // this.tank.yBodyRot = 0;
    /*
            Level pLevel = this.tank.getLevel();
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(pLevel, this.tank, this.tank.yBodyRot);
            magicProjectile.shootFromRotation(this.tank, 0, this.tank.yBodyRot, 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(magicProjectile);
            */
            this.tank.yBodyRot = 45;
            this.tank.setYRot(45);

            double offset = 4;
            double offsetX = - Math.sin(this.tank.yBodyRot * (float)(Math.PI / 180.0D)) * offset;
            double offsetZ = Math.cos(this.tank.yBodyRot  * (float)(Math.PI / 180.0D)) * offset;
            BlockPos newPos = new BlockPos(this.tank.getX() + offsetX, this.tank.getY() , this.tank.getZ() + offsetZ);

            if(BlockBlock(this.tank.getLevel(), newPos, Blocks.IRON_BLOCK)){
                // blocked
            }else{
                DestroyBlock(this.tank.getLevel(), newPos);


                this.tank.setDeltaMovement(-0.1F, 0F, 0.1F);
            }
            /*
            Block bp = this.tank.getLevel().getBlockState(newPos).getBlock();
            // destroy block
            if(bp == Blocks.DIRT){
                this.tank.getLevel().destroyBlock(newPos, false);
            }else if (bp == Blocks.IRON_BLOCK){

            }else{

            }
            */

            //this.tank.getLevel().setBlockAndUpdate(newPos, Blocks.DIRT.defaultBlockState());

            /*
            double yR = this.tank.yBodyRot * (float)Math.PI / 180F;
            double bomb_offset = 6.0D;
            double d0 = this.tank.position().x - Math.sin(yR) * bomb_offset;
            double d1 = this.tank.position().y + 1.5D;
            double d2 = this.tank.position().z + Math.cos(yR) * bomb_offset;
            BlockPos center_pos = new BlockPos(d0, d1, d2);
            BlockPos left_pos = new BlockPos(d0, d1, d2);
            BlockPos right_pos = new BlockPos(d0, d1, d2);
            BlockPos upper_pos = new BlockPos(d0, d1, d2);
            BlockPos lower_pos = new BlockPos(d0, d1, d2);
            this.tank.getLevel().destroyBlock(center_pos, false);
            if (!this.tank.getLevel().players().isEmpty()) {
                this.tank.getLevel().players().get(0).sendSystemMessage(Component.literal(" tankx = " + this.tank.getX() + " tanky = " + this.tank.getY() + " tankz " + this.tank.getZ()));
                this.tank.getLevel().players().get(0).sendSystemMessage(Component.literal(" center pos = " +center_pos));
            }
            */

        }


    }

}
