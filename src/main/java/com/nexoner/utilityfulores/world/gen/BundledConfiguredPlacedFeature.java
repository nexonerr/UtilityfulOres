package com.nexoner.utilityfulores.world.gen;

import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
import com.nexoner.utilityfulores.config.StandardOreConfig;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * Instead of separate configured and placed features, just do both of them in one class
 */
public class BundledConfiguredPlacedFeature {
    public final Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED;
    public final Holder<PlacedFeature> PLACED;

    public final boolean GENERATE;

    public BundledConfiguredPlacedFeature(String id, List<OreConfiguration.TargetBlockState> targetBlocks, int veinSize, List<PlacementModifier> placementModifier, boolean generate) {
        this.CONFIGURED = FeatureUtils.register(id,
                Feature.ORE, new OreConfiguration(targetBlocks, veinSize));
        this.PLACED = PlacementUtils.register(id + "_placed",
                CONFIGURED, placementModifier);
        this.GENERATE = generate;
    }
    public BundledConfiguredPlacedFeature(String id, List<OreConfiguration.TargetBlockState> targetBlocks, int veinSize, boolean isRare, int maxSpawn, int minSpawn, int spawnRate, boolean generate) {
        this.CONFIGURED = FeatureUtils.register(id,
                Feature.ORE, new OreConfiguration(targetBlocks, veinSize));
        if (!isRare) {
            this.PLACED = PlacementUtils.register(id + "_placed",
                    CONFIGURED, commonOrePlacement(spawnRate, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(minSpawn), VerticalAnchor.absolute(maxSpawn))));
        } else {
            this.PLACED = PlacementUtils.register(id + "_placed",
                    CONFIGURED, rareOrePlacement(spawnRate, // Every x chunks
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(minSpawn), VerticalAnchor.absolute(maxSpawn))));
        }
        this.GENERATE = generate;
    }
    public BundledConfiguredPlacedFeature(StandardOreConfig oreConfig,List<OreConfiguration.TargetBlockState> targetBlocks){
         this(oreConfig.id,targetBlocks,oreConfig.VEIN_SIZE.get(),oreConfig.IS_RARE.get(),oreConfig.SPAWN_MAX.get(),oreConfig.SPAWN_MIN.get(),oreConfig.SPAWN_RATE.get(),oreConfig.GENERATE.get());
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
