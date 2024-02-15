package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.MarcelloModDataGenerator;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalEntityTypeTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class MM_EntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public MM_EntityTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(MM_Tags.ENTITY_BLOCK_BUTTON_IMMUNE)
                .addOptionalTag(ConventionalEntityTypeTags.BOSSES)
                .add(EntityType.WARDEN);
    }
}