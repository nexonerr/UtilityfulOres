package com.nexoner.utilityfulores.creative_tab;

import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ORES_TAB = new CreativeModeTab("utilityfulorestab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ENDER_SHARD.get());
        }
    };
}
