package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class ModBlockTagProvider extends BlockTagsProvider {

    private ArrayList<Block> standardOres = new ArrayList<>();

    public ModBlockTagProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, UtilityfulOres.MOD_ID, existingFileHelper);
    }

    public static final TagKey<Block> ENDER_ORE = createTag("forge","ores/ender");

    @Override
    protected void addTags() {
        tag(ENDER_ORE).add(ModBlocks.DEEPSLATE_ENDER_ORE.get(),ModBlocks.ENDER_ORE.get());
        tagStandardOres();
    }

    private void tagStandardOres(){
        //define all standard ores here
        setStandardOres(
                ModBlocks.ENDER_ORE.get(),
                ModBlocks.DEEPSLATE_ENDER_ORE.get()
        );
        for (Block block: standardOres) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
        }
    }

    private void setStandardOres(Block... toAdd){
        standardOres.addAll(Arrays.asList(toAdd));
    }

    public static TagKey<Block> createTag(String nameSpace, String tag){
        return BlockTags.create(new ResourceLocation(nameSpace,tag));
    }
}
