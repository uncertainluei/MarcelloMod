package io.github.luisrandomness.marcellomod.init;

import it.unimi.dsi.fastutil.Hash;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.HashMap;

import static io.github.luisrandomness.marcellomod.MarcelloMod.modIdentifier;

public class MM_Blocks {

    static HashMap<Block, BlockItem> blockItems = new HashMap<>();
    public static BlockItem getBlockItem(Block block)
    {
        if (blockItems.containsKey(block)) return blockItems.get(block);

        BlockItem item = (BlockItem)MM_Items.registerItem(Registries.BLOCK.getId(block).getPath(), new BlockItem(block, new FabricItemSettings()));
        blockItems.put(block,item);
        return item;
    }

    public static Block registerBlock(String identifier, Block block)
    {
        return registerBlock(identifier,block,true);
    }
    public static Block registerBlock(String identifier, Block block, boolean includeItemForm)
    {
        Block registered = Registry.register(Registries.BLOCK, modIdentifier(identifier), block);
        if (includeItemForm)
            getBlockItem(registered);
        return registered;
    }

    public static final Block MARCELLO_BLOCK = registerBlock("marcello_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE)
            .strength(2.4F).requiresTool().sounds(BlockSoundGroup.WART_BLOCK)));
    public static final Block MARK_BLOCK = registerBlock("mark_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE)
            .strength(4.8F,12F).requiresTool().sounds(BlockSoundGroup.WART_BLOCK)));

    public static final ExperienceDroppingBlock MARCELLO_ORE = (ExperienceDroppingBlock) registerBlock("marcello_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 3), FabricBlockSettings.copyOf(Blocks.LAPIS_ORE)));
    public static final ExperienceDroppingBlock DEEPSLATE_MARCELLO_ORE = (ExperienceDroppingBlock) registerBlock("deepslate_marcello_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 3), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE)));
    public static final ExperienceDroppingBlock NETHER_MARCELLO_ORE = (ExperienceDroppingBlock) registerBlock("nether_marcello_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 3), FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE)));

    public static final ExperienceDroppingBlock JUMPERITE_ORE = (ExperienceDroppingBlock) registerBlock("jumperite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 7), FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)
            .strength(8F,32F).requiresTool()));
    public static final Block JUMPERITE_BLOCK = registerBlock("jumperite_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
            .strength(20F,32F).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static void registerAll()
    {
    }
}
