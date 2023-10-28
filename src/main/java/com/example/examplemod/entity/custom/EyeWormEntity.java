package com.example.examplemod.entity.custom;

import com.example.examplemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class EyeWormEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public EyeWormEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.6f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        /*
        this.goalSelector.addGoal(1, new PotionGoal());
       this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Villager.class, 6.0F));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, WitherSkeleton.class, 6.0F));
       this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WitherSkeleton.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SnowArmEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, GrassGiantEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Husk.class, true));
        */
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.getHealth() < 10F) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.eye_worm.down", false));
        }else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.eye_worm.walk", true));
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
        this.yBodyRot = 0;
        super.tick();
    }

    public class PotionGoal extends Goal {
        private final EyeWormEntity me;

        public PotionGoal() {
            this.me = EyeWormEntity.this;
        }

        private int cool_down = 0;

        @Override
        public boolean canUse() {

            return this.me.getTarget() != null;
        }

        public void tick() {

            this.cool_down += 1;

            if (this.cool_down > 5) {
                    final Vec3 vTarget = this.me.getTarget().getDeltaMovement();
                    final double dX = this.me.getTarget().getX() + vTarget.x - getX();
                    final double dY = this.me.getTarget().getEyeY() - 1.1 - getY();
                    final double dZ = this.me.getTarget().getZ() + vTarget.z - getZ();
                    final double dH = Math.sqrt( dX * dX + dZ * dZ );

                    ItemStack potion = new ItemStack(Items.POTION, 1);
                    PotionUtils.setPotion( potion, Potions.HARMING );

                    ThrownPotion thrownPotion = new ThrownPotion(this.me.level, this.me);
                    thrownPotion.setItem(potion);
                    thrownPotion.shoot( dX, dY + (double) (dH * 0.2F), dZ, 0.75F, 1.0F  );

                    this.me.getLevel().addFreshEntity(thrownPotion);
                    this.me.getTarget().hurt(DamageSource.MAGIC, 2F);
                    this.cool_down = 0;



            }
        }
    }


}
