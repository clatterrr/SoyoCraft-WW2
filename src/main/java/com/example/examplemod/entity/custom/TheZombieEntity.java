package com.example.examplemod.entity.custom;

import com.example.examplemod.item.ModItems;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TheZombieEntity extends Monster {

    public boolean kelped = false;

    public float towards = 0;

    public Vec3 delta_movement = new Vec3(0,0,0);
    protected TheZombieEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public void setTowards(float towards){
        this.yBodyRot = towards;
    }

    public boolean moveto = false;
    public Vec3 movetopos;

    public  boolean lookat = false;
    public Vec3 lookatpos;

    public float speed = 1.0f;

    public void moveTo2(Vec3 targetPos, float speed){
        this.movetopos = targetPos;
        this.moveto = true;
        this.speed = speed;
    }
    public void moveTo(Vec3 targetPos, Vec3 myPos, float t){
        double dx = (targetPos.x - myPos.x) / t;
        double dy = (targetPos.y - myPos.y) / t;
        double dz = (targetPos.z - myPos.z) / t;
        this.moveto = true;
        this.delta_movement = new Vec3(dx, dy,dz);
        this.movetopos = targetPos;
    }

    public void lookTo(Vec3 pos0){
        this.lookat = true;
        this.lookatpos = pos0;
    }

    double distance2(Vec3 pos0, Vec3 pos1){
        return (pos0.x - pos1.x) * (pos0.x - pos1.x) + (pos0.y - pos1.y) * (pos0.y - pos1.y) + (pos0.z - pos1.z) * (pos0.z - pos1.z);
    }

    @Override
    public void tick() {

        super.tick();
        if(this.lookat == true){
            this.lookAt(EntityAnchorArgument.Anchor.EYES, this.lookatpos);
        }

        if(this.moveto == true){
            //this.setDeltaMovement(this.delta_movement);
            this.getNavigation().moveTo(this.movetopos.x, this.movetopos.y, this.movetopos.z, this.speed);
            this.lookAt(EntityAnchorArgument.Anchor.EYES, this.movetopos);
            if(distance2(this.position(), this.movetopos) < 6d){
                this.moveto = false;
                this.setDeltaMovement(0,0,0);
            }
        }

    }
}
