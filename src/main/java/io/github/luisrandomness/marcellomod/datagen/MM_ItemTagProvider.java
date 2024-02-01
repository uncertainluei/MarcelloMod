package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.MarcelloModDataGenerator;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class MM_ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public MM_ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture, MarcelloModDataGenerator.blockTags);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        copy(MM_Tags.BLOCK_MARCELLO_ORES, MM_Tags.ITEM_MARCELLO_ORES);
        copy(MM_Tags.BLOCK_JUMPERITE_ORES, MM_Tags.ITEM_JUMPERITE_ORES);

        getOrCreateTagBuilder(MM_Tags.ITEM_JUMPERITE_ORES).add(MM_Blocks.JUMPERITE_ORE.asItem());

        getOrCreateTagBuilder(ItemTags.SWORDS).add(MM_Items.MARCELLO_SWORD).add(MM_Items.JUMPERITE_SWORD);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(MM_Items.MARCELLO_SWORD).add(MM_Items.JUMPERITE_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(MM_Items.MARCELLO_SHOVEL).add(MM_Items.JUMPERITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(MM_Items.MARCELLO_PICKAXE).add(MM_Items.JUMPERITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(MM_Items.MARCELLO_AXE).add(MM_Items.JUMPERITE_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(MM_Items.MARCELLO_HOE).add(MM_Items.JUMPERITE_HOE);

        getOrCreateTagBuilder(MM_Tags.ITEM_JUMPERITE_ARMOR)
                .add(MM_Items.JUMPERITE_HELMET)
                .add(MM_Items.JUMPERITE_CHESTPLATE)
                .add(MM_Items.JUMPERITE_LEGGINGS)
                .add(MM_Items.JUMPERITE_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).addTag(MM_Tags.ITEM_JUMPERITE_ARMOR);
    }
}