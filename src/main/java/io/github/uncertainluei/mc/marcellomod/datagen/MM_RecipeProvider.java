package io.github.uncertainluei.mc.marcellomod.datagen;

import io.github.uncertainluei.mc.marcellomod.MarcelloMod;
import io.github.uncertainluei.mc.marcellomod.init.MM_Blocks;
import io.github.uncertainluei.mc.marcellomod.init.MM_Items;
import io.github.uncertainluei.mc.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class MM_RecipeProvider extends FabricRecipeProvider {

    public MM_RecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, MM_Items.MARCELLO_FRUIT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK);
        nineBlockStorageRecipes(output, RecipeCategory.MISC, MM_Items.RUISIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.RUISIUM_BLOCK);
        nineBlockStorageRecipes(output, RecipeCategory.FOOD, MM_Items.MARK_FRUIT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARK_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MM_Blocks.RUISIUM_CRYSTAL_BLOCK).define('#', MM_Items.RUISIUM_SHARD).pattern("##").pattern("##").unlockedBy("has_ruisium_shard", has(MM_Items.RUISIUM_SHARD)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MM_Blocks.RUISIUM_BRICKS, 8).define('#', MM_Blocks.RUISIUM_CRYSTAL_BLOCK).pattern("##").pattern("##").unlockedBy("has_ruisium_shard", has(MM_Items.RUISIUM_SHARD)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.RUISIUM_BRICK_SLAB, MM_Blocks.RUISIUM_BRICKS);
        wall(output, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.RUISIUM_BRICK_WALL, MM_Blocks.RUISIUM_BRICKS);
        stairBuilder(MM_Blocks.RUISIUM_BRICK_STAIRS, Ingredient.of(MM_Blocks.RUISIUM_BRICKS)).unlockedBy("has_ruisium_bricks", has(MM_Blocks.RUISIUM_BRICKS)).save(output);

        chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, MM_Blocks.CHISELED_RUISIUM_BRICKS, Ingredient.of(MM_Blocks.RUISIUM_BRICK_SLAB)).unlockedBy("has_chiseled_ruisium_bricks", has(MM_Blocks.CHISELED_RUISIUM_BRICKS)).unlockedBy("has_ruisium_bricks", has(MM_Blocks.RUISIUM_BRICKS)).unlockedBy("has_ruisium_crystal_block", has(MM_Blocks.RUISIUM_CRYSTAL_BLOCK)).save(output);

        woodFromLogs(output, MM_Blocks.MARCELIUM_WOOD, MM_Blocks.MARCELIUM_LOG);
        woodFromLogs(output, MM_Blocks.STRIPPED_MARCELIUM_WOOD, MM_Blocks.STRIPPED_MARCELIUM_LOG);
        planksFromLogs(output, MM_Blocks.MARCELIUM_PLANKS, MM_Tags.ITEM_MARCELIUM_LOGS, 4);
        pressurePlate(output, MM_Blocks.MARCELIUM_PRESSURE_PLATE, MM_Blocks.MARCELIUM_PLANKS);
        slab(output,RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELIUM_SLAB, MM_Blocks.MARCELIUM_PLANKS);
        stairBuilder(MM_Blocks.MARCELIUM_STAIRS, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(output);
        signBuilder(MM_Items.MARCELIUM_SIGN, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(output);
        hangingSign(output, MM_Items.MARCELIUM_HANGING_SIGN, MM_Blocks.STRIPPED_MARCELIUM_LOG);
        doorBuilder(MM_Blocks.MARCELIUM_DOOR, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(output);
        trapdoorBuilder(MM_Blocks.MARCELIUM_TRAPDOOR, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(output);

        doorBuilder(MM_Blocks.DOOR_2_WALL, Ingredient.of(Items.QUARTZ_BRICKS)).unlockedBy("has_quartz_bricks", has(Items.QUARTZ_BRICKS)).save(output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES), RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK, 0.6F, 200).group("marcello_block").unlockedBy("has_marcello_smeltables", has(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES)).save(output, MarcelloMod.modIdentifier("marcello_block_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES), RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK, 0.6F, 100).group("marcello_block").unlockedBy("has_marcello_smeltables", has(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES)).save(output, MarcelloMod.modIdentifier("marcello_block_from_blasting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MM_Items.MARCELLO_SWORD).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("X").pattern("X").pattern("#").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_SHOVEL).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("X").pattern("#").pattern("#").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_PICKAXE).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_AXE).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_HOE).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(output);

        woodenBoat(output, MM_Items.MARCELIUM_BOAT_ITEM, MM_Blocks.MARCELIUM_PLANKS);
        chestBoat(output, MM_Items.MARCELIUM_CHEST_BOAT_ITEM, MM_Items.MARCELIUM_BOAT_ITEM);

        copySmithingTemplate(output, MM_Items.RUISIUM_UPGRADE_SMITHING_TEMPLATE, MM_Blocks.UNKNOWN_FLESH);

        ruisiumSmithing(output, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, MM_Items.RUISIUM_SWORD);
        ruisiumSmithing(output, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, MM_Items.RUISIUM_SHOVEL);
        ruisiumSmithing(output, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, MM_Items.RUISIUM_PICKAXE);
        ruisiumSmithing(output, Items.DIAMOND_AXE, RecipeCategory.TOOLS, MM_Items.RUISIUM_AXE);
        ruisiumSmithing(output, Items.DIAMOND_HOE, RecipeCategory.TOOLS, MM_Items.RUISIUM_HOE);

        ruisiumSmithing(output, Items.BOW, RecipeCategory.COMBAT, MM_Items.RUISIUM_BOW);

        ruisiumSmithing(output, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, MM_Items.RUISIUM_HELMET);
        ruisiumSmithing(output, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, MM_Items.RUISIUM_CHESTPLATE);
        ruisiumSmithing(output, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, MM_Items.RUISIUM_LEGGINGS);
        ruisiumSmithing(output, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, MM_Items.RUISIUM_BOOTS);
    }

    public static void ruisiumSmithing(RecipeOutput recipeOutput, Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MM_Items.RUISIUM_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredientItem), Ingredient.of(MM_Items.RUISIUM_INGOT), category, resultItem).unlocks("has_ruisium_ingot", has(MM_Items.RUISIUM_INGOT)).save(recipeOutput, getItemName(resultItem) + "_smithing");
    }
}
