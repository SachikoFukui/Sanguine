package net.sanguine.sanguinemod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.entity.ModEntities;
import net.sanguine.sanguinemod.item.custom.ModFoods;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Sanguine.MODID);

    public static final RegistryObject<Item> RUBIN = ITEMS.register("rubin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBIN = ITEMS.register("raw_rubin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SHAPED_RUBIN = ITEMS.register("shaped_rubin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HAIRLOCK = ITEMS.register("hairlock",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL = ITEMS.register("soul",
            () -> new Item(new Item.Properties().food(ModFoods.SOUL)){
            @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.sanguinemod.soul.tooltip"));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            }
            );
    public static final RegistryObject<Item> AMALGAM = ITEMS.register("amalgam",
            () -> new Item(new Item.Properties().food(ModFoods.AMALGAM)){
            @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.sanguinemod.amalgam.tooltip"));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            }
            );


    public static final RegistryObject<Item> KULTYSTA_SPAWN_EGG = ITEMS.register("kultysta_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.KULTYSTA, 0x7600bc, 0x4c00b0, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
