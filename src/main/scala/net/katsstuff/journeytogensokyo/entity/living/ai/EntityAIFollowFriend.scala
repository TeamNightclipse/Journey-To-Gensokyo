/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living.ai

import net.katsstuff.journeytogensokyo.entity.living.EntityFairy
import net.katsstuff.journeytogensokyo.helper.LogHelper
import net.minecraft.block.material.Material
import net.minecraft.entity.ai.EntityAIBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.pathfinding.{PathNavigateGround, PathNodeType}
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.{BlockPos, MathHelper}

class EntityAIFollowFriend(val fairy: EntityFairy, val followSpeed: Double, var minDist: Float, var maxDist: Float) extends EntityAIBase {
  private var friend: EntityPlayer         = _

  private val world            = fairy.world
  private val pathfinder       = fairy.getNavigator
  private var timeToRecalcPath = 0
  private var oldWaterCost     = 0F

  this.setMutexBits(3)

  override def shouldExecute: Boolean = {
    fairy.friend.fold(false) {
      case fairyFriend if this.fairy.getDistanceSqToEntity(fairyFriend) >= (this.minDist * this.minDist) && !fairyFriend.isSpectator =>
        friend = fairyFriend
        true
      case _ => false
    }
  }

  override def shouldContinueExecuting: Boolean =
    !pathfinder.noPath && fairy.getDistanceSqToEntity(this.friend) > (this.maxDist * this.maxDist)

  override def startExecuting(): Unit = {
    timeToRecalcPath = 0
    oldWaterCost = fairy.getPathPriority(PathNodeType.WATER)
    fairy.setPathPriority(PathNodeType.WATER, 0.0F)
  }

  override def resetTask(): Unit = {
    friend = null
    pathfinder.clearPathEntity()
    fairy.setPathPriority(PathNodeType.WATER, oldWaterCost)
  }

  private def isEmptyBlock(pos: BlockPos) = {
    val state = world.getBlockState(pos)
    if (state.getMaterial == Material.AIR) true
    else !state.isFullCube
  }

  override def updateTask(): Unit = {
    fairy.getLookHelper.setLookPositionWithEntity(friend, 10.0F, fairy.getVerticalFaceSpeed)
    timeToRecalcPath -= 1

    if (timeToRecalcPath <= 0) {
      timeToRecalcPath = 10
      if (!pathfinder.tryMoveToEntityLiving(friend, followSpeed) && !fairy.getLeashed && fairy.getDistanceSqToEntity(this.friend) >= 144.0D) {
        val i = MathHelper.floor(friend.posX) - 2
        val j = MathHelper.floor(friend.posZ) - 2
        val k = MathHelper.floor(friend.getEntityBoundingBox.minY)
        var done = false

        for {
          l <- 0 to 4
          if !done
          i1 <- 0 to 4
          if l < 1 || i1 < 1 || l > 3 || i1 > 3
        } {

          val air1   = new BlockPos(i + l, k, j + i1)
          val ground = air1.down()
          val air2   = air1.up()
          if (world.getBlockState(ground).isSideSolid(world, ground, EnumFacing.UP) && isEmptyBlock(air1) && isEmptyBlock(air2)) {
            this.fairy.setLocationAndAngles(i + l + 0.5F, k, j + i1 + 0.5F, fairy.rotationYaw, fairy.rotationPitch)
            this.pathfinder.clearPathEntity()
            done = true
          }
        }
      }
    }
  }
}