package net.sanguine.sanguinemod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Sanguine.MODID);

    public static final RegistryObject<BlockEntityType<InfernoEntity>> INFERNO =
            BLOCK_ENTITIES.register("inferno", () ->
                    BlockEntityType.Builder.of(InfernoEntity::new,
                            ModBlocks.INFERNO.get()).build(null));
//    public static final RegistryObject<BlockEntityType<InfernoEntity>> PIEC_CUSTOM =
//            BLOCK_ENTITIES.register("piec_custom", () ->
//                    BlockEntityType.Builder.of(InfernoEntity::new,
//                            ModBlocks.PIEC_CUSTOM.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
