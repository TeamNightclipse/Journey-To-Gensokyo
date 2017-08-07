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
import net.katsstuff.danmakucore.entity.living.TouhouSpecies
import net.katsstuff.danmakucore.lib.data.{LibPhases, LibShotData}
import net.minecraft.world.World

class EntityFairyNether(_world: World) extends EntityFairy(_world) {

  {
    val movement = MovementData.constant(0.4D)
    val rotation = RotationData.none

    phaseManager.addPhase(LibPhases.SHAPE_WIDE.instantiate(phaseManager, 8, 30F, 0F, 0D, LibShotData.SHOT_SPHERE_DARK, movement, rotation))
    phaseManager.getCurrentPhase.init()
    setSpecies(TouhouSpecies.FAIRY_HELL)
  }
}
