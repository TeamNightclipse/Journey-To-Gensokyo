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

class PhaseShapeType extends PhaseType {

	setRegistryName(LibPhaseName.Shape)

	override def instantiate(phaseManager: PhaseManager): Phase = instantiate(phaseManager, new ShapeEmpty)
	def instantiate(phaseManager: PhaseManager, shape: IShape): Phase = new PhaseShape(phaseManager, shape, this)
}

class PhaseShape(manager: PhaseManager, shape: IShape, phaseType: PhaseShapeType) extends Phase(manager) {

	override def serverUpdate(): Unit = {
		if(counter == 0) {
			val entity = getEntity
			shape.drawForTick(new Vector3(entity), entity.getAngle, 0)
		}
	}

	override protected def getType: PhaseType = phaseType
}
