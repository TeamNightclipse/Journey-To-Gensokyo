package com.katrix.journeyToGensokyo.worldgen;

import com.katrix.journeyToGensokyo.handler.ConfigHandler;
import com.katrix.journeyToGensokyo.util.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class JTGWorldGen {
	
	public static void init() {
		
		if(ConfigHandler.OresEnabled) {
			LogHelper.warn("JTG Ores enabled, this is not a officialy suported feature");
			GameRegistry.registerWorldGenerator(oreGen, 1);
		}
	}

	static OreGen oreGen = new OreGen();
	
}
