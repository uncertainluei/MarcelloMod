package io.github.luisrandomness.marcellomod;

import io.github.luisrandomness.marcellomod.client.render.MM_BlockRendering;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class MarcelloModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MM_BlockRendering.initialize();
	}
}