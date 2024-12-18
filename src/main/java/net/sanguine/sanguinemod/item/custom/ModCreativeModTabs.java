package net.sanguine.sanguinemod.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.item.ModItems;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Sanguine.MODID);

    public static final RegistryObject<CreativeModeTab> SANGUINE = CREATIVE_MODE_TABS.register("sanguines",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CHARRED_OBSIDIAN.get()))
                    .title(Component.translatable("creativetab.sanguines"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.HAIRLOCK.get());
                        pOutput.accept(ModItems.RAW_RUBIN.get());
                        pOutput.accept(ModItems.SHAPED_RUBIN.get());
                        pOutput.accept(ModItems.RUBIN.get());

                        pOutput.accept(ModBlocks.RUBIN_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBIN_ORE.get());
                        pOutput.accept(ModBlocks.RAW_RUBIN_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBIN_BLOCK.get());
                        pOutput.accept(ModBlocks.CHARRED_OBSIDIAN.get());

                        pOutput.accept(ModBlocks.CHARRED_NETHERRACK.get());
                        pOutput.accept(ModBlocks.POLISHED_NETHERRACK.get());
                        pOutput.accept(ModBlocks.NETHERRACK_BRICKS.get());
                        pOutput.accept(ModBlocks.CRACKED_NETHERRACK_BRICKS.get());
                        pOutput.accept(ModBlocks.BLEEDING_NETHERRACK.get());
                        pOutput.accept(ModBlocks.BLEEDING_NETHERRACK_BRICKS.get());

                        pOutput.accept(ModBlocks.NETHERRACK_SLAB.get());
                        pOutput.accept(ModBlocks.NETHERRACK_STAIRS.get());
                        pOutput.accept(ModBlocks.NETHERRACK_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocks.NETHERRACK_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocks.CHARRED_NETHERRACK_SLAB.get());
                        pOutput.accept(ModBlocks.CHARRED_NETHERRACK_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_NETHERRACK_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_NETHERRACK_STAIRS.get());

                        pOutput.accept(ModItems.SOUL.get());
                        pOutput.accept(ModItems.AMALGAM.get());

                        pOutput.accept(ModItems.BLOOD_BUCKET.get());

                        pOutput.accept(ModBlocks.INFERNO.get());
                        pOutput.accept(ModBlocks.MOD_PORTAL.get());

                        pOutput.accept(ModItems.KULTYSTA_SPAWN_EGG.get());



                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
