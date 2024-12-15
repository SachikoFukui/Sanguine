package net.sanguine.sanguinemod.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.worldgen.biome.ModBiomes;

public class ModSurfaceRules {

    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CHARRED_NETHERRACK = makeStateRule(ModBlocks.CHARRED_NETHERRACK.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AGONY),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CHARRED_NETHERRACK)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, CHARRED_NETHERRACK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, CHARRED_NETHERRACK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, CHARRED_NETHERRACK)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
