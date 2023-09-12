package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import com.example.examplemod.entity.custom.MagicProjectileEntity;

public class TankEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public TankEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TankMoveToGoal());
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
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
            float f = this.rotA;
            if (!this.getLevel().players().isEmpty()) {
                BlockPos bp = this.getOnPos();
                //this.getLevel().players().get(0).sendSystemMessage(Component.literal(" tt " + f + " tank tick " + bp));
                for(int i = -3; i <= 3; i++ ){
                    this.getLevel().setBlockAndUpdate(new BlockPos(bp.getX() + 1, bp.getY(), bp.getZ() + i), Blocks.DIRT.defaultBlockState());
                    this.getLevel().setBlockAndUpdate(new BlockPos(bp.getX() - 2, bp.getY(), bp.getZ() + i), Blocks.DIRT.defaultBlockState());
                }
            }
        }
        super.tick();
    }

    public class TankMoveToGoal extends Goal {
        private final TankEntity tank;
        public TankMoveToGoal(){
            tank = TankEntity.this;
        }

        @Override
        public boolean canUse() {
            return tank.getTarget() != null;
        }

        public void tick(){
            /*
            final LivingEntity target = tank.getTarget();
            if (target != null && target.isAlive()) {
                tank.getNavigation().moveTo(target, 3f);
            }
            */
            Level pLevel = this.tank.getLevel();
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(pLevel, this.tank);
            magicProjectile.shootFromRotation(this.tank, this.tank.getXRot(), this.tank.getYRot(), 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(magicProjectile);
        }
    }

}
