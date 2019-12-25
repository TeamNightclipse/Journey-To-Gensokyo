package net.katsstuff.journeytogensokyo.spellcard

import net.katsstuff.journeytogensokyo.lib.LibSpellcardName
import net.katsstuff.journeytogensokyo.shape.ShapeWideSlow
import net.katsstuff.journeytogensokyo.subentity.JTGSubEntities
import net.katsstuff.teamnightclipse.danmakucore.{DanmakuCore, EnumDanmakuLevel}
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.{EntitySpellcard, Spellcard, SpellcardEntity}
import net.katsstuff.teamnightclipse.danmakucore.impl.shape.ShapeSphere
import net.katsstuff.teamnightclipse.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.{DanmakuCreationHelper, DanmakuHelper}
import net.katsstuff.teamnightclipse.danmakucore.shape.ShapeHandler
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLivingBase

class SpellcardDemarcation extends Spellcard(LibSpellcardName.Demarcation) {
  override def instantiate(card: EntitySpellcard, target: Option[EntityLivingBase]): SpellcardEntity =
    new SpellcardEntityDemarcation(this, card, target)

  override def level: Int = 2

  override def removeTime: Int = 100

  override def endTime: Int = 120

  override def touhouUser: TouhouCharacter = TouhouCharacter.RUMIA
}
class SpellcardEntityDemarcation(
    spellcard: Spellcard,
    card: EntitySpellcard,
    target: Option[EntityLivingBase]
) extends SpellcardEntity(spellcard, card, target) {
  override def onSpellcardUpdate(): Unit = {
    danmakuLevel = EnumDanmakuLevel.NORMAL

    if (time == 1) {
      spawnCrissCross(LibColor.COLOR_SATURATED_BLUE, 0F)
    }

    if (time == 20) {
      spawnCrissCross(LibColor.COLOR_SATURATED_GREEN, 5F)
    }

    if (time == 40) {
      spawnCrissCross(LibColor.COLOR_SATURATED_RED, 10F)
    }

    if (time == 50 || time == 70) {
      spawnSlowHoming(reverse = false)
    }

    if (time == 60 || time == 80) {
      spawnSlowHoming(reverse = true)
    }
  }

  private def spawnCrissCross(color: Int, baseAnglePlus: Float): Unit = {
    DanmakuHelper.playSoundAt(world, posUser, LibSounds.SHOT1, 0.2F, 1F)
    val danmaku = DanmakuTemplate.builder
      .setUser(user)
      .setSource(cardEntity)
      .setShot(
        LibShotData.SHOT_CRYSTAL1
          .setEdgeColor(color)
          .setSubEntity(JTGSubEntities.DelayedRotate)
          .addSubEntityProperty("delayedRotateWait", 20)
          .addSubEntityProperty("delayedRotateNewSpeed", 0.3D)
          //Rotating in the wrong order looks better since we're using a sphere
          .addSubEntityProperty("delayedRotateWrongOrder", 1D)
          .setEnd(120)
      )
      .setMovementData(0.2D, 5D, -0.02D)
      .build
    val amount = danmakuLevel.getMultiplier * 8

    def makeSphere(rotateBy: Double, baseAngle: Float, speedModBefore: Double, speedModAfter: Double) = {
      DanmakuCreationHelper.createSphereShot(
        danmaku.copy(
          shot = danmaku.shot
            .addSubEntityProperty("delayedRotateBy", rotateBy)
            .addSubEntityProperty("delayedRotateNewSpeed", 0.25D * speedModAfter),
          movement = danmaku.movement.copy(speedOriginal = danmaku.movement.speedOriginal * speedModBefore)
        ),
        amount,
        amount / 2,
        baseAngle + baseAnglePlus,
        0.5D
      )
    }

    makeSphere(110D, 0F, 1D, 1.1D)
    makeSphere(-110D, 2.5F, 1D, 1.1D)

    makeSphere(110D, 0F, 1.5D, 1D)
    makeSphere(-110D, 2.5F, 1.5D, 1D)
  }

  private def spawnSlowHoming(reverse: Boolean): Unit = {
    val waves  = (danmakuLevel.getMultiplier + 1) / 2
    val height = danmakuLevel.getMultiplier + 1
    val look   = directionUserToTarget.getOrElse(Vector3.directionEntity(user))

    for {
      i <- 1 to waves
      j <- -height / 2 to height / 2
    } {
      val danmaku = DanmakuTemplate.builder
        .setUser(user)
        .setSource(cardEntity)
        .setDirection(look.rotate(Quat.fromEuler(5 * j, 0F, 0F)))
        .setShot(
          LibShotData.SHOT_CIRCLE
            .setEdgeColor(LibColor.COLOR_SATURATED_BLUE)
            .setSubEntity(JTGSubEntities.DelayedHoming)
            .addSubEntityProperty("delayedHomingWait", 20)
            .addSubEntityProperty("delayedHomingNewSpeed", 0.4D)
        )
        .setMovementData(0.2 + 0.025D * i, 10D, -0.025)
        .setOrientation(Quat.Identity)
        .build
      ShapeHandler.createShape(new ShapeWideSlow(danmaku, 8, 45F, 0F, i * 0.5D, 4, reverse), user)
    }
  }
}
