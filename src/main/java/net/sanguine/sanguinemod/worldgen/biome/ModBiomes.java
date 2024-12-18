package net.sanguine.sanguinemod.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.entity.ModEntities;

public class ModBiomes {
    public static final ResourceKey<Biome> AGONY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Sanguine.MODID, "agony"));

    public static final ResourceKey<Biome> NIHIL = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Sanguine.MODID, "nihil"));

    public static final ResourceKey<Biome> SCARLET = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Sanguine.MODID, "scarlet"));

    public static void boostrap(BootstapContext<Biome> context){
        context.register(AGONY, agonyBiome(context));
        context.register(NIHIL, nihilBiome(context));
        context.register(SCARLET, scarletBiome(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
    public static void globalNetherGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addAncientDebris(builder);
        BiomeDefaultFeatures.addFossilDecoration(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
    }

    public static Biome agonyBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.KULTYSTA.get(), 100, 5, 10));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalOverworldGeneration(biomeBuilder);
//       BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
//        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
//        BiomeDefaultFeatures.addFerns(biomeBuilder);
//        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
//        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

//        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
//        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe7a2d1d)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x400c09)
                        .grassColorOverride(0x160606)
                        .foliageColorOverride(0xff0000)
                        .fogColor(0x9c7e7e)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)

                        .build())
                .build();
    }
    public static Biome nihilBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
       globalOverworldGeneration(biomeBuilder);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x00000)
                        .waterFogColor(0x00000)
                        .skyColor(0x00000)
                        .grassColorOverride(0x00000)
                        .foliageColorOverride(0x00000)
                        .fogColor(0x00000)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)

                        .build())
                .build();
    }
    public static Biome scarletBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.KULTYSTA.get(), 100, 5, 10));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalNetherGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe7a2d1d)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x400c09)
                        .grassColorOverride(0x160606)
                        .foliageColorOverride(0xff0000)
                        .fogColor(0x9c7e7e)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)

                        .build())
                .build();
    }


}
