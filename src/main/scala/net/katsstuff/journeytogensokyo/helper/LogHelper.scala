/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.helper

import org.apache.logging.log4j.{Level, Logger}

object LogHelper {

  private var logger: Logger = _

  private def log(level: Level, obj: Any): Unit = logger.log(level, String.valueOf(obj))

  def assignLog(logger: Logger): Unit = {
    if(this.logger != null) {
      throw new IllegalStateException("Logger already set")
    }
    this.logger = logger
  }

  def all(obj:   Any): Unit = log(Level.ALL, obj)
  def debug(obj: Any): Unit = log(Level.DEBUG, obj)
  def error(obj: Any): Unit = log(Level.ERROR, obj)
  def fatal(obj: Any): Unit = log(Level.FATAL, obj)
  def info(obj:  Any): Unit = log(Level.INFO, obj)
  def off(obj:   Any): Unit = log(Level.OFF, obj)
  def trace(obj: Any): Unit = log(Level.TRACE, obj)
  def warn(obj:  Any): Unit = log(Level.WARN, obj)

}
