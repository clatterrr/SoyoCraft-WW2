package com.example.examplemod.entity.custom;

import com.example.examplemod.item.ModItems;
import net.minecraft.core.BlockPos;
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

public class ConeHeadZombieEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    private boolean drop = false;

    public ConeHeadZombieEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.20f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SummonGoal());
        this.goalSelector.addGoal(2, new StickGoal());
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WallNutEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PeaShooterEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ChomperEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.getHealth() >= 20){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cone_head_zombie.attack", true));
        }else if (this.getHealth() >= 15){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cone_head_zombie.attack2", true));
        }else if (this.getHealth() >= 10){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cone_head_zombie.attack3", true));
        }else if (this.getHealth() >= 5){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cone_head_zombie.attack4", true));
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
        super.tick();
        if(this.getHealth() <= 15 && this.drop == false){
            this.drop = true;
            this.spawnAtLocation(ModItems.CONE.get());
        }
    }

    @Override
    public void die(DamageSource p_21014_) {
        if(this.drop == false){
            this.drop = true;
            this.spawnAtLocation(ModItems.CONE.get());
        }
        super.die(p_21014_);
    }

    public class SummonGoal extends Goal {
        private final ConeHeadZombieEntity cactus;

        public SummonGoal() {
            cactus = ConeHeadZombieEntity.this;
            cactuspos = cactus.getOnPos();
        }

        private int cool_down = 0;
        private BlockPos cactuspos;

        @Override
        public boolean canUse() {

            BlockPos thepos = this.cactus.getOnPos();

            int search_radius = 3;
            for (int i = -search_radius; i <= search_radius; i++) {
                for (int j = -search_radius; j <= search_radius; j++) {
                    for (int k = 0; k <= 2; k++) {
                        BlockPos newpos = new BlockPos(thepos.getX() + i, thepos.getY() + k, thepos.getZ() + j);
                        Block bp = this.cactus.getLevel().getBlockState(newpos).getBlock();
                        if (bp == Blocks.CACTUS) {
                            this.cactuspos = newpos;
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public void tick() {
            this.cool_down += 1;
            if (this.cactuspos != this.cactus.getOnPos()) {
                if (this.cool_down > 5) {
                    this.cactus.getLevel().destroyBlock(this.cactuspos, false);
                    ConeHeadZombieEntity c = new ConeHeadZombieEntity((EntityType<? extends Monster>) this.cactus.getType(), this.cactus.getLevel());
                    c.setPos(this.cactuspos.getX(), this.cactuspos.getY(), this.cactuspos.getZ());
                    this.cactus.getLevel().addFreshEntity(c);
                }
            }
        }
    }

    public class StickGoal extends Goal {
        private final ConeHeadZombieEntity cactus;

        public StickGoal() {
            cactus = ConeHeadZombieEntity.this;
        }

        private int cool_down = 0;
        @Override
        public boolean canUse() {
            return this.cactus.getTarget() != null;
        }

        public void tick() {

           // this.cactus.getTarget().addEffect(new MobEffectInstance(MobEffects.POISON, 300,0));

        }
    }
}
