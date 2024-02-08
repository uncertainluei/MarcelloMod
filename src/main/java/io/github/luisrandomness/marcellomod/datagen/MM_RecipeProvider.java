package io.github.luisrandomness.marcellomod.datagen;

import com.google.common.collect.ImmutableList;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class MM_RecipeProvider extends FabricRecipeProvider {
    public MM_RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, MM_Items.MARCELLO_FRUIT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, MM_Items.JUMPERITE_INGOT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.JUMPERITE_BLOCK);

        woodFromLogs(exporter, MM_Blocks.MARCELIUM_WOOD, MM_Blocks.MARCELIUM_LOG);
        woodFromLogs(exporter, MM_Blocks.STRIPPED_MARCELIUM_WOOD, MM_Blocks.STRIPPED_MARCELIUM_LOG);
        planksFromLogs(exporter, MM_Blocks.MARCELIUM_PLANKS, MM_Tags.ITEM_MARCELIUM_LOGS, 4);
        pressurePlate(exporter, MM_Blocks.MARCELIUM_PRESSURE_PLATE, MM_Blocks.MARCELIUM_PLANKS);
        slab(exporter,RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELIUM_SLAB, MM_Blocks.MARCELIUM_PLANKS);
        stairBuilder(MM_Blocks.MARCELIUM_STAIRS, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(exporter);
        signBuilder(MM_Items.MARCELIUM_SIGN, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(exporter);
        hangingSign(exporter, MM_Items.MARCELIUM_HANGING_SIGN, MM_Blocks.STRIPPED_MARCELIUM_LOG);
        doorBuilder(MM_Blocks.MARCELIUM_DOOR, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(exporter);
        trapdoorBuilder(MM_Blocks.MARCELIUM_TRAPDOOR, Ingredient.of(MM_Blocks.MARCELIUM_PLANKS)).unlockedBy("has_marcelium_planks", has(MM_Blocks.MARCELIUM_PLANKS)).save(exporter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES), RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK, 0.6F, 200).group("marcello_block").unlockedBy("has_marcello_smeltables", has(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES)).save(exporter, MarcelloMod.modIdentifier("marcello_block_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES), RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK, 0.6F, 100).group("marcello_block").unlockedBy("has_marcello_smeltables", has(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES)).save(exporter, MarcelloMod.modIdentifier("marcello_block_from_blasting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(MM_Blocks.JUMPERITE_ORE), RecipeCategory.MISC, MM_Items.JUMPERITE_SHARD, 0.8F, 100).group("jumperite_shard").unlockedBy("has_jumperite_ores", has(MM_Tags.ITEM_JUMPERITE_ORES)).save(exporter, MarcelloMod.modIdentifier("jumperite_shard_from_smelting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MM_Blocks.JUMPERITE_ORE), RecipeCategory.MISC, MM_Items.JUMPERITE_SHARD, 0.8F, 200).group("jumperite_shard").unlockedBy("has_jumperite_ores", has(MM_Tags.ITEM_JUMPERITE_ORES)).save(exporter, MarcelloMod.modIdentifier("jumperite_shard_from_blasting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MM_Items.MARCELLO_SWORD).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("X").pattern("X").pattern("#").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_SHOVEL).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("X").pattern("#").pattern("#").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_PICKAXE).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_AXE).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.MARCELLO_HOE).define('#', Items.STICK).define('X', MM_Blocks.MARCELLO_BLOCK).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_marcello_block", has(MM_Blocks.MARCELLO_BLOCK)).save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MM_Items.JUMPERITE_SWORD).define('#', MM_Items.JUMPERITE_ROD).define('X', MM_Items.JUMPERITE_INGOT).pattern("X").pattern("X").pattern("#").unlockedBy("has_jumperite_ingot", has(MM_Blocks.JUMPERITE_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.JUMPERITE_SHOVEL).define('#', MM_Items.JUMPERITE_ROD).define('X', MM_Items.JUMPERITE_INGOT).pattern("X").pattern("#").pattern("#").unlockedBy("has_jumperite_ingot", has(MM_Blocks.JUMPERITE_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.JUMPERITE_PICKAXE).define('#', MM_Items.JUMPERITE_ROD).define('X', MM_Items.JUMPERITE_INGOT).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_jumperite_ingot", has(MM_Blocks.JUMPERITE_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.JUMPERITE_AXE).define('#', MM_Items.JUMPERITE_ROD).define('X', MM_Items.JUMPERITE_INGOT).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_jumperite_ingot", has(MM_Blocks.JUMPERITE_BLOCK)).save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MM_Items.JUMPERITE_HOE).define('#', MM_Items.JUMPERITE_ROD).define('X', MM_Items.JUMPERITE_INGOT).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_jumperite_ingot", has(MM_Blocks.JUMPERITE_BLOCK)).save(exporter);
    }
}
