package com.nexoner.utilityfulores.block;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.custom.GracefulMinerOreBlock;
import com.nexoner.utilityfulores.block.custom.UnstableSulfuricOre;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
import com.nexoner.utilityfulores.creative_tab.ModCreativeModeTab;
import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UtilityfulOres.MOD_ID);

    public static final StoneVarientedOre ENDER_ORE = new StoneVarientedOre("ender_ore");

    public static final StoneVarientedOre BLAZE_ORE = new StoneVarientedOre("blaze_ore");

    public static final StoneVarientedOre SLIME_ORE = new StoneVarientedOre("slime_ore",2,4);

    public static final StoneVarientedOre BONESTRUCK_ORE = new StoneVarientedOre("bonestruck_ore",2,4);

    public static final StoneVarientedOre SPIDER_ORE = new StoneVarientedOre("spider_ore",2,4);

    public static final StoneVarientedOre SULFURIC_ORE = new StoneVarientedOre("sulfuric_ore",1,4);

    public static final StoneVarientedOre SHARDED_SKULKER_ORE = new StoneVarientedOre("sharded_shulker_ore",3,6);

    public static final StoneVarientedOre GARDENED_ORE = new StoneVarientedOre("gardened_ore",2,4);

    public static final StoneVarientedOre GRACEFUL_MINER_ORE = new StoneVarientedOre(
            ModBlocks.registerBlock("graceful_miner_ore", () -> new GracefulMinerOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB),
            ModBlocks.registerBlock("deepslate_graceful_miner_ore", () -> new GracefulMinerOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB)
            );

    public static final StoneVarientedOre UNSTABLE_SULFURIC_ORE = new StoneVarientedOre(
            ModBlocks.registerBlock("unstable_sulfuric_ore", () -> new UnstableSulfuricOre(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB),
            ModBlocks.registerBlock("deepslate_unstable_sulfuric_ore", () -> new UnstableSulfuricOre(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB)
    );


    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
