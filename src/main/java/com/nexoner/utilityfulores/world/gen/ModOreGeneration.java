package com.nexoner.utilityfulores.world.gen;

import com.nexoner.utilityfulores.config.StandardOreConfig;
import com.nexoner.utilityfulores.config.WorldGenConfig;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        if (!WorldGenConfig.GENERATE_ORES.get()) return;

        addWithDependency(ConfiguredPlacedFeatures.ENDER_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.BLAZE_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.SLIME_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.BONESTRUCK_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.SPIDER_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.GRACEFUL_MINER_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.SULFURIC_ORE,base);
        addWithDependency(ConfiguredPlacedFeatures.SHARDED_SHULKER_ORE,base);

    }

    private static void addWithDependency(BundledConfiguredPlacedFeature configuredPlacedFeature, List<Holder<PlacedFeature>> base){
        if (WorldGenConfig.INVERTED_MODE.get() != configuredPlacedFeature.GENERATE){
            base.add(configuredPlacedFeature.PLACED);
        }
    }
}
