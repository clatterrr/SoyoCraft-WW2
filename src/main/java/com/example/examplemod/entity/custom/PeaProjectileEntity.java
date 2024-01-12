package com.example.examplemod.entity.custom;

import com.example.examplemod.entity.ModEntityTypes;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class PeaProjectileEntity extends Monster implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(NormalZombieEntity.class, EntityDataSerializers.BOOLEAN);
    private AnimationFactory factory = new AnimationFactory(this);

    public PeaProjectileEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
        this.setNoGravity(true);
        this.setBoundingBox(AABB.ofSize(new Vec3(0,0,0), 0, 0, 0));
        this.could_fire = true;
    }

    public void setCouldFire(boolean could_fire){
        this.could_fire = could_fire;
    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100f)
                .add(Attributes.MOVEMENT_SPEED, 0.0f).build();
    }

    private boolean could_fire = true;

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TheZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

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

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    public void tick(){
        this.setDeltaMovement(0,0,0.2f);
        super.tick();
        List<TheZombieEntity> zombies = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(8));
        if(!zombies.isEmpty()) {
            for (int i = 0; i < zombies.size(); i++) {
                TheZombieEntity z = zombies.get(i);
                if(z.getOnPos().getX() == this.getOnPos().getX() && z.getOnPos().getZ() == this.getOnPos().getZ()){
                    z.hurt(DamageSource.GENERIC, 0.1f);
                    this.remove(RemovalReason.KILLED);
                }
            }
        }

        if(this.could_fire){
            List<TorchwoodEntity> torch = this.level.getEntitiesOfClass(TorchwoodEntity.class, this.getBoundingBox().inflate(1));
            for(int i = 0; i< torch.size();i++){
                TorchwoodEntity z = torch.get(i);
                if(z.getOnPos().getZ()  == this.getOnPos().getZ() && z.getOnPos().getX() == this.getOnPos().getX()){
                    FirePeaProjectileEntity pea = new FirePeaProjectileEntity(ModEntityTypes.FIRE_PEA_PROJECTILE.get(), this.level);
                    pea.setPos(this.position());
                    this.level.addFreshEntity(pea);
                    this.remove(RemovalReason.DISCARDED);
                }
            }
        }

    }
}
