package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class MM_BlockLootTableProvider extends FabricBlockLootTableProvider {

    public MM_BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    private HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup;

    @Override
    public void generate() {
        dropSelf(MM_Blocks.MARCELLO_BLOCK);
        dropSelf(MM_Blocks.MARK_BLOCK);
        dropSelf(MM_Blocks.RUISIUM_BLOCK);

        enchantmentRegistryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        add(MM_Blocks.MARCELLO_ORE, this::marcelloOreDrops);
        add(MM_Blocks.DEEPSLATE_MARCELLO_ORE, this::marcelloOreDrops);
        add(MM_Blocks.NETHER_MARCELLO_ORE, this::marcelloOreDrops);
        add(MM_Blocks.RUISIUM_ORE, this::ruisiumOreDrops);

        dropSelf(MM_Blocks.MARCELIUM_LOG);
        dropSelf(MM_Blocks.MARCELIUM_WOOD);
        dropSelf(MM_Blocks.STRIPPED_MARCELIUM_LOG);
        dropSelf(MM_Blocks.STRIPPED_MARCELIUM_WOOD);
        dropSelf(MM_Blocks.MARCELIUM_PLANKS);
        dropSelf(MM_Blocks.MARCELIUM_STAIRS);
        dropSelf(MM_Blocks.MARCELIUM_SLAB);
        dropSelf(MM_Blocks.MARCELIUM_FENCE);
        dropSelf(MM_Blocks.MARCELIUM_FENCE_GATE);
        createDoorTable(MM_Blocks.MARCELIUM_DOOR);
        dropSelf(MM_Blocks.MARCELIUM_TRAPDOOR);

        dropOther(MM_Blocks.MARCELIUM_SIGN, MM_Items.MARCELIUM_SIGN);
        dropOther(MM_Blocks.MARCELIUM_WALL_SIGN, MM_Items.MARCELIUM_SIGN);

        dropOther(MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Items.MARCELIUM_HANGING_SIGN);
        dropOther(MM_Blocks.MARCELIUM_WALL_HANGING_SIGN, MM_Items.MARCELIUM_HANGING_SIGN);

        dropSelf(MM_Blocks.RED_MARCELIUM_SAPLING);
        dropSelf(MM_Blocks.GREEN_MARCELIUM_SAPLING);
        dropSelf(MM_Blocks.YELLOW_MARCELIUM_SAPLING);
        createPotFlowerItemTable(MM_Blocks.POTTED_RED_MARCELIUM_SAPLING);
        createPotFlowerItemTable(MM_Blocks.POTTED_GREEN_MARCELIUM_SAPLING);
        createPotFlowerItemTable(MM_Blocks.POTTED_YELLOW_MARCELIUM_SAPLING);

        add(MM_Blocks.RED_MARCELIUM_LEAVES, (block) -> createLeavesDrops(block, MM_Blocks.RED_MARCELIUM_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(MM_Blocks.GREEN_MARCELIUM_LEAVES, (block) -> createLeavesDrops(block, MM_Blocks.GREEN_MARCELIUM_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(MM_Blocks.YELLOW_MARCELIUM_LEAVES, (block) -> createLeavesDrops(block, MM_Blocks.YELLOW_MARCELIUM_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));

        createDoorTable(MM_Blocks.DOOR_2_WALL);
    }

    public LootTable.Builder marcelloOreDrops(Block drop) {
        return createSilkTouchDispatchTable(drop, applyExplosionDecay(drop, LootItem.lootTableItem(MM_Items.MARCELLO_FRUIT).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))).apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    public LootTable.Builder ruisiumOreDrops(Block drop) {
        return createSilkTouchDispatchTable(drop, applyExplosionDecay(drop, LootItem.lootTableItem(MM_Items.RUISIUM_SHARD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }
}
