package net.sanguine.sanguinemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
//     private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
//    static {
//        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
//        trimMaterials.put(TrimMaterials.IRON, 0.2F);
//        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
//        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
//        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
//        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
//        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
//        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
//        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
//        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
//    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Sanguine.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        simpleItem(ModItems.RAW_RUBIN);
        simpleItem(ModItems.SHAPED_RUBIN);
        simpleItem(ModItems.RUBIN);
        simpleItem(ModItems.HAIRLOCK);

        simpleItem(ModItems.SOUL);
        simpleItem(ModItems.AMALGAM);

        evenSimplerBlockItem(ModBlocks.INFERNO);

        evenSimplerBlockItem(ModBlocks.NETHERRACK_STAIRS);
        evenSimplerBlockItem(ModBlocks.NETHERRACK_SLAB);

        evenSimplerBlockItem(ModBlocks.CHARRED_NETHERRACK_STAIRS);
        evenSimplerBlockItem(ModBlocks.CHARRED_NETHERRACK_SLAB);

        evenSimplerBlockItem(ModBlocks.POLISHED_NETHERRACK_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_NETHERRACK_SLAB);

        evenSimplerBlockItem(ModBlocks.NETHERRACK_BRICKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.NETHERRACK_BRICKS_SLAB);

        simpleItem(ModItems.BLOOD_BUCKET);

//        simpleItem(ModItems.METAL_DETECTOR);
//        simpleItem(ModItems.GRAPE);
//
//        simpleBlockItem(ModBlocks.RUBIN_DOOR);
//
//        fenceItem(ModBlocks.RUBIN_FENCE, ModBlocks.RUBIN_BLOCK);
//        buttonItem(ModBlocks.RUBIN_BUTTON, ModBlocks.RUBIN_BLOCK);
//        wallItem(ModBlocks.RUBIN_WALL, ModBlocks.RUBIN_BLOCK);
//

//        evenSimplerBlockItem(ModBlocks.RUBIN_PRESSURE_PLATE);
//        evenSimplerBlockItem(ModBlocks.RUBIN_FENCE_GATE);
//
//        trapdoorItem(ModBlocks.RUBIN_TRAPDOOR);
//
//        handheldItem(ModItems.RUBIN_SWORD);
//        handheldItem(ModItems.RUBIN_AXE);
//        handheldItem(ModItems.RUBIN_PICKAXE);
//        handheldItem(ModItems.RUBIN_SHOVEL);
//        handheldItem(ModItems.RUBIN_HOE);
//
//        trimmedArmorItem(ModItems.CHARRED_HELMET);
//        trimmedArmorItem(ModItems.CHARRED_CHESTPLATE);
//        trimmedArmorItem(ModItems.CHARRED_LEGGINGS);
//        trimmedArmorItem(ModItems.CHARRED_BOOTS);
//
        withExistingParent(ModItems.KULTYSTA_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

//    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
//        final String MOD_ID = SachikoMod.MODID; // Change this to your mod id
//
//        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
//            trimMaterials.entrySet().forEach(entry -> {
//
//                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
//                float trimValue = entry.getValue();
//
//                String armorType = switch (armorItem.getEquipmentSlot()) {
//                    case HEAD -> "helmet";
//                    case CHEST -> "chestplate";
//                    case LEGS -> "leggings";
//                    case FEET -> "boots";
//                    default -> "";
//                };
//
//                String armorItemPath = "item/" + armorItem;
//                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
//                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
//                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
//                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
//                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);
//
//                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
//                // avoid an IllegalArgumentException
//                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");
//
//                // Trimmed armorItem files
//                getBuilder(currentTrimName)
//                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
//                        .texture("layer0", armorItemResLoc)
//                        .texture("layer1", trimResLoc);
//
//                // Non-trimmed armorItem file (normal variant)
//                this.withExistingParent(itemRegistryObject.getId().getPath(),
//                                mcLoc("item/generated"))
//                        .override()
//                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
//                        .predicate(mcLoc("trim_type"), trimValue).end()
//                        .texture("layer0",
//                                new ResourceLocation(MOD_ID,
//                                        "item/" + itemRegistryObject.getId().getPath()));
//            });
//        }
//    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Sanguine.MODID, "item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Sanguine.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Sanguine.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Sanguine.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Sanguine.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Sanguine.MODID,"item/" + item.getId().getPath()));
    }
     private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
         return withExistingParent(item.getId().getPath(),
                 new ResourceLocation("item/generated")).texture("layer0",
                 new ResourceLocation(Sanguine.MODID, "item/" + item.getId().getPath()));
     }
}
