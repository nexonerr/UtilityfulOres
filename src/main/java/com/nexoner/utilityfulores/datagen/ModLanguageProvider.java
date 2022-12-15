package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
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
        translateStoneVarientedOre(ModBlocks.ENDER_ORE,"Ender Ore");
        translateStoneVarientedOre(ModBlocks.BLAZE_ORE, "Blaze Ore");
    }

    private void addCreativeModeTab(CreativeModeTab key, String translation){
        add(key.getDisplayName().getString(), translation);
    }

    private void translateStoneVarientedOre(StoneVarientedOre stoneVarientedOre, String translation){
        add(stoneVarientedOre.STONE_VARIENT.get(),translation);
        add(stoneVarientedOre.DEEPSLATE_VARIENT.get(),"Deepslate " + translation);
    }
}
