package com.nexoner.utilityfulores.block.util;

import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.creative_tab.ModCreativeModeTab;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class StoneVarientedOre {

    public final RegistryObject<OreBlock> STONE_VARIENT;
    public final RegistryObject<OreBlock> DEEPSLATE_VARIENT;

    public StoneVarientedOre(String id, float strengthMultiplier, UniformInt xpDrop) {
        STONE_VARIENT = ModBlocks.registerBlock(id,
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f * strengthMultiplier).requiresCorrectToolForDrops(),xpDrop), ModCreativeModeTab.ORES_TAB);
        DEEPSLATE_VARIENT = ModBlocks.registerBlock("deepslate_" + id,
                () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f * strengthMultiplier).requiresCorrectToolForDrops(),xpDrop), ModCreativeModeTab.ORES_TAB);
    }

    public StoneVarientedOre(String id, float strengthMultiplier, int minExp, int maxExp){
        this(id,strengthMultiplier,UniformInt.of(minExp,maxExp));
    }

    public StoneVarientedOre(String id, int minExp, int maxExp){
        this(id,1f,UniformInt.of(minExp,maxExp));
    }

    public StoneVarientedOre(String id){
        this(id,1f, UniformInt.of(3,5));
    }
}
