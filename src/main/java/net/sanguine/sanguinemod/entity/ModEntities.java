package net.sanguine.sanguinemod.entity;

import net.sanguine.sanguinemod.Sanguine;
import net.minecraft.world.entity.EntityType;
import net.sanguine.sanguinemod.entity.custom.KultystaEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Sanguine.MODID);

    public static final RegistryObject<EntityType<KultystaEntity>> KULTYSTA =
            ENTITY_TYPES.register("kultysta", () -> EntityType.Builder.of(KultystaEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).clientTrackingRange(8).build("kultysta"));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
