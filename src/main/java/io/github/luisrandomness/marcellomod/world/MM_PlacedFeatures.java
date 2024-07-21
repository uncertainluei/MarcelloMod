package io.github.luisrandomness.marcellomod.world;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.init.MM_Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class MM_PlacedFeatures {

    public static final ResourceKey<PlacedFeature> ORE_MARCELLO_UPPER = registerKey("ore_marcello_upper");
    public static final ResourceKey<PlacedFeature> ORE_MARCELLO_LOWER = registerKey("ore_marcello_lower");
    public static final ResourceKey<PlacedFeature> ORE_MARCELLO_LARGE = registerKey("ore_marcello_large");

    public static final ResourceKey<PlacedFeature> ORE_MARCELLO_NETHER = registerKey("ore_marcello_nether");

    public static final ResourceKey<PlacedFeature> MARCELIUM_RED = registerKey("marcelium_red");
    public static final ResourceKey<PlacedFeature> MARCELIUM_GREEN = registerKey("marcelium_green");
    public static final ResourceKey<PlacedFeature> MARCELIUM_YELLOW = registerKey("marcelium_yellow");

    public static final ResourceKey<PlacedFeature> MARCELIUM_VARIED = registerKey("trees_marcelium_varied");
    public static final ResourceKey<PlacedFeature> MARCELIUM_FOREIGN = registerKey("trees_marcelium_foreign");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> cfLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?,?>> oreConfig = cfLookup.getOrThrow(MM_ConfiguredFeatures.ORE_MARCELLO_SMALL);
        register(context, ORE_MARCELLO_UPPER, oreConfig, commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(56), VerticalAnchor.belowTop(64))));
        register(context, ORE_MARCELLO_LOWER, oreConfig, commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(16), VerticalAnchor.absolute(72))));
        register(context, ORE_MARCELLO_LARGE, cfLookup.getOrThrow(MM_ConfiguredFeatures.ORE_MARCELLO), rareOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(8), VerticalAnchor.absolute(96))));

        register(context, ORE_MARCELLO_NETHER, cfLookup.getOrThrow(MM_ConfiguredFeatures.ORE_MARCELLO_NETHER), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(4), VerticalAnchor.aboveBottom(48))));

        register(context, MARCELIUM_RED, cfLookup.getOrThrow(MM_ConfiguredFeatures.MARCELIUM_RED), List.of(new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(MM_Blocks.RED_MARCELIUM_SAPLING)}));
        register(context, MARCELIUM_GREEN, cfLookup.getOrThrow(MM_ConfiguredFeatures.MARCELIUM_GREEN), List.of(new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(MM_Blocks.GREEN_MARCELIUM_SAPLING)}));
        register(context, MARCELIUM_YELLOW, cfLookup.getOrThrow(MM_ConfiguredFeatures.MARCELIUM_YELLOW), List.of(new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(MM_Blocks.YELLOW_MARCELIUM_SAPLING)}));
    }

    public static void bootstrapPost(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> cfLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MARCELIUM_VARIED, cfLookup.getOrThrow(MM_ConfiguredFeatures.MARCELIUM_VARIED), treePlacement(PlacementUtils.countExtra(2, 0.1F, 2)));

        List<PlacementModifier> foreignTreePlacement = new ArrayList<>(List.of(RarityFilter.onAverageOnceEvery(160)));
        foreignTreePlacement.addAll(treePlacement(PlacementUtils.countExtra(2, 0.1F, 2)));

        register(context, MARCELIUM_FOREIGN, cfLookup.getOrThrow(MM_ConfiguredFeatures.MARCELIUM_VARIED), foreignTreePlacement);
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, MarcelloMod.modIdentifier(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }
}
