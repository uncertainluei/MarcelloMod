package com.luisrandomness.marcellomod.client;

import com.luisrandomness.marcellomod.client.entity.MarcelloRenderer;
import com.luisrandomness.marcellomod.core.registry.MarcelloModEntityTypes;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientSetupEvent {
    public static void register() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetupEvent::onFMLClientSetupEvent);
    }

    public static void onFMLClientSetupEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(MarcelloModEntityTypes.MARCELLO.get(), MarcelloRenderer::new);
    }
}
