package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, UtilityfulOres.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerStoneVarientedOreModels(ModBlocks.ENDER_ORE);
        registerStoneVarientedOreModels(ModBlocks.BLAZE_ORE);
    }

    private void registerStoneVarientedOreModels(StoneVarientedOre stoneVarientedOre){
        simpleBlock(stoneVarientedOre.STONE_VARIENT.get());
        simpleBlock(stoneVarientedOre.DEEPSLATE_VARIENT.get());
    }
}