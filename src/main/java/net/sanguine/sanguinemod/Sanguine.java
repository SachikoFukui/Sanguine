package net.sanguine.sanguinemod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sanguine.sanguinemod.block.ModBlocks;
import net.sanguine.sanguinemod.block.entity.ModBlockEntities;
import net.sanguine.sanguinemod.entity.ModEntities;
import net.sanguine.sanguinemod.entity.client.KultystaRenderer;
import net.sanguine.sanguinemod.item.custom.ModCreativeModTabs;
import net.sanguine.sanguinemod.item.ModItems;
import net.sanguine.sanguinemod.loot.ModLootModifiers;
import net.sanguine.sanguinemod.recipe.ModRecipes;
import net.sanguine.sanguinemod.screen.InfernoScreen;
import net.sanguine.sanguinemod.screen.ModMenuTypes;
import net.sanguine.sanguinemod.worldgen.biome.ModTerrablender;
import net.sanguine.sanguinemod.worldgen.biome.surface.ModSurfaceRules;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Sanguine.MODID)
public class Sanguine {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "sanguinemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Sanguine() {
    // Konstruktor bezargumentowy - wymagany przez Forge.
    }
    public Sanguine(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ModLootModifiers.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModTerrablender.registerBiomes();

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());
        });

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_RUBIN);
            event.accept(ModItems.SHAPED_RUBIN);
            event.accept(ModItems.RUBIN);
            event.accept(ModItems.HAIRLOCK);

            event.accept(ModBlocks.CHARRED_OBSIDIAN);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.CHARRED_OBSIDIAN);
            event.accept(ModBlocks.NETHERRACK_BRICKS);
            event.accept(ModBlocks.POLISHED_NETHERRACK);
            event.accept(ModBlocks.BLEEDING_NETHERRACK_BRICKS);
            event.accept(ModBlocks.CRACKED_NETHERRACK_BRICKS);
            event.accept(ModBlocks.BLEEDING_NETHERRACK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            EntityRenderers.register(ModEntities.KULTYSTA.get(), KultystaRenderer::new);

            MenuScreens.register(ModMenuTypes.INFERNO_MENU.get(), InfernoScreen::new);
        }
    }
}
