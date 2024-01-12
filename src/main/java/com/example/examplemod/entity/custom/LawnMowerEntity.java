package com.example.examplemod.entity.custom;

import com.example.examplemod.item.ModItems;
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

public class LawnMowerEntity extends ThePlantEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(LawnMowerEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(LawnMowerEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public LawnMowerEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0f)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.FLYING_SPEED, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.1f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lawn_mower.idle", true));
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

    Boolean launch_state = false;

    Boolean begin_count = false;
    int count = 0;

    public void tick() {

        if(begin_count == true){
            this.count += 1;
            if(this.count > 5){
                this.remove(RemovalReason.DISCARDED);
            }
        }
        BlockPos bp = this.getOnPos();
        if(this.launch_state){

            List<TheZombieEntity> zombies = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(2));
            for(int i = 0; i< zombies.size();i++){
                TheZombieEntity z = zombies.get(i);
                if(z.getOnPos().getZ() == bp.getZ() && z.getOnPos().getX() == bp.getX()){
                    z.kill();
                }
            }

            if(this.level.getBlockState(bp).getBlock() == Blocks.WATER){
                this.setDeltaMovement(0,-0.1, 0.0f);
                if(begin_count == false){
                    begin_count = true;
                }
            }else{
                this.setDeltaMovement(0,0, 0.2f);
            }
        }else{
            this.setDeltaMovement(0,0,0);

            List<TheZombieEntity> zombies = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(2));
            for(int i = 0; i< zombies.size();i++){
                TheZombieEntity z = zombies.get(i);
                if(z.getOnPos().getZ()  == bp.getZ() + 1 && z.getOnPos().getX() == bp.getX()){
                    this.launch_state = true;
                }
            }
        }
        this.yBodyRot = 0;
        super.tick();

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
