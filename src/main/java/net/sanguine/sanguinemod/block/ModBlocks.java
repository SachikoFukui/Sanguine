package net.sanguine.sanguinemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.custom.Inferno;
import net.sanguine.sanguinemod.block.custom.ModPortalBlock;
import net.sanguine.sanguinemod.fluid.ModFluids;
import net.sanguine.sanguinemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Sanguine.MODID);

    public static final RegistryObject<Block> INFERNO = registerBlock("inferno",
            () -> new Inferno(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));
    public static final RegistryObject<Block> MOD_PORTAL = registerBlock("mod_portal",
            () -> new ModPortalBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable().noOcclusion().noLootTable()));

    public static final RegistryObject<Block> CHARRED_OBSIDIAN = registerBlock("charred_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

    public static final RegistryObject<Block> RUBIN_ORE = registerBlock("rubin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_RUBIN_ORE = registerBlock("deepslate_rubin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final RegistryObject<Block> RUBIN_BLOCK = registerBlock("rubin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_RUBIN_BLOCK = registerBlock("raw_rubin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> CHARRED_NETHERRACK = registerBlock("charred_netherrack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));
    public static final RegistryObject<Block> POLISHED_NETHERRACK = registerBlock("polished_netherrack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)));
    public static final RegistryObject<Block> NETHERRACK_BRICKS = registerBlock("netherrack_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_NETHERRACK_BRICKS = registerBlock("cracked_netherrack_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)));
    public static final RegistryObject<Block> BLEEDING_NETHERRACK = registerBlock("bleeding_netherrack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)));
    public static final RegistryObject<Block> BLEEDING_NETHERRACK_BRICKS = registerBlock("bleeding_netherrack_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)));


     public static final RegistryObject<Block> NETHERRACK_SLAB = registerBlock("netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));
    public static final RegistryObject<Block> NETHERRACK_STAIRS = registerBlock("netherrack_stairs",
            () -> new StairBlock(Blocks.NETHERRACK::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));

    public static final RegistryObject<Block> CHARRED_NETHERRACK_SLAB = registerBlock("charred_netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));
    public static final RegistryObject<Block> CHARRED_NETHERRACK_STAIRS = registerBlock("charred_netherrack_stairs",
            () -> new StairBlock(() -> ModBlocks.CHARRED_NETHERRACK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));

    public static final RegistryObject<Block> POLISHED_NETHERRACK_SLAB = registerBlock("polished_netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));
    public static final RegistryObject<Block> POLISHED_NETHERRACK_STAIRS = registerBlock("polished_netherrack_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_NETHERRACK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));

    public static final RegistryObject<Block> NETHERRACK_BRICKS_SLAB = registerBlock("netherrack_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));
    public static final RegistryObject<Block> NETHERRACK_BRICKS_STAIRS = registerBlock("netherrack_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.NETHERRACK_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK).explosionResistance(6)));


    public static final RegistryObject<LiquidBlock> BLOOD_BLOCK = BLOCKS.register("blood_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BLOOD, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));




//    public static final RegistryObject<Block> PIEC_CUSTOM = registerBlock("piec_custom",
//            () -> new Inferno(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));



    private static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}