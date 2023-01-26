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
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
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

        this.add(ModBlocks.BLAZE_ORE.STONE_VARIENT.get(), (block) -> createAmplifiedDustDrop(ModBlocks.BLAZE_ORE.STONE_VARIENT.get(), Items.BLAZE_POWDER,Items.BLAZE_ROD));
        this.add(ModBlocks.BLAZE_ORE.DEEPSLATE_VARIENT.get(), (block) -> createAmplifiedDustDrop(ModBlocks.BLAZE_ORE.DEEPSLATE_VARIENT.get(), Items.BLAZE_POWDER,Items.BLAZE_ROD));

        this.add(ModBlocks.SLIME_ORE.STONE_VARIENT.get(), (block) -> createMultipliedOreDrop(ModBlocks.SLIME_ORE.STONE_VARIENT.get(), Items.SLIME_BALL,2.0f,2.0f));
        this.add(ModBlocks.SLIME_ORE.DEEPSLATE_VARIENT.get(), (block) -> createMultipliedOreDrop(ModBlocks.SLIME_ORE.DEEPSLATE_VARIENT.get(), Items.SLIME_BALL,2.0f,2.0f));

        this.add(ModBlocks.BONESTRUCK_ORE.STONE_VARIENT.get(), (block) -> createMultipliedOreDrop(ModBlocks.BONESTRUCK_ORE.STONE_VARIENT.get(), Items.BONE,1.0f,3.0f));
        this.add(ModBlocks.BONESTRUCK_ORE.DEEPSLATE_VARIENT.get(), (block) -> createMultipliedOreDrop(ModBlocks.BONESTRUCK_ORE.DEEPSLATE_VARIENT.get(), Items.BONE,1.0f,3.0f));

        this.add(ModBlocks.SPIDER_ORE.STONE_VARIENT.get(), (block) -> createAmplifiedDustDrop(ModBlocks.SPIDER_ORE.STONE_VARIENT.get(), Items.STRING,Items.SPIDER_EYE));
        this.add(ModBlocks.SPIDER_ORE.DEEPSLATE_VARIENT.get(), (block) -> createAmplifiedDustDrop(ModBlocks.SPIDER_ORE.DEEPSLATE_VARIENT.get(), Items.STRING,Items.SPIDER_EYE));

        this.add(ModBlocks.SULFURIC_ORE.STONE_VARIENT.get(), (block) -> createAmplifiedDustDrop(ModBlocks.SULFURIC_ORE.STONE_VARIENT.get(), ModItems.SULFUR_DUST.get(),Items.GUNPOWDER));
        this.add(ModBlocks.SULFURIC_ORE.DEEPSLATE_VARIENT.get(), (block) -> createAmplifiedDustDrop(ModBlocks.SULFURIC_ORE.DEEPSLATE_VARIENT.get(), ModItems.SULFUR_DUST.get(),Items.GUNPOWDER));

        this.add(ModBlocks.SHARDED_SKULKER_ORE.STONE_VARIENT.get(), (block) -> createOreDrop(ModBlocks.SHARDED_SKULKER_ORE.STONE_VARIENT.get(), ModItems.SHULKER_SHARD.get()));
        this.add(ModBlocks.SHARDED_SKULKER_ORE.DEEPSLATE_VARIENT.get(), (block) -> createOreDrop(ModBlocks.SHARDED_SKULKER_ORE.DEEPSLATE_VARIENT.get(), ModItems.SHULKER_SHARD.get()));

        this.add(ModBlocks.GRACEFUL_MINER_ORE.STONE_VARIENT.get(), applyExplosionDecay(ModBlocks.GRACEFUL_MINER_ORE.STONE_VARIENT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f,2.0f)).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .add(LootItem.lootTableItem(Items.DIAMOND_PICKAXE).apply(new EnchantRandomlyFunction.Builder().withEnchantment(Enchantments.BLOCK_FORTUNE).withEnchantment(Enchantments.BLOCK_EFFICIENCY)).setWeight(1))
                        .add(LootItem.lootTableItem(Items.IRON_PICKAXE).apply(new EnchantRandomlyFunction.Builder().withEnchantment(Enchantments.BLOCK_FORTUNE).withEnchantment(Enchantments.BLOCK_EFFICIENCY)).setWeight(3))
                        .add(LootItem.lootTableItem(Items.STONE_PICKAXE).apply(new EnchantRandomlyFunction.Builder().withEnchantment(Enchantments.BLOCK_FORTUNE).withEnchantment(Enchantments.BLOCK_EFFICIENCY)).setWeight(5))
                        .add(LootItem.lootTableItem(Items.OBSIDIAN).apply(SetItemCountFunction.setCount(UniformGenerator.between(2f,10f))).setWeight(5))
                        .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(32f,64f))).setWeight(6)).when(HAS_NO_SILK_TOUCH)
                )
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModBlocks.GRACEFUL_MINER_ORE.STONE_VARIENT.get())).when(HAS_SILK_TOUCH))
        ));

        this.add(ModBlocks.GRACEFUL_MINER_ORE.DEEPSLATE_VARIENT.get(), applyExplosionDecay(ModBlocks.GRACEFUL_MINER_ORE.DEEPSLATE_VARIENT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f,2.0f)).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .add(LootItem.lootTableItem(Items.DIAMOND_PICKAXE).apply(new EnchantRandomlyFunction.Builder().withEnchantment(Enchantments.BLOCK_FORTUNE).withEnchantment(Enchantments.BLOCK_EFFICIENCY)).setWeight(1))
                        .add(LootItem.lootTableItem(Items.IRON_PICKAXE).apply(new EnchantRandomlyFunction.Builder().withEnchantment(Enchantments.BLOCK_FORTUNE).withEnchantment(Enchantments.BLOCK_EFFICIENCY)).setWeight(3))
                        .add(LootItem.lootTableItem(Items.STONE_PICKAXE).apply(new EnchantRandomlyFunction.Builder().withEnchantment(Enchantments.BLOCK_FORTUNE).withEnchantment(Enchantments.BLOCK_EFFICIENCY)).setWeight(5))
                        .add(LootItem.lootTableItem(Items.OBSIDIAN).apply(SetItemCountFunction.setCount(UniformGenerator.between(2f,10f))).setWeight(5))
                        .add(LootItem.lootTableItem(Items.TORCH).apply(SetItemCountFunction.setCount(UniformGenerator.between(32f,64f))).setWeight(6)).when(HAS_NO_SILK_TOUCH)
                )
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModBlocks.GRACEFUL_MINER_ORE.DEEPSLATE_VARIENT.get())).when(HAS_SILK_TOUCH))
        ));

        this.add(ModBlocks.GARDENED_ORE.STONE_VARIENT.get(), applyExplosionDecay(ModBlocks.GARDENED_ORE.STONE_VARIENT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f,4.0f)).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .add(LootItem.lootTableItem(Items.OAK_SAPLING).apply(SetItemCountFunction.setCount(UniformGenerator.between(3f,12f))).setWeight(1))
                        .add(LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1f,4f))).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MELON).apply(SetItemCountFunction.setCount(UniformGenerator.between(5f,15f))).setWeight(2))
                        .add(LootItem.lootTableItem(Items.OAK_LOG).apply(SetItemCountFunction.setCount(UniformGenerator.between(10f,20f))).setWeight(3))
                        .add(LootItem.lootTableItem(Items.MOSS_BLOCK).apply(SetItemCountFunction.setCount(UniformGenerator.between(3f,12f))).setWeight(1)).when(HAS_NO_SILK_TOUCH)
                )
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModBlocks.GARDENED_ORE.STONE_VARIENT.get())).when(HAS_SILK_TOUCH))
        ));

        this.add(ModBlocks.GARDENED_ORE.DEEPSLATE_VARIENT.get(), applyExplosionDecay(ModBlocks.GARDENED_ORE.DEEPSLATE_VARIENT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f,4.0f)).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .add(LootItem.lootTableItem(Items.OAK_SAPLING).apply(SetItemCountFunction.setCount(UniformGenerator.between(3f,12f))).setWeight(1))
                        .add(LootItem.lootTableItem(Items.PUMPKIN_SEEDS).apply(SetItemCountFunction.setCount(UniformGenerator.between(1f,4f))).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MELON).apply(SetItemCountFunction.setCount(UniformGenerator.between(5f,15f))).setWeight(2))
                        .add(LootItem.lootTableItem(Items.OAK_LOG).apply(SetItemCountFunction.setCount(UniformGenerator.between(10f,20f))).setWeight(3))
                        .add(LootItem.lootTableItem(Items.MOSS_BLOCK).apply(SetItemCountFunction.setCount(UniformGenerator.between(3f,12f))).setWeight(1)).when(HAS_NO_SILK_TOUCH)
                )
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModBlocks.GARDENED_ORE.DEEPSLATE_VARIENT.get())).when(HAS_SILK_TOUCH))
        ));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    //Method
    private LootTable.Builder createAmplifiedDustDrop(Block pBlock, ItemLike pItem, ItemLike pItemAlt) {
        return applyExplosionDecay(pBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f,3.0f))
                        .add(LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,2.0f))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(2))
                        .add(LootItem.lootTableItem(pItemAlt).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(1)).when(HAS_NO_SILK_TOUCH)
                )
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock)).when(HAS_SILK_TOUCH))
        );
    }



    private LootTable.Builder createMultipliedOreDrop(Block pBlock, ItemLike pItem, float min, float max){
        return createSilkTouchDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(min,max))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


}
