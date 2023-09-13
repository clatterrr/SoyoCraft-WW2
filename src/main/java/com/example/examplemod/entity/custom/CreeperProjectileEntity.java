package com.example.examplemod.entity.custom;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.MagicProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class CreeperProjectileEntity extends Projectile {
	private static final EntityDataAccessor<Boolean> HIT =
			SynchedEntityData.defineId(CreeperProjectileEntity.class, EntityDataSerializers.BOOLEAN);
	private int counter = 0;

	public CreeperProjectileEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public CreeperProjectileEntity(Level pLevel, Player player) {
		super(ModEntityTypes.CREEPER_PROJECTILE.get(), pLevel);
		setOwner(player);
		BlockPos blockpos = player.blockPosition();
		double d0 = (double)blockpos.getX() + 0.5D;
		double d1 = (double)blockpos.getY() + 1.75D;
		double d2 = (double)blockpos.getZ() + 0.5D;
		this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
	}

	public CreeperProjectileEntity(Level pLevel, Entity entity, double yRot) {
		super(ModEntityTypes.CREEPER_PROJECTILE.get(), pLevel);
		setOwner(entity);
		double yR = yRot * (float)Math.PI / 180F;
		double bomb_offset = 6.0D;
		double d0 = entity.position().x - Math.sin(yR) * bomb_offset;
		double d1 = entity.position().y + 1.4D;
		double d2 = entity.position().z + Math.cos(yR) * bomb_offset;
		this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
	}

	@Override
	public void tick() {
		super.tick();
		if(this.entityData.get(HIT)) {
			if(this.tickCount >= counter) {
				this.discard();
			}
		}

		if (this.tickCount >= 300) {
			this.remove(RemovalReason.DISCARDED);
		}

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

        /*
        for(int i = 1; i < 5; ++i) {
            this.getLevel().addParticle(ModParticles.ALEXANDRITE_PARTICLES.get(), d0-(d5*2), d1-(d6*2), d2-(d7*2),
                    -d5, -d6 - 0.1D, -d7);
        }
        */

		if (this.getLevel().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.discard();
		} else if (this.isInWaterOrBubble()) {
			this.discard();
		} else {
			this.setDeltaMovement(vec3.scale(0.99F));
			this.setPos(d0, d1, d2);
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		Entity hitEntity = hitResult.getEntity();
		Entity owner = this.getOwner();

		if(hitEntity == owner && this.getLevel().isClientSide()) {
			return;
		}

        /*
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.NEUTRAL,
                2F, 1F);
        */

		LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
		float damage = 2f;
        /*
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingentity), damage);
        if (hurt) {
            if(hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1), owner);
            }
        }
        */
	}

	@Override
	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
        /*
        for(int x = 0; x < 18; ++x) {
            for(int y = 0; y < 18; ++y) {
                this.level().addParticle(ModParticles.ALEXANDRITE_PARTICLES.get(), this.getX(), this.getY(), this.getZ(),
                        Math.cos(x*20) * 0.15d, Math.cos(y*20) * 0.15d, Math.sin(x*20) * 0.15d);
            }
        }
        */

		if(this.getLevel().isClientSide()) {
			return;
		}

		if(hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
			Entity hit = entityHitResult.getEntity();
			Entity owner = this.getOwner();
			if(owner != hit) {
				this.entityData.set(HIT, true);
				counter = this.tickCount + 5;
			}
		} else {
			this.entityData.set(HIT, true);
			counter = this.tickCount + 5;
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