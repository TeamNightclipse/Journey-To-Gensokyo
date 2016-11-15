/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */

/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import net.katsstuff.danmakucore.data.Vector3
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.impl.shape.ShapeEmpty
import net.katsstuff.danmakucore.shape.IShape
import net.katsstuff.journeytogensokyo.helper.Implicits._
import net.katsstuff.journeytogensokyo.lib.LibPhaseName

class PhaseShapeContinuousType extends PhaseType {

	setRegistryName(LibPhaseName.ShapeContinuous)

	override def instantiate(phaseManager: PhaseManager): Phase = instantiate(phaseManager, new ShapeEmpty)
	def instantiate(phaseManager: PhaseManager, shape: IShape): Phase = new PhaseShapeContinuous(phaseManager, shape, this)
}

class PhaseShapeContinuous(manager: PhaseManager, shape: IShape, phaseType: PhaseShapeContinuousType) extends Phase(manager) {

	override def init(): Unit = {
		super.init()
		counter = 0
		interval = 99999
	}

	override def serverUpdate(): Unit = {
		super.serverUpdate()
		val entity = getEntity
		val done = shape.drawForTick(new Vector3(entity), entity.getAngle, counter)

		if(done.getFirst) {
			counter = 0
		}
	}

	override protected def getType: PhaseType = phaseType
}
