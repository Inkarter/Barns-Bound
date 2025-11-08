package net.inkarter.barnsbound.entity.client.cow;


import net.inkarter.barnsbound.entity.client.chicken.ChickenAnimations;
import net.inkarter.barnsbound.entity.custom.CowEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CowModel extends HierarchicalModel<CowEntity>
{

    private final ModelPart cow;
    private final ModelPart main_neck_1;
    private final ModelPart main_neck_2;
    private final ModelPart head;

    public CowModel(ModelPart root) {
        this.cow = root.getChild("cow");
        this.main_neck_1 = cow.getChild("body").getChild("body_front").getChild("neck").getChild("main_neck_1");
        this.main_neck_2 = cow.getChild("body").getChild("body_front").getChild("neck").getChild("main_neck_1").getChild("main_neck_2");
        this.head = cow.getChild("body").getChild("body_front").getChild("neck").getChild("main_neck_1").getChild("main_neck_2").getChild("head");

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition cow = partdefinition.addOrReplaceChild("cow", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -9.0F));

        PartDefinition body = cow.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(9.5F, -11.5F, -16.0F));

        PartDefinition body_front = body.addOrReplaceChild("body_front", CubeListBuilder.create(), PartPose.offset(-9.5F, -12.5F, 18.0F));

        PartDefinition main_body_front = body_front.addOrReplaceChild("main_body_front", CubeListBuilder.create().texOffs(92, 83).addBox(-5.0F, 11.6667F, -2.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-6.0F, 0.1667F, -8.5F, 12.0F, 10.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(78, 55).addBox(-6.0F, 10.1667F, -2.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1667F, 0.0F));

        PartDefinition right_front_leg = main_body_front.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(-5.0F, 8.1667F, -4.5F));

        PartDefinition right_front_leg_top = right_front_leg.addOrReplaceChild("right_front_leg_top", CubeListBuilder.create().texOffs(92, 67).addBox(-1.5F, -4.5F, -3.5F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(78, 42).addBox(-2.0F, -3.5F, -3.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(82, 115).addBox(-1.5F, -3.5F, 3.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_front_leg_mid = right_front_leg_top.addOrReplaceChild("right_front_leg_mid", CubeListBuilder.create().texOffs(24, 67).addBox(-2.5F, -1.5F, -2.5F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.01F))
                .texOffs(84, 97).addBox(-2.0F, 1.5F, -1.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, 0.0F));

        PartDefinition right_front_leg_bottom = right_front_leg_mid.addOrReplaceChild("right_front_leg_bottom", CubeListBuilder.create().texOffs(98, 111).addBox(-0.5F, -1.5F, 0.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.01F))
                .texOffs(114, 74).addBox(-0.5F, 2.0F, 0.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 6.0F, -1.0F));

        PartDefinition right_front_leg_hoof = right_front_leg_bottom.addOrReplaceChild("right_front_leg_hoof", CubeListBuilder.create().texOffs(124, 0).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 108).addBox(-1.5F, 0.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.001F))
                .texOffs(124, 2).addBox(-1.5F, 0.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(122, 123).addBox(-1.5F, 1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 117).addBox(-2.0F, 1.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.0F, 2.0F));

        PartDefinition left_front_leg = main_body_front.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(7.0F, 7.6667F, -4.5F));

        PartDefinition left_front_leg_top = left_front_leg.addOrReplaceChild("left_front_leg_top", CubeListBuilder.create().texOffs(22, 94).addBox(-2.5F, -4.5F, -3.5F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 81).addBox(-2.0F, -3.5F, -3.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(14, 116).addBox(-2.5F, -3.5F, 3.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.5F, 0.0F));

        PartDefinition left_front_leg_mid = left_front_leg_top.addOrReplaceChild("left_front_leg_mid", CubeListBuilder.create().texOffs(46, 81).addBox(-1.5F, -2.5F, -4.5F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.01F))
                .texOffs(98, 0).addBox(-1.0F, 0.5F, -3.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, 2.0F));

        PartDefinition left_front_leg_bottom = left_front_leg_mid.addOrReplaceChild("left_front_leg_bottom", CubeListBuilder.create().texOffs(110, 111).addBox(-0.5F, -1.5F, 0.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.01F))
                .texOffs(24, 116).addBox(-0.5F, 2.0F, 0.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -3.0F));

        PartDefinition left_front_leg_hoof = left_front_leg_bottom.addOrReplaceChild("left_front_leg_hoof", CubeListBuilder.create().texOffs(124, 4).addBox(-0.5F, 0.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 95).addBox(-0.5F, 0.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.001F))
                .texOffs(124, 6).addBox(-0.5F, 0.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(124, 30).addBox(-0.5F, 1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 118).addBox(-1.0F, 1.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 2.0F));

        PartDefinition neck = body_front.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, -8.0F));

        PartDefinition main_neck_1 = neck.addOrReplaceChild("main_neck_1", CubeListBuilder.create().texOffs(44, 47).addBox(-5.0F, -4.4545F, -4.7273F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(66, 75).addBox(-4.5F, -4.9545F, -4.2273F, 10.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(32, 108).addBox(3.5F, 3.5455F, -2.7273F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(74, 15).addBox(-3.0F, 5.5455F, -2.7273F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(78, 33).addBox(-2.5F, 6.5455F, -2.7273F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(64, 97).addBox(-1.5F, 7.5455F, -2.2273F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(106, 36).addBox(-1.0F, 8.5455F, -1.7273F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(52, 19).addBox(-2.5F, 3.0455F, -5.7273F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(114, 42).addBox(-1.5F, 6.0455F, -4.2273F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(44, 121).addBox(-1.0F, 7.0455F, -3.2273F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(112, 67).addBox(-3.5F, 3.5455F, -2.7273F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.5455F, 0.7273F));

        PartDefinition main_neck_2 = main_neck_1.addOrReplaceChild("main_neck_2", CubeListBuilder.create().texOffs(7, 0).addBox(-4.5F, -4.5F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 4).addBox(3.5F, -4.5F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 33).addBox(-4.5F, -4.5F, -5.0F, 9.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(66, 83).addBox(-4.5F, -5.5F, -4.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(98, 10).addBox(-4.5F, -6.0F, -4.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F))
                .texOffs(84, 24).addBox(-2.5F, 3.5F, -4.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(58, 113).addBox(-2.0F, 3.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(100, 42).addBox(-2.5F, -6.0F, -6.0F, 5.0F, 10.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.5F, 0.0455F, -2.7273F));

        PartDefinition head = main_neck_2.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -4.0F));

        PartDefinition main_head = head.addOrReplaceChild("main_head", CubeListBuilder.create().texOffs(0, 82).addBox(-3.5F, -5.5F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.001F))
                .texOffs(112, 54).addBox(-2.5F, -4.5F, -5.0F, 5.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 113).addBox(-2.5F, -3.5F, -6.0F, 5.0F, 7.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(0, 109).addBox(-2.5F, -2.0F, -7.5F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(114, 46).addBox(-2.5F, -1.0F, -8.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 89).addBox(-1.5F, -0.3125F, -10.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(120, 18).addBox(2.0F, -1.3125F, -7.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F))
                .texOffs(92, 115).addBox(2.0F, -2.8125F, -5.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(92, 120).addBox(-3.0F, -1.3125F, -7.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F))
                .texOffs(64, 122).addBox(-3.0F, -2.8125F, -5.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(120, 25).addBox(-2.0F, 0.0F, -9.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 94).addBox(-2.0F, 0.6875F, -10.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 101).addBox(-1.5F, 0.6875F, -11.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 121).addBox(-2.0F, 2.6875F, -10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(92, 86).addBox(-2.0F, 3.375F, -9.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(80, 122).addBox(-1.5F, 3.1875F, -10.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 124).addBox(-1.0F, 2.6875F, -11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(88, 122).addBox(1.0F, 2.6875F, -10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(78, 60).addBox(-2.5F, 3.5F, -8.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(24, 78).addBox(-2.5F, 3.25F, -6.5F, 5.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F))
                .texOffs(106, 31).addBox(-2.5F, 3.0F, -6.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.01F))
                .texOffs(102, 94).addBox(-2.5F, 3.5F, -3.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F))
                .texOffs(42, 97).addBox(1.0F, 0.6875F, -10.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(52, 124).addBox(2.5F, -2.5F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 52).addBox(1.0F, -2.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 121).addBox(0.5F, -1.5F, -1.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(122, 36).addBox(-2.5F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.001F))
                .texOffs(34, 123).addBox(-0.5F, -0.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 123).addBox(2.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(118, 100).addBox(-2.0F, -0.5F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(124, 54).addBox(3.0F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.0F, -1.0F));

        PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(124, 52).addBox(-4.5F, -2.5F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(122, 38).addBox(-5.0F, -2.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(122, 40).addBox(-4.5F, -1.5F, -1.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 122).addBox(-1.5F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.001F))
                .texOffs(70, 123).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(100, 120).addBox(-3.0F, -0.5F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(124, 56).addBox(-3.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.001F))
                .texOffs(58, 124).addBox(-4.0F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -5.0F, -1.0F));

        PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(9.5F, 8.0F, -3.0F));

        PartDefinition right_eye = eyes.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(124, 60).addBox(-12.5F, -11.8125F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_eye = eyes.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(124, 58).addBox(-7.5F, -11.8125F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_mid = body.addOrReplaceChild("body_mid", CubeListBuilder.create().texOffs(48, 25).addBox(-5.0F, 6.0F, -3.5F, 11.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.5F, -7.0F, -7.0F, 14.0F, 13.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(84, 88).addBox(7.0F, -5.0F, -5.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(52, 0).addBox(7.5F, -4.0F, -6.0F, 1.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(44, 62).addBox(-7.5F, -4.0F, -6.0F, 1.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(46, 92).addBox(-7.0F, -5.0F, -5.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -6.0F, 25.0F));

        PartDefinition body_back = body.addOrReplaceChild("body_back", CubeListBuilder.create(), PartPose.offset(-9.5F, 3.5F, 35.5F));

        PartDefinition main_body_back = body_back.addOrReplaceChild("main_body_back", CubeListBuilder.create().texOffs(0, 47).addBox(-6.0F, -16.0F, -8.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 121).addBox(2.5F, -6.5F, -6.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(112, 120).addBox(-4.5F, -6.5F, -6.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(112, 63).addBox(-2.5F, -16.5F, -3.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_back_leg = body_back.addOrReplaceChild("right_back_leg", CubeListBuilder.create(), PartPose.offset(-5.0F, -10.0F, -5.0F));

        PartDefinition right_back_leg_butt = right_back_leg.addOrReplaceChild("right_back_leg_butt", CubeListBuilder.create().texOffs(102, 86).addBox(-1.5F, -7.0F, 0.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F))
                .texOffs(56, 104).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 0.0F, 4.0F));

        PartDefinition right_back_leg_top = right_back_leg_butt.addOrReplaceChild("right_back_leg_top", CubeListBuilder.create().texOffs(92, 60).addBox(-1.5F, -5.0F, -2.5F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.001F))
                .texOffs(0, 67).addBox(-2.0F, -4.0F, -3.5F, 5.0F, 8.0F, 7.0F, new CubeDeformation(0.01F))
                .texOffs(34, 116).addBox(-1.5F, -3.0F, -4.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_back_leg_mid = right_back_leg_top.addOrReplaceChild("right_back_leg_mid", CubeListBuilder.create().texOffs(66, 88).addBox(-2.5F, 0.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 101).addBox(-2.5F, 4.0F, -4.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(100, 97).addBox(-2.5F, 6.0F, -3.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, 3.0F));

        PartDefinition right_back_leg_bottom = right_back_leg_mid.addOrReplaceChild("right_back_leg_bottom", CubeListBuilder.create().texOffs(84, 107).addBox(-1.0F, -2.0F, -4.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F))
                .texOffs(72, 113).addBox(-0.5F, 2.0F, -3.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offset(-1.0F, 8.0F, 1.0F));

        PartDefinition right_back_leg_hoof = right_back_leg_bottom.addOrReplaceChild("right_back_leg_hoof", CubeListBuilder.create().texOffs(120, 8).addBox(-1.5F, 0.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.001F))
                .texOffs(100, 123).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 8).addBox(-1.5F, 1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 81).addBox(-2.0F, 1.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.01F))
                .texOffs(106, 123).addBox(-1.5F, 0.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.0F, -2.0F));

        PartDefinition left_back_leg = body_back.addOrReplaceChild("left_back_leg", CubeListBuilder.create(), PartPose.offset(4.0F, -10.0F, -1.0F));

        PartDefinition left_back_leg_butt = left_back_leg.addOrReplaceChild("left_back_leg_butt", CubeListBuilder.create().texOffs(104, 14).addBox(-1.5F, -7.0F, 0.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F))
                .texOffs(106, 22).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_back_leg_top = left_back_leg_butt.addOrReplaceChild("left_back_leg_top", CubeListBuilder.create().texOffs(0, 95).addBox(-1.5F, -5.0F, -2.5F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.001F))
                .texOffs(74, 0).addBox(-2.0F, -4.0F, -3.5F, 5.0F, 8.0F, 7.0F, new CubeDeformation(0.01F))
                .texOffs(116, 104).addBox(-1.5F, -3.0F, -4.5F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_back_leg_mid = left_back_leg_top.addOrReplaceChild("left_back_leg_mid", CubeListBuilder.create().texOffs(96, 74).addBox(-2.5F, -2.0F, -3.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(38, 101).addBox(-2.5F, 2.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-2.5F, 4.0F, -1.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.0F, 1.0F));

        PartDefinition left_back_leg_bottom = left_back_leg_mid.addOrReplaceChild("left_back_leg_bottom", CubeListBuilder.create().texOffs(18, 108).addBox(-1.0F, -2.0F, -4.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F))
                .texOffs(114, 0).addBox(-0.5F, 2.0F, -3.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offset(-1.0F, 6.0F, 3.0F));

        PartDefinition left_back_leg_hoof = left_back_leg_bottom.addOrReplaceChild("left_back_leg_hoof", CubeListBuilder.create().texOffs(120, 13).addBox(-0.5F, 0.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.001F))
                .texOffs(124, 32).addBox(-0.5F, 0.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(124, 34).addBox(-0.5F, 1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 85).addBox(-1.0F, 1.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.01F))
                .texOffs(40, 124).addBox(-0.5F, 0.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -2.0F));

        PartDefinition udder = body_back.addOrReplaceChild("udder", CubeListBuilder.create().texOffs(108, 54).addBox(1.0F, -1.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(125, 67).addBox(-3.0F, -7.5F, -7.5F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(108, 56).addBox(-2.0F, -1.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 109).addBox(-2.0F, -1.5F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 58).addBox(1.0F, -1.5F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail = body_back.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail_1 = tail.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(38, 78).addBox(-0.5F, -17.0F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail_2 = tail_1.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(122, 120).addBox(-0.5F, -17.0F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail_3 = tail_2.addOrReplaceChild("tail_3", CubeListBuilder.create(), PartPose.offset(0.0F, -17.0F, 2.5F));

        PartDefinition cube_r1 = tail_3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(122, 111).addBox(-0.5F, -0.6062F, -0.099F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2357F, -0.5316F, -1.2217F, 0.0F, 0.0F));

        PartDefinition tail_4 = tail_3.addOrReplaceChild("tail_4", CubeListBuilder.create(), PartPose.offset(0.0F, 1.8649F, 0.6914F));

        PartDefinition cube_r2 = tail_4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 123).addBox(-0.5F, -0.4568F, -0.4195F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5002F, -0.289F, -1.2217F, 0.0F, 0.0F));

        PartDefinition tail_5 = tail_4.addOrReplaceChild("tail_5", CubeListBuilder.create(), PartPose.offset(0.0F, 1.7536F, 0.6552F));

        PartDefinition cube_r3 = tail_5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(122, 114).addBox(-0.5F, -0.6885F, -0.1898F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2323F, -0.6614F, -1.3963F, 0.0F, 0.0F));

        PartDefinition tail_6 = tail_5.addOrReplaceChild("tail_6", CubeListBuilder.create(), PartPose.offset(0.0F, 1.875F, 0.3149F));

        PartDefinition cube_r4 = tail_6.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 123).addBox(-0.5F, -0.6885F, -0.1898F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3269F, -0.629F, -1.3963F, 0.0F, 0.0F));

        PartDefinition tail_7 = tail_6.addOrReplaceChild("tail_7", CubeListBuilder.create(), PartPose.offset(0.0F, 1.9934F, 0.3041F));

        PartDefinition cube_r5 = tail_7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(122, 117).addBox(-0.5F, -0.6885F, -0.1898F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3031F, -0.5857F, -1.3963F, 0.0F, 0.0F));

        PartDefinition tail_8 = tail_7.addOrReplaceChild("tail_8", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0147F, 0.4607F));

        PartDefinition cube_r6 = tail_8.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 123).addBox(-0.5F, -0.3989F, 0.013F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.008F, -0.4492F, -1.3963F, 0.0F, 0.0F));

        PartDefinition tail_9 = tail_8.addOrReplaceChild("tail_9", CubeListBuilder.create(), PartPose.offset(0.0F, 1.9334F, 0.275F));

        PartDefinition cube_r7 = tail_9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(28, 123).addBox(-0.5F, -0.1527F, -0.0304F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0441F, -0.1269F, -1.3963F, 0.0F, 0.0F));

        PartDefinition tail_end = tail_9.addOrReplaceChild("tail_end", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3505F, -5.2391F));

        PartDefinition cube_r8 = tail_end.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(1, 1).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0761F, 3.9813F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r9 = tail_end.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(100, 104).addBox(-1.0F, -0.5726F, 0.0282F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, -4.3063F, 4.8622F, -1.3963F, 0.0F, 0.0F));

        PartDefinition cube_r10 = tail_end.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(70, 104).addBox(-0.5F, -1.5877F, -0.1454F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.1327F, 4.8774F, -1.3963F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(CowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);//to reset animation and not to add
        this.applyHeadRotation(netHeadYaw, headPitch);
        this.animateWalk(CowAnimations.Walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        //this.animate(entity.idleAnimationState, ChickenAnimations.sitting, ageInTicks, 1f);

    }

    private void applyHeadRotation(float headYaw, float headPitch){
        headYaw = Mth.clamp(headYaw, -10f, 10f);
        headPitch = Mth.clamp(headPitch, -5f, 25f);
        this.main_neck_1.yRot = headYaw * ((float) Math.PI / 180f);
        this.main_neck_1.xRot = headPitch * ((float) Math.PI / 180f);
        this.main_neck_2.yRot = headYaw * ((float) Math.PI / 180f);
        this.main_neck_2.xRot = headPitch * ((float) Math.PI / 180f);
        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);

    }//restrict the angle (degrees) that the neck/head can rotate in
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color ) {
        cow.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
    @Override
    public ModelPart root()
    {
        return cow ;
    }
    
}
