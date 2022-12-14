package com.nexoner.utilityfulores;

import com.mojang.logging.LogUtils;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.config.BlockPropertyConfig;
import com.nexoner.utilityfulores.config.WorldGenConfig;
import com.nexoner.utilityfulores.item.ModItems;
import com.nexoner.utilityfulores.sound.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.loading.FileUtils;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UtilityfulOres.MOD_ID)
public class UtilityfulOres
{
    public static final String MOD_ID = "utilityfulores";

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public UtilityfulOres()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModSounds.register(eventBus);

        FileUtils.getOrCreateDirectory(FMLPaths.CONFIGDIR.get().resolve(MOD_ID), MOD_ID);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WorldGenConfig.SPEC, MOD_ID + "/world_gen.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BlockPropertyConfig.SPEC, MOD_ID + "/block_properties.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
