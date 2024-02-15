package io.github.luisrandomness.marcellomod;

import io.github.luisrandomness.marcellomod.init.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarcelloMod implements ModInitializer {
	public static final String MOD_NAMESPACE = "marcellomod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("marcellomod");

	public static ResourceLocation modIdentifier(String location) {
		return new ResourceLocation(MOD_NAMESPACE, location);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		MM_SoundEvents.registerAll();
		MM_MobEffects.registerAll();
		MM_EntityTypes.registerEntities();
		MM_Items.registerAll();
		MM_Blocks.registerBlockEvents();
		MM_Paintings.registerAll();
	}
}