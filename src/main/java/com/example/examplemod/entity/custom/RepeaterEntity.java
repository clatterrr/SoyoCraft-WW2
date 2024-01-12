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

import java.util.List;

public class RepeaterEntity extends ThePlantEntity implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(RepeaterEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(RepeaterEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public RepeaterEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
                .add(Attributes.MAX_HEALTH, 10.0f)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.07f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {


        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.repeater.idle", true));



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
    public void tick(){
        this.cool_down += 1;
        this.yBodyRot = 0;
        this.setDeltaMovement(0,0,0);
        super.tick();
        this.setDeltaMovement(0,0,0);
        BlockPos bp = this.getOnPos();
        List<LilyPadEntity> lily_pads = this.level.getEntitiesOfClass(LilyPadEntity.class, this.getBoundingBox().inflate(1));
        if(!lily_pads.isEmpty()){
            LilyPadEntity flag = lily_pads.get(0);
            this.setDeltaMovement(flag.getDeltaMovement());
        }
        Boolean find_zombie = false;
        List<TheZombieEntity> zombies = this.level.getEntitiesOfClass(TheZombieEntity.class, this.getBoundingBox().inflate(8));
        if(!zombies.isEmpty()){
            for(int i = 0; i < zombies.size();i++){
                TheZombieEntity z = zombies.get(i);
                if(z instanceof SnorkelZombieEntity s){
                    if(s.Style() == 0){
                        continue;
                    }
                }
                if(z.getOnPos().getZ() >= this.getOnPos().getZ() && z.getOnPos().getX() == this.getOnPos().getX()){
                    find_zombie = true;

                }
            }
        }
        if(find_zombie == true){
            if(this.cool_down > 20){
                this.cool_down = 0;
                PeaProjectileEntity pea = new PeaProjectileEntity(ModEntityTypes.PEA_PROJECTILE.get(), this.level);
                BlockPos bpq = this.getOnPos();
                pea.setPos(bpq.getX() + 0.3f, bpq.getY() + 1.8f, bpq.getZ() + 1.3f);
                this.getLevel().addFreshEntity(pea);

                PeaProjectileEntity pea2 = new PeaProjectileEntity(ModEntityTypes.PEA_PROJECTILE.get(), this.level);
                pea2.setPos(bpq.getX() + 0.3f, bpq.getY() + 1.8f, bpq.getZ() + 0.8f);
                this.getLevel().addFreshEntity(pea2);
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
