package net.inkarter.barnsbound.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.entity.custom.ChickenEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.level.block.CreateFluidSourceEvent;

public class ChickenRenderer extends MobRenderer<ChickenEntity, ChickenModel>
{
    public ChickenRenderer(EntityRendererProvider.Context context)
    {
        super(context, new ChickenModel(context.bakeLayer(ModModelLayer.CHICKEN_WHITE)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(ChickenEntity chickenEntity)
    {
        return ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID, "textures/entity/chicken_white/chicken_white.png");
    }

    @Override
    public void render(ChickenEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {

        if (entity.isBaby()){
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}