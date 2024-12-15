package net.sanguine.sanguinemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.worldgen.ModBiomeModifiers;
import net.sanguine.sanguinemod.worldgen.ModConfigureFeature;
import net.sanguine.sanguinemod.worldgen.ModPlacedFeature;
import net.sanguine.sanguinemod.worldgen.biome.ModBiomes;
import net.sanguine.sanguinemod.worldgen.dimension.ModDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, ModConfigureFeature::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeature::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, ModBiomes::boostrap)
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem);




    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Sanguine.MODID));
    }
}
