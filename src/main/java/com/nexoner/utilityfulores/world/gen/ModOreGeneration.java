package com.nexoner.utilityfulores.world.gen;

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

        base.add(ConfiguredPlacedFeatures.ENDER_ORE.PLACED);
        base.add(ConfiguredPlacedFeatures.BLAZE_ORE.PLACED);
        base.add(ConfiguredPlacedFeatures.SLIME_ORE.PLACED);
        base.add(ConfiguredPlacedFeatures.BONESTRUCK_ORE.PLACED);
        base.add(ConfiguredPlacedFeatures.SPIDER_ORE.PLACED);
        base.add(ConfiguredPlacedFeatures.GRACEFUL_MINER_ORE.PLACED);

    }
}
