package com.nexoner.utilityfulores.world.gen;

import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
import com.nexoner.utilityfulores.config.WorldGenConfig;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ConfiguredPlacedFeatures {
    private static final List<OreConfiguration.TargetBlockState> ENDER_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.ENDER_ORE);
    private static final List<OreConfiguration.TargetBlockState> BLAZE_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.BLAZE_ORE);
    private static final List<OreConfiguration.TargetBlockState> SLIME_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.SLIME_ORE);
    private static final List<OreConfiguration.TargetBlockState> BONESTRUCK_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.BONESTRUCK_ORE);

    public static final BundledConfiguredPlacedFeature ENDER_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.ENDER_ORE_CONFIG, ENDER_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature BLAZE_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.BLAZE_ORE_CONFIG, BLAZE_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature SLIME_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.SLIME_ORE_CONFIG, SLIME_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature BONESTRUCK_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.BONESTRUCK_ORE_CONFIG, BONESTRUCK_ORE_TARGETS);

    public static List<OreConfiguration.TargetBlockState> listizeStoneVarientedOre(StoneVarientedOre stoneVarientedOre){
        return List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, stoneVarientedOre.STONE_VARIENT.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, stoneVarientedOre.DEEPSLATE_VARIENT.get().defaultBlockState()));
    }
}
