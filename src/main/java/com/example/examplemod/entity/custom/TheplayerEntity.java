package com.example.examplemod.entity.custom;

import net.minecraft.commands.arguments.EntityAnchorArgument;
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
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TheplayerEntity extends Monster implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(TheplayerEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(TheplayerEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public TheplayerEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.Style() == 0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", true));
        }else if(this.Style() == 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.walk", true));
        }else if(this.Style() == 2){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.attack", true));
        }else if(this.Style() == 3){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.look", true));
        }else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.dead", true));
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




    public void SetAnimation(String anim){
        System.out.println("anim = " + anim);
        if(anim.equals("charge_in") || anim.equals("walk") || anim.equals("run")){
            this.setStyle(1);
        }else if(anim.equals("attack")){
            this.setStyle(2);
        }else if(anim.equals("spawn") || anim.equals("look")){
            this.setStyle(3);
        }else if(anim.equals("dead")){
            this.setStyle(4);
        }else{
            this.setStyle(0);
        }
    }

    private Vec3 theDeltaMove = Vec3.ZERO;
    private Vec3 lookat = Vec3.ZERO;
    private Vec3 lookatDelta = Vec3.ZERO;
    public void SetDeltaMove(Vec3 m){
        this.theDeltaMove = m;
    }

    private boolean alreadyLook = false;

    public void SetEffect(){

        this.frame = 1;
    }
    public void SetLookAt(Vec3 m){
        this.frame = 0;
        this.alreadyLook = true;
        this.lookat = m;
    }
    private int frame = 0;
    public void tick() {
        super.tick();
        this.setDeltaMovement(this.theDeltaMove);
        if(this.alreadyLook == true){
            BlockPos bp = this.blockPosition();
            double dx = bp.getX() + this.lookat.x ;
            double dy = bp.getY() + this.lookat.y + 1 ;
            double dz = bp.getZ() + this.lookat.z;
            this.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(dx, dy, dz));
        }
        if(this.frame < 100 && this.frame > 0){
            Vec3 p = this.position();
            final double d0 = this.random.nextGaussian() * 1.2D;
            final double d1 = this.random.nextGaussian() * 1.2D;
            final double d2 = this.random.nextGaussian() * 1.2D;
            this.getLevel().addParticle(ParticleTypes.LAVA, p.x, p.y + 0.5f, p.z, d0, d1, d2);
            this.frame += 1;
        }

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
