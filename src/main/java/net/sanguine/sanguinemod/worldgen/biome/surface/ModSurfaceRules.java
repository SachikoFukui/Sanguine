package net.sanguine.sanguinemod.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.fluid.ModFluidTypes;
import net.sanguine.sanguinemod.fluid.ModFluids;
import net.sanguine.sanguinemod.worldgen.biome.ModBiomes;

public class ModSurfaceRules {

    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CHARRED_NETHERRACK = makeStateRule(ModBlocks.CHARRED_NETHERRACK.get());
    private static final SurfaceRules.RuleSource VOID = makeStateRule(Blocks.VOID_AIR);
    private static final SurfaceRules.RuleSource BLOOD = makeStateRule(ModBlocks.BLOOD_BLOCK.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT
        );

        SurfaceRules.RuleSource agonySurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CHARRED_NETHERRACK),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, CHARRED_NETHERRACK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, CHARRED_NETHERRACK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, CHARRED_NETHERRACK),

                SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0,0), BLOOD)
        );

        SurfaceRules.RuleSource nihilSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.NIHIL), VOID)
        );

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AGONY), agonySurface),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.NIHIL), nihilSurface),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }


}
