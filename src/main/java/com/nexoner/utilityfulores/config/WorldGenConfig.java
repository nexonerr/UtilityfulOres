package com.nexoner.utilityfulores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorldGenConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final StandardOreConfig ENDER_ORE_CONFIG;
    public static final StandardOreConfig BLAZE_ORE_CONFIG;

    static {
        BUILDER.push("Utilityful Ores Worldgen Configs");

        ENDER_ORE_CONFIG = new StandardOreConfig(6,3,-15,40,false,BUILDER,"ender_ore");
        BLAZE_ORE_CONFIG = new StandardOreConfig(7,4,-50,10,false,BUILDER,"blaze_ore");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
