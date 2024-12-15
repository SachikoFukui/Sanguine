package net.sanguine.sanguinemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;

public class ModBlockStateProvider  extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Sanguine.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(ModBlocks.RAW_RUBIN_BLOCK);
//        blockWithItem(ModBlocks.RUBIN_BLOCK);
//
        blockWithItem(ModBlocks.RUBIN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBIN_ORE);
        blockWithItem(ModBlocks.RUBIN_BLOCK);
        blockWithItem(ModBlocks.RAW_RUBIN_BLOCK);

        blockWithItem(ModBlocks.CHARRED_NETHERRACK);
        blockWithItem(ModBlocks.POLISHED_NETHERRACK);
        blockWithItem(ModBlocks.NETHERRACK_BRICKS);
        blockWithItem(ModBlocks.CRACKED_NETHERRACK_BRICKS);
        blockWithItem(ModBlocks.BLEEDING_NETHERRACK);
        blockWithItem(ModBlocks.BLEEDING_NETHERRACK_BRICKS);

        blockWithItem(ModBlocks.CHARRED_OBSIDIAN);
        blockWithItem(ModBlocks.MOD_PORTAL);

//        blockWithItem(ModBlocks.INFERNO);
//        blockWithItem(ModBlocks.SOUND_BLOCK);
        stairsBlock(((StairBlock) ModBlocks.NETHERRACK_STAIRS.get()), blockTexture(Blocks.NETHERRACK));
        slabBlock(((SlabBlock) ModBlocks.NETHERRACK_SLAB.get()), blockTexture(Blocks.NETHERRACK), blockTexture(Blocks.NETHERRACK));
        stairsBlock(((StairBlock) ModBlocks.CHARRED_NETHERRACK_STAIRS.get()), blockTexture(ModBlocks.CHARRED_NETHERRACK.get()));
        slabBlock(((SlabBlock) ModBlocks.CHARRED_NETHERRACK_SLAB.get()), blockTexture(ModBlocks.CHARRED_NETHERRACK.get()), blockTexture(ModBlocks.CHARRED_NETHERRACK.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_NETHERRACK_STAIRS.get()), blockTexture(ModBlocks.POLISHED_NETHERRACK.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_NETHERRACK_SLAB.get()), blockTexture(ModBlocks.POLISHED_NETHERRACK.get()), blockTexture(ModBlocks.POLISHED_NETHERRACK.get()));
        stairsBlock(((StairBlock) ModBlocks.NETHERRACK_BRICKS_STAIRS.get()), blockTexture(ModBlocks.NETHERRACK_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.NETHERRACK_BRICKS_SLAB.get()), blockTexture(ModBlocks.NETHERRACK_BRICKS.get()), blockTexture(ModBlocks.NETHERRACK_BRICKS.get()));
        //
//        buttonBlock(((ButtonBlock) ModBlocks.RUBIN_BUTTON.get()), blockTexture(ModBlocks.RUBIN_BLOCK.get()));
//        pressurePlateBlock(((PressurePlateBlock) ModBlocks.RUBIN_PRESSURE_PLATE.get()), blockTexture(ModBlocks.RUBIN_BLOCK.get()));
//
//        fenceBlock(((FenceBlock) ModBlocks.RUBIN_FENCE.get()), blockTexture(ModBlocks.RUBIN_BLOCK.get()));
//        fenceGateBlock(((FenceGateBlock) ModBlocks.RUBIN_FENCE_GATE.get()), blockTexture(ModBlocks.RUBIN_BLOCK.get()));
//        wallBlock(((WallBlock) ModBlocks.RUBIN_WALL.get()), blockTexture(ModBlocks.RUBIN_BLOCK.get()));
//
//        doorBlockWithRenderType(((DoorBlock) ModBlocks.RUBIN_DOOR.get()), modLoc("block/rubin_door_bottom"), modLoc("block/rubin_door_top"), "cutout");
//        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.RUBIN_TRAPDOOR.get()), modLoc("block/rubin_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
