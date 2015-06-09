package com.katrix.journeyToGensokyo;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class JTGConfig {
	
	public static int entityIdTHFairyIce;
	public static int entityIdTHFairyNether;
	public static int entityIdFamiliarIce;
	public static int entityIdHellRaven;
	public static int entityIdTenguCrow;
	
	public static boolean rtyOreGen;
	public static boolean rtyOreProcessing;
	public static boolean rtyChestSpawn;
	public static boolean rtyThaumcraftResearch;
	public static boolean rtyMiscRecipes;
	public static boolean rtyTHSCRecipesDisable;

	
	
	public static void setConfig(FMLPreInitializationEvent event) {
		
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			
			cfg.load();
			cfg.addCustomCategoryComment("RTY", "Don't change this if you don't know what you are doing");
			
			rtyOreGen = cfg.get("RTY", "Ore gen enabled", false, "should RTY ores generate?").getBoolean();
			rtyOreProcessing = cfg.get("RTY", "Ore processing enabled", false, "should RTY ore proceessing be enabled?").getBoolean();
			rtyChestSpawn = cfg.get("RTY", "Chest spawns enabled", false, "should RTY specific stuff generate in chests?").getBoolean();
			rtyThaumcraftResearch = cfg.get("RTY", "Thaumcraft Research", false, "should RTY specific Research be enabled?").getBoolean();
			rtyMiscRecipes = cfg.get("RTY", "Misc Recipes", false, "should RTY misc recipes be enabled?").getBoolean();
			rtyTHSCRecipesDisable = cfg.get("RTY", "Disable THSC Recipes", false, "should Touhou Items mod recipes that can be disabled with minetweaker be disabled?").getBoolean();
			
			entityIdTHFairyIce = cfg.get("entityID", "THFairyIce", 700).getInt();
			entityIdFamiliarIce = cfg.get("entityID", "FamiliarIce", 701).getInt();
			entityIdHellRaven = cfg.get("entityID", "HellRaven", 702).getInt();
			entityIdTenguCrow = cfg.get("entityID", "TenguCrow", 703).getInt();
			entityIdTHFairyNether = cfg.get("entityID", "THFairyNether", 704).getInt();
		}
		catch (Exception e)
		{
			FMLLog.severe("Error Message");
		}
		finally
		{
			cfg.save();
		}
		
	}

}
