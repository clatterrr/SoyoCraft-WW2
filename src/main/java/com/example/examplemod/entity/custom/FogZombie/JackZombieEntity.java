
package com.example.examplemod.entity.custom.FogZombie;

import com.example.examplemod.entity.custom.PoolZombie.SnorkelZombieEntity;
import com.example.examplemod.entity.custom.PoolZombie.ZomboniEntity;
import com.example.examplemod.entity.custom.ThePlantEntity;
import com.example.examplemod.entity.custom.TheZombieEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;
import java.util.Random;

public class JackZombieEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(JackZombieEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(JackZombieEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public JackZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
        if(this.Style() == 1){

            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.jack_zombie.break", true));
        }else {

            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.jack_zombie.walk", true));
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

    @Override
    public void die(DamageSource p_21014_) {
        this.spawnAtLocation(Items.MUSIC_DISC_CAT);
        super.die(p_21014_);
    }

    int cool_down = 0;
    public void tick() {
        super.tick();
        this.yBodyRot = 180;
        this.setDeltaMovement(0,0, -0.01f);
        BlockPos bp = this.getOnPos();
        Random rand = new Random();
        Boolean z3 = false;
        List<ZomboniEntity> zombies = this.level.getEntitiesOfClass(ZomboniEntity.class, this.getBoundingBox().inflate(8));
        if(!zombies.isEmpty()){
            for(int i = 0; i < zombies.size();i++){
                ZomboniEntity z = zombies.get(i);
                if(z.getOnPos().getX() == this.getOnPos().getX() && (this.getOnPos().getZ() - z.getOnPos().getZ()) <= 1){
                    z3 = true;
                }
            }
        }

        this.cool_down += 1;
        if(this.cool_down > 400){
            this.setStyle(1);
            this.setDeltaMovement(0,0, 0f);
            if(this.cool_down == 41){
                BlockPos bp2 = this.getOnPos();
                Random rand2 = new Random();
                for (int i = 0; i < 20; i++) {
                    double vx = rand.nextGaussian() * 0.5F;
                    double vy = rand.nextGaussian() * 0.5F;
                    double vz = rand.nextGaussian() * 0.5F;
                    this.level.addParticle(ParticleTypes.EXPLOSION, bp.getX(), bp.getY() + 1.0F, bp.getZ(), vx, vy, vz);
                }
                this.getLevel().explode(null, bp.getX(), bp.getY(), bp.getZ(), 0.1F, false, Explosion.BlockInteraction.DESTROY);
                int sz = 2;
                for(int i = -sz; i <= sz;i++){
                    for(int j = -sz; j <= sz; j++){
                        for(int k = -sz; k <= sz; k++){
                            BlockPos nbp = new BlockPos(bp2.getX() + i, bp2.getY() + j, bp2.getZ() + k);
                            this.level.destroyBlock(nbp, false);
                        }
                    }
                }

            }
            if(this.cool_down > 42){
                List<ZomboniEntity> plants = this.level.getEntitiesOfClass(ZomboniEntity.class, this.getBoundingBox().inflate(2));
                if(!plants.isEmpty()){
                    for(int i = 0; i < plants.size();i++){
                        ZomboniEntity z = plants.get(i);
                        z.kill();
                    }
                }
                this.kill();
            }
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



