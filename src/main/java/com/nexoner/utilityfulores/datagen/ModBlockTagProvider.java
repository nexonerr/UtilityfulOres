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
import java.util.List;

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
    public static final TagKey<Block> ORE_SULFUR = createTag("forge","ores/sulfur");
    public static final TagKey<Block> ORE_SHULKER = createTag("forge","ores/shulker");

    @Override
    protected void addTags() {
        tagStoneVarientedOre(ModBlocks.ENDER_ORE,ORE_ENDER);
        tagStoneVarientedOre(ModBlocks.BLAZE_ORE,ORE_BLAZE);
        tagStoneVarientedOre(ModBlocks.SLIME_ORE,ORE_SLIME);
        tagStoneVarientedOre(ModBlocks.BONESTRUCK_ORE,ORE_BONE);
        tagStoneVarientedOre(ModBlocks.SPIDER_ORE,ORE_SPIDER);
        tagStoneVarientedOre(ModBlocks.SULFURIC_ORE,ORE_SULFUR);
        tagStoneVarientedOre(ModBlocks.SHARDED_SKULKER_ORE,ORE_SHULKER);
        tagStoneVarientedOre(ModBlocks.UNSTABLE_SULFURIC_ORE,ORE_SULFUR);
        tagStandardOres();
    }

    private void tagStandardOres(){
        //define all standard ores here
        setStandardOres(

        );
        setStandardStoneVarientedOres(
                ModBlocks.ENDER_ORE,
                ModBlocks.BLAZE_ORE,
                ModBlocks.SLIME_ORE,
                ModBlocks.BONESTRUCK_ORE,
                ModBlocks.SPIDER_ORE,
                ModBlocks.GRACEFUL_MINER_ORE,
                ModBlocks.SULFURIC_ORE,
                ModBlocks.SHARDED_SKULKER_ORE,
                ModBlocks.GARDENED_ORE,
                ModBlocks.UNSTABLE_SULFURIC_ORE
        );
        for (Block block: standardOres) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
        }
    }

    private void setStandardOres(Block... toAdd){
        standardOres.addAll(Arrays.asList(toAdd));
    }

    private void setStandardStoneVarientedOres(StoneVarientedOre... toAdd){
        List<StoneVarientedOre> list = Arrays.asList(toAdd);

        for (StoneVarientedOre stoneVarientedOre: list){
            standardOres.add(stoneVarientedOre.STONE_VARIENT.get());
            standardOres.add(stoneVarientedOre.DEEPSLATE_VARIENT.get());
        }
    }

    public static TagKey<Block> createTag(String nameSpace, String tag){
        return BlockTags.create(new ResourceLocation(nameSpace,tag));
    }

    private void tagStoneVarientedOre(StoneVarientedOre stoneVarientedOre, TagKey<Block> tagKey){
        tag(tagKey).add(stoneVarientedOre.STONE_VARIENT.get()).add(stoneVarientedOre.DEEPSLATE_VARIENT.get());
    }
}
