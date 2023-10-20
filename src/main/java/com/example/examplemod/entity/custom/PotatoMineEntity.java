package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
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

public class PotatoMineEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public PotatoMineEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private int ready_counter = 0;

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(1, new SummonGoal());
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, NormalZombieEntity.class, 6.0F));
        //this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, NormalZombieEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, FlagZombieEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PoleVaultingZombieEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ConeHeadZombieEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BucketHeadZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WitherSkeleton.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.ready_counter < 100){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.potato_mine.wait", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.potato_mine.ready", true));
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

    public void tick(){
        //this.yBodyRot = 0;
        this.ready_counter += 1;
        if(this.ready_counter > 100){
            List<NormalZombieEntity> normal_zombies = this.getLevel().getEntitiesOfClass(NormalZombieEntity.class, this.getBoundingBox().inflate(1));
            if(!normal_zombies.isEmpty()){
                for(NormalZombieEntity zombie: normal_zombies){
                    zombie.kill();
                }
                BlockPos bp = this.getOnPos();
                this.getLevel().explode(null, bp.getX(), bp.getY(), bp.getZ(), 1.0F, false, Explosion.BlockInteraction.NONE);
                this.getLevel().addParticle(ParticleTypes.SMOKE, bp.getX(), bp.getY(), bp.getZ(),0,0.3F,0);
                this.kill();
                this.die(DamageSource.FALL);
            }
            List<PoleVaultingZombieEntity> pole_zombies = this.getLevel().getEntitiesOfClass(PoleVaultingZombieEntity.class, this.getBoundingBox().inflate(1));
            if(!pole_zombies.isEmpty()){
                for(PoleVaultingZombieEntity zombie: pole_zombies){
                    zombie.kill();
                }
                BlockPos bp = this.getOnPos();
                this.getLevel().explode(null, bp.getX(), bp.getY(), bp.getZ(), 1.0F, false, Explosion.BlockInteraction.NONE);
                this.getLevel().addParticle(ParticleTypes.SMOKE, bp.getX(), bp.getY(), bp.getZ(),0,0.3F,0);
                this.kill();
                this.die(DamageSource.FALL);
            }

        }
        super.tick();
    }
}
