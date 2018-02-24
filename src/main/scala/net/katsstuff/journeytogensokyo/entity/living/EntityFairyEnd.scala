/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.data.{MovementData, RotationData}
import net.katsstuff.danmakucore.lib.LibColor
import net.katsstuff.danmakucore.lib.data.LibDanmakuVariants
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.world.World

class EntityFairyEnd(_world: World) extends EntityFairy(_world) {

  {
    val shot = LibDanmakuVariants.LASER.getShotData.copy(edgeColor = LibColor.randomSaturatedColor(), subEntity = ???)
    phaseManager.addPhase(
      JTGPhases.ShapeArrow.instantiate(phaseManager, shot, MovementData.constant(0.4D), RotationData.none, 8, 0.5, 2D)
    )
    phaseManager.currentPhase.init()
  }

}
