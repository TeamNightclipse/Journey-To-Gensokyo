package net.katsstuff.journeytogensokyo.phase

import net.katsstuff.danmakucore.data.Vector3
import net.katsstuff.danmakucore.entity.danmaku.DanmakuTemplate
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.helper.{DanmakuCreationHelper, DanmakuHelper}
import net.katsstuff.danmakucore.lib.LibColor
import net.katsstuff.danmakucore.lib.data.LibShotData
import net.katsstuff.journeytogensokyo.helper.FlyingRandomPositionGenerator

class PhaseTypeTengu extends PhaseType {
  override def instantiate(manager: PhaseManager): Phase = new PhaseTengu(manager, this)
}

class PhaseTengu(manager: PhaseManager, val getType: PhaseTypeTengu) extends Phase(manager) {

  var cooldown = 0
  private val shotData = LibShotData.SHOT_SMALL.copy(color = LibColor.COLOR_SATURATED_YELLOW)

  override def init(): Unit = {
    super.init()
    interval = 24
  }

  override def serverUpdate(): Unit = {
    super.serverUpdate()

    val entity = getEntity
    val target = entity.getAttackTarget

    if (!isFrozen && target != null && entity.getEntitySenses.canSee(target)) {
      entity.faceEntity(target, 30F, 30F)
      if (counter % 12 == 0) {
        val template = DanmakuTemplate
          .builder()
          .setUser(entity)
          .setAngle(Vector3.angleToLiving(entity, target))
          .setShot(shotData)
          .setMovementData(0.4D)
          .build()

        DanmakuCreationHelper.createRandomRingShot(template, 3 * level.getMultiplier, 40F, 0.5D)
        DanmakuHelper.playShotSound(entity)
      }

      if (isCounterStart) {
        if (cooldown > 0) cooldown -= 1

        if (cooldown == 0 && !entity.hasPath) {

          if (entity.getRNG.nextInt(3) == 0) {
            val angle @ Vector3(x, y, z) = Vector3.angleToLiving(entity, target) * (entity.getSpeed * 2.5)
            entity.motionX += x
            entity.motionY += y
            entity.motionZ += z

            val template = DanmakuTemplate
              .builder()
              .setUser(entity)
              .setAngle(angle)
              .setShot(shotData.setColor(LibColor.COLOR_SATURATED_RED).scaleSize(2F))
              .setMovementData(entity.getSpeed * 2)
              .build()

            entity.worldObj.spawnEntityInWorld(template.asEntity())
            cooldown = 3
          } else {
            val targetVec = FlyingRandomPositionGenerator.findRandomTarget(entity, 4, 1)
            if (targetVec != null) {
              val path = entity.getNavigator.getPathToXYZ(targetVec.xCoord, targetVec.yCoord, targetVec.zCoord)
              if (path != null) {
                if (entity.getNavigator.setPath(path, entity.getSpeed)) {
                  cooldown = 2
                }
              }
            }
          }
        }
      }
    }
  }
}
