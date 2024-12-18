package net.sanguine.sanguinemod.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModNetherRegion extends Region {

    public ModNetherRegion(ResourceLocation name, int weight) {
        super(name, RegionType.NETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedNetherOverworldBuilder -> {
            modifiedNetherOverworldBuilder.replaceBiome(Biomes.BADLANDS, ModBiomes.AGONY);
            modifiedNetherOverworldBuilder.replaceBiome(Biomes.BASALT_DELTAS, ModBiomes.SCARLET);
        });
    }
}
