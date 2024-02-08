package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Paintings;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.concurrent.CompletableFuture;

public class MM_PaintingTagProvider extends FabricTagProvider<PaintingVariant> {

    public MM_PaintingTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.PAINTING_VARIANT, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        for (PaintingVariant paintingVariant : MM_Paintings.ALL_PAINTINGS)
            getOrCreateTagBuilder(MM_Tags.PAINTINGS).add(paintingVariant);
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE).addTag(MM_Tags.PAINTINGS);
    }
}