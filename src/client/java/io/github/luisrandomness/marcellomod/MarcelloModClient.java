package io.github.luisrandomness.marcellomod;

import io.github.luisrandomness.marcellomod.client.render.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;

public class MarcelloModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MM_BlockRendering.initialize();
		MM_ItemRendering.initialize();
		MM_EntityRendering.initialize();

		FabricLoader.getInstance().getModContainer("marcellomod").ifPresent(modContainer -> {
					ResourceManagerHelper.registerBuiltinResourcePack(MarcelloMod.modIdentifier("legacy"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
		}
		);
	}
}