package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class MM_BlockLootTableProvider extends FabricBlockLootTableProvider {
    public MM_BlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(MM_Blocks.MARCELLO_BLOCK);
        addDrop(MM_Blocks.MARK_BLOCK);
        addDrop(MM_Blocks.JUMPERITE_BLOCK);

        addDrop(MM_Blocks.MARCELLO_ORE, this::marcelloOreDrops);
        addDrop(MM_Blocks.DEEPSLATE_MARCELLO_ORE, this::marcelloOreDrops);
        addDrop(MM_Blocks.NETHER_MARCELLO_ORE, this::marcelloOreDrops);
        addDrop(MM_Blocks.JUMPERITE_ORE, this::jumperiteOreDrops);
        addDrop(MM_Blocks.MARCELIUM_LOG);
        addDrop(MM_Blocks.MARCELIUM_WOOD);
        addDrop(MM_Blocks.STRIPPED_MARCELIUM_LOG);
        addDrop(MM_Blocks.STRIPPED_MARCELIUM_WOOD);
        addDrop(MM_Blocks.MARCELIUM_PLANKS);
        addDrop(MM_Blocks.MARCELIUM_STAIRS);
        addDrop(MM_Blocks.MARCELIUM_SLAB);
        addDrop(MM_Blocks.MARCELIUM_FENCE);
        addDrop(MM_Blocks.MARCELIUM_FENCE_GATE);
        addDrop(MM_Blocks.MARCELIUM_DOOR);
        addDrop(MM_Blocks.MARCELIUM_TRAPDOOR);

        addDrop(MM_Blocks.MARCELIUM_SIGN, MM_Items.MARCELIUM_SIGN);
        addDrop(MM_Blocks.MARCELIUM_WALL_SIGN, MM_Items.MARCELIUM_SIGN);

        addDrop(MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Items.MARCELIUM_HANGING_SIGN);
        addDrop(MM_Blocks.MARCELIUM_WALL_HANGING_SIGN, MM_Items.MARCELIUM_HANGING_SIGN);

        addDrop(MM_Blocks.RED_MARCELIUM_SAPLING);
        addDrop(MM_Blocks.GREEN_MARCELIUM_SAPLING);
        addDrop(MM_Blocks.YELLOW_MARCELIUM_SAPLING);
        addPottedPlantDrops(MM_Blocks.POTTED_RED_MARCELIUM_SAPLING);
        addPottedPlantDrops(MM_Blocks.POTTED_GREEN_MARCELIUM_SAPLING);
        addPottedPlantDrops(MM_Blocks.POTTED_YELLOW_MARCELIUM_SAPLING);

        addDrop(MM_Blocks.RED_MARCELIUM_LEAVES, (block) -> leavesDrops(block, MM_Blocks.RED_MARCELIUM_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(MM_Blocks.GREEN_MARCELIUM_LEAVES, (block) -> leavesDrops(block, MM_Blocks.GREEN_MARCELIUM_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(MM_Blocks.YELLOW_MARCELIUM_LEAVES, (block) -> leavesDrops(block, MM_Blocks.YELLOW_MARCELIUM_SAPLING, SAPLING_DROP_CHANCE));
    }

    public LootTable.Builder marcelloOreDrops(Block drop) {
        return dropsWithSilkTouch(drop, applyExplosionDecay(drop, ItemEntry.builder(MM_Items.MARCELLO_FRUIT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder jumperiteOreDrops(Block drop) {
        return dropsWithSilkTouch(drop, applyExplosionDecay(drop, ItemEntry.builder(MM_Items.JUMPERITE_SHARD).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    @Override
    public BlockLootTableGenerator withConditions(ConditionJsonProvider... conditions) {
        return super.withConditions(conditions);
    }

    @Override
    public BiConsumer<Identifier, LootTable.Builder> withConditions(BiConsumer<Identifier, LootTable.Builder> exporter, ConditionJsonProvider... conditions) {
        return super.withConditions(exporter, conditions);
    }
}
