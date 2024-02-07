package io.github.luisrandomness.marcellomod.datagen;

import com.google.common.collect.ImmutableList;
import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import io.github.luisrandomness.marcellomod.init.MM_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.advancement.criterion.ImpossibleCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;

public class MM_RecipeProvider extends FabricRecipeProvider {
    public MM_RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, MM_Items.MARCELLO_FRUIT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, MM_Items.JUMPERITE_INGOT, RecipeCategory.BUILDING_BLOCKS, MM_Blocks.JUMPERITE_BLOCK);

        offerBarkBlockRecipe(exporter, MM_Blocks.MARCELIUM_WOOD, MM_Blocks.MARCELIUM_LOG);
        offerBarkBlockRecipe(exporter, MM_Blocks.STRIPPED_MARCELIUM_WOOD, MM_Blocks.STRIPPED_MARCELIUM_LOG);
        offerPlanksRecipe(exporter, MM_Blocks.MARCELIUM_PLANKS, MM_Tags.ITEM_MARCELIUM_LOGS, 4);
        offerPressurePlateRecipe(exporter, MM_Blocks.MARCELIUM_PRESSURE_PLATE, MM_Blocks.MARCELIUM_PLANKS);
        offerSlabRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELIUM_SLAB, MM_Blocks.MARCELIUM_PLANKS);
        createStairsRecipe(MM_Blocks.MARCELIUM_STAIRS, Ingredient.ofItems(MM_Blocks.MARCELIUM_PLANKS)).criterion("has_marcelium_planks", conditionsFromItem(MM_Blocks.MARCELIUM_PLANKS)).offerTo(exporter);
        createSignRecipe(MM_Items.MARCELIUM_SIGN, Ingredient.ofItems(MM_Blocks.MARCELIUM_PLANKS)).criterion("has_marcelium_planks", conditionsFromItem(MM_Blocks.MARCELIUM_PLANKS)).offerTo(exporter);
        offerHangingSignRecipe(exporter, MM_Items.MARCELIUM_HANGING_SIGN, MM_Blocks.STRIPPED_MARCELIUM_LOG);
        createDoorRecipe(MM_Blocks.MARCELIUM_DOOR, Ingredient.ofItems(MM_Blocks.MARCELIUM_PLANKS)).criterion("has_marcelium_planks", conditionsFromItem(MM_Blocks.MARCELIUM_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(MM_Blocks.MARCELIUM_TRAPDOOR, Ingredient.ofItems(MM_Blocks.MARCELIUM_PLANKS)).criterion("has_marcelium_planks", conditionsFromItem(MM_Blocks.MARCELIUM_PLANKS)).offerTo(exporter);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.fromTag(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES), RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK, 0.6F, 200).group("marcello_block").criterion("has_marcello_smeltables", conditionsFromTag(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES)).offerTo(exporter, MarcelloMod.modIdentifier("marcello_block_from_smelting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.fromTag(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES), RecipeCategory.BUILDING_BLOCKS, MM_Blocks.MARCELLO_BLOCK, 0.6F, 100).group("marcello_block").criterion("has_marcello_smeltables", conditionsFromTag(MM_Tags.ITEM_MARCELLO_BLOCK_SMELTABLES)).offerTo(exporter, MarcelloMod.modIdentifier("marcello_block_from_blasting"));

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(MM_Blocks.JUMPERITE_ORE), RecipeCategory.MISC, MM_Items.JUMPERITE_SHARD, 0.8F, 100).group("jumperite_shard").criterion("has_jumperite_ores", conditionsFromTag(MM_Tags.ITEM_JUMPERITE_ORES)).offerTo(exporter, MarcelloMod.modIdentifier("jumperite_shard_from_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(MM_Blocks.JUMPERITE_ORE), RecipeCategory.MISC, MM_Items.JUMPERITE_SHARD, 0.8F, 200).group("jumperite_shard").criterion("has_jumperite_ores", conditionsFromTag(MM_Tags.ITEM_JUMPERITE_ORES)).offerTo(exporter, MarcelloMod.modIdentifier("jumperite_shard_from_blasting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, MM_Items.MARCELLO_SWORD).input('#', Items.STICK).input('X', MM_Blocks.MARCELLO_BLOCK).pattern("X").pattern("X").pattern("#").criterion("has_marcello_block", conditionsFromItem(MM_Blocks.MARCELLO_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.MARCELLO_SHOVEL).input('#', Items.STICK).input('X', MM_Blocks.MARCELLO_BLOCK).pattern("X").pattern("#").pattern("#").criterion("has_marcello_block", conditionsFromItem(MM_Blocks.MARCELLO_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.MARCELLO_PICKAXE).input('#', Items.STICK).input('X', MM_Blocks.MARCELLO_BLOCK).pattern("XXX").pattern(" # ").pattern(" # ").criterion("has_marcello_block", conditionsFromItem(MM_Blocks.MARCELLO_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.MARCELLO_AXE).input('#', Items.STICK).input('X', MM_Blocks.MARCELLO_BLOCK).pattern("XX").pattern("X#").pattern(" #").criterion("has_marcello_block", conditionsFromItem(MM_Blocks.MARCELLO_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.MARCELLO_HOE).input('#', Items.STICK).input('X', MM_Blocks.MARCELLO_BLOCK).pattern("XX").pattern(" #").pattern(" #").criterion("has_marcello_block", conditionsFromItem(MM_Blocks.MARCELLO_BLOCK)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, MM_Items.JUMPERITE_SWORD).input('#', MM_Items.JUMPERITE_ROD).input('X', MM_Items.JUMPERITE_INGOT).pattern("X").pattern("X").pattern("#").criterion("has_jumperite_ingot", conditionsFromItem(MM_Blocks.JUMPERITE_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.JUMPERITE_SHOVEL).input('#', MM_Items.JUMPERITE_ROD).input('X', MM_Items.JUMPERITE_INGOT).pattern("X").pattern("#").pattern("#").criterion("has_jumperite_ingot", conditionsFromItem(MM_Blocks.JUMPERITE_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.JUMPERITE_PICKAXE).input('#', MM_Items.JUMPERITE_ROD).input('X', MM_Items.JUMPERITE_INGOT).pattern("XXX").pattern(" # ").pattern(" # ").criterion("has_jumperite_ingot", conditionsFromItem(MM_Blocks.JUMPERITE_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.JUMPERITE_AXE).input('#', MM_Items.JUMPERITE_ROD).input('X', MM_Items.JUMPERITE_INGOT).pattern("XX").pattern("X#").pattern(" #").criterion("has_jumperite_ingot", conditionsFromItem(MM_Blocks.JUMPERITE_BLOCK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, MM_Items.JUMPERITE_HOE).input('#', MM_Items.JUMPERITE_ROD).input('X', MM_Items.JUMPERITE_INGOT).pattern("XX").pattern(" #").pattern(" #").criterion("has_jumperite_ingot", conditionsFromItem(MM_Blocks.JUMPERITE_BLOCK)).offerTo(exporter);
    }
}
