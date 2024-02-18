package com.example.examplemod.entity.custom.PoolZombie;

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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class DolphinRiderZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(DolphinRiderZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(DolphinRiderZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public DolphinRiderZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.07f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {


        if(this.Style() == 0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.walk", true));
        }else if(this.Style() ==1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.drop", false));
        }else if(this.Style() == 2){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.swim", true));
        }else if(this.Style() == 3){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.jump", false));
        }else if(this.Style() == 4){
            if(this.isAttacking()){
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.attack", true));

            }else{
                if(this.getHealth() > 5){
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.swim2", true));

                }else{
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dolphin_rider_zombie.swim3", true));
                }
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

    int drop_cool_down = 0;

    boolean is_tall_nut = false;

    public void tick() {
        this.setStyle(2);
        this.setNoGravity(true);
        /*
        BlockPos back = new BlockPos(this.getOnPos().getX(), this.getOnPos().getY(), this.getOnPos().getZ() + 1);
        BlockPos front = new BlockPos(this.getOnPos().getX(), this.getOnPos().getY(), this.getOnPos().getZ());
        Block back_block = this.level.getBlockState(back).getBlock();
        Block front_block = this.level.getBlockState(front).getBlock();

        if(this.Style() == 0){
            this.setDeltaMovement(0, 0, -0.01f);
            if(back_block == Blocks.GRASS_BLOCK && front_block == Blocks.WATER){
                this.setStyle(1);
            }
        }
        if(this.Style() == 1){
            this.setDeltaMovement(0, 0, -0.02f);
        }
        if(this.Style() == 2){
            this.setDeltaMovement(0, 0, -0.02f);
            List<ThePlantEntity> plants = this.level.getEntitiesOfClass(ThePlantEntity.class, this.getBoundingBox().inflate(2));
            if(!plants.isEmpty()) {
                for (int i = 0; i < plants.size(); i++) {
                    ThePlantEntity z = plants.get(i);
                    if(z.getOnPos().getX() == this.getOnPos().getX() &&  z.position().z + 0.8f > this.position().z){
                        this.setStyle(3);
                        if(z instanceof  TallnutEntity tall){
                            this.is_tall_nut = true;
                        }
                    }
                }
            }
        }
        if(this.Style() == 3){
        }
        if(this.Style() == 4){
            this.setDeltaMovement(0, 0, -0.01f);
        }

        if(this.Style() == 1){
            this.drop_cool_down += 1;
            if(this.drop_cool_down >= 20){
                this.setStyle(2);
                this.drop_cool_down = 0;
            }
        }

        if(this.Style() == 3){
            this.drop_cool_down += 1;

            if(this.drop_cool_down < 18){

                this.setDeltaMovement(0, 0.04f, -0.06f);
                if(this.is_tall_nut){
                    this.setDeltaMovement(0, 0.04f, 0);
                }
            }else if(this.drop_cool_down < 36){

                this.setDeltaMovement(0, -0.04f, -0.04f);
                if(this.is_tall_nut){
                    this.setDeltaMovement(0, -0.04f, 0);
                }
            }else{
                this.setStyle(4);
                this.drop_cool_down = 0;
            }
        }
        if(this.Style() == 4){
            this.setDeltaMovement(0,0,-0.01f);
            this.setAttacking(false);
            List<ThePlantEntity> plants = this.level.getEntitiesOfClass(ThePlantEntity.class, this.getBoundingBox().inflate(2));
            if(!plants.isEmpty()) {
                for (int i = 0; i < plants.size(); i++) {
                    ThePlantEntity z = plants.get(i);
                    if(z.getOnPos().getX() == this.getOnPos().getX()  &&  z.position().z + 0.8f > this.position().z &&  z.position().z < this.position().z){
                        this.setDeltaMovement(0,0,0);
                        this.setAttacking(true);
                        if(z instanceof LilyPadEntity pad){

                        }else {

                            z.hurt(DamageSource.CACTUS, 1.0f);
                        }
                    }
                }
            }

        }
        */
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
