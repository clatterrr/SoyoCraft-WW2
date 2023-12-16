package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
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

public class DuckTubeConeHeadZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(DuckTubeConeHeadZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(DuckTubeConeHeadZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public DuckTubeConeHeadZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
        //this.setPathfindingMalus(BlockPathTypes.WATER, 8.0f);
        double r = pLevel.random.nextGaussian();
        if(r < 0.4){
            this.setStyle(0);
        }else if(r < 0.6){
            this.setStyle(1);
        }else {
            this.setStyle(2);
        }
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(1, new SummonGoal());
/*
         this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this)); */
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ThePlantEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));


    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if(this.getHealth() > 30){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duck_tube_zombie.swim", true));
        }else if(this.getHealth() > 10){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duck_tube_zombie.swim2", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duck_tube_zombie.die", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "smoker_controller",
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

        if (this.getTarget() != null) {
            double dx = this.getX() - this.getTarget().getX();
            double dz = this.getZ() - this.getTarget().getZ();

            if ((dx * dx + dz * dz) < 4.0) {
                this.setAttacking(true);
            }
        }
        this.setDeltaMovement(0, 0, -0.01f);
        this.setDeltaMovement(0,0,0);
        super.tick();
       // this.yBodyRot = 0;
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public void setStyle(int style) {
        this.entityData.set(STYLE, style);
    }

    public int Style() {
        return this.entityData.get(STYLE);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(STYLE, 0);
    }

}
