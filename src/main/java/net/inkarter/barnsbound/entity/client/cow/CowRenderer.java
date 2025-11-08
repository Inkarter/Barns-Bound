package net.inkarter.barnsbound.entity.client.cow;

import com.mojang.blaze3d.vertex.PoseStack;
import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.entity.client.ModModelLayer;
import net.inkarter.barnsbound.entity.custom.CowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CowRenderer extends MobRenderer<CowEntity, CowModel>
{
    public CowRenderer(EntityRendererProvider.Context context)
    {
        super(context, new CowModel(context.bakeLayer(ModModelLayer.COW_DAIRY_BLACK)), 1.05f);
    }

    @Override
    public ResourceLocation getTextureLocation(CowEntity cowEntity)
    {
        return ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID, "textures/entity/cow/cow_dairy_black.png");
    }

    @Override
    public void render(CowEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {

        if (entity.isBaby()){
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}