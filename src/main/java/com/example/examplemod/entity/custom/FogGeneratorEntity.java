package com.example.examplemod.entity.custom;

import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.entity.custom.FogPlant.BloverEntity;
import com.example.examplemod.entity.custom.FogPlant.PlanternEntity;
import com.example.examplemod.entity.custom.PoolZombie.ZomboniEntity;
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

import java.util.List;
import java.util.Random;

public class FogGeneratorEntity extends TheZombieEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(FogGeneratorEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(FogGeneratorEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public FogGeneratorEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ThePlantEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fog_generator.idle", true));
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

    int cool_down = 0;
    public void tick() {
        super.tick();
        int  radius = 40;
        int inner_radius = 10;
        this.cool_down += 1;
        BlockPos  bp = new BlockPos(-200, 107, 700);
        for(int i = -radius;i <= radius; i++){
            for(int j = -radius; j < radius;j++){
                if(this.cool_down < 250){
                    if(this.cool_down % 5 == 0){
                        int c = this.cool_down / 5;
                        if ((i * i + j * j ) <= radius * radius) {
                            this.level.setBlock(new BlockPos(bp.getX() + i, bp.getY() + c, bp.getZ() + j), Blocks.AIR.defaultBlockState(), 3);
                           // this.level.setBlock(new BlockPos(bp.getX() + i, bp.getY() + c + 1, bp.getZ() + j), Blocks.AIR.defaultBlockState(), 3);

                        }
                        if ((i * i + j * j) <= inner_radius * inner_radius && (i * i + j * j) >= (inner_radius - 1) * (inner_radius - 1)) {
                            this.level.setBlock(new BlockPos(bp.getX() + i, bp.getY() + c, bp.getZ() + j), ModBlocks.POOL_BRICK_1.get().defaultBlockState(), 3);
                        }
                        for(int k = 1; k < radius;k++){
                            if ((i * i + j * j + k * k) <= radius * radius && (i * i + j * j + k * k) >= (radius - 1) * (radius - 1)) {
                                this.level.setBlock(new BlockPos(bp.getX() + i, bp.getY() + c + k, bp.getZ() + j), ModBlocks.POOL_BRICK_1.get().defaultBlockState(), 3);
                            }
                        }
                    }
                }

            }
        }
        /*
        for(int i = -radius;i <= radius; i++){
            for(int j = -radius; j < radius;j++){

                for(int k = 0; k < radius*2;k++){
                    if(k <= 50)
                    {
                        if ((i * i + j * j) < inner_radius * inner_radius ) {
                            world.setBlock(new BlockPos(bp.getX() + i, bp.getY() + k, bp.getZ() + j), ModBlocks.POOL_BRICK_1.get().defaultBlockState(), 3);
                        }
                    }else if((i * i + j * j + (k - radius)*(k - radius)) < radius * radius){
                        world.setBlock(new BlockPos(bp.getX() + i, bp.getY() + k, bp.getZ() + j), ModBlocks.POOL_BRICK_1.get().defaultBlockState(), 3);
                    }


                }
            }
        }
        */
        /*
        BlockPos bp = this.getOnPos();
        int scale = 1;
        this.cool_down -= 1;

        List<BloverEntity> blovers = this.level.getEntitiesOfClass(BloverEntity.class, this.getBoundingBox().inflate(20));
        if(!blovers.isEmpty()){
            this.cool_down = 100;
        }

        if(this.cool_down <= 0){
            this.cool_down = 4;

            List<PlanternEntity> planters = this.level.getEntitiesOfClass(PlanternEntity.class, this.getBoundingBox().inflate(8));
            for (int i = -4 * scale; i <= 4 * scale; i++) {
                for(int j = - 6 * scale; j < - 1 * scale; j++){
                    float tx = bp.getX()+i * (1.0f / scale);
                    float tz = bp.getZ()+j * (1.0f / scale);
                    Boolean could = true;
                    for(int k = 0; k < planters.size(); k ++){
                        PlanternEntity pla = planters.get(k);
                        if (Math.abs(tx - pla.getOnPos().getX()) <=2 && Math.abs(tz - pla.getOnPos().getZ()) <= 2){
                            could = false;
                        }
                    }
                    if(could){
                        this.level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,tx , bp.getY() + 1.5F, tz, 0,0,0);
                        this.level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,tx , bp.getY() + 2.0F, tz, 0,0,0);
                        this.level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,tx , bp.getY() + 2.5F, tz, 0,0,0);
                        this.level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,tx , bp.getY() + 3.0F, tz, 0,0,0);
                        this.level.addParticle(ParticleTypes.POOF,tx , bp.getY() + 2.0F, tz, 0,-0.04f,0);
                    }
                }
            }
        }
        */
        if(this.cool_down > 1000){
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
