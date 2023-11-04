package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SmilesEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public SmilesEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        /*
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false));
      //  this.goalSelector.addGoal(2, new ThrowGoal());
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Skeleton.class, true));
        */
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
if(event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.smiles.attack", true));
        }else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.smiles.attack", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "smoker_controller",
                0, this::predicate));
    }

    private boolean hit_by_snow = false;

    public void hit_snow(){
        this.setSpeed(0.7F);
        this.hit_by_snow = true;
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

    public void tick(){
        this.yBodyRot = 0;
        super.tick();
    }

    public class ThrowGoal extends Goal {
        private final SmilesEntity me;

        public ThrowGoal() {
            this.me = SmilesEntity.this;
        }

        private int cool_down = 0;

        @Override
        public boolean canUse() {

            return this.me.getTarget() != null;
        }

        public void tick() {

            this.cool_down += 1;

            if (this.cool_down > 40) {
                if (this.me.getLevel().players().size() > 0) {
                    Player p = this.me.getLevel().players().get(0);
                    
                    //p.sendSystemMessage(Component.literal("throw potion"));
                }


                GrassProjectileEntity ga = new GrassProjectileEntity(this.me.level, this.me);
                ga.shootFromRotation(this.me, this.me.getXRot(), this.me.yBodyRot, 0.0F, 1.5F, 0.25F);
                this.me.getLevel().addFreshEntity(ga);
                this.me.getTarget().hurt(DamageSource.MAGIC, 10F);
                this.cool_down = 0;




            }
        }
    }


}
