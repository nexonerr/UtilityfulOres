package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.block.ModBlocks;
import com.nexoner.utilityfulores.block.util.StoneVarientedOre;
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

    public static final TagKey<Block> ORE_ENDER = createTag("forge","ores/ender");
    public static final TagKey<Block> ORE_BLAZE = createTag("forge","ores/blaze");
    public static final TagKey<Block> ORE_SLIME = createTag("forge","ores/slime");
    public static final TagKey<Block> ORE_BONE = createTag("forge","ores/bone");
    public static final TagKey<Block> ORE_SPIDER = createTag("forge","ores/spider");

    @Override
    protected void addTags() {
        tagStoneVarientedOre(ModBlocks.ENDER_ORE,ORE_ENDER);
        tagStoneVarientedOre(ModBlocks.BLAZE_ORE,ORE_BLAZE);
        tagStoneVarientedOre(ModBlocks.SLIME_ORE,ORE_SLIME);
        tagStoneVarientedOre(ModBlocks.BONESTRUCK_ORE,ORE_BONE);
        tagStoneVarientedOre(ModBlocks.SPIDER_ORE,ORE_SPIDER);
        tagStandardOres();
    }

    private void tagStandardOres(){
        //define all standard ores here
        setStandardOres(
                ModBlocks.ENDER_ORE.STONE_VARIENT.get(),
                ModBlocks.ENDER_ORE.DEEPSLATE_VARIENT.get(),
                ModBlocks.BLAZE_ORE.STONE_VARIENT.get(),
                ModBlocks.BLAZE_ORE.DEEPSLATE_VARIENT.get(),
                ModBlocks.SLIME_ORE.STONE_VARIENT.get(),
                ModBlocks.SLIME_ORE.DEEPSLATE_VARIENT.get(),
                ModBlocks.BONESTRUCK_ORE.STONE_VARIENT.get(),
                ModBlocks.BONESTRUCK_ORE.DEEPSLATE_VARIENT.get(),
                ModBlocks.SPIDER_ORE.STONE_VARIENT.get(),
                ModBlocks.SPIDER_ORE.DEEPSLATE_VARIENT.get(),
                ModBlocks.GRACEFUL_MINER_ORE.STONE_VARIENT.get(),
                ModBlocks.GRACEFUL_MINER_ORE.DEEPSLATE_VARIENT.get()
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

    private void tagStoneVarientedOre(StoneVarientedOre stoneVarientedOre, TagKey<Block> tagKey){
        tag(tagKey).add(stoneVarientedOre.STONE_VARIENT.get()).add(stoneVarientedOre.DEEPSLATE_VARIENT.get());
    }
}
