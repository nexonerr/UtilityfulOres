package com.nexoner.utilityfulores.block.custom;

import com.nexoner.utilityfulores.config.BlockPropertyConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class UnstableSulfuricOre extends OreBlock {
    public UnstableSulfuricOre(Properties pProperties) {
        super(pProperties, UniformInt.of(4,6));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof Player){
            Player player = (Player) pEntity;
            if (pLevel.getRandom().nextInt(3) == 1){
                explode(pLevel,pPos,player);
            }
        }
    }

    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack) {
            if (pLevel.getRandom().nextInt(35) == 1){
                explode(pLevel,pPos,null);
            }
    }

    @Override
    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        explode(pLevel,pPos,null);
    }

    private static void explode(Level pLevel, BlockPos pPos, @Nullable Player pPlayer){
        pLevel.removeBlock(pPos,false);
        pLevel.explode(pPlayer, pPos.getX(), pPos.getY(), pPos.getZ(), BlockPropertyConfig.UNSTABLE_SULFURIC_ORE_EXPLOSION_RADIUS.get(), Explosion.BlockInteraction.BREAK);
    }

}
