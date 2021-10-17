package me.luisrandomness.marcellomod.core;

import me.luisrandomness.marcellomod.MarcelloMod;
import me.luisrandomness.marcellomod.core.items.MM_SpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MarcelloMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnEggSetupEvent {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        MM_SpawnEggItem.initUnaddedEggs();
    }
}
