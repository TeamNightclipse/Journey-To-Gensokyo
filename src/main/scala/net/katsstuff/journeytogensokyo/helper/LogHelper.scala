/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.helper

import org.apache.logging.log4j.Level

import net.katsstuff.danmakucore.lib.LibMod
import net.minecraftforge.fml.common.FMLLog

object LogHelper {

	private def log(level: Level, obj: Any): Unit = FMLLog.log(LibMod.NAME, level, String.valueOf(obj))

	def all(obj: Any): Unit = log(Level.ALL, obj)
	def debug(obj: Any): Unit = log(Level.DEBUG, obj)
	def error(obj: Any): Unit = log(Level.ERROR, obj)
	def fatal(obj: Any): Unit = log(Level.FATAL, obj)
	def info(obj: Any): Unit = log(Level.INFO, obj)
	def off(obj: Any): Unit = log(Level.OFF, obj)
	def trace(obj: Any): Unit = log(Level.TRACE, obj)
	def warn(obj: Any): Unit = log(Level.WARN, obj)

}
