package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, UtilityfulOres.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerItems();
        registerBlockItems();
    }

    private void registerItems(){
        simpleItem(ModItems.ENDER_SHARD.get());
        simpleItem(ModItems.SULFUR_DUST.get());
        simpleItem(ModItems.SHULKER_SHARD.get());
    }

    private void registerBlockItems(){
        stoneVarientedOreBlockItem(ModBlocks.ENDER_ORE);
        stoneVarientedOreBlockItem(ModBlocks.BLAZE_ORE);
        stoneVarientedOreBlockItem(ModBlocks.SLIME_ORE);
        stoneVarientedOreBlockItem(ModBlocks.BONESTRUCK_ORE);
        stoneVarientedOreBlockItem(ModBlocks.SPIDER_ORE);
        stoneVarientedOreBlockItem(ModBlocks.GRACEFUL_MINER_ORE);
        stoneVarientedOreBlockItem(ModBlocks.SULFURIC_ORE);
        stoneVarientedOreBlockItem(ModBlocks.SHARDED_SKULKER_ORE);
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UtilityfulOres.MOD_ID,"item/" + item.getRegistryName().getPath()));
    }

    private ItemModelBuilder blockItem(Block block) {
        return withExistingParent(block.getRegistryName().getPath(),
                new ResourceLocation(UtilityfulOres.MOD_ID,"block/" + block.getRegistryName().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(Block block) {
        return cubeAll(block.getRegistryName().getPath(), new ResourceLocation(UtilityfulOres.MOD_ID,
                "block/" + block.getRegistryName().getPath()));
    }

    private void stoneVarientedOreBlockItem(StoneVarientedOre stoneVarientedOre){
        simpleBlockItem(stoneVarientedOre.STONE_VARIENT.get());
        simpleBlockItem(stoneVarientedOre.DEEPSLATE_VARIENT.get());
    }
}
