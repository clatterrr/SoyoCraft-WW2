
package com.example.examplemod.entity.custom.FogZombie;

import com.example.examplemod.entity.custom.FogPlant.BloverEntity;
import com.example.examplemod.entity.custom.PoolZombie.SnorkelZombieEntity;
import com.example.examplemod.entity.custom.ThePlantEntity;
import com.example.examplemod.entity.custom.TheZombieEntity;
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class BalloonZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(BalloonZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(BalloonZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public BalloonZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 12.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.FLYING_SPEED, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.1f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
      //  this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2F, false));
      //  this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ThePlantEntity.class, true));
      //  this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Ghast.class, true));
      //  this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Bee.class, true));

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.Style() == 0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.balloon_zombie.idle", true));
        }else if(this.Style() == 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.balloon_zombie.break", true));
        }else if(this.Style() == 2){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.balloon_zombie.walk", true));
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


    int cool_down = 0;
    boolean flying = true;

    public boolean isFlying(){
        return this.flying;
    }

    public void Down(){
        this.flying = false;
    }
    public void tick() {
        super.tick();
        this.yBodyRot = 180;
        /*
        if(this.flying == false){
            this.cool_down += 1;
            if(this.cool_down < 30){
                this.setStyle(0);
            }else if(this.cool_down < 50){
                this.setStyle(1);
            }else {
                this.setStyle(2);
            }
        }
        */
        List<BloverEntity> zombies = this.level.getEntitiesOfClass(BloverEntity.class, this.getBoundingBox().inflate(8));
        if(!zombies.isEmpty()){
            this.cool_down = 100;
        }
        if(this.cool_down >= 0){
            this.cool_down -= 1;
            this.setDeltaMovement(0, 0, 0.04f);
        }else{
            this.setDeltaMovement(0, 0, -0.01f);
        }
    }

    @Override
    public void die(DamageSource p_21014_) {
        this.spawnAtLocation(Items.STRING);
        super.die(p_21014_);
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



