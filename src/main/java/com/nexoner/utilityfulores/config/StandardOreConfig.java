package com.nexoner.utilityfulores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class StandardOreConfig {
    public final ForgeConfigSpec.ConfigValue<Integer> VEIN_SIZE;
    public final ForgeConfigSpec.ConfigValue<Integer> SPAWN_RATE;
    public final ForgeConfigSpec.ConfigValue<Integer> SPAWN_MIN;
    public final ForgeConfigSpec.ConfigValue<Integer> SPAWN_MAX;
    public final ForgeConfigSpec.ConfigValue<Boolean> IS_RARE;

    public final String id;

    /**
     * @param id This is also used in worldgen, don't use '_config' or stg like that, just put the ore id
     */
    public StandardOreConfig(int veinSize, int spawnRate, int spawnMin, int spawnMax, boolean isRare, ForgeConfigSpec.Builder builder, String id) {
        builder.push(id);
            VEIN_SIZE = builder.comment("Size of the veins for " + id).define(id + "_vein_size",veinSize);
            SPAWN_RATE = builder.comment("Spawn rate for " + id + " DON'T SET TOO HIGH").define(id + "_spawn_rate",spawnRate);
            SPAWN_MIN = builder.comment("Minimum spawn height for " + id).defineInRange(id + "_spawn_min",spawnMin,-64,320);
            SPAWN_MAX = builder.comment("Maximum spawn height for " + id).defineInRange(id + "_spawn_max",spawnMax,-64,320);
            IS_RARE = builder.comment("Defines if " + id + " is a rare ore or not, if rare, the spawn rate will define per how many chunks the ore will generate, if not, the amount of veins in a chunk")
                    .define(id + "_is_rare",isRare);
        builder.pop();

        this.id = id;
    }
}
