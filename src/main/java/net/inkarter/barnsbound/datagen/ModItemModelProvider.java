package net.inkarter.barnsbound.datagen;

import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.block.ModBlocks;
import net.inkarter.barnsbound.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper)
    {
        super(output, BarnsBoundMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(ModItems.SMALL_EGG.get());
        basicItem(ModItems.MEDIUM_EGG.get());
        basicItem(ModItems.LARGE_EGG.get());


        basicItem(ModItems.BLACK_OPAL.get());
        basicItem(ModItems.RAW_BLACK_OPAL.get());
        basicItem(ModItems.CHAISAW.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());

        buttonItem(ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_BLOCK);

        fenceItem(ModBlocks.BLACK_OPAL_FENCE, ModBlocks.BLACK_OPAL_BLOCK);
        wallItem(ModBlocks.BLACK_OPAL_WALL, ModBlocks.BLACK_OPAL_BLOCK);


        basicItem(ModBlocks.BLACK_OPAL_DOOR.asItem());

        basicItem(ModItems.WHITE_CHICKEN_SPAWN_EGG.get());
        basicItem(ModItems.WHITE_ROOSTER_SPAWN_EGG.get());
        basicItem(ModItems.WHITE_CHICK_SPAWN_EGG.get());
        basicItem(ModItems.COW_DAIRY_BLACK_SPAWN_EGG.get());

        withExistingParent(ModItems.PENGUIN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.COW_DAIRY_BLACK_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.WHITE_CHICKEN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));



    }
    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
    this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
            .texture("texture",  ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID,
                    "block/" + baseBlock.getId().getPath()));
}

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(BarnsBoundMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

}
