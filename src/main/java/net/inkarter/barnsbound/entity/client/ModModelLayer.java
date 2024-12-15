package net.inkarter.barnsbound.entity.client;

import net.inkarter.barnsbound.BarnsBoundMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayer {
    public static final ModelLayerLocation PENGUIN = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID, "penguin"), "main");
    public static final ModelLayerLocation CHICKEN_WHITE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID, "chicken_white"), "main"); //way to register a model
}
