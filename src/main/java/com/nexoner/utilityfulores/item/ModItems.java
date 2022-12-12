package com.nexoner.utilityfulores.item;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.creative_tab.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, UtilityfulOres.MOD_ID);

        public static final RegistryObject<Item> ENDER_SHARD = ITEMS.register("ender_shard",
                () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ORES_TAB)));


        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
    }

