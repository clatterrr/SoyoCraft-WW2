package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
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

public class WallNutEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public WallNutEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, NormalZombieEntity.class, 6.0F));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.getHealth() >= 50){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wall_nut.idle", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wall_nut.idle2", true));
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
        //this.yBodyRot = 0;
        super.tick();
    }

    public class SummonGoal extends Goal {
        private final WallNutEntity cactus;

        public SummonGoal() {
            cactus = WallNutEntity.this;
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
                    WallNutEntity c = new WallNutEntity((EntityType<? extends Monster>) this.cactus.getType(), this.cactus.getLevel());
                    c.setPos(this.cactuspos.getX(), this.cactuspos.getY(), this.cactuspos.getZ());
                    this.cactus.getLevel().addFreshEntity(c);
                }
            }
        }
    }

    public class ShootGoal extends Goal {
        private final WallNutEntity shooter;

        public ShootGoal() {
            shooter = WallNutEntity.this;
        }

        private int cool_down = 0;
        @Override
        public boolean canUse() {
          // return true;
            return this.shooter.getTarget() != null;
        }

        public void tick() {
            //this.shooter.lookAt(this.shooter.getTarget(), 30f, 30f);
            //this.shooter.yBodyRot = 0;
            this.cool_down += 1;
            if(this.cool_down > 5) {
                //this.shooter.spawnAtLocation(ModItems.PEA_CROP.get());


                MagicProjectileEntity pea = new MagicProjectileEntity(this.shooter.getLevel(), this.shooter);
                pea.shootFromRotation(this.shooter, this.shooter.getXRot(), this.shooter.yBodyRot, 0.0F, 1.5F, 0.25F);
                shooter.getLevel().addFreshEntity(pea);

                this.cool_down = 0;


            }



        }
    }
}
