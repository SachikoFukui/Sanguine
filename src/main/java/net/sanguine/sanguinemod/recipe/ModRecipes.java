package net.sanguine.sanguinemod.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Sanguine.MODID);

    public static final RegistryObject<RecipeSerializer<InfernoRecipe>> INFERNO_SERIALIZER =
            SERIALIZERS.register("inferno_smelt", ()-> InfernoRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
