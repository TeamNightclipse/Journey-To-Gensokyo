package net.katsstuff.journeytogensokyo.spellcard

import net.katsstuff.journeytogensokyo.lib.LibSpellcardName
import net.katsstuff.teamnightclipse.danmakucore.{DanmakuCore, EnumDanmakuLevel}
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.{EntitySpellcard, Spellcard, SpellcardEntity}
import net.katsstuff.teamnightclipse.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.{DanmakuCreationHelper, DanmakuHelper}
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLivingBase

class SpellcardMeshLightDarknes extends Spellcard(LibSpellcardName.MeshLightDarkness) {
  override def instantiate(card: EntitySpellcard, target: Option[EntityLivingBase]): SpellcardEntity =
    new SpellcardEntityMeshLightDarknes(this, card, target)

  override def level: Int = 5

  override def removeTime: Int = 50

  override def endTime: Int = 150

  override def touhouUser: TouhouCharacter = TouhouCharacter.YUKARI_YAKUMO
}
class SpellcardEntityMeshLightDarknes(
    spellcard: Spellcard,
    card: EntitySpellcard,
    target: Option[EntityLivingBase]
) extends SpellcardEntity(spellcard, card, target) {

  private val rot30  = Quat.fromAxisAngle(Vector3.Up, 30F)
  private val rotM30 = Quat.fromAxisAngle(Vector3.Up, -30F)

  private var laserCounter: Int = 0

  private def calcUserOrient: Quat = {
    val forward = directionUserToTarget.getOrElse(Vector3.directionEntity(user))
    Quat.orientationOfVec(forward)
  }

  override def onSpellcardUpdate(): Unit = {
    if (time == 1 || time == 50) {
      laserCounter = 0
      DanmakuHelper.playSoundAt(world, posUser, LibSounds.SHOT1, 0.2F, 1F)

      val userOrient = calcUserOrient

      val baseTemplate  = DanmakuTemplate.builder.setUser(user).setSource(card).setPos(posUser).setMovementData(0.55D)
      val leftTemplate  = baseTemplate.copy().setDirection(userOrient * rot30 * Vector3.Forward)
      val rightTemplate = baseTemplate.copy().setDirection(userOrient * rotM30 * Vector3.Forward)

      if (time == 1) {
        releaseInitial(leftTemplate, rightTemplate)
      } else {
        releaseInitial(rightTemplate, leftTemplate)
      }
    }

    val every = danmakuLevel match {
      case EnumDanmakuLevel.PEACEFUL                                => 10
      case EnumDanmakuLevel.EASY | EnumDanmakuLevel.NORMAL          => 4
      case EnumDanmakuLevel.HARD                                    => 3
      case EnumDanmakuLevel.LUNATIC | EnumDanmakuLevel.EXTRA        => 2
      case EnumDanmakuLevel.LAST_SPELL | EnumDanmakuLevel.LAST_WORD => 1
    }

    if (((time > 1 && time < 20) || (time > 50 && time < 70)) && time % every == 0) {
      releaseLasters()
    }
  }

  private def doWithColors[A](
      left: DanmakuTemplate.Builder,
      right: DanmakuTemplate.Builder,
      shotData: ShotData,
      setColor: (ShotData, Int) => ShotData
  )(f: DanmakuTemplate.Builder => A): Seq[A] =
    Seq(
      f(left.copy().setShot(setColor(shotData, LibColor.COLOR_SATURATED_BLUE))),
      f(right.copy().setShot(setColor(shotData, LibColor.COLOR_SATURATED_RED)))
    )

  private def releaseInitial(left: DanmakuTemplate.Builder, right: DanmakuTemplate.Builder): Unit = {
    DanmakuCore.spawnDanmaku(doWithColors(left, right, LibShotData.SHOT_BUBBLE.setSize(1.5F), _.setCoreColor(_)) { d =>
      d.build.asEntity
    })

    //TODO: Add option to DanmakuCreationHelper to not create it's danmaku
    for (i <- 1 to 4 * danmakuLevel.getMultiplier) {
      doWithColors(left, right, LibShotData.SHOT_MEDIUM.setSize(0.5F), _.setEdgeColor(_)) { d =>
        DanmakuCreationHelper.createRandomRingShot(
          d.setMovementData(0.03D * i).build,
          2,
          180F / i,
          0.2D
        )
      }
    }

    for (i <- 1 until danmakuLevel.getMultiplier) {
      doWithColors(left, right, LibShotData.SHOT_MEDIUM.setSize(1F).setDamage(4F), _.setEdgeColor(_)) { d =>
        DanmakuCreationHelper.createRandomRingShot(
          d.setMovementData(0.3D * i * 0.25, 0.23 * i * 0.25, 0D).build,
          2,
          90F / i,
          0.2D
        )
      }
    }
  }

  private def releaseLasters(): Unit = {
    val first         = time > 1 && time < 20
    val timeFromStart = if (first) time else time - 50

    DanmakuHelper.playSoundAt(world, posUser, LibSounds.SHOT1, 0.2F, 1F)

    val userOrient = calcUserOrient

    val isOdd = (laserCounter % 2) == 1
    laserCounter += 1

    val (dirIn, dirOut) = if (isOdd) (Vector3.Left, Vector3.Right) else (Vector3.Right, Vector3.Left)

    val leftOrient  = userOrient * rot30
    val rightOrient = userOrient * rotM30

    val leftForward  = leftOrient * Vector3.Forward
    val rightForward = rightOrient * Vector3.Forward

    val leftDirection  = leftOrient * Vector3.limitRandomDirection(dirIn, 10F)
    val rightDirection = rightOrient * Vector3.limitRandomDirection(dirOut, 10F)

    val baseTemplate = DanmakuTemplate.builder
      .setUser(user)
      .setSource(card)
      .setMovementData(0D)
    val leftTemplate = baseTemplate
      .copy()
      .setPos(posUser.offset(leftForward, 1D * timeFromStart))
      .setDirection(leftDirection)
    val rightTemplate = baseTemplate
      .copy()
      .setPos(posUser.offset(rightForward, 1D * timeFromStart))
      .setDirection(rightDirection)

    val leftLaserTemplate = leftTemplate.copy().setPos(leftTemplate.pos.offset(leftDirection, -5D))
    val blueLaserTemplate = rightTemplate.copy().setPos(rightTemplate.pos.offset(rightDirection, -5D))

    val (coreLeft, coreRight) = if (first) (leftTemplate, rightTemplate) else (rightTemplate, leftTemplate)
    val (laserLeft, laserRight) =
      if (first) (leftLaserTemplate, blueLaserTemplate) else (blueLaserTemplate, leftLaserTemplate)

    val cores =
      doWithColors(
        coreLeft,
        coreRight,
        LibShotData.SHOT_MEDIUM.setSize(0.5F).setDamage(8F).setEnd(80),
        _.setEdgeColor(_)
      ) { d =>
        d.build.asEntity
      }

    val lasers =
      doWithColors(
        laserLeft,
        laserRight,
        LibShotData.SHOT_LASER.setSize(0.5F, 0.5F, 10F).setDamage(8F).setDelay(20).setEnd(60),
        _.setEdgeColor(_)
      ) { d =>
        d.build.asEntity
      }

    DanmakuCore.spawnDanmaku(
      cores ++ lasers
    )
  }
}
