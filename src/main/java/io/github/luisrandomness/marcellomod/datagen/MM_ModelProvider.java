package io.github.luisrandomness.marcellomod.datagen;

import io.github.luisrandomness.marcellomod.init.MM_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class MM_ModelProvider extends FabricModelProvider {
    public MM_ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

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
