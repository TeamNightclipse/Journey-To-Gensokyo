/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living.ai

import net.katsstuff.journeytogensokyo.entity.living.EntityTenguCrow
import net.katsstuff.journeytogensokyo.helper.LogHelper
import net.katsstuff.teamnightclipse.mirror.data.Vector3
import net.minecraft.entity.ai.EntityAIBase

//Same as EntityAIMoveRanged, except it doesn't delete the current path
class EntityAIMoveRangedTengu(
    val entity: EntityTenguCrow,
    val moveSpeedAmp: Double,
    val maxDistanceXZ: Float,
    val maxDistanceY: Float
) extends EntityAIBase {
  private val maxAttackDistanceXZ = maxDistanceXZ * maxDistanceXZ
  private val maxAttackDistanceY  = maxDistanceXZ * maxDistanceXZ
  private var seeTime             = 0
  private var strafingClockwise   = false
  private var strafingBackwards   = false
  private var flyingUp            = false
  private var strafingTime        = -1

  this.setMutexBits(3)
  def shouldExecute: Boolean = this.entity.getAttackTarget != null

  override def shouldContinueExecuting(): Boolean = this.shouldExecute || !this.entity.getNavigator.noPath

  override def resetTask() {
    super.resetTask()
    this.seeTime = 0
  }

  override def updateTask(): Unit = {
    val target = entity.getAttackTarget
    if (target != null) {
      //We ignore the y coordinate here
      val distXZ  = entity.getDistanceSq(target.posX, entity.posY, target.posZ)
      val distY    = entity.posY - target.posY
      val canSee  = entity.getEntitySenses.canSee(target)
      val hasSeen = seeTime > 0

      if (canSee != hasSeen) seeTime = 0

      if (canSee) seeTime += 1 else seeTime -= 1

      if ((distXZ <= maxAttackDistanceXZ || Math.abs(distY) <= maxAttackDistanceY) && seeTime >= 20) {
        val path = entity.getNavigator.getPath
        if (path != null) {
          val last = path.getFinalPathPoint
          val vec  = Vector3(last.x, last.y, last.z)
          if (vec.distanceSquared(target.posX, target.posY, target.posZ) < 5 * 5) {
            entity.getNavigator.clearPath()
          }
        }
        strafingTime += 1
      } else {
        entity.getNavigator.tryMoveToEntityLiving(target, moveSpeedAmp)
        strafingTime = -1
      }

      if (strafingTime >= 20) {
        if (entity.getRNG.nextFloat < 0.3D) strafingClockwise = !strafingClockwise
        if (entity.getRNG.nextFloat < 0.3D) strafingBackwards = !strafingBackwards
        strafingTime = 0
      }

      if (strafingTime > -1) {
        if (distXZ > (maxAttackDistanceXZ * 0.75F)) strafingBackwards = false
        else if (distXZ < maxAttackDistanceXZ * 0.25F) strafingBackwards = true

        if (distY > (maxAttackDistanceY * 0.5F)) flyingUp = false
        else if (distY < maxAttackDistanceY * -0.5F) flyingUp = true

        entity.getMoveHelper.strafe(if (strafingBackwards) -0.5F else 0.5F, if (strafingClockwise) 0.5F else -0.5F)
        entity.setMoveVertical(if(flyingUp) 0.5F else -0.5F)
        entity.faceEntity(target, 30.0F, 30.0F)
      } else entity.getLookHelper.setLookPositionWithEntity(target, 30.0F, 30.0F)
    }
  }
}
