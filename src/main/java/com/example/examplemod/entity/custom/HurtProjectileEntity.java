package com.example.examplemod.entity.custom;

import com.example.examplemod.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class HurtProjectileEntity extends Projectile {
    private static final EntityDataAccessor<Boolean> HIT =
            SynchedEntityData.defineId(HurtProjectileEntity.class, EntityDataSerializers.BOOLEAN);
    private int counter = 0;

    public SporesProjectileEntity sp;

    public HurtProjectileEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public HurtProjectileEntity(Level pLevel, Entity player) {
        super(ModEntityTypes.HURT_PROJECTILE.get(), pLevel);
        setOwner(player);
        BlockPos blockpos = player.blockPosition();
        double d0 = (double)blockpos.getX() + 0.5D;
        double d1 = (double)blockpos.getY() + 0.5D;
        double d2 = (double)blockpos.getZ() + 0.5D;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
    }

    public HurtProjectileEntity(Level pLevel, Entity player, SporesProjectileEntity s) {
        super(ModEntityTypes.HURT_PROJECTILE.get(), pLevel);
        setOwner(player);
        BlockPos blockpos = player.blockPosition();
        double d0 = (double)blockpos.getX() + 0.5D;
        double d1 = (double)blockpos.getY() + 0.5D;
        double d2 = (double)blockpos.getZ() + 0.5D;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
        this.sp = s;
    }

    public HurtProjectileEntity(Level pLevel, Entity player, SporesProjectileEntity s, Vec3 offset) {
        super(ModEntityTypes.HURT_PROJECTILE.get(), pLevel);
        setOwner(player);
        BlockPos blockpos = player.blockPosition();
        double d0 = (double)blockpos.getX() + 0.5D + offset.x;
        double d1 = (double)blockpos.getY() + 0.5D + offset.y;
        double d2 = (double)blockpos.getZ() + 0.5D + offset.z;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
        this.sp = s;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.entityData.get(HIT)) {
            if(this.tickCount >= counter) {
                if(this.sp != null){

                    this.sp.discard();
                }
                this.discard();
            }
        }

        if (this.tickCount >= 300) {
            if(this.sp != null){

                this.sp.remove(RemovalReason.DISCARDED);
            }
            this.remove(RemovalReason.DISCARDED);
        }
        this.setDeltaMovement(0.0f, 0.0f, 0.2f);
        Vec3 vec3 = this.getDeltaMovement();
        HitResult hitresult = ProjectileUtil.getHitResult(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult))
            this.onHit(hitresult);

        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

        double d5 = vec3.x;
        double d6 = vec3.y;
        double d7 = vec3.z;


        this.setDeltaMovement(vec3.scale(0.99F));
        this.setPos(d0, d1, d2);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity hitEntity = hitResult.getEntity();
        Entity owner = this.getOwner();

        if(hitEntity == owner && this.level.isClientSide()) {
            return;
        }


        LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 3f;


        if(hitEntity instanceof TheZombieEntity livingHitEntity) {
            boolean hurt = hitEntity.hurt(DamageSource.CACTUS, damage);
            if (hurt) {
                livingHitEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1), owner);
            }
        }

    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if(this.level.isClientSide()) {
            return;
        }

        if(hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
            Entity hit = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            if(owner != hit) {
                if(hit instanceof TheZombieEntity zombie){
                    level.addParticle(ParticleTypes.BUBBLE, hit.getX(), hit.getY(), hit.getZ(), 0, 0, 0);
                    this.entityData.set(HIT, true);
                    hit.hurt(DamageSource.CACTUS, 3);
                    counter = this.tickCount + 50;
                }
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(HIT, false);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return (Packet<ClientGamePacketListener>) NetworkHooks.getEntitySpawningPacket(this);
    }
}
