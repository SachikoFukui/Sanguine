package net.sanguine.sanguinemod.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation BLOOD_OVERLAY_RL = new ResourceLocation("misc/in_blood");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Sanguine.MODID);

    public static final RegistryObject<FluidType> BLOOD_FLUID_TYPE = register("blood_fluid",
            FluidType.Properties.create().lightLevel(4).density(5).viscosity(5).canSwim(false).canDrown(true).sound(SoundAction.get(""),
                    SoundEvents.HONEY_DRINK));


    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, BLOOD_OVERLAY_RL,
                0xA1A50F0F, new Vector3f(165f / 255f, 15f / 255f, 15f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}