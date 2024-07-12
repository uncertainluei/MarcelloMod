package io.github.luisrandomness.marcellomod.core;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.core.items.MM_SpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MarcelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnEggSetupEvent {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        MM_SpawnEggItem.initUnaddedEggs();
    }
}
