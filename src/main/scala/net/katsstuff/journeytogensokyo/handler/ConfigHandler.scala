/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.handler

import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraftforge.common.config.Config
import net.minecraftforge.common.config.Config.Comment

@Config(modid = LibMod.Id)
class ConfigHandler {

	ConfigHandler.entry = this

	@Comment(Array("The spawn rate of mobs percentage"))
	var spawnRate = 30
}
object ConfigHandler {

	//Super hacky, but meh
	var entry: ConfigHandler = _
}
