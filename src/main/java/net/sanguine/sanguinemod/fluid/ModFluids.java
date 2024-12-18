package net.sanguine.sanguinemod.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Sanguine.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_BLOOD = FLUIDS.register("blood_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BLOOD = FLUIDS.register("flowing_blood_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BLOOD_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties BLOOD_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.BLOOD_FLUID_TYPE, SOURCE_BLOOD, FLOWING_BLOOD)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.BLOOD_BLOCK).bucket(ModItems.BLOOD_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
