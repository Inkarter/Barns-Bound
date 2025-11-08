package net.inkarter.barnsbound.event;

import net.inkarter.barnsbound.BarnsBoundMod;
import net.inkarter.barnsbound.entity.ModEntities;
import net.inkarter.barnsbound.entity.client.chicken.ChickenModel;
import net.inkarter.barnsbound.entity.client.cow.CowModel;
import net.inkarter.barnsbound.entity.client.ModModelLayer;
import net.inkarter.barnsbound.entity.client.PenguinModel;
import net.inkarter.barnsbound.entity.custom.ChickenEntity;
import net.inkarter.barnsbound.entity.custom.CowEntity;
import net.inkarter.barnsbound.entity.custom.PenguinEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = BarnsBoundMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayer.PENGUIN, PenguinModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayer.CHICKEN_WHITE, ChickenModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayer.COW_DAIRY_BLACK, CowModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.PENGUIN.get(), PenguinEntity.createAttributes().build());
        event.put(ModEntities.CHICKEN_WHITE.get(), ChickenEntity.createAttributes().build());
        event.put(ModEntities.COW_DAIRY_BLACK.get(), CowEntity.createAttributes().build());
    }
}
