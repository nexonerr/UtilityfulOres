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
    private static final List<OreConfiguration.TargetBlockState> SPIDER_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.SPIDER_ORE);
    private static final List<OreConfiguration.TargetBlockState> GRACEFUL_MINER_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.GRACEFUL_MINER_ORE);
    private static final List<OreConfiguration.TargetBlockState> SULFURIC_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.SULFURIC_ORE);
    private static final List<OreConfiguration.TargetBlockState> SHARDED_SHULKER_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.SHARDED_SKULKER_ORE);
    private static final List<OreConfiguration.TargetBlockState> GARDENED_ORE_TARGETS = listizeStoneVarientedOre(ModBlocks.GARDENED_ORE);

    public static final BundledConfiguredPlacedFeature ENDER_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.ENDER_ORE_CONFIG, ENDER_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature BLAZE_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.BLAZE_ORE_CONFIG, BLAZE_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature SLIME_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.SLIME_ORE_CONFIG, SLIME_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature BONESTRUCK_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.BONESTRUCK_ORE_CONFIG, BONESTRUCK_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature SPIDER_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.SPIDER_ORE_CONFIG, SPIDER_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature GRACEFUL_MINER_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.GRACEFUL_MINER_ORE_CONFIG, GRACEFUL_MINER_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature SULFURIC_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.SULFURIC_ORE_CONFIG, SULFURIC_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature SHARDED_SHULKER_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.SHARDED_SHULKER_ORE_CONFIG, SHARDED_SHULKER_ORE_TARGETS);
    public static final BundledConfiguredPlacedFeature GARDENED_ORE = new BundledConfiguredPlacedFeature(WorldGenConfig.GARDENED_ORE_CONFIG, GARDENED_ORE_TARGETS);

    public static List<OreConfiguration.TargetBlockState> listizeStoneVarientedOre(StoneVarientedOre stoneVarientedOre){
        return List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, stoneVarientedOre.STONE_VARIENT.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, stoneVarientedOre.DEEPSLATE_VARIENT.get().defaultBlockState()));
    }
}
