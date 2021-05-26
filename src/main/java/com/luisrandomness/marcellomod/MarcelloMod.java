package com.luisrandomness.marcellomod;

import com.luisrandomness.marcellomod.core.registry.MarcelloModBlocks;
import com.luisrandomness.marcellomod.core.registry.MarcelloModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("marcellomod")
public class MarcelloMod
{
    public static final String ID = "marcellomod";
    public static final String NAME = "MarcelloMod";

    public static MarcelloMod INSTANCE;
    private static final Logger LOGGER = LogManager.getLogger();

    public MarcelloMod() {
        INSTANCE = this;

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        MarcelloModItems.REGISTRY.register(eventBus);
        MarcelloModBlocks.REGISTRY.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(ID, name.toLowerCase(Locale.ROOT));
    }
}
