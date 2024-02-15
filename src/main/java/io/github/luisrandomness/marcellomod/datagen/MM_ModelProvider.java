package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

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
        gen.createTrivialBlock(MM_Blocks.JUMPERITE_ORE, TexturedModel.CUBE_TOP_BOTTOM);
        gen.createTrivialCube(MM_Blocks.JUMPERITE_BLOCK);

        gen.woodProvider(MM_Blocks.MARCELIUM_LOG).log(MM_Blocks.MARCELIUM_LOG).wood(MM_Blocks.MARCELIUM_WOOD);
        gen.woodProvider(MM_Blocks.STRIPPED_MARCELIUM_LOG).log(MM_Blocks.STRIPPED_MARCELIUM_LOG).wood(MM_Blocks.STRIPPED_MARCELIUM_WOOD);

        gen.createTrivialBlock(MM_Blocks.RED_MARCELIUM_LEAVES, TexturedModel.LEAVES);
        gen.createTrivialBlock(MM_Blocks.GREEN_MARCELIUM_LEAVES, TexturedModel.LEAVES);
        gen.createTrivialBlock(MM_Blocks.YELLOW_MARCELIUM_LEAVES, TexturedModel.LEAVES);
        gen.createPlant(MM_Blocks.RED_MARCELIUM_SAPLING, MM_Blocks.POTTED_RED_MARCELIUM_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);
        gen.createPlant(MM_Blocks.GREEN_MARCELIUM_SAPLING, MM_Blocks.POTTED_GREEN_MARCELIUM_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);
        gen.createPlant(MM_Blocks.YELLOW_MARCELIUM_SAPLING, MM_Blocks.POTTED_YELLOW_MARCELIUM_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        gen.family(MM_Blocks.MARCELIUM_PLANKS).generateFor(MM_Blocks.FAMILY_MARCELIUM);
        gen.createHangingSign(MM_Blocks.STRIPPED_MARCELIUM_LOG, MM_Blocks.MARCELIUM_HANGING_SIGN, MM_Blocks.MARCELIUM_WALL_HANGING_SIGN);
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        gen.generateFlatItem(MM_Items.MARCELLO_FRUIT, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.MOLDY_FRUIT, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.JUMPMAN_BALL, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.PHONE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.OTHERWORLDLY_PHONE, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.BLOCK_BUTTON, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.HAMMER_PENCIL, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.JUMPERITE_SHARD, ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(MM_Items.JUMPERITE_INGOT, ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(MM_Items.JUMPERITE_ROD, ModelTemplates.FLAT_HANDHELD_ITEM);

        gen.generateFlatItem(MM_Items.MARCELLO_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.MARCELLO_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        gen.generateFlatItem(MM_Items.JUMPERITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.JUMPERITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.JUMPERITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.JUMPERITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(MM_Items.JUMPERITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        gen.generateArmorTrims(MM_Items.JUMPERITE_HELMET);
        gen.generateArmorTrims(MM_Items.JUMPERITE_CHESTPLATE);
        gen.generateArmorTrims(MM_Items.JUMPERITE_LEGGINGS);
        gen.generateArmorTrims(MM_Items.JUMPERITE_BOOTS);

        ResourceLocation spawnEggTemplate = new ResourceLocation("item/template_spawn_egg");
        for (Item item : MM_Items.ALL_ITEMS)
            if (item instanceof SpawnEggItem)
                gen.generateFlatItem(item, new ModelTemplate(Optional.of(spawnEggTemplate), Optional.empty()));
    }
}
