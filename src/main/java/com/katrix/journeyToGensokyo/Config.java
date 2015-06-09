package com.katrix.journeyToGensokyo;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static int entityIdTHFairyIce;
	public static int entityIdTHFairyNether;
	public static int entityIdFamiliarIce;
	public static int entityIdHellRaven;
	public static int entityIdTenguCrow;
	
	public static boolean OresEnabled;
	public static boolean NotesEnabled;
	public static boolean rtyMode;

	
	
	public static void setConfig(FMLPreInitializationEvent event) {
		
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			
			cfg.load();
			cfg.addCustomCategoryComment("RTY", "Don't change this if you don't know what you are doing");
			
			OresEnabled = cfg.get("RTY", "Ore gen enabled", false, "should JTG ores generate?").getBoolean();
			NotesEnabled = cfg.get("RTY", "Notes and old spellcards enabled", false, "should gensokyo notes and old spellcards be enabled").getBoolean();
			rtyMode = cfg.get("RTY", "RTY Mode", false, "should some RTY specific things be activated?").getBoolean();
			
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
