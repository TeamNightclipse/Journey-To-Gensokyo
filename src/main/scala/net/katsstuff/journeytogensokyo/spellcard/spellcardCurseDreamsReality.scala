package net.katsstuff.journeytogensokyo.spellcard

import net.katsstuff.journeytogensokyo.lib.LibSpellcardName
import net.katsstuff.journeytogensokyo.subentity.JTGSubEntities
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.{EntitySpellcard, Spellcard, SpellcardEntity}
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData
import net.katsstuff.teamnightclipse.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.{DanmakuCreationHelper, DanmakuHelper}
import net.katsstuff.teamnightclipse.danmakucore.{DanmakuCore, EnumDanmakuLevel}
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLivingBase

class SpellcardCurseDreamsReality extends Spellcard(LibSpellcardName.CurseDreamsReality) {
  override def instantiate(card: EntitySpellcard, target: Option[EntityLivingBase]): SpellcardEntity =
    new SpellcardEntityCurseDreamsReality(this, card, target)

  override def level: Int = 4

  override def removeTime: Int = 50

  override def endTime: Int = 160

  override def touhouUser: TouhouCharacter = TouhouCharacter.YUKARI_YAKUMO
}
class SpellcardEntityCurseDreamsReality(
    spellcard: Spellcard,
    card: EntitySpellcard,
    target: Option[EntityLivingBase]
) extends SpellcardEntity(spellcard, card, target) {

  private val rot45  = Quat.fromAxisAngle(Vector3.Up, 45F)
  private val rotM45 = Quat.fromAxisAngle(Vector3.Up, -45F)

  private var homingEnd: Vector3 = Vector3.Zero
  private var crossEnd: Vector3  = Vector3.Zero
  private var bigEndAt           = 999

  private def calcUserOrient: Quat = {
    val forward = directionUserToTarget.getOrElse(Vector3.directionEntity(user))
    Quat.orientationOfVec(forward)
  }

  override def onSpellcardUpdate(): Unit = {
    if (time == 1 || time == 50) {
      val bigEnd = 15

      val userOrient = calcUserOrient

      val leftDir  = userOrient * rot45 * Vector3.Forward
      val rightDir = userOrient * rotM45 * Vector3.Forward

      val speed = 0.35D

      val baseTemplate = DanmakuTemplate.builder
        .setUser(user)
        .setSource(card)
        .setPos(posUser)
        .setMovementData(speed)
        .setShot(LibShotData.SHOT_BUBBLE.setCoreColor(LibColor.COLOR_SATURATED_BLUE).setEnd(bigEnd))
      val leftTemplate  = baseTemplate.copy().setDirection(leftDir)
      val rightTemplate = baseTemplate.setDirection(rightDir)

      DanmakuHelper.playSoundAt(world, posUser, LibSounds.SHOT1, 0.2F, 1F)
      DanmakuCore.spawnDanmaku(Seq(leftTemplate.build.asEntity, rightTemplate.build.asEntity))

      homingEnd = posUser.offset(leftDir, speed * bigEnd)
      crossEnd = posUser.offset(rightDir, speed * bigEnd)

      if (time == 50) {
        val tmp = homingEnd
        homingEnd = crossEnd
        crossEnd = tmp
      }

      bigEndAt = time + bigEnd - 1
    }

    //Homing handling
    if (time > bigEndAt && time < bigEndAt + 10 && time % 2 == 0) {
      DanmakuHelper.playSoundAt(world, homingEnd, LibSounds.SHOT1, 0.2F, 1F)
      DanmakuCreationHelper.createSphereShot(
        DanmakuTemplate.builder
          .setUser(user)
          .setSource(card)
          .setPos(homingEnd)
          .setDirection(Quat.fromAxisAngle(Vector3.Up, (time - bigEndAt) * 5) * Vector3.Forward)
          .setMovementData(0.35D)
          .setShot(
            LibShotData.SHOT_RICE
              .setEdgeColor(LibColor.COLOR_SATURATED_CYAN)
              .setEnd(85)
              .setSubEntity(JTGSubEntities.DelayedHoming)
              .addSubEntityProperty("delayedHomingWait", 5)
              .addSubEntityProperty("delayedHomingNewSpeed", 0.4D)
          )
          .build,
        3 * danmakuLevel.getMultiplier,
        (1.5D * danmakuLevel.getMultiplier).toInt,
        0F,
        0.1D
      )
    }

    //Cross handling
    if (time == bigEndAt) {
      DanmakuHelper.playSoundAt(world, crossEnd, LibSounds.SHOT1, 0.2F, 1F)
      createCross(-1 until 3 by 2, LibColor.COLOR_VANILLA_LIME)
    }

    if (time == bigEndAt + 3) {
      DanmakuHelper.playSoundAt(world, crossEnd, LibSounds.SHOT1, 0.2F, 1F)
      createCross(-2 until 4 by 2, LibColor.COLOR_SATURATED_GREEN)
    }
  }

  def createCross(range: Range, color: Int): Unit = {
    for {
      x <- range
      y <- range
      z <- range
    } {
      DanmakuCreationHelper.createSphereShot(
        DanmakuTemplate.builder
          .setUser(user)
          .setSource(card)
          .setPos(crossEnd.add(x, y, z))
          .setMovementData(0.2D)
          .setShot(LibShotData.SHOT_SCALE.setEdgeColor(color).scaleSize(1.5F))
          .build,
        3 * danmakuLevel.getMultiplier,
        (1.5D * danmakuLevel.getMultiplier).toInt,
        0F,
        0.1D
      )
    }
  }
}
