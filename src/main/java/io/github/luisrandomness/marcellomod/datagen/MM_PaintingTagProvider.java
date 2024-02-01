package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Paintings;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;

import java.util.concurrent.CompletableFuture;

public class MM_PaintingTagProvider extends FabricTagProvider<PaintingVariant> {
    public MM_PaintingTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, Registries.PAINTING_VARIANT.getKey(), registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (PaintingVariant paintingVariant : MM_Paintings.ALL_PAINTINGS)
            getOrCreateTagBuilder(MM_Tags.PAINTINGS).add(paintingVariant);
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE).addTag(MM_Tags.PAINTINGS);
    }
}