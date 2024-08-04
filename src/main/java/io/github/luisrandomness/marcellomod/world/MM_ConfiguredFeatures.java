package io.github.luisrandomness.marcellomod.world;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;

public class MM_ConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_MARCELLO = registerKey("ore_marcello");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_MARCELLO_SMALL = registerKey("ore_marcello_small");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_MARCELLO_NETHER = registerKey("ore_marcello_nether");

    public static final ResourceKey<ConfiguredFeature<?,?>> ORE_RUISIUM_END = registerKey("ore_ruisium_end");

    public static final ResourceKey<ConfiguredFeature<?,?>> MARCELIUM_RED = registerKey("marcelium_red");
    public static final ResourceKey<ConfiguredFeature<?,?>> MARCELIUM_GREEN = registerKey("marcelium_green");
    public static final ResourceKey<ConfiguredFeature<?,?>> MARCELIUM_YELLOW = registerKey("marcelium_yellow");

    public static final ResourceKey<ConfiguredFeature<?,?>> MARCELIUM_VARIED = registerKey("trees_marcelium_varied");

    public static ResourceKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, MarcelloMod.modIdentifier(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneOreTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> marcelloOreBlocks = List.of(OreConfiguration.target(stoneOreTest, MM_Blocks.MARCELLO_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreTest, MM_Blocks.DEEPSLATE_MARCELLO_ORE.defaultBlockState()));

        register(context, ORE_MARCELLO, Feature.ORE, new OreConfiguration(marcelloOreBlocks, 12, 0.5F));
        register(context, ORE_MARCELLO_SMALL, Feature.ORE, new OreConfiguration(marcelloOreBlocks, 5));

        register(context, ORE_MARCELLO_NETHER, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.NETHERRACK), MM_Blocks.NETHER_MARCELLO_ORE.defaultBlockState(), 5));

        register(context, ORE_RUISIUM_END, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), MM_Blocks.END_RUISIUM_ORE.defaultBlockState(), 1, 1F));


        BlockStateProvider log = BlockStateProvider.simple(MM_Blocks.MARCELIUM_LOG);
        FoliagePlacer foliagePlacer = new FancyFoliagePlacer(ConstantInt.of(2), UniformInt.of(3,4), 4);

        register(context, MARCELIUM_RED, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(log,
                new FancyTrunkPlacer(2,9,2),
                BlockStateProvider.simple(MM_Blocks.RED_MARCELIUM_LEAVES),
                foliagePlacer,
                new TwoLayersFeatureSize(1, 0, 2)).build()
        );

        register(context, MARCELIUM_GREEN, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(log,
                new FancyTrunkPlacer(3,8,4),
                BlockStateProvider.simple(MM_Blocks.GREEN_MARCELIUM_LEAVES),
                foliagePlacer,
                new TwoLayersFeatureSize(1, 0, 2)).build()
        );

        register(context, MARCELIUM_YELLOW, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(log,
                new FancyTrunkPlacer(4,6,1),
                BlockStateProvider.simple(MM_Blocks.YELLOW_MARCELIUM_LEAVES),
                foliagePlacer,
                new TwoLayersFeatureSize(1, 0, 2)).build()
        );
    }

    public static void bootstrapPost(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> pfLookup = context.lookup(Registries.PLACED_FEATURE);

        Holder<PlacedFeature> treeRed = pfLookup.getOrThrow(MM_PlacedFeatures.MARCELIUM_RED);
        Holder<PlacedFeature> treeGreen = pfLookup.getOrThrow(MM_PlacedFeatures.MARCELIUM_GREEN);
        Holder<PlacedFeature> treeYellow = pfLookup.getOrThrow(MM_PlacedFeatures.MARCELIUM_YELLOW);

        register(context, MARCELIUM_VARIED, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(treeYellow, 0.2F), new WeightedPlacedFeature(treeGreen, 0.4F)), treeRed));
    }
}
