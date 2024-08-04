package io.github.luisrandomness.marcellomod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MM_EntityLootProvider extends SimpleFabricLootTableProvider {
    public MM_EntityLootProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup, LootContextParamSet lootContextType) {
        super(output, registryLookup, lootContextType);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {

    }
}
