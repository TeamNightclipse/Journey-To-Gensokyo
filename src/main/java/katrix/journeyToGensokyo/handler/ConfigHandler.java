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

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import katrix.journeyToGensokyo.reference.ConfigRef;
import katrix.journeyToGensokyo.reference.ModInfo;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static Configuration cfg;

	public static boolean newFariesSpawn;
	public static boolean newMobsSpawn;
	public static boolean newBossesSpawn;
	public static boolean fixTHKaguyaSpawn;

	public static boolean OresEnabled;
	public static boolean NotesEnabled;
	public static boolean rtyMode;

	public static boolean newHealthBar;

	public static void setConfig(File configFile) {

		cfg = new Configuration(configFile);
		loadConfig();
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

		if (event.modID.equalsIgnoreCase(ModInfo.MODID)) {
			loadConfig();
		}
	}

	public static void loadConfig() {

		cfg.addCustomCategoryComment(ConfigRef.RTY, "Don't change this if you don't know what you are doing");

		newFariesSpawn = cfg.get(ConfigRef.MOBS, "New faries spawn", true, "Can new faries added by JTG spawn?").getBoolean();
		newMobsSpawn = cfg.get(ConfigRef.MOBS, "New mobs spawn", true, "Can new mobs(mobs that are not faries) added by JTG spawn?").getBoolean();
		newBossesSpawn = cfg.get(ConfigRef.MOBS, "New bosses spawn", true, "Can new bosses added by JTG spawn?").getBoolean();
		fixTHKaguyaSpawn = cfg.get(ConfigRef.MOBS, "Spawn biome fixer enabled", true, "Allow Touhou Items Mod bobs to spawn in mod added biomes?").getBoolean();
		newHealthBar = cfg.get(ConfigRef.MISC, "New Healthbar", true, "Use the new health bar for bosses? Setting this to false will use the old health bar")
				.getBoolean();

		OresEnabled = cfg.get(ConfigRef.RTY, "Ore gen enabled", false, "should JTG ores generate?").getBoolean();
		NotesEnabled = cfg.get(ConfigRef.RTY, "Notes and old spellcards enabled", false, "should gensokyo notes and old spellcards be enabled").getBoolean();
		rtyMode = cfg.get(ConfigRef.RTY, "RTY Mode", false, "should some RTY specific things be activated?").getBoolean();

		if (cfg.hasChanged()) {
			cfg.save();
		}
	}
}
