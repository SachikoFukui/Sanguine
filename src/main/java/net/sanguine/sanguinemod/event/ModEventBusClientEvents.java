package net.sanguine.sanguinemod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.entity.client.KultystaModel;
import net.sanguine.sanguinemod.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = Sanguine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.KULTYSTA_LAYER, KultystaModel::createBodyLayer);
    }
}
