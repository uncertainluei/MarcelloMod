package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

public class MM_ModelProvider extends FabricModelProvider {
    public MM_ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        gen.registerSingleton(MM_Blocks.MARCELLO_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        gen.registerSingleton(MM_Blocks.MARK_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        gen.registerSimpleCubeAll(MM_Blocks.MARCELLO_ORE);
        gen.registerSimpleCubeAll(MM_Blocks.DEEPSLATE_MARCELLO_ORE);
        gen.registerSimpleCubeAll(MM_Blocks.NETHER_MARCELLO_ORE);
        gen.registerSingleton(MM_Blocks.JUMPERITE_ORE, TexturedModel.CUBE_BOTTOM_TOP);
        gen.registerSimpleCubeAll(MM_Blocks.JUMPERITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        gen.register(MM_Items.MARCELLO_FRUIT, Models.GENERATED);
        gen.register(MM_Items.MOLDY_FRUIT, Models.GENERATED);
        gen.register(MM_Items.JUMPMAN_BALL, Models.GENERATED);
        gen.register(MM_Items.PHONE, Models.GENERATED);

        gen.register(MM_Items.JUMPERITE_SHARD, Models.GENERATED);
        gen.register(MM_Items.JUMPERITE_INGOT, Models.GENERATED);

        gen.register(MM_Items.JUMPERITE_ROD, Models.HANDHELD);

        gen.register(MM_Items.MARCELLO_SWORD, Models.HANDHELD);
        gen.register(MM_Items.MARCELLO_SHOVEL, Models.HANDHELD);
        gen.register(MM_Items.MARCELLO_PICKAXE, Models.HANDHELD);
        gen.register(MM_Items.MARCELLO_AXE, Models.HANDHELD);
        gen.register(MM_Items.MARCELLO_HOE, Models.HANDHELD);

        gen.register(MM_Items.JUMPERITE_SWORD, Models.HANDHELD);
        gen.register(MM_Items.JUMPERITE_SHOVEL, Models.HANDHELD);
        gen.register(MM_Items.JUMPERITE_PICKAXE, Models.HANDHELD);
        gen.register(MM_Items.JUMPERITE_AXE, Models.HANDHELD);
        gen.register(MM_Items.JUMPERITE_HOE, Models.HANDHELD);

        gen.registerArmor(MM_Items.JUMPERITE_HELMET);
        gen.registerArmor(MM_Items.JUMPERITE_CHESTPLATE);
        gen.registerArmor(MM_Items.JUMPERITE_LEGGINGS);
        gen.registerArmor(MM_Items.JUMPERITE_BOOTS);
    }
}
