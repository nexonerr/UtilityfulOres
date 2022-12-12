package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = UtilityfulOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ModLootTableProvider(generator));
        generator.addProvider(new ModItemModelProvider(generator,existingFileHelper));
        generator.addProvider(new ModBlockStateProvider(generator,existingFileHelper));
        generator.addProvider(new ModLanguageProvider(generator, "en_us"));
        ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(generator,existingFileHelper);
        generator.addProvider(blockTagProvider);
        generator.addProvider(new ModItemTagProvider(generator,blockTagProvider,existingFileHelper));


    }
}
