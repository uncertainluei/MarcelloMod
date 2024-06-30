package io.github.luisrandomness.marcellomod;

import io.github.luisrandomness.marcellomod.datagen.*;
import io.github.luisrandomness.marcellomod.world.MM_ConfiguredFeatures;
import io.github.luisrandomness.marcellomod.world.MM_PlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.*;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MarcelloModDataGenerator implements DataGeneratorEntrypoint {
	public static FabricTagProvider.BlockTagProvider blockTags;

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MM_ModelProvider::new);

		blockTags = pack.addProvider(MM_BlockTagProvider::new);
		pack.addProvider(MM_ItemTagProvider::new);
		pack.addProvider(MM_EntityTagProvider::new);
		pack.addProvider(MM_PaintingTagProvider::new);
		pack.addProvider(MM_BlockLootTableProvider::new);
		pack.addProvider(MM_RecipeProvider::new);
		pack.addProvider(MM_WorldGenerationProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, MM_ConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, MM_PlacedFeatures::bootstrap);
	}
}
