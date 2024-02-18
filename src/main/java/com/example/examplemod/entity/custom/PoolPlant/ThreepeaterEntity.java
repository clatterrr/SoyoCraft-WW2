package com.example.examplemod.entity.custom.PoolPlant;

import com.example.examplemod.entity.ModEntityTypes;

import com.example.examplemod.entity.custom.DayZombie.NormalZombieEntity;
import com.example.examplemod.entity.custom.PoolZombie.SnorkelZombieEntity;
import com.example.examplemod.entity.custom.Projectile.PeaProjectileEntity;
import com.example.examplemod.entity.custom.ThePlantEntity;
import com.example.examplemod.entity.custom.TheZombieEntity;
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
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class ThreepeaterEntity extends ThePlantEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(NormalZombieEntity.class, EntityDataSerializers.BOOLEAN);
    private AnimationFactory factory = new AnimationFactory(this);

    public ThreepeaterEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TheZombieEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.threepeater.idle", true));
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
    private int cool_down = 0;
    public void tick(){
        this.yBodyRot = 0;
        this.setDeltaMovement(0,0,0);
        super.tick();
        this.setDeltaMovement(0,0,0);
        this.cool_down += 1;
        List<TheZombieEntity> zombies = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(8));
        if(!zombies.isEmpty()){
            for(int i = 0; i < zombies.size();i++){
                TheZombieEntity z = zombies.get(i);
                if(z instanceof SnorkelZombieEntity s){
                    if(s.Style() == 0){
                        continue;
                    }
                }
                int zd = z.getOnPos().getX() - this.getOnPos().getX();
                if(z.getOnPos().getZ() >= this.getOnPos().getZ() && zd >= -1 && zd <= 1){
                    if(this.cool_down > 8){
                        this.cool_down = 0;


                        BlockPos bpq = this.getOnPos();
                        {
                            PeaProjectileEntity pea = new PeaProjectileEntity(ModEntityTypes.PEA_PROJECTILE.get(), this.level);
                            pea.setPos(bpq.getX() + 0.5f, bpq.getY() + 1.7f, bpq.getZ() + 1.3f);
                            this.getLevel().addFreshEntity(pea);
                        }
                        {
                            PeaProjectileEntity pea = new PeaProjectileEntity(ModEntityTypes.PEA_PROJECTILE.get(), this.level);
                            pea.setPos(bpq.getX() + 1.5f, bpq.getY() + 2.5f, bpq.getZ() + 1.3f);
                            this.getLevel().addFreshEntity(pea);
                        }
                        {
                            PeaProjectileEntity pea = new PeaProjectileEntity(ModEntityTypes.PEA_PROJECTILE.get(), this.level);
                            pea.setPos(bpq.getX() - 0.5f, bpq.getY() + 2.3, bpq.getZ() + 1.3f);
                            this.getLevel().addFreshEntity(pea);
                        }
                    }
                }
            }
        }

    }
}
