package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MM_BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public MM_BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELLO_ORES).add(MM_Blocks.MARCELLO_ORE).add(MM_Blocks.DEEPSLATE_MARCELLO_ORE).add(MM_Blocks.NETHER_MARCELLO_ORE);
        getOrCreateTagBuilder(MM_Tags.BLOCK_JUMPERITE_ORES).add(MM_Blocks.JUMPERITE_ORE);
        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELLO_EFFICIENT).add(MM_Blocks.MARCELLO_BLOCK).add(MM_Blocks.MARK_BLOCK).addTag(MM_Tags.BLOCK_MARCELLO_ORES);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(MM_Blocks.JUMPERITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(MM_Blocks.MARCELLO_BLOCK)
                .add(MM_Blocks.MARK_BLOCK)
                .addTag(MM_Tags.BLOCK_MARCELLO_ORES)
                .addTag(MM_Tags.BLOCK_JUMPERITE_ORES)
                .add(MM_Blocks.JUMPERITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(MM_Blocks.MARCELLO_BLOCK)
                .add(MM_Blocks.MARK_BLOCK)
                .addTag(MM_Tags.BLOCK_MARCELLO_ORES);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(MM_Tags.BLOCK_JUMPERITE_ORES)
                .add(MM_Blocks.JUMPERITE_BLOCK);
    }
}