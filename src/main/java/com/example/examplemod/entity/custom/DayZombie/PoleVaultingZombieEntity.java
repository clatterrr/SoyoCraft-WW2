package com.example.examplemod.entity.custom.DayZombie;

import com.example.examplemod.entity.custom.PoolPlant.TallnutEntity;
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

import java.util.List;

public class PoleVaultingZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(PoleVaultingZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(PoleVaultingZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public PoleVaultingZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.07f).build();
    }

    private boolean is_tall_nut = false;

    @Override
    protected void registerGoals() {
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {


        if(this.Style() == 0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pole_vaulting_zombie.walk", true));
        }else if(this.Style() ==1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pole_vaulting_zombie.jump", false));
        }else if(this.Style() == 2) {
            if (this.isAttacking()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pole_vaulting_zombie.attack", true));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pole_vaulting_zombie.walk2", true));
            }
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
    private  int cool = 0;
    public void tick() {

        if(this.Style() == 0){
            this.setDeltaMovement(0,0, -0.02f);
            List<ThePlantEntity> plants = this.level.getEntitiesOfClass(ThePlantEntity.class, this.getBoundingBox().inflate(2));
            if(!plants.isEmpty()) {
                for (int i = 0; i < plants.size(); i++) {
                    ThePlantEntity z = plants.get(i);
                    if(z.getOnPos().getX() == this.getOnPos().getX() &&  z.position().z + 0.8f > this.position().z &&  z.position().z < this.position().z){
                        this.setStyle(1);
                        if(z instanceof  TallnutEntity tall){
                            this.is_tall_nut = true;
                        }
                    }
                }
            }
        }

        if(this.Style() == 1){
            this.cool += 1;
            if(this.cool < 12) {
                if(this.is_tall_nut){

                    this.setDeltaMovement(0,0.1, 0);
                }else {

                    this.setDeltaMovement(0,0.1, -0.04f);
                }
            }else{
                if(this.is_tall_nut){

                    this.setDeltaMovement(0,-0.1, 0);
                }else {

                    this.setDeltaMovement(0,-0.1, -0.04f);
                }
            }
            if(this.cool >= 24){
                this.setStyle(2);
            }
        }

        if(this.Style() == 2){
            this.setDeltaMovement(0,0,-0.01f);
            this.setAttacking(false);
            List<ThePlantEntity> plants = this.level.getEntitiesOfClass(ThePlantEntity.class, this.getBoundingBox().inflate(2));
            if(!plants.isEmpty()) {
                for (int i = 0; i < plants.size(); i++) {
                    ThePlantEntity z = plants.get(i);
                    if(z.getOnPos().getX() == this.getOnPos().getX()  &&  z.position().z + 0.8f > this.position().z &&  z.position().z < this.position().z){
                        this.setDeltaMovement(0,0,0);
                        this.setAttacking(true);
                        z.hurt(DamageSource.CACTUS, 1.0f);
                    }
                }
            }

        }
        super.tick();
        this.yBodyRot = 180;
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
