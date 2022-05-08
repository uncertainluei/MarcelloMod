package me.luisrandomness.marcellomod;

import me.luisrandomness.marcellomod.core.entities.MarcelloEntity;
import me.luisrandomness.marcellomod.core.entities.MoldyEntity;
import me.luisrandomness.marcellomod.client.ClientSetupEvent;
import me.luisrandomness.marcellomod.core.events.BlockedEffectEvents;
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
    public static final String MOD_ID = "marcellomod";

    public static MarcelloMod INSTANCE;
    private static final Logger LOGGER = LogManager.getLogger();

    public MarcelloMod() {
        INSTANCE = this;

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //eventBus.addListener(this::setup);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientSetupEvent::register);

        this.registerEverything(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new BlockedEffectEvents());

        eventBus.addListener(this::setupAttributes);
    }

    private void registerEverything(IEventBus eventBus) {
        MM_Items.REGISTRY.register(eventBus);
        MM_Blocks.REGISTRY.register(eventBus);
        MM_EntityTypes.REGISTRY.register(eventBus);
        MM_Enchantments.REGISTRY.register(eventBus);
        MM_PotionEffects.REGISTRY.register(eventBus);
        MM_Paintings.REGISTRY.register(eventBus);
    }

    //private void setup(final FMLCommonSetupEvent event) {
    //}

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }

    private void setupAttributes(final EntityAttributeCreationEvent event) {
        event.put(MM_EntityTypes.MARCELLO.get(), MarcelloEntity.setAttributes().build());
        event.put(MM_EntityTypes.MOLDY.get(), MoldyEntity.setAttributes().build());
    }
}
