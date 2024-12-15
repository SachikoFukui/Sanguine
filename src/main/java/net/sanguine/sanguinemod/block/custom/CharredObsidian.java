package net.sanguine.sanguinemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CharredObsidian extends Block {
    public CharredObsidian(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFireSource(BlockState state, LevelReader level, BlockPos pos, Direction direction) {
        return super.isFireSource(state, level, pos, direction);
    }
}
