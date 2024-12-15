package net.sanguine.sanguinemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Sanguine.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
//                .add(ModBlocks.RUBIN_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHARRED_OBSIDIAN.get(),
                        ModBlocks.DEEPSLATE_RUBIN_ORE.get(),
                        ModBlocks.RUBIN_ORE.get(),
                        ModBlocks.RAW_RUBIN_BLOCK.get(),
                        ModBlocks.RUBIN_BLOCK.get(),
                        ModBlocks.INFERNO.get(),
                        ModBlocks.NETHERRACK_BRICKS.get(),
                        ModBlocks.BLEEDING_NETHERRACK_BRICKS.get(),
                        ModBlocks.CRACKED_NETHERRACK_BRICKS.get(),
                        ModBlocks.POLISHED_NETHERRACK.get(),
                        ModBlocks.BLEEDING_NETHERRACK.get(),
                        ModBlocks.CHARRED_NETHERRACK.get(),
                        ModBlocks.NETHERRACK_SLAB.get(),
                        ModBlocks.NETHERRACK_STAIRS.get(),
                        ModBlocks.CHARRED_NETHERRACK_SLAB.get(),
                        ModBlocks.CHARRED_NETHERRACK_STAIRS.get(),
                        ModBlocks.POLISHED_NETHERRACK_SLAB.get(),
                        ModBlocks.POLISHED_NETHERRACK_STAIRS.get(),
                        ModBlocks.NETHERRACK_BRICKS_SLAB.get(),
                        ModBlocks.NETHERRACK_BRICKS_STAIRS.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBIN_ORE.get(),
                        ModBlocks.CHARRED_NETHERRACK.get(),
                        ModBlocks.CRACKED_NETHERRACK_BRICKS.get(),
                        ModBlocks.POLISHED_NETHERRACK.get(),
                        ModBlocks.CRACKED_NETHERRACK_BRICKS.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CHARRED_NETHERRACK.get(),
                        ModBlocks.INFERNO.get());
        //
//        this.tag(ModTags.Blocks.NEEDS_RUBIN_TOOL)
//                .add(ModBlocks.CHARRED_OBSIDIAN.get());
//
//        this.tag(BlockTags.FENCES)
//                .add(ModBlocks.RUBIN_FENCE.get());
//        this.tag(BlockTags.FENCE_GATES)
//                .add(ModBlocks.RUBIN_FENCE_GATE.get());
//        this.tag(BlockTags.WALLS)
//                .add(ModBlocks.RUBIN_WALL.get());

    }
}
