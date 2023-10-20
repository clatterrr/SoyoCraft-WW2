package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Explosion;
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

public class CherryBombEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    private int explode_count = 0;

    public CherryBombEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    @Override
    protected void registerGoals() {
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        /*
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.smoker.walk", true));
            return PlayState.CONTINUE;
        }
        */

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cherry_bomb.explode", true));
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


    public void tick(){
        //this.yBodyRot = 0;
        super.tick();
       this.explode_count += 1;
        if(this.explode_count == 20){
            BlockPos bp = this.getOnPos();
            this.getLevel().explode(null, bp.getX(), bp.getY(), bp.getZ(), 0.3F, false, Explosion.BlockInteraction.DESTROY);
            for(int i = -1;i <= 1; i++){
                for(int j = -1;j <= 1;j ++){
                    for(int k = -1;k<=1;k++){
                        this.getLevel().destroyBlock(new BlockPos(bp.getX() + i, bp.getY() + j, bp.getZ() + k), false);
                    }
                }
            }
            List<FlagZombieEntity> flag_zombies = this.getLevel().getEntitiesOfClass(FlagZombieEntity.class, this.getBoundingBox().inflate(3));
            for(FlagZombieEntity zombie: flag_zombies){
                zombie.kill();
            }
            List<NormalZombieEntity> normal_zombies = this.getLevel().getEntitiesOfClass(NormalZombieEntity.class, this.getBoundingBox().inflate(3));
            for(NormalZombieEntity zombie: normal_zombies){
                zombie.kill();
            }
            List<ConeHeadZombieEntity> cone_zombies = this.getLevel().getEntitiesOfClass(ConeHeadZombieEntity.class, this.getBoundingBox().inflate(3));
            for(ConeHeadZombieEntity zombie: cone_zombies){
                zombie.kill();
            }
            List<BucketHeadZombieEntity> bucket_zombies = this.getLevel().getEntitiesOfClass(BucketHeadZombieEntity.class, this.getBoundingBox().inflate(3));
            for(BucketHeadZombieEntity zombie: bucket_zombies){
                zombie.kill();
            }
            List<PoleVaultingZombieEntity> pole_zombie = this.getLevel().getEntitiesOfClass(PoleVaultingZombieEntity.class, this.getBoundingBox().inflate(3));
            for(PoleVaultingZombieEntity zombie: pole_zombie){
                zombie.kill();
            }
            this.die(DamageSource.IN_FIRE);
            this.kill();
        }
    }

}
