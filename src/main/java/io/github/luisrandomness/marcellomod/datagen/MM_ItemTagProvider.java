package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.MarcelloModDataGenerator;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class MM_ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public MM_ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, MarcelloModDataGenerator.blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        copy(MM_Tags.BLOCK_MARCELLO_ORES, MM_Tags.ITEM_MARCELLO_ORES);
        copy(MM_Tags.BLOCK_RUISIUM_ORES, MM_Tags.ITEM_RUISIUM_ORES);
        copy(MM_Tags.BLOCK_MARCELIUM_LOGS, MM_Tags.ITEM_MARCELIUM_LOGS);
        copy(MM_Tags.BLOCK_MARCELIUM_SAPLINGS, MM_Tags.ITEM_MARCELIUM_SAPLINGS);
        copy(MM_Tags.BLOCK_MARCELIUM_LEAVES, MM_Tags.ITEM_MARCELIUM_LEAVES);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(MM_Tags.ITEM_MARCELIUM_LOGS);
        getOrCreateTagBuilder(ItemTags.LEAVES).addTag(MM_Tags.ITEM_MARCELIUM_LEAVES);
        getOrCreateTagBuilder(ItemTags.SAPLINGS).addTag(MM_Tags.ITEM_MARCELIUM_SAPLINGS);

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(MM_Blocks.MARCELIUM_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(MM_Blocks.MARCELIUM_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(MM_Blocks.MARCELIUM_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(MM_Blocks.MARCELIUM_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(MM_Blocks.MARCELIUM_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(MM_Blocks.MARCELIUM_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(MM_Blocks.MARCELIUM_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.SIGNS).add(MM_Items.MARCELIUM_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(MM_Items.MARCELIUM_HANGING_SIGN);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(MM_Blocks.MARCELIUM_PLANKS.asItem());

        getOrCreateTagBuilder(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES).addTag(MM_Tags.ITEM_MARCELLO_ORES).add(MM_Items.PHONE);

        getOrCreateTagBuilder(MM_Tags.ITEM_RUISIUM_ORES).add(MM_Blocks.RUISIUM_ORE.asItem());

        getOrCreateTagBuilder(ItemTags.SWORDS).add(MM_Items.MARCELLO_SWORD).add(MM_Items.RUISIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(MM_Items.MARCELLO_SHOVEL).add(MM_Items.RUISIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(MM_Items.MARCELLO_PICKAXE).add(MM_Items.RUISIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(MM_Items.MARCELLO_AXE).add(MM_Items.RUISIUM_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(MM_Items.MARCELLO_HOE).add(MM_Items.RUISIUM_HOE);

        getOrCreateTagBuilder(ConventionalItemTags.BOWS).add(MM_Items.RUISIUM_BOW);

        getOrCreateTagBuilder(MM_Tags.ITEM_RUISIUM_ARMOR)
                .add(MM_Items.RUISIUM_HELMET)
                .add(MM_Items.RUISIUM_CHESTPLATE)
                .add(MM_Items.RUISIUM_LEGGINGS)
                .add(MM_Items.RUISIUM_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).addTag(MM_Tags.ITEM_RUISIUM_ARMOR);
        getOrCreateTagBuilder(ConventionalItemTags.INGOTS).add(MM_Items.RUISIUM_INGOT);
        getOrCreateTagBuilder(ConventionalItemTags.GEMS).add(MM_Items.RUISIUM_SHARD);
        getOrCreateTagBuilder(ConventionalItemTags.NUGGETS).add(MM_Items.RUISIUM_SHARD);
        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(MM_Items.RUISIUM_INGOT);
    }
}