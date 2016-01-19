/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.util;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import katrix.journeyToGensokyo.lib.LibMod;

public class LogHelper {

	public static void log(Level logLevel, Object obj) {
		FMLLog.log(LibMod.NAME, logLevel, String.valueOf(obj));
	}

	public static void all(Object obj) {
		log(Level.ALL, obj);
	}

	public static void debug(Object obj) {
		log(Level.DEBUG, obj);
	}

	public static void error(Object obj) {
		log(Level.ERROR, obj);
	}

	public static void fatal(Object obj) {
		log(Level.FATAL, obj);
	}

	public static void info(Object obj) {
		log(Level.INFO, obj);
	}

	public static void off(Object obj) {
		log(Level.OFF, obj);
	}

	public static void trace(Object obj) {
		log(Level.TRACE, obj);
	}

	public static void warn(Object obj) {
		log(Level.WARN, obj);
	}
}
