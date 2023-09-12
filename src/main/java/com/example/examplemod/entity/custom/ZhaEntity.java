package com.example.examplemod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ZhaEntity extends Entity {
    private static final EntityDataAccessor<ItemStack> DATA_ITEM = SynchedEntityData.defineId(ZhaEntity.class, EntityDataSerializers.ITEM_STACK);

    private double xpos;
    private double ypos;
    private double zpos;
    public ZhaEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    public ZhaEntity(Level p_32001_, double p_32002_, double p_32003_, double p_32004_, ItemStack p_32005_) {
        this(p_32001_, p_32002_, p_32003_, p_32004_, p_32005_, p_32001_.random.nextDouble() * 0.2D - 0.1D, 0.2D, p_32001_.random.nextDouble() * 0.2D - 0.1D);
    }

    public ZhaEntity(Level p_149663_, double p_149664_, double p_149665_, double p_149666_, ItemStack p_149667_, double p_149668_, double p_149669_, double p_149670_) {
        this(EntityType.ITEM, p_149663_);
        this.setPos(p_149664_, p_149665_, p_149666_);
        this.setDeltaMovement(p_149668_, p_149669_, p_149670_);
        this.setItem(p_149667_);
        this.xpos = p_149664_;
        this.ypos = p_149665_;
        this.zpos = p_149666_;
    }

    @Override
    protected void defineSynchedData() {
        this.getEntityData().define(DATA_ITEM, ItemStack.EMPTY);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public void setItem(ItemStack p_32046_) {
        this.getEntityData().set(DATA_ITEM, p_32046_);
    }

    @Override
    public void tick(){
        this.setPos(xpos, ypos, zpos);
        this.teleportTo(xpos, ypos, zpos);
        this.moveTo(xpos, ypos, zpos);
        this.setRot(0, 0);
        super.tick();
    }

}
