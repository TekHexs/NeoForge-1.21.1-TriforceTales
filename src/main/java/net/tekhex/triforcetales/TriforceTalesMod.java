package net.tekhex.triforcetales;

import net.tekhex.triforcetales.registry.ItemInit;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TriforceTalesMod.MOD_ID)
public class TriforceTalesMod
{
    public static final String MOD_ID = "triforcetales";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public TriforceTalesMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        NeoForge.EVENT_BUS.register(this);

        // Register item initializer
        ItemInit.register(modEventBus);

        // Register creative tabs
        TriforceTalesCreativeTab.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Triforce Tales mod initializing!");
    }

    // Add items to creative tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // You can still add items to vanilla tabs if you want
        // But no need since we now have our own tab

        // Alternatively, you can keep this if you want the rupees to appear in both tabs
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ItemInit.GREENRUPEE);
            event.accept(ItemInit.BLUERUPEE);
            event.accept(ItemInit.REDRUPEE);
            event.accept(ItemInit.PURPLERUPEE);
            event.accept(ItemInit.SILVERRUPEE);
            event.accept(ItemInit.GOLDENRUPEE);
            event.accept(ItemInit.RUPOOR);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Triforce Tales server components initializing");
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("Triforce Tales client setup complete");
        }
    }
}