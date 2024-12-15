package net.sanguine.sanguinemod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;

import java.util.List;

public class ModConfigureFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBIN_ORE_KEY = registerKey("rubin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DEEPSLATE_RUBIN_ORE_KEY = registerKey("deepslate_rubin_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BLEEDING_NETHERRACK_KEY = registerKey("bleeding_netherrack");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new TagMatchTest(BlockTags.NETHER_CARVER_REPLACEABLES);


        List<OreConfiguration.TargetBlockState> overworldRubinOres = List.of(OreConfiguration.target(stoneReplacables, ModBlocks.RUBIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.DEEPSLATE_RUBIN_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_RUBIN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubinOres, 7));

        List<OreConfiguration.TargetBlockState> netherBleedingNetherrack = List.of(OreConfiguration.target(netherrackReplacables, ModBlocks.BLEEDING_NETHERRACK.get().defaultBlockState()));
        register(context, NETHER_BLEEDING_NETHERRACK_KEY, Feature.ORE, new OreConfiguration(netherBleedingNetherrack, 20));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Sanguine.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
