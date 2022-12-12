package com.nexoner.utilityfulores.world.gen;

import com.nexoner.utilityfulores.block.ModBlocks;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ConfiguredPlacedFeatures {
    private static final List<OreConfiguration.TargetBlockState> ENDER_ORE_TARGETS = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ENDER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ENDER_ORE.get().defaultBlockState()));

    public static final BundledConfiguredPlacedFeature ENDER_ORE = new BundledConfiguredPlacedFeature("ender_ore", ENDER_ORE_TARGETS, 6, false, 30, -30, 100);
}
