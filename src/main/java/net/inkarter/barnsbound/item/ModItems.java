package net.inkarter.barnsbound.item;

import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.entity.ModEntities;
import net.inkarter.barnsbound.item.custom.ChainsawItem;
import net.inkarter.barnsbound.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BarnsBoundMod.MOD_ID);


    public static final DeferredItem<Item> SMALL_EGG = ITEMS.registerSimpleItem("small_egg");
    public static final DeferredItem<Item> MEDIUM_EGG = ITEMS.registerSimpleItem("medium_egg");
    public static final DeferredItem<Item> LARGE_EGG = ITEMS.registerSimpleItem("large_egg");


    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAISAW =
            ITEMS.registerItem("chainsaw", ChainsawItem::new, new Item.Properties().durability(32));
    //another way how to do tooltips inh Tomato
    public static final DeferredItem<Item> TOMATO =
            ITEMS.registerItem("tomato", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.barnsbound.tomato.1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.TOMATO));

    public static final DeferredItem<Item> FROSTFIRE_ICE =
            ITEMS.registerItem("frostfire_ice", properties -> new FuelItem(properties, 800), new Item.Properties().food(ModFoodProperties.TOMATO));

    public static final DeferredItem<Item> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.PENGUIN, 0xdebd47, 0xccbfbe, //hex colors
                    new Item.Properties()));
    public static final DeferredItem<Item> WHITE_CHICKEN_SPAWN_EGG = ITEMS.register("white_chicken_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.CHICKEN_WHITE,0xffffff ,0xff0000 ,  //hex colors
                    new Item.Properties()));
    public static final DeferredItem<Item> WHITE_ROOSTER_SPAWN_EGG = ITEMS.register("white_rooster_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.CHICKEN_WHITE,0xffffff ,0xff0000 ,  //hex colors
                    new Item.Properties()));
    public static final DeferredItem<Item> WHITE_CHICK_SPAWN_EGG = ITEMS.register("white_chick_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.CHICKEN_WHITE,0xffffff ,0xff0000 ,  //hex colors
                    new Item.Properties()));
    public static final DeferredItem<Item> COW_DAIRY_BLACK_SPAWN_EGG = ITEMS.register("cow_dairy_black_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.COW_DAIRY_BLACK,0xffffff ,0x000000 ,  //hex colors
                    new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }




}
