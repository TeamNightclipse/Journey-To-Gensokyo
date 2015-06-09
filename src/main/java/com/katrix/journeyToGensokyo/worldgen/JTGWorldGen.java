package com.katrix.journeyToGensokyo.worldgen;

import com.katrix.journeyToGensokyo.Config;

import cpw.mods.fml.common.registry.GameRegistry;

public class JTGWorldGen {
	
	public static void init() {
		
		if(Config.OresEnabled) {
			GameRegistry.registerWorldGenerator(oreGen, 1);
		}
	}

	static OreGen oreGen = new OreGen();
	
}
