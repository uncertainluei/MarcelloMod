package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MM_BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public MM_BlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELLO_ORES)
                .add(MM_Blocks.MARCELLO_ORE)
                .add(MM_Blocks.DEEPSLATE_MARCELLO_ORE)
                .add(MM_Blocks.NETHER_MARCELLO_ORE);

        getOrCreateTagBuilder(MM_Tags.BLOCK_RUISIUM_ORES).add(MM_Blocks.RUISIUM_ORE);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(MM_Blocks.RUISIUM_BLOCK);

        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELIUM_LOGS).add(MM_Blocks.MARCELIUM_LOG).add(MM_Blocks.MARCELIUM_WOOD).add(MM_Blocks.STRIPPED_MARCELIUM_LOG).add(MM_Blocks.STRIPPED_MARCELIUM_WOOD);
        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELIUM_LEAVES).add(MM_Blocks.RED_MARCELIUM_LEAVES).add(MM_Blocks.GREEN_MARCELIUM_LEAVES).add(MM_Blocks.YELLOW_MARCELIUM_LEAVES);
        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELIUM_SAPLINGS).add(MM_Blocks.RED_MARCELIUM_SAPLING).add(MM_Blocks.GREEN_MARCELIUM_SAPLING).add(MM_Blocks.YELLOW_MARCELIUM_SAPLING);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(MM_Tags.BLOCK_MARCELIUM_LOGS);
        getOrCreateTagBuilder(BlockTags.LEAVES).addTag(MM_Tags.BLOCK_MARCELIUM_LEAVES);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE).addTag(MM_Tags.BLOCK_MARCELIUM_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS).addTag(MM_Tags.BLOCK_MARCELIUM_SAPLINGS);

        getOrCreateTagBuilder(MM_Tags.BLOCK_MARCELLO_EFFICIENT)
                .add(MM_Blocks.MARCELLO_BLOCK)
                .add(MM_Blocks.MARK_BLOCK)
                .addTag(MM_Tags.BLOCK_MARCELLO_ORES)
                .addTag(MM_Tags.BLOCK_MARCELIUM_LEAVES)
                .addTag(MM_Tags.BLOCK_MARCELIUM_LOGS)
                .add(MM_Blocks.MARCELIUM_PLANKS)
                .add(MM_Blocks.MARCELIUM_STAIRS)
                .add(MM_Blocks.MARCELIUM_SLAB)
                .add(MM_Blocks.MARCELIUM_FENCE)
                .add(MM_Blocks.MARCELIUM_FENCE_GATE)
                .add(MM_Blocks.MARCELIUM_DOOR)
                .add(MM_Blocks.MARCELIUM_TRAPDOOR)
                .add(MM_Blocks.MARCELIUM_BUTTON)
                .add(MM_Blocks.MARCELIUM_PRESSURE_PLATE)
                .add(MM_Blocks.MARCELIUM_SIGN)
                .add(MM_Blocks.MARCELIUM_WALL_SIGN)
                .add(MM_Blocks.MARCELIUM_HANGING_SIGN)
                .add(MM_Blocks.MARCELIUM_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.PLANKS).add(MM_Blocks.MARCELIUM_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(MM_Blocks.MARCELIUM_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(MM_Blocks.MARCELIUM_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(MM_Blocks.MARCELIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(MM_Blocks.MARCELIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(MM_Blocks.MARCELIUM_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(MM_Blocks.MARCELIUM_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.SLABS).add(MM_Blocks.RUISIUM_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(MM_Blocks.RUISIUM_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.WALLS).add(MM_Blocks.RUISIUM_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MM_Blocks.MARCELLO_BLOCK)
                .add(MM_Blocks.MARK_BLOCK)
                .addTag(MM_Tags.BLOCK_MARCELLO_ORES)
                .addTag(MM_Tags.BLOCK_RUISIUM_ORES)
                .add(MM_Blocks.RUISIUM_BLOCK)
                .add(MM_Blocks.RUISIUM_SHARD_BLOCK)
                .add(MM_Blocks.RUISIUM_BRICKS)
                .add(MM_Blocks.RUISIUM_BRICK_SLAB)
                .add(MM_Blocks.RUISIUM_BRICK_STAIRS)
                .add(MM_Blocks.RUISIUM_BRICK_WALL)
                .add(MM_Blocks.CHISELED_RUISIUM_BRICKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(MM_Blocks.MARCELLO_BLOCK)
                .add(MM_Blocks.MARK_BLOCK)
                .addTag(MM_Tags.BLOCK_MARCELLO_ORES);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(MM_Tags.BLOCK_RUISIUM_ORES)
                .add(MM_Blocks.RUISIUM_BLOCK)
                .add(MM_Blocks.RUISIUM_SHARD_BLOCK)
                .add(MM_Blocks.RUISIUM_BRICKS)
                .add(MM_Blocks.RUISIUM_BRICK_SLAB)
                .add(MM_Blocks.RUISIUM_BRICK_STAIRS)
                .add(MM_Blocks.RUISIUM_BRICK_WALL)
                .add(MM_Blocks.CHISELED_RUISIUM_BRICKS);
    }
}