/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.handler;

import java.io.File;

import katrix.journeyToGensokyo.reference.ConfigRef;
import katrix.journeyToGensokyo.reference.ModInfo;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration cfg;
	
	public static int entityIdTHFairyIce;
	public static int entityIdTHFairyNether;
	public static int entityIdTHFairyEnd;
	public static int entityIdSunFlowerFairyEnd;
	public static int entityIdFamiliarIce;
	public static int entityIdHellRaven;
	public static int entityIdTenguCrow;
	
	public static boolean newFariesSpawn;
	public static boolean newMobsSpawn;
	public static boolean newBossesSpawn;
	public static boolean fixTHKaguyaSpawn;
	
	public static boolean OresEnabled;
	public static boolean NotesEnabled;
	public static boolean rtyMode;
	
	public static void setConfig(File configFile) {
		
		cfg = new Configuration(configFile);
		loadConfig();
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		
		if (event.modID.equalsIgnoreCase(ModInfo.MODID))
		{
			loadConfig();
		}
	}
	
	public static void loadConfig(){
		
		cfg.addCustomCategoryComment(ConfigRef.CAT_RTY, "Don't change this if you don't know what you are doing");
		
		newFariesSpawn = cfg.get(ConfigRef.CAT_MOBS, "New faries spawn", true, "Can new faries added by JTG spawn?").getBoolean();
		newMobsSpawn = cfg.get(ConfigRef.CAT_MOBS, "New mobs spawn", true, "Can new mobs(mobs that are not faries) added by JTG spawn?").getBoolean();
		newBossesSpawn = cfg.get(ConfigRef.CAT_MOBS, "New bosses spawn", true, "Can new bosses added by JTG spawn?").getBoolean();
		fixTHKaguyaSpawn = cfg.get(ConfigRef.CAT_MOBS, "Spawn biome fixer enabled", true, "Allow Touhou Items Mod bobs to spawn in mod added biomes?").getBoolean();
		
		OresEnabled = cfg.get(ConfigRef.CAT_RTY, "Ore gen enabled", false, "should JTG ores generate?").getBoolean();
		NotesEnabled = cfg.get(ConfigRef.CAT_RTY, "Notes and old spellcards enabled", false, "should gensokyo notes and old spellcards be enabled").getBoolean();
		rtyMode = cfg.get(ConfigRef.CAT_RTY, "RTY Mode", false, "should some RTY specific things be activated?").getBoolean();
		
		entityIdTHFairyIce = cfg.get(ConfigRef.CAT_ENTITYID, "THFairyIce", 700).getInt();
		entityIdFamiliarIce = cfg.get(ConfigRef.CAT_ENTITYID, "FamiliarIce", 701).getInt();
		entityIdHellRaven = cfg.get(ConfigRef.CAT_ENTITYID, "HellRaven", 702).getInt();
		entityIdTenguCrow = cfg.get(ConfigRef.CAT_ENTITYID, "TenguCrow", 703).getInt();
		entityIdTHFairyNether = cfg.get(ConfigRef.CAT_ENTITYID, "THFairyNether", 704).getInt();
		entityIdTHFairyEnd = cfg.get(ConfigRef.CAT_ENTITYID, "THFairyEnd", 705).getInt();
		entityIdSunFlowerFairyEnd = cfg.get(ConfigRef.CAT_ENTITYID, "SunFlowerFairyEnd", 706).getInt();
		
		if (cfg.hasChanged())
		{
			cfg.save();
		}
	}
}
