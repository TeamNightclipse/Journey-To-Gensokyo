package net.katsstuff.journeytogensokyo.spellcard

import net.katsstuff.journeytogensokyo.lib.LibSpellcardName
import net.katsstuff.teamnightclipse.danmakucore.{DanmakuCore, EnumDanmakuLevel}
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.{EntitySpellcard, Spellcard, SpellcardEntity}
import net.katsstuff.teamnightclipse.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.{DanmakuCreationHelper, DanmakuHelper}
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLivingBase

class SpellcardMoonlightRay extends Spellcard(LibSpellcardName.MoonlightRay) {
  override def instantiate(card: EntitySpellcard, target: Option[EntityLivingBase]): SpellcardEntity =
    new SpellcardEntityMoonlightRay(this, card, target)

  override def level: Int = 1

  override def removeTime: Int = 50

  override def endTime: Int = 80

  override def touhouUser: TouhouCharacter = TouhouCharacter.RUMIA
}
class SpellcardEntityMoonlightRay(
    spellcard: Spellcard,
    card: EntitySpellcard,
    target: Option[EntityLivingBase]
) extends SpellcardEntity(spellcard, card, target) {
  override def onSpellcardUpdate(): Unit = {
    if (time == 1) {
      val endTime     = 75
      val rotatedAway = 50
      // Increment rotate every tick by the given angle,
      // until we are 15 degrees away from hitting the target
      val rotateIncrement = rotatedAway / (endTime + 15).toFloat

      val laser = DanmakuTemplate.builder
        .setUser(user)
        .setSource(cardEntity)
        .setMovementData(0)
        .setShot(LibShotData.SHOT_LASER.copy(edgeColor = LibColor.COLOR_SATURATED_BLUE, delay = 5, end = endTime))

      val forward    = directionUserToTarget.getOrElse(Vector3.directionEntity(user))
      val userOrient = Quat.orientationOfVec(forward)

      val rotAway1 = Quat.fromEuler(rotatedAway, 0F, 0F)
      val rotAway2 = Quat.fromEuler(-rotatedAway, 0F, 0F)

      val orient1 = userOrient * rotAway1
      val orient2 = userOrient * rotAway2

      val dir1 = orient1 * Vector3.Forward
      val dir2 = orient2 * Vector3.Forward

      val pivot =
        Vector3.Backward * (laser.shot.sizeZ / 2) +
          Vector3.Up * (laser.shot.sizeY / 2) +
          Vector3.Right * (laser.shot.sizeX * 1.3)

      val dan1 = laser
        .setPos(posCard.offset(dir1, 8F))
        .setDirection(dir1)
        .setOrientation(orient1)
        .setRotationData(orient1 * Vector3.Up, rotateIncrement, 9999, pivot)
        .build
        .asEntity
      val dan2 = laser
        .setPos(posCard.offset(dir2, 8F))
        .setDirection(dir2)
        .setOrientation(orient2)
        .setRotationData(orient2 * Vector3.Up, -rotateIncrement, 9999, pivot)
        .build
        .asEntity
      DanmakuCore.spawnDanmaku(Seq(dan1, dan2))
    }

    val sphereInterval = 50 / danmakuLevel.getMultiplier
    var counter = 2
    if (time % sphereInterval == 0) {
      val danmaku = DanmakuTemplate.builder
        .setUser(user)
        .setSource(cardEntity)
        .setMovementData(0.001, 0.2F, 0.005F * counter)
        .setShot(LibShotData.pellet(LibColor.COLOR_SATURATED_BLUE).scaleSize(2F).setEnd(100))
        .build
      DanmakuCreationHelper.createSphereShot(danmaku, 48, 24, 0, 0.025D)
      DanmakuHelper.playSoundAt(world, posUser, LibSounds.SHOT1, 0.2F, 1F)
      counter -= 1
    }

  }
}
