package com.example.examplemod.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;

public class ConeEntity extends ItemEntity {

    private static final EntityDataAccessor<Boolean> HIT =
            SynchedEntityData.defineId(ConeEntity.class, EntityDataSerializers.BOOLEAN);
    public ConeEntity(EntityType<? extends ItemEntity> p_31991_, Level p_31992_) {
        super(p_31991_, p_31992_);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
