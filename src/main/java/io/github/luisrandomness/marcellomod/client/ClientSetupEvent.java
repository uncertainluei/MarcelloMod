package io.github.luisrandomness.marcellomod.client;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.client.entity.HumanoidNpcRenderer;
import io.github.luisrandomness.marcellomod.client.entity.VariedHumanoidNpcRenderer;
import io.github.luisrandomness.marcellomod.core.registry.MM_EntityTypes;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientSetupEvent {
    public static void register() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetupEvent::onFMLClientSetupEvent);
    }

    public static final ResourceLocation[] MARCELLO_ENTITY_TEXTURES = new ResourceLocation[]
            {
                    MarcelloMod.prefix("textures/entity/marcello/classic.png"),
                    MarcelloMod.prefix("textures/entity/marcello/glasses.png"),
                    MarcelloMod.prefix("textures/entity/marcello/redhair.png")
            };
    public static final ResourceLocation MOLDY_ENTITY_TEXTURE = MarcelloMod.prefix("textures/entity/moldy.png");

    public static void onFMLClientSetupEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(MM_EntityTypes.MARCELLO.get(), (EntityRendererManager context) -> new VariedHumanoidNpcRenderer(context, false, MARCELLO_ENTITY_TEXTURES, true));
        RenderingRegistry.registerEntityRenderingHandler(MM_EntityTypes.MOLDY.get(), (EntityRendererManager context) -> new HumanoidNpcRenderer(context,true,MOLDY_ENTITY_TEXTURE));
    }
}
