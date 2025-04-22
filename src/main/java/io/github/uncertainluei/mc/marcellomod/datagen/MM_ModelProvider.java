package io.github.uncertainluei.mc.marcellomod.datagen;

import io.github.uncertainluei.mc.marcellomod.init.MM_Blocks;
import io.github.uncertainluei.mc.marcellomod.init.MM_Items;
import io.github.uncertainluei.mc.marcellomod.init.item.MM_SpawnEggs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class MM_ModelProvider extends FabricModelProvider {
    public MM_ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
        
        gen.createTrivialBlock(MM_Blocks.MARCELLO_BLOCK, TexturedModel.CUBE_TOP_BOTTOM);
        gen.createTrivialBlock(MM_Blocks.MARK_BLOCK, TexturedModel.CUBE_TOP_BOTTOM);
        gen.createTrivialCube(MM_Blocks.MARCELLO_ORE);
        gen.createTrivialCube(MM_Blocks.DEEPSLATE_MARCELLO_ORE);
        gen.createTrivialCube(MM_Blocks.NETHER_MARCELLO_ORE);
        gen.createTrivialCube(MM_Blocks.RUISIUM_BLOCK);
        gen.createTrivialCube(MM_Blocks.RUISIUM_CRYSTAL_BLOCK);
        gen.createTrivialCube(MM_Blocks.BUDDING_RUISIUM_CRYSTAL);

        gen.createAmethystCluster(MM_Blocks.RUISIUM_CLUSTER);
        gen.createAmethystCluster(MM_Blocks.LARGE_RUISIUM_BUD);
        gen.createAmethystCluster(MM_Blocks.MEDIUM_RUISIUM_BUD);
        gen.createAmethystCluster(MM_Blocks.SMALL_RUISIUM_BUD);

        gen.createRotatedVariantBlock(MM_Blocks.UNKNOWN_FLESH);

        gen.family(MM_Blocks.MARCELIUM_PLANKS).generateFor(MM_Blocks.FAMILY_MARCELIUM);
        gen.family(MM_Blocks.SKIMELI_PLANKS).generateFor(MM_Blocks.FAMILY_SKIMELI);
        gen.family(MM_Blocks.RUISIUM_BRICKS).generateFor(MM_Blocks.FAMILY_RUISIUM_BRICK);

        gen.createTrivialBlock(MM_Blocks.CHISELED_RUISIUM_BRICKS, TexturedModel.COLUMN);

        gen.woodProvider(MM_Blocks.MARCELIUM_LOG).log(MM_Blocks.MARCELIUM_LOG).wood(MM_Blocks.MARCELIUM_WOOD);
        gen.woodProvider(MM_Blocks.STRIPPED_MARCELIUM_LOG).log(MM_Blocks.STRIPPED_MARCELIUM_LOG).wood(MM_Blocks.STRIPPED_MARCELIUM_WOOD);

        gen.woodProvider(MM_Blocks.SKIMELI_LOG).log(MM_Blocks.SKIMELI_LOG).wood(MM_Blocks.SKIMELI_WOOD);
        gen.woodProvider(MM_Blocks.STRIPPED_SKIMELI_LOG).log(MM_Blocks.STRIPPED_SKIMELI_LOG).wood(MM_Blocks.STRIPPED_SKIMELI_WOOD);
        
        gen.createTrivialBlock(MM_Blocks.RED_MARCELIUM_LEAVES, TexturedModel.LEAVES);
        gen.createTrivialBlock(MM_Blocks.GREEN_MARCELIUM_LEAVES, TexturedModel.LEAVES);
        gen.createTrivialBlock(MM_Blocks.YELLOW_MARCELIUM_LEAVES, TexturedModel.LEAVES);
        gen.createPlant(MM_Blocks.RED_MARCELIUM_SAPLING, MM_Blocks.POTTED_RED_MARCELIUM_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);
        gen.createPlant(MM_Blocks.GREEN_MARCELIUM_SAPLING, MM_Blocks.POTTED_GREEN_MARCELIUM_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);
        gen.createPlant(MM_Blocks.YELLOW_MARCELIUM_SAPLING, MM_Blocks.POTTED_YELLOW_MARCELIUM_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        gen.createHangingSign(MM_Blocks.STRIPPED_MARCELIUM_LOG, MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Blocks.MARCELIUM_WALL_HANGING_SIGN);
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        gen.generateFlatItem(MM_Items.MARCELLO_FRUIT, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.MOLDY_FRUIT, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.MARK_FRUIT, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.PHONE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.OTHERWORLDLY_PHONE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.BLOCK_BUTTON, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.HAMMER_PENCIL, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.RUISIUM_SHARD, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.RUISIUM_INGOT, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.RUISIUM_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.MARCELIUM_BOAT_ITEM, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.MARCELIUM_CHEST_BOAT_ITEM, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Blocks.DOOR_2_WALL.asItem(), ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.MARCELLO_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        gen.generateFlatItem(MM_Items.RUISIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.RUISIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.RUISIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.RUISIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.RUISIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        gen.generateArmorTrims(MM_Items.RUISIUM_HELMET);
        gen.generateArmorTrims(MM_Items.RUISIUM_CHESTPLATE);
        gen.generateArmorTrims(MM_Items.RUISIUM_LEGGINGS);
        gen.generateArmorTrims(MM_Items.RUISIUM_BOOTS);

        ResourceLocation spawnEggTemplate = ResourceLocation.withDefaultNamespace("item/template_spawn_egg");
        for (Item item : MM_SpawnEggs.ALL_SPAWN_EGGS)
                gen.generateFlatItem(item, new ModelTemplate(Optional.of(spawnEggTemplate), Optional.empty()));
    }
}
