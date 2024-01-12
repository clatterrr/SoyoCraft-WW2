package com.example.examplemod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;

public class ThePlantEntity extends Monster {

    protected ThePlantEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
        this.setNoGravity(true);
        this.setBoundingBox(AABB.of(BoundingBox.infinite()));
    }
}
