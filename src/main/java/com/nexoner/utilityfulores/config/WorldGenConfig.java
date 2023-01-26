package com.nexoner.utilityfulores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorldGenConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue GENERATE_ORES;
    public static final ForgeConfigSpec.BooleanValue INVERTED_MODE;

    public static final StandardOreConfig ENDER_ORE_CONFIG;
    public static final StandardOreConfig BLAZE_ORE_CONFIG;
    public static final StandardOreConfig SLIME_ORE_CONFIG;
    public static final StandardOreConfig BONESTRUCK_ORE_CONFIG;
    public static final StandardOreConfig SPIDER_ORE_CONFIG;
    public static final StandardOreConfig GRACEFUL_MINER_ORE_CONFIG;
    public static final StandardOreConfig SULFURIC_ORE_CONFIG;
    public static final StandardOreConfig SHARDED_SHULKER_ORE_CONFIG;
    public static final StandardOreConfig GARDENED_ORE_CONFIG;



    static {
        BUILDER.push("Utilityful Ores Worldgen Configs");

        GENERATE_ORES = BUILDER.comment("Defines whether ores should be generated or not").define("generate_ores",true);
        INVERTED_MODE = BUILDER.comment("If true, all generation clauses will be inverted, which means that ores will generate if their 'generate' clause is false. Use this if you want to enable ores instead of disabling them")
                .define("inverted_mode",false);

        ENDER_ORE_CONFIG = new StandardOreConfig(6,3,-15,40,false,BUILDER,"ender_ore");
        BLAZE_ORE_CONFIG = new StandardOreConfig(7,4,-50,10,false,BUILDER,"blaze_ore");
        SLIME_ORE_CONFIG = new StandardOreConfig(5,9,-5,70,false,BUILDER,"slime_ore");
        BONESTRUCK_ORE_CONFIG = new StandardOreConfig(6,10,-15,100,false,BUILDER,"bonestruck_ore");
        SPIDER_ORE_CONFIG = new StandardOreConfig(6,8,-20,90,false,BUILDER,"spider_ore");
        GRACEFUL_MINER_ORE_CONFIG = new StandardOreConfig(3,2,-45,15,false,BUILDER,"graceful_miner_ore");
        SULFURIC_ORE_CONFIG = new StandardOreConfig(15,4,-20,35,false,BUILDER,"sulfuric_ore");
        SHARDED_SHULKER_ORE_CONFIG = new StandardOreConfig(3,2,-50,30,false,BUILDER,"sharded_shulker_ore");
        GARDENED_ORE_CONFIG = new StandardOreConfig(5,10,-15,60,false,BUILDER,"gardened_ore");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
