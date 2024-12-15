package net.inkarter.barnsbound.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.inkarter.barnsbound.entity.custom.ChickenEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ChickenModel extends HierarchicalModel<ChickenEntity>
{


    private final ModelPart chicken;

    private final ModelPart neck;

    public ChickenModel(ModelPart root) {
        this.chicken = root.getChild("chicken");
        this.neck = chicken.getChild("body").getChild("neck");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition chicken = partdefinition.addOrReplaceChild("chicken", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.875F));

        PartDefinition body = chicken.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition main_body = body.addOrReplaceChild("main_body", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, 2.55F, -2.625F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -2.25F, -4.125F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.75F, -0.875F, -0.0873F, 0.0F, 0.0F));

        PartDefinition main_body_1 = main_body.addOrReplaceChild("main_body_1", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.75F, 1.375F));

        PartDefinition main_body_2 = main_body.addOrReplaceChild("main_body_2", CubeListBuilder.create().texOffs(25, 26).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.25F, -2.125F));

        PartDefinition boby_cube1 = main_body.addOrReplaceChild("boby_cube1", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.06F))
                .texOffs(32, 0).addBox(-5.0F, -2.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.06F)), PartPose.offset(2.0F, 4.65F, -1.125F));

        PartDefinition left_wing = main_body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.1667F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.001F))
                .texOffs(31, 20).addBox(-0.5F, 0.3333F, 1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(6, 38).addBox(-0.5F, 0.8333F, 4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(3.5F, -1.5833F, -2.125F, -0.0873F, 0.0F, -0.2618F));

        PartDefinition right_wing = main_body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -0.1667F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.001F)).mirror(false)
                .texOffs(31, 20).mirror().addBox(-0.5F, 0.3333F, 1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(6, 38).mirror().addBox(-0.5F, 0.8333F, 4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -1.5833F, -2.125F, -0.0873F, 0.0F, 0.2618F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition top_tail = tail.addOrReplaceChild("top_tail", CubeListBuilder.create().texOffs(22, 26).addBox(-1.8F, 1.8F, 1.2F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.8F, -3.6264F, -0.1848F));

        PartDefinition tail_4 = top_tail.addOrReplaceChild("tail_4", CubeListBuilder.create(), PartPose.offset(-0.8F, 2.0586F, 1.3678F));

        PartDefinition cube_r1 = tail_4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -5.3302F, 0.1449F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0414F, 0.1322F, -0.1745F, 0.0F, 0.0F));

        PartDefinition tail_3 = top_tail.addOrReplaceChild("tail_3", CubeListBuilder.create(), PartPose.offset(-0.3F, 2.3405F, 1.4704F));

        PartDefinition cube_r2 = tail_3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 32).addBox(-1.5F, -4.9128F, -0.9962F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5405F, 0.2296F, -0.0873F, 0.0F, 0.0F));

        PartDefinition tail_2 = top_tail.addOrReplaceChild("tail_2", CubeListBuilder.create(), PartPose.offset(-0.9F, 0.3074F, 0.624F));

        PartDefinition cube_r3 = tail_2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(19, 37).addBox(-1.0F, -4.0436F, -0.999F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.0074F, 0.076F, 0.0436F, 0.0F, 0.0F));

        PartDefinition tail_1 = top_tail.addOrReplaceChild("tail_1", CubeListBuilder.create(), PartPose.offset(-0.8F, 0.4359F, -1.0062F));

        PartDefinition cube_r4 = tail_1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 32).addBox(-1.5F, -5.1305F, -0.9914F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1654F, 0.7984F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bottom_tail = tail.addOrReplaceChild("bottom_tail", CubeListBuilder.create().texOffs(11, 26).addBox(-2.0F, -3.95F, 0.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 6).addBox(-1.5F, -0.45F, 0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1236F, -1.4848F));

        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -7.4286F, -3.0286F));

        PartDefinition main_neck = neck.addOrReplaceChild("main_neck", CubeListBuilder.create().texOffs(31, 38).addBox(-1.0F, -3.5F, -3.75F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(11, 33).addBox(-1.5F, -5.0F, -3.25F, 3.0F, 5.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(17, 17).addBox(-2.0F, -6.0F, -2.75F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 10).addBox(-1.5F, -0.1875F, -2.75F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 38).addBox(1.5F, -5.0F, -1.75F, 1.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F))
                .texOffs(37, 24).addBox(-2.5F, -5.0F, -1.75F, 1.0F, 3.0F, 2.0F, new CubeDeformation(-0.001F))
                .texOffs(28, 17).addBox(-2.0F, -7.0F, -2.25F, 4.0F, 1.0F, 2.0F, new CubeDeformation(-0.001F))
                .texOffs(9, 20).addBox(-1.0F, -8.0F, -2.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, -0.0714F, -0.2214F, -0.0873F, 0.0F, 0.0F));

        PartDefinition mid_neck = neck.addOrReplaceChild("mid_neck", CubeListBuilder.create(), PartPose.offset(0.0F, -0.0714F, -0.2214F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, -4.0667F, -4.1667F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.001F))
                .texOffs(0, 1).addBox(-0.4F, -1.5667F, -4.6667F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(0, 1).addBox(0.4F, -1.5667F, -4.6667F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, -4.5048F, -0.8048F));

        PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.5667F, -3.6667F));

        PartDefinition crest = head.addOrReplaceChild("crest", CubeListBuilder.create(), PartPose.offset(0.0F, -5.5667F, -2.6667F));

        PartDefinition cube_r5 = crest.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(14, 9).addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(14, 16).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(-0.5F, -1.3667F, -4.6667F));

        PartDefinition pre_pre_left_leg = body.addOrReplaceChild("pre_pre_left_leg", CubeListBuilder.create(), PartPose.offset(2.0F, -6.0F, 0.0F));

        PartDefinition main_left_leg = pre_pre_left_leg.addOrReplaceChild("main_left_leg", CubeListBuilder.create().texOffs(25, 8).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(25, 38).addBox(-1.0F, -0.5F, 2.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition pre_left_leg = pre_pre_left_leg.addOrReplaceChild("pre_left_leg", CubeListBuilder.create().texOffs(38, 19).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

        PartDefinition left_leg = pre_left_leg.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 1.2F, 0.0F));

        PartDefinition main_left_leg2 = left_leg.addOrReplaceChild("main_left_leg2", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 1.9F, 0.0F));

        PartDefinition left_leg_fingers = left_leg.addOrReplaceChild("left_leg_fingers", CubeListBuilder.create(), PartPose.offset(0.0F, 2.8F, 0.0F));

        PartDefinition left_left_finger = left_leg_fingers.addOrReplaceChild("left_left_finger", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition cube_r6 = left_left_finger.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 16).addBox(0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

        PartDefinition left_right_finger = left_leg_fingers.addOrReplaceChild("left_right_finger", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, 0.0F));

        PartDefinition cube_r7 = left_right_finger.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 16).addBox(0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

        PartDefinition left_back_finger = left_leg_fingers.addOrReplaceChild("left_back_finger", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition pre_pre_right_leg = body.addOrReplaceChild("pre_pre_right_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, -6.0F, 0.0F));

        PartDefinition main_right_leg = pre_pre_right_leg.addOrReplaceChild("main_right_leg", CubeListBuilder.create().texOffs(25, 38).addBox(-1.0F, -0.4333F, 2.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(0, 20).addBox(-1.0F, -0.9333F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.0667F, 0.0F));

        PartDefinition pre_right_leg = pre_pre_right_leg.addOrReplaceChild("pre_right_leg", CubeListBuilder.create().texOffs(38, 15).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

        PartDefinition right_leg = pre_right_leg.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 1.2F, 0.0F));

        PartDefinition main_right_leg2 = right_leg.addOrReplaceChild("main_right_leg2", CubeListBuilder.create().texOffs(0, 20).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 1.9F, 0.0F));

        PartDefinition right_leg_fingers = right_leg.addOrReplaceChild("right_leg_fingers", CubeListBuilder.create(), PartPose.offset(0.0F, 2.8F, 0.0F));

        PartDefinition right_left_finger = right_leg_fingers.addOrReplaceChild("right_left_finger", CubeListBuilder.create().texOffs(3, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

        PartDefinition right_right_finger = right_leg_fingers.addOrReplaceChild("right_right_finger", CubeListBuilder.create().texOffs(3, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

        PartDefinition right_back_finger = right_leg_fingers.addOrReplaceChild("right_back_finger", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(ChickenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);//to reset animation and not to add
        this.applyHeadRotation(netHeadYaw, headPitch);
        this.animateWalk(ChickenAnimations.Walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        //this.animate(entity.idleAnimationState, ChickenAnimations.sitting, ageInTicks, 1f);

    }

    private void applyHeadRotation(float headYaw, float headPitch){
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25, 45);
        this.neck.yRot = headYaw * ((float) Math.PI / 180f);
        this.neck.xRot = headPitch * ((float) Math.PI / 180f);

    }//restrict the angle (degrees) that the neck/head can rotate in

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color ) {
        chicken.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root()
    {
        return chicken;
    }
}
