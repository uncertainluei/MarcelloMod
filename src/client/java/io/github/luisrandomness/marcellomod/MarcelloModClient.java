package io.github.luisrandomness.marcellomod;

import io.github.luisrandomness.marcellomod.client.render.*;
import net.fabricmc.api.ClientModInitializer;

public class MarcelloModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MM_BlockRendering.initialize();
		MM_ItemRendering.initialize();
		MM_EntityRendering.initialize();
	}
}