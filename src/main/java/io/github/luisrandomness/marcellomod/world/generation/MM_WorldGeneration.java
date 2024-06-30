package io.github.luisrandomness.marcellomod.world.generation;

import io.github.luisrandomness.marcellomod.init.MM_EntityTypes;
import io.github.luisrandomness.marcellomod.world.MM_PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MM_WorldGeneration {

    public static void addWorldGenModifications() {
        addOres();
    }

    public static void addOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, MM_PlacedFeatures.ORE_MARCELLO_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, MM_PlacedFeatures.ORE_MARCELLO_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, MM_PlacedFeatures.ORE_MARCELLO_LARGE);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, MM_PlacedFeatures.ORE_MARCELLO_NETHER);

        BiomeModifications.addSpawn(BiomeSelectors.all(), MobCategory.MISC, MM_EntityTypes.MARCELLO, 4, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.all(), MobCategory.MISC, MM_EntityTypes.MOLDY, 4, 1, 3);
    }
}
