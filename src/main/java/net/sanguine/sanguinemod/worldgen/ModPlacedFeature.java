package net.sanguine.sanguinemod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.sanguine.sanguinemod.Sanguine;

import java.util.List;

public class ModPlacedFeature {
    public static final ResourceKey<PlacedFeature> RUBIN_ORE_PLACED_KEY = registerKey("rubin_ore_placed");

    public static final ResourceKey<PlacedFeature> BLEEDING_NETHERRACK_PLACED_KEY = registerKey("bleeding_netherrack_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, RUBIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigureFeature.OVERWORLD_RUBIN_ORE_KEY),
        ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(50))));

        register(context, BLEEDING_NETHERRACK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigureFeature.NETHER_BLEEDING_NETHERRACK_KEY),
        ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(0),VerticalAnchor.absolute(30))));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Sanguine.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
