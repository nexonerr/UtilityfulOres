package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();

    @Override
    protected void addTables() {
        this.add(ModBlocks.ENDER_ORE.STONE_VARIENT.get(), (block) -> createOreDrop(ModBlocks.ENDER_ORE.STONE_VARIENT.get(), ModItems.ENDER_SHARD.get()));
        this.add(ModBlocks.ENDER_ORE.DEEPSLATE_VARIENT.get(), (block) -> createOreDrop(ModBlocks.ENDER_ORE.DEEPSLATE_VARIENT.get(), ModItems.ENDER_SHARD.get()));

        createAmplifiedDustDrop(ModBlocks.BLAZE_ORE.STONE_VARIENT.get(), Items.BLAZE_POWDER,Items.BLAZE_ROD);
        createAmplifiedDustDrop(ModBlocks.BLAZE_ORE.DEEPSLATE_VARIENT.get(), Items.BLAZE_POWDER,Items.BLAZE_ROD);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    private void createAmplifiedDustDrop(Block pBlock, ItemLike pItem, ItemLike pItemAlt) {
        this.add(pBlock, applyExplosionDecay(pBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f,3.0f))
                        .add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,2.0f))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(2))
                        .add(LootItem.lootTableItem(pItemAlt).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(1)).when(HAS_NO_SILK_TOUCH)
                )
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock)).when(HAS_SILK_TOUCH))
        ));
    }


}
