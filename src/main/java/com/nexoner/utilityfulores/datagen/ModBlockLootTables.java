package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.add(ModBlocks.ENDER_ORE.get(), (block) -> createOreDrop(ModBlocks.ENDER_ORE.get(), ModItems.ENDER_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_ENDER_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_ENDER_ORE.get(), ModItems.ENDER_SHARD.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
