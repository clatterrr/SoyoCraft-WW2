package com.example.examplemod.entity.custom.DayZombie;

import com.example.examplemod.entity.custom.ThePlantEntity;
import com.example.examplemod.entity.custom.TheZombieEntity;
import com.example.examplemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
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

public class NormalZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(NormalZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(NormalZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public NormalZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
                .add(Attributes.FLYING_SPEED, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.1f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ThePlantEntity.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {


        if(this.getHealth() > 5){
            if(this.isAttacking() == true){
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.attack", true));
            }else{
                if(this.Style() == 0){
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.walk", true));
                }else if(this.Style() == 1){
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.walk2", true));
                }else {
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.walk3", true));
                }

            }
        }else {
            if(this.isAttacking()){
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.attack2", true));
            }else{
                if(this.Style() == 0){
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.walk1_1", true));
                }else if(this.Style() == 1){
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.walk2_1", true));
                }else {
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal_zombie.walk3_1", true));
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

    public void tick() {
        /*
        this.setAttacking(false);
        List<ThePlantEntity> plants = this.level.getEntitiesOfClass(ThePlantEntity.class, this.getBoundingBox().inflate(2));
        if(!plants.isEmpty()) {
            for (int i = 0; i < plants.size(); i++) {
                ThePlantEntity z = plants.get(i);
                if(z.getOnPos().getX() == this.getOnPos().getX() &&  z.position().z + 0.8f > this.position().z){
                    this.kelped = true;
                    this.setAttacking(true);
                    z.hurt(DamageSource.CACTUS, 1.0f);
                }
            }
        }
        if(this.getHealth() <= 5 && this.drop_hand == false){
            this.drop_hand = true;
            this.spawnAtLocation(ModItems.ZOMBIE_HAND.get());
        }
        if(this.kelped) {
            this.setDeltaMovement(0,0,0);
        }else{

            this.setDeltaMovement(0, 0, -0.01f);
        }
        this.kelped = false;

        BlockPos bp = this.getOnPos();
        if(this.level.getBlockState(bp).getBlock() == Blocks.AIR){

            this.setDeltaMovement(0, -0.1f, -0.01f);
        }else{

            this.setDeltaMovement(0, 0, -0.01f);
        }
         */
        super.tick();
        //this.yBodyRot = towards;
        if(this.delta_movement.x == 0 && this.delta_movement.y == 0 && this.delta_movement.z == 0){

        }else{
           // this.setDeltaMovement(this.delta_movement.x, this.delta_movement.y, this.delta_movement.z);
        }

        this.setAttacking(false);

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
