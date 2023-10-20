package com.example.examplemod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class BucketModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart bone;

    public BucketModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 22.0F, -2.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(24, 27).addBox(-4.0F, -6.0F, -3.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main = bone2.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-5.0F, -5.0F, -4.0F, 7.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(24, 15).addBox(-4.0F, -11.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone3 = main.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -1.5F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 1.0F));

        PartDefinition handle = bone2.addOrReplaceChild("handle", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.0649F, 0.3082F, 0.1665F));

        PartDefinition head_r1 = handle.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(24, 12).addBox(-6.0F, 12.5F, -6.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 5.5F, -0.7854F, 0.0F, 0.0F));

        PartDefinition head_r2 = handle.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(30, 0).addBox(-6.0F, -6.5F, -12.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(5.0F, -6.5F, -12.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 5.5F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}