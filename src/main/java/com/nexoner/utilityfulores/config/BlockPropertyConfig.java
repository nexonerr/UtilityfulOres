package com.nexoner.utilityfulores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BlockPropertyConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> GRACEFUL_MINER_HASTE_TIME;
    public static final ForgeConfigSpec.ConfigValue<Float> UNSTABLE_SULFURIC_ORE_EXPLOSION_RADIUS;

    static {
        BUILDER.push("Utilityful Ores Block Property Configs");

        BUILDER.push("graceful_miner_ore");
        GRACEFUL_MINER_HASTE_TIME = BUILDER.comment("The maximum amount of time that haste will be given for when the Graceful Miner's Ore is broken, in seconds").define("graceful_miner_haste_time", 300);
        BUILDER.pop();

        BUILDER.push("unstable_sulfuric_ore");
        UNSTABLE_SULFURIC_ORE_EXPLOSION_RADIUS = BUILDER.comment("The radius for the explosion of the unstable sulfuric ore").define("unstable_sulfuric_ore_explosion_radius", 4.0F);
        BUILDER.pop();

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
