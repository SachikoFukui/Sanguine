package net.sanguine.sanguinemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.item.ModItems;
import net.sanguine.sanguinemod.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Sanguine.MODID);
    }

    @Override
    protected void start() {
        add("hairlock_from_villagers", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/villager")).build(),
                LootItemRandomChanceCondition.randomChance(0.20f).build()}, ModItems.HAIRLOCK.get()));
        add("hairlock_from_ruined_portal", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build()}, ModItems.HAIRLOCK.get()));
    }
}
