package com.nexoner.utilityfulores.world;

import com.nexoner.utilityfulores.UtilityfulOres;
import com.nexoner.utilityfulores.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UtilityfulOres.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent

    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ModOreGeneration.generateOres(event);
    }
}
