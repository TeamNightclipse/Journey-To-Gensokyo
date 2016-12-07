/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.danmaku.DanmakuTemplate
import net.katsstuff.danmakucore.helper.DanmakuHelper
import net.katsstuff.danmakucore.impl.shape.ShapeArrow
import net.katsstuff.danmakucore.lib.data.LibDanmakuVariants
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.world.World

class EntityFairyEnd(world: World) extends EntityFairy(world) {

	{
		val danmaku = DanmakuTemplate.builder().setUser(this).setShot({
			LibDanmakuVariants.LASER.getShotData.copy(
				color = DanmakuHelper.randomSaturatedColor(),
				subEntity = ???
			)
		}).build()
		phaseManager.addPhase(JTGPhases.Shape.instantiate(phaseManager, new ShapeArrow(danmaku, 8, 0.5D, 2D)))
		phaseManager.getCurrentPhase.init()
	}

}
