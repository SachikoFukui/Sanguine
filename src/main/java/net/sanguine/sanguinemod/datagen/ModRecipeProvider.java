package net.sanguine.sanguinemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBIN_SMELTABLES = List.of(ModItems.SHAPED_RUBIN.get());
    private static final List<ItemLike> SHAPEDRUBIN_LIST = List.of(ModItems.RAW_RUBIN.get());



    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, RUBIN_SMELTABLES, RecipeCategory.MISC, ModItems.RUBIN.get(), 0.25f, 100, "rubin" );
        oreSmelting(pWriter, RUBIN_SMELTABLES, RecipeCategory.MISC, ModItems.RUBIN.get(), 0.25f, 200, "rubin" );


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBIN_BLOCK.get())
                .pattern("$$$")
                .pattern("$$$")
                .pattern("$$$")
                .define('$', ModItems.RUBIN.get())
               .unlockedBy(getHasName(ModItems.RUBIN.get()), has(ModBlocks.RUBIN_BLOCK.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBIN.get(), 9)
                .requires(ModBlocks.RUBIN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBIN_BLOCK.get()), has(ModBlocks.RUBIN_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERRACK_STAIRS.get())
                .pattern("$  ")
                .pattern("$$ ")
                .pattern("$$$")
                .define('$', Blocks.NETHERRACK)
               .unlockedBy(getHasName(Blocks.NETHERRACK), has(Blocks.NETHERRACK))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERRACK_SLAB.get())
                .pattern("$$$")
                .define('$', Blocks.NETHERRACK)
               .unlockedBy(getHasName(Blocks.NETHERRACK), has(Blocks.NETHERRACK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHARRED_NETHERRACK_STAIRS.get())
                .pattern("$  ")
                .pattern("$$ ")
                .pattern("$$$")
                .define('$', ModBlocks.CHARRED_NETHERRACK.get())
               .unlockedBy(getHasName(ModBlocks.CHARRED_NETHERRACK.get()), has(ModBlocks.CHARRED_NETHERRACK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHARRED_NETHERRACK_SLAB.get())
                .pattern("$$$")
                .define('$', ModBlocks.CHARRED_NETHERRACK.get())
               .unlockedBy(getHasName(ModBlocks.CHARRED_NETHERRACK.get()), has(ModBlocks.CHARRED_NETHERRACK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_NETHERRACK_STAIRS.get())
                .pattern("$  ")
                .pattern("$$ ")
                .pattern("$$$")
                .define('$', ModBlocks.POLISHED_NETHERRACK.get())
               .unlockedBy(getHasName(ModBlocks.POLISHED_NETHERRACK.get()), has(ModBlocks.POLISHED_NETHERRACK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_NETHERRACK_SLAB.get())
                .pattern("$$$")
                .define('$', ModBlocks.POLISHED_NETHERRACK.get())
               .unlockedBy(getHasName(ModBlocks.POLISHED_NETHERRACK.get()), has(ModBlocks.POLISHED_NETHERRACK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERRACK_BRICKS_STAIRS.get())
                .pattern("$  ")
                .pattern("$$ ")
                .pattern("$$$")
                .define('$', ModBlocks.NETHERRACK_BRICKS.get())
               .unlockedBy(getHasName(ModBlocks.NETHERRACK_BRICKS.get()), has(ModBlocks.NETHERRACK_BRICKS.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERRACK_BRICKS_SLAB.get())
                .pattern("$$$")
                .define('$', ModBlocks.NETHERRACK_BRICKS.get())
               .unlockedBy(getHasName(ModBlocks.NETHERRACK_BRICKS.get()), has(ModBlocks.NETHERRACK_BRICKS.get()))
                .save(pWriter);


    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Sanguine.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
