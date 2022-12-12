package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
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
    }

    private void registerBlockItems(){
        simpleBlockItem(ModBlocks.ENDER_ORE.get());
        simpleBlockItem(ModBlocks.DEEPSLATE_ENDER_ORE.get());
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
}
