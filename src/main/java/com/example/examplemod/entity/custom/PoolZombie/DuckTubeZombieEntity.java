package com.example.examplemod.entity.custom.PoolZombie;

import com.example.examplemod.entity.custom.ThePlantEntity;
import com.example.examplemod.entity.custom.TheZombieEntity;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class DuckTubeZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(DuckTubeZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(DuckTubeZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public DuckTubeZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public static AttributeSupplier setAttributes() {

        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {


    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if(this.getHealth() > 3){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duck_tube_zombie.swim", true));
        }else if(this.getHealth() > 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duck_tube_zombie.swim2", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duck_tube_zombie.die", true));
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

    int kill_tick = 0;
    public void tick() {

        List<ThePlantEntity> plants = this.level.getEntitiesOfClass(ThePlantEntity.class, this.getBoundingBox().inflate(2));
        if(!plants.isEmpty()) {
            for (int i = 0; i < plants.size(); i++) {
                ThePlantEntity z = plants.get(i);
                if(z.getOnPos().getX() == this.getOnPos().getX() &&  z.position().z + 0.8f > this.position().z && z.position().z < this.position().z){
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

            this.setDeltaMovement(0, 0, -0.005f);
        }
        this.kelped = false;
        super.tick();

        this.yBodyRot = 0;
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
