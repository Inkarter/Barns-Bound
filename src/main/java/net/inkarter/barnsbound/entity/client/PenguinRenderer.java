package net.inkarter.barnsbound.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.entity.custom.PenguinEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.level.block.CreateFluidSourceEvent;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel>
{
    public PenguinRenderer(EntityRendererProvider.Context context)
    {
        super(context, new PenguinModel(context.bakeLayer(ModModelLayer.PENGUIN)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity penguinEntity)
    {
        return ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID, "textures/entity/penguin/penguin.png");
    }

    @Override
    public void render(PenguinEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {

        if (entity.isBaby()){
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
