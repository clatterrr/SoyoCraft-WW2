package com.example.examplemod.entity.custom;

import com.example.examplemod.block.ModBlocks;
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
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class KoopaEntity extends Monster implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(KoopaEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(KoopaEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public KoopaEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ThePlantEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.Style() == 0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.koopa.walk", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.koopa.squash", true));
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

    int cool = 0;
    boolean jumped = false;
    float speed = 1.0f;
    public void tick() {
        if(this.cool < 120){
            this.setDeltaMovement(0,0, 0.1f);
        }else if(this.cool < 240){

            this.setDeltaMovement(0,0, -0.1f);
        }else{
            this.cool = 0;
        }
        super.tick();
        this.cool += 1;
        if(this.cool < 120){
            this.yBodyRot = -90;
        }else if(this.cool < 240){
            this.yBodyRot = 90;
        }else{
            this.cool = 0;
        }
        /*
        BlockPos bp = this.getOnPos();
        BlockPos left = new BlockPos(bp.getX(), bp.getY() + 1, bp.getZ() - 1);
        BlockPos left1 = new BlockPos(bp.getX(), bp.getY() + 2, bp.getZ() - 1);
        BlockPos right = new BlockPos(bp.getX(), bp.getY() + 1, bp.getZ() + 1);
        BlockPos right1 = new BlockPos(bp.getX(), bp.getY() + 2, bp.getZ() + 1);
        if(this.level.getBlockState(left).getBlock() == ModBlocks.STAIR.get() ||
                this.level.getBlockState(left1).getBlock() == ModBlocks.P1.get()){
            speed = 1.0f;
        }
        if(this.level.getBlockState(right).getBlock() == ModBlocks.STAIR.get()||
                this.level.getBlockState(right1).getBlock() == ModBlocks.P0.get()){
            speed = -1.0f;
        }
        //this.setDeltaMovement(0.0f, 0.0f, speed * 0.1f);
        if(speed == 1.0f){

            this.yBodyRot = -90;
        }else{

            this.yBodyRot = 90;
        }
        if(!this.level.players().isEmpty()){
            Player player = this.level.players().get(0);
            Vec3 p0 = player.position();
            Vec3 p1 = this.position();
            if((p0.x - p1.x) * (p0.x - p1.x) + (p0.z - p1.z) * (p0.z - p1.z) < 0.5f  && p0.y - p1.y < 1.0f){
                if(p0.y - p1.y > 0.5f){
                    this.jumped = true;
                    this.setStyle(1);
                }else{
                    //player.die(DamageSource.FALL);
                }

            }
        }
        if(this.jumped == true){
            this.cool += 1;
            if(this.cool >= 120){
                this.remove(RemovalReason.DISCARDED);
            }
        }
        */

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
