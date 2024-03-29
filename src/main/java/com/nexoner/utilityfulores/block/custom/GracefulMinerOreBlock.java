package com.nexoner.utilityfulores.block.custom;

import com.nexoner.utilityfulores.config.BlockPropertyConfig;
import com.nexoner.utilityfulores.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import java.util.HashMap;
import java.util.Map;

public class GracefulMinerOreBlock extends OreBlock {
    public GracefulMinerOreBlock(Properties pProperties) {
        super(pProperties, UniformInt.of(4,6));
    }


    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        if (!EnchantmentHelper.getEnchantments(player.getMainHandItem()).containsKey(Enchantments.SILK_TOUCH)) {
            if (!level.isClientSide) {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, (int) (Math.random() * 20 * BlockPropertyConfig.GRACEFUL_MINER_HASTE_TIME.get()), 0));
            } else {
                level.playSound(player, player.getOnPos(), ModSounds.MINER_GRACE_BREAK.get(), SoundSource.BLOCKS, 1f, 1f);
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
