package com.example.examplemod.entity.custom;

import kroppeb.stareval.function.Type;
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

import java.util.List;

public class SquashEntity extends Monster implements IAnimatable {

    private static final EntityDataAccessor<Integer> ATTACKING =
            SynchedEntityData.defineId(SquashEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public SquashEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
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
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TheZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if(this.isAttacking() == 0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.squash.idle", true));
        }else if(this.isAttacking() == 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.squash.see_right", true));
        }else if(this.isAttacking() == 2){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.squash.attack_right", true));
        }else if(this.isAttacking() == 3){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.squash.see_left", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.squash.attack_left", true));
        }

        //event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.squash.move", true));
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

    public void setAttacking(int attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public int isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, 0);
    }

    int kill_count = 0;

    public void tick(){
        this.yBodyRot = 90;
        this.setDeltaMovement(0,0,0);
        super.tick();
        this.setDeltaMovement(0,0,0);

        if(this.isAttacking() >= 3){
            this.kill_count += 1;
            if(this.kill_count == 20){
                this.setAttacking(4);
            }
            if(this.kill_count >= 50){
                this.setDeltaMovement(0, -1.0f, 0);
                List<TheZombieEntity> lily_pads = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(2));
                for(int i = 0; i< lily_pads.size();i++){
                    TheZombieEntity z = lily_pads.get(i);
                    //z.remove(RemovalReason.KILLED);
                    z.kill();
                }
                if(this.kill_count >=60){
                    this.remove(RemovalReason.KILLED);
                }
            }
        }

        if(this.isAttacking() == 1 || this.isAttacking() == 2){
            this.kill_count += 1;
            if(this.kill_count == 20){
                this.setAttacking(2);
            }
            if(this.kill_count >= 50){
                this.setDeltaMovement(0, -1.0f, 0);
                List<TheZombieEntity> lily_pads = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(2));
                for(int i = 0; i< lily_pads.size();i++){
                    TheZombieEntity z = lily_pads.get(i);
                    //z.remove(RemovalReason.KILLED);
                    z.kill();
                }
                if(this.kill_count >=60){
                    this.remove(RemovalReason.KILLED);
                }
            }
        }



        List<TheZombieEntity> lily_pads = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(2));
        if(!lily_pads.isEmpty() && this.isAttacking() == 0){
            TheZombieEntity flag = lily_pads.get(0);
            if(flag.getOnPos().getZ() == this.getOnPos().getZ() + 1){
                this.setAttacking(1);
            }
            if(flag.getOnPos().getZ() == this.getOnPos().getZ() - 1){
                this.setAttacking(3);
            }
        }

    }
}
