package com.nexoner.utilityfulores.datagen;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.sound.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundProvider extends SoundDefinitionsProvider {

    protected ModSoundProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UtilityfulOres.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        addStandardSound(ModSounds.MINER_GRACE_BREAK.get());
    }

    private void addStandardSound(SoundEvent soundEvent){
        add(soundEvent, definition()
                .subtitle("sound." + UtilityfulOres.MOD_ID + "." + soundEvent.getLocation().getPath())
                .with(sound(soundEvent.getLocation(), SoundDefinition.SoundType.SOUND))
        );
    }
}
