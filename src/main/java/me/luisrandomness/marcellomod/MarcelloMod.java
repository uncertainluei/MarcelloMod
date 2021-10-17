package me.luisrandomness.marcellomod;

import me.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import me.luisrandomness.marcellomod.core.entities.MoldyEntity;
import me.luisrandomness.marcellomod.client.ClientSetupEvent;
import me.luisrandomness.marcellomod.core.registry.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

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

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSetupEvent::register);

        MarcelloModItems.REGISTRY.register(eventBus);
        MarcelloModBlocks.REGISTRY.register(eventBus);
        MarcelloModEntityTypes.REGISTRY.register(eventBus);
        MarcelloModEnchantments.REGISTRY.register(eventBus);
        MarcelloModPaintings.REGISTRY.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::setupAttributes);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(ID, name.toLowerCase(Locale.ROOT));
    }

    private void setupAttributes(final EntityAttributeCreationEvent event) {
        event.put(MarcelloModEntityTypes.MARCELLO.get(), MarcelloEntity.setAttributes().build());
        event.put(MarcelloModEntityTypes.MOLDY.get(), MoldyEntity.setAttributes().build());
    }
}
