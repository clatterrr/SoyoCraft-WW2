
package com.example.examplemod.entity.client.UpgradePlant;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.UpgradePlant.SpikeRockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpikeRockModel extends AnimatedGeoModel<SpikeRockEntity> {

    @Override
    public ResourceLocation getModelResource(SpikeRockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/spike_rock.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpikeRockEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/spike_rock.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpikeRockEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/spike_rock.animation.json");

    }
}

