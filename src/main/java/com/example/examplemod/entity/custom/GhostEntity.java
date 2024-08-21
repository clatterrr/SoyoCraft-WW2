package com.example.examplemod.entity.custom;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
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

import java.util.List;

public class GhostEntity extends Monster implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(GhostEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(GhostEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public GhostEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
                .add(Attributes.MAX_HEALTH, 10)
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.punch", true));
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



    int attack_cool_down = 0;

    public void tick() {
        super.tick();

        double speed = 0.2f;
        // ability 1
        List<Monster> entities = this.level.getEntitiesOfClass(Monster.class, this.getBoundingBox().inflate(8));
        if(entities.size() > 1){
            this.setStyle(2);
            for(int i = 0; i < entities.size(); i++){
                Entity target = entities.get(i);
                if(target.hashCode() == this.hashCode()){
                    continue;
                }
                double mx = target.position().x - this.position().x;
                double my = target.position().y - this.position().y;
                double mz = target.position().z - this.position().z;
                Vec3 m = new Vec3(mx, my,mz);

                if(m.length() < 0.5f){
                    this.setDeltaMovement(0,0,0);
                    if(this.attack_cool_down == 0){
                        target.hurt(DamageSource.CACTUS, 5f);
                        attack_cool_down = 20;
                    }
                    attack_cool_down -= 1;

                }else{

                    m = m.normalize();
                    this.setDeltaMovement(m.x * speed, m.y * speed, m.z * speed);
                    double theta = Math.atan2(mz, mx) * 180.0 / 3.14;
                    this.yBodyRot = (float) theta - 90;
                }
                break;
            }



        }else{
            this.setStyle(0);
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
