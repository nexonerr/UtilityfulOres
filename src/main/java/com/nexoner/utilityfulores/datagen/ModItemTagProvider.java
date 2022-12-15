package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, UtilityfulOres.MOD_ID, existingFileHelper);
    }

    public static final TagKey<Item> ORE_ENDER = createTag("forge","ores/ender");
    public static final TagKey<Item> ORE_BLAZE = createTag("forge","ores/blaze");
    public static final TagKey<Item> ORE_SLIME = createTag("forge","ores/slime");
    public static final TagKey<Item> ORE_BONE = createTag("forge","ores/bone");

    @Override
    protected void addTags() {
        copy(ModBlockTagProvider.ORE_ENDER, ORE_ENDER);
        copy(ModBlockTagProvider.ORE_BLAZE, ORE_BLAZE);
        copy(ModBlockTagProvider.ORE_SLIME, ORE_SLIME);
        copy(ModBlockTagProvider.ORE_BONE, ORE_BONE);
    }

    @Override
    public String getName() {
        return "Utilityful Ores Item Tags Provider";
    }

    public static TagKey<Item> createTag(String nameSpace, String tag){
        return ItemTags.create(new ResourceLocation(nameSpace,tag));
    }
}
