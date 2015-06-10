package com.katrix.journeyToGensokyo.worldgen;

import com.katrix.journeyToGensokyo.Config;
import com.katrix.journeyToGensokyo.JourneyToGensokyo;

import cpw.mods.fml.common.registry.GameRegistry;

public class JTGWorldGen {
	
	public static void init() {
		
		if(Config.OresEnabled) {
			JourneyToGensokyo.log.info("JTG Ores enabled, this is not a officialy suported feature");
			GameRegistry.registerWorldGenerator(oreGen, 1);
		}
	}

	static OreGen oreGen = new OreGen();
	
}
