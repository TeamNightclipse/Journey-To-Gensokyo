package net.katsstuff.journeytogensokyo.phase

import java.util.concurrent.ThreadLocalRandom

import net.katsstuff.danmakucore.data.{Quat, Vector3}
import net.katsstuff.danmakucore.entity.danmaku.DanmakuTemplate
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.helper.{DanmakuCreationHelper, DanmakuHelper}
import net.katsstuff.danmakucore.lib.LibColor
import net.katsstuff.danmakucore.lib.data.LibShotData
import net.katsstuff.journeytogensokyo.helper.Implicits._

class PhaseTypeHellRaven extends PhaseType {
  override def instantiate(manager: PhaseManager): Phase = new PhaseHellRaven(manager, ThreadLocalRandom.current().nextBoolean(), this)
}

class PhaseHellRaven(manager: PhaseManager, star: Boolean, val getType:  PhaseTypeHellRaven) extends Phase(manager) {
  private val starShotData = LibShotData.SHOT_KUNAI.copy(
    color = LibColor.COLOR_SATURATED_BLUE,
    end = 60
  )
  private val otherShotData = LibShotData.SHOT_SMALL.copy(
    color = LibColor.COLOR_SATURATED_BLUE
  )

  override def init(): Unit = {
    super.init()
    if(star) interval = 81
    else interval = 45
  }

  override def serverUpdate(): Unit = {
    super.serverUpdate()
    val entity = getEntity
    val target = entity.getAttackTarget

    def moveLeftRight(): Unit = {
      val dir = if(entity.getRNG.nextBoolean()) 1 else -1
      val Vector3(x, y, z) = entity.angle.rotate(Quat.eulerToQuat(dir * 45F, 0F, 0F)) / 2

      entity.motionX += x
      entity.motionY += y
      entity.motionZ += z
    }

    if (!isFrozen && target != null && entity.getEntitySenses.canSee(target)) {
      val angle = Vector3.angleToLiving(entity, target)
      if(star) {
        if(counter >= 20) {
          val template = DanmakuTemplate.builder().setUser(entity).setShot(starShotData).setAngle(angle).setMovementData(0.3D * level.getMultiplier).build()
          DanmakuCreationHelper.createStarShot(template, Math.max(10, 5 * level.getMultiplier), 0F, 0F, 0.5D)
          DanmakuHelper.playShotSound(entity)
        }

        if(isCounterStart) {
          moveLeftRight()
        }
      }
      else {
        if(counter % 10 == 0) {
          val num = ((1 + level.getMultiplier) * 1.3).toInt
          val template = DanmakuTemplate.builder().setUser(entity).setShot(otherShotData).setAngle(angle)

          for(i <- 1 until num) {
            entity.worldObj.spawnEntityInWorld(template.setMovementData(0.3D * (i + i / 2D), 0.3D * (i / 2D), 0D).build().asEntity())
          }

          DanmakuHelper.playShotSound(entity)
        }

        if(counter == 31) {
          moveLeftRight()
        }
      }
    }
  }
}