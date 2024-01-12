package com.example.examplemod.entity.custom;

import com.example.examplemod.entity.ModEntityTypes;
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

public class PoleVaultingEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(PoleVaultingEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(PoleVaultingEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public PoleVaultingEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.07f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(1, new SummonGoal());

         this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ThePlantEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {


        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sled.walk", true));



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

    boolean spawn = false;

    public void tick() {

        this.setDeltaMovement(0, 0, -0.02f);
        super.tick();
        this.yBodyRot = 180;

        BlockPos bp = new BlockPos(this.getOnPos().getX(), this.getOnPos().getY(), this.getOnPos().getZ() - 1);
        if(this.level.getBlockState(bp).getBlock() != Blocks.ICE){

            if(!spawn){
                ZombieBobsledTeamEntity crew0 = new ZombieBobsledTeamEntity(ModEntityTypes.ZOMBIE_BOBSLED_TEAM.get(), this.level);
                crew0.setPos(bp.getX() + 0.5f, bp.getY() + 1.0f, bp.getZ() + 3.4f);
                this.level.addFreshEntity(crew0);

                ZombieBobsledTeamEntity crew1 = new ZombieBobsledTeamEntity(ModEntityTypes.ZOMBIE_BOBSLED_TEAM.get(), this.level);
                crew1.setPos(bp.getX() + 0.5f, bp.getY() + 1.0f, bp.getZ() + 2.6f);
                this.level.addFreshEntity(crew1);

                ZombieBobsledTeamEntity crew2 = new ZombieBobsledTeamEntity(ModEntityTypes.ZOMBIE_BOBSLED_TEAM.get(), this.level);
                crew2.setPos(bp.getX() + 0.5f, bp.getY() + 1.0f, bp.getZ() + 1.8f);
                this.level.addFreshEntity(crew2);

                ZombieBobsledTeamEntity crew3 = new ZombieBobsledTeamEntity(ModEntityTypes.ZOMBIE_BOBSLED_TEAM.get(), this.level);
                crew3.setPos(bp.getX() + 0.5f, bp.getY() + 1.0f, bp.getZ() + 1.0f);
                this.level.addFreshEntity(crew3);
                spawn = true;
            }



        }
        if(spawn){
            this.remove(RemovalReason.DISCARDED);
            this.kill();
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
