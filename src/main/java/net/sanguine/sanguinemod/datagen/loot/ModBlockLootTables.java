package net.sanguine.sanguinemod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RUBIN_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_RUBIN_BLOCK.get());
        this.dropSelf(ModBlocks.CHARRED_OBSIDIAN.get());

        this.dropSelf(ModBlocks.INFERNO.get());

        this.dropSelf(ModBlocks.CHARRED_NETHERRACK.get());
        this.dropSelf(ModBlocks.NETHERRACK_BRICKS.get());
        this.dropSelf(ModBlocks.POLISHED_NETHERRACK.get());
        this.dropSelf(ModBlocks.BLEEDING_NETHERRACK_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_NETHERRACK_BRICKS.get());

        this.dropSelf(ModBlocks.NETHERRACK_SLAB.get());
        this.dropSelf(ModBlocks.NETHERRACK_STAIRS.get());
        this.dropSelf(ModBlocks.CHARRED_NETHERRACK_SLAB.get());
        this.dropSelf(ModBlocks.CHARRED_NETHERRACK_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_NETHERRACK_SLAB.get());
        this.dropSelf(ModBlocks.POLISHED_NETHERRACK_STAIRS.get());
        this.dropSelf(ModBlocks.NETHERRACK_BRICKS_SLAB.get());
        this.dropSelf(ModBlocks.NETHERRACK_BRICKS_STAIRS.get());


        this.add(ModBlocks.BLEEDING_NETHERRACK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.BLEEDING_NETHERRACK.get(), ModItems.SOUL.get()));
        this.add(ModBlocks.RUBIN_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.RUBIN_ORE.get(), ModItems.RAW_RUBIN.get()));
        this.add(ModBlocks.DEEPSLATE_RUBIN_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_RUBIN_ORE.get(), ModItems.RAW_RUBIN.get()));

//        this.dropSelf(ModBlocks.RUBIN_STAIRS.get());
//        this.dropSelf(ModBlocks.RUBIN_BUTTON.get());
//        this.dropSelf(ModBlocks.RUBIN_PRESSURE_PLATE.get());
//        this.dropSelf(ModBlocks.RUBIN_TRAPDOOR.get());
//        this.dropSelf(ModBlocks.RUBIN_FENCE.get());
//        this.dropSelf(ModBlocks.RUBIN_FENCE_GATE.get());
//        this.dropSelf(ModBlocks.RUBIN_WALL.get());

//        this.add(ModBlocks.RUBIN_SLAB.get(),
//                block -> createSlabItemTable(ModBlocks.RUBIN_SLAB.get()));
//        this.add(ModBlocks.RUBIN_DOOR.get(),
//                block -> createDoorTable(ModBlocks.RUBIN_DOOR.get()));
    }
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
