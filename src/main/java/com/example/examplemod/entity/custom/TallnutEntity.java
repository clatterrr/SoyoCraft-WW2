package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TallnutEntity extends ThePlantEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(NormalZombieEntity.class, EntityDataSerializers.BOOLEAN);
    private AnimationFactory factory = new AnimationFactory(this);

    public TallnutEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 15.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new ShootGoal());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TheZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.isAttacking()){

            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.puff_shroom.attack", true));
        }else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.puff_shroom.idle", true));
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

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    public void tick(){
        this.yBodyRot = 90;
        super.tick();

    }

    public class ShootGoal extends Goal {
        private final TallnutEntity shroom;

        public ShootGoal() {
            shroom = TallnutEntity.this;
        }

        private int cool_down = 0;

        @Override
        public boolean canUse() {

            if(this.shroom.getTarget() != null){

                BlockPos bp0 = this.shroom.getTarget().getOnPos();
                BlockPos bp1 = this.shroom.getOnPos();

                if(bp0.getZ() - bp1.getZ() < 8 && bp0.getZ() - bp1.getZ() > -1 ){
                    this.shroom.setAttacking(true);
                    return true;
                }
            }
            this.shroom.setAttacking(false);
            return false;
        }

        public void tick() {
            Vec3 p = this.shroom.getTarget().position();
            final double d0 = this.shroom.random.nextGaussian() * 0.2D;
            final double d1 = this.shroom.random.nextGaussian() * 0.2D;
            final double d2 = this.shroom.random.nextGaussian() * 0.2D;
            this.shroom.getLevel().addParticle(ParticleTypes.SPLASH, p.x, p.y, p.z, d0, d1, d2);
            this.cool_down += 1;
            if(this.cool_down > 5) {


            }
        }
    }

}