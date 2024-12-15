package net.sanguine.sanguinemod.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.sanguine.sanguinemod.Sanguine;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(new ResourceLocation(Sanguine.MODID, "overworld"), 5));
        Regions.register(new ModNetherRegion(new ResourceLocation(Sanguine.MODID, "nether"), 5));
    }
}
