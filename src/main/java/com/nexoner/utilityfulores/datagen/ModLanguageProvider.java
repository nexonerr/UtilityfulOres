package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
import com.nexoner.utilityfulores.creative_tab.ModCreativeModeTab;
import com.nexoner.utilityfulores.item.ModItems;
import com.nexoner.utilityfulores.sound.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.sounds.SoundEvent;
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
        addSound(ModSounds.MINER_GRACE_BREAK.get(),"Graceful Miner's Ore is activated");
    }

    private void Items(){
        add(ModItems.ENDER_SHARD.get(),"Ender Shard");
        add(ModItems.SULFUR_DUST.get(),"Sulfur Dust");
        add(ModItems.SHULKER_SHARD.get(),"Shulker Shard");
    }

    private void Blocks(){
        translateStoneVarientedOre(ModBlocks.ENDER_ORE,"Ender Ore");
        translateStoneVarientedOre(ModBlocks.BLAZE_ORE, "Blaze Ore");
        translateStoneVarientedOre(ModBlocks.SLIME_ORE, "Slime Ore");
        translateStoneVarientedOre(ModBlocks.BONESTRUCK_ORE, "Bonestruck Ore");
        translateStoneVarientedOre(ModBlocks.SPIDER_ORE, "Spider Ore");
        translateStoneVarientedOre(ModBlocks.GRACEFUL_MINER_ORE, "Graceful Miner's Ore");
        translateStoneVarientedOre(ModBlocks.SULFURIC_ORE, "Sulfuric Ore");
        translateStoneVarientedOre(ModBlocks.SHARDED_SKULKER_ORE, "Sharded Shulker Ore");
        translateStoneVarientedOre(ModBlocks.GARDENED_ORE, "Gardened Ore");
        translateStoneVarientedOre(ModBlocks.UNSTABLE_SULFURIC_ORE, "Unstable Sulfuric Ore");
    }

    private void addCreativeModeTab(CreativeModeTab key, String translation){
        add(key.getDisplayName().getString(), translation);
    }

    private void translateStoneVarientedOre(StoneVarientedOre stoneVarientedOre, String translation){
        add(stoneVarientedOre.STONE_VARIENT.get(),translation);
        add(stoneVarientedOre.DEEPSLATE_VARIENT.get(),"Deepslate " + translation);
    }

    private void addSound(SoundEvent key, String translation){
        add("sound." + UtilityfulOres.MOD_ID + "." + key.getLocation().getPath(),translation);
    }
}
