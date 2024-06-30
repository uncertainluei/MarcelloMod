package io.github.luisrandomness.marcellomod.world;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class MM_ConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_MARCELLO = registerKey("ore_marcello");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_MARCELLO_SMALL = registerKey("ore_marcello_small");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_MARCELLO_NETHER = registerKey("ore_marcello_nether");

    public static ResourceKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, MarcelloMod.modIdentifier(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneOreTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> marcelloOreBlocks = List.of(OreConfiguration.target(stoneOreTest, MM_Blocks.MARCELLO_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreTest, MM_Blocks.DEEPSLATE_MARCELLO_ORE.defaultBlockState()));

        register(context, ORE_MARCELLO, Feature.ORE, new OreConfiguration(marcelloOreBlocks, 12, 0.5F));
        register(context, ORE_MARCELLO_SMALL, Feature.ORE, new OreConfiguration(marcelloOreBlocks, 5));

        register(context, ORE_MARCELLO_NETHER, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.NETHERRACK), MM_Blocks.NETHER_MARCELLO_ORE.defaultBlockState(), 5));
    }
}
