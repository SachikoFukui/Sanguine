package net.sanguine.sanguinemod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.entity.ModEntities;
import net.sanguine.sanguinemod.entity.custom.KultystaEntity;

@Mod.EventBusSubscriber(modid = Sanguine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.KULTYSTA.get(), KultystaEntity.createAttributes().build());
    }
}
