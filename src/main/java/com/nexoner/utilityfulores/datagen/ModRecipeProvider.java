package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(Items.ENDER_PEARL)
                .group("utilityfulores_compacting")
                .requires(ModItems.ENDER_SHARD.get(),3)
                .unlockedBy("has_ender_shard", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDER_SHARD.get()).build()))
                .save(pFinishedRecipeConsumer);
    }
}
