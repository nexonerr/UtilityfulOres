package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.creative_tab.ModCreativeModeTab;
import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, UtilityfulOres.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        Items();
        Blocks();
        addCreativeModeTab(ModCreativeModeTab.ORES_TAB,"Utilityful Ores");
    }

    private void Items(){
        add(ModItems.ENDER_SHARD.get(),"Ender Shard");
    }

    private void Blocks(){
        add(ModBlocks.ENDER_ORE.get(),"Ender Ore");
        add(ModBlocks.DEEPSLATE_ENDER_ORE.get(),"Deepslate Ender Ore");
    }

    private void addCreativeModeTab(CreativeModeTab key, String translation){
        add(key.getDisplayName().getString(), translation);
    }
}
