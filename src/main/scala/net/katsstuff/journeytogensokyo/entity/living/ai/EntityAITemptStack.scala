/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living.ai

import javax.annotation.Nullable

import net.minecraft.entity.EntityCreature
import net.minecraft.entity.ai.EntityAIBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.pathfinding.PathNavigateGround

class EntityAITemptStack(val temptedEntity: EntityCreature, val speed: Double, val scaredByPlayerMovement: Boolean, private var _temptStacks: Set[ItemStack]) extends EntityAIBase {
  this.setMutexBits(3)
  if (! temptedEntity.getNavigator.isInstanceOf[PathNavigateGround] ) throw new IllegalArgumentException("Unsupported mob type for TemptGoal")

  private var targetX                      = 0D
  private var targetY                      = 0D
  private var targetZ                      = 0D
  private var pitch                        = 0D
  private var yaw                          = 0D
  private var temptingPlayer: EntityPlayer = _
  private var delayTemptCounter            = 0
  private var _isTempted                    = false

  def isTempted: Boolean = _isTempted

  def temptStacks_=(stacks: Set[ItemStack]): Unit = _temptStacks = stacks
  def temptStacks: Set[ItemStack] = _temptStacks

  override def shouldExecute: Boolean = {
    val res = if (delayTemptCounter > 0) {
      delayTemptCounter -= 1
      false
    }
    else {
      temptingPlayer = temptedEntity.world.getClosestPlayerToEntity(this.temptedEntity, 10.0D)
      if (temptingPlayer == null) false
      else {
        isTempting(temptingPlayer.getHeldItemMainhand) || isTempting(temptingPlayer.getHeldItemOffhand)
      }
    }

    res
  }

  protected def isTempting(@Nullable stack: ItemStack): Boolean = {
    if (stack == null) false
    else this._temptStacks.exists(_.isItemEqual(stack))
  }

  override def continueExecuting: Boolean = {
    if (scaredByPlayerMovement) {
      if (temptedEntity.getDistanceSqToEntity(temptingPlayer) < 36.0D) {
        if (Math.abs(temptingPlayer.rotationPitch.toDouble - pitch) > 5.0D ||
          Math.abs(temptingPlayer.rotationYaw.toDouble - yaw) > 5.0D) return false
      }
      else {
        targetX = temptingPlayer.posX
        targetY = temptingPlayer.posY
        targetZ = temptingPlayer.posZ
      }

      pitch = temptingPlayer.rotationPitch.toDouble
      yaw = temptingPlayer.rotationYaw.toDouble
    }

    shouldExecute
  }

  override def startExecuting(): Unit = {
    targetX = temptingPlayer.posX
    targetY = temptingPlayer.posY
    targetZ = temptingPlayer.posZ
    _isTempted = true
  }

  override def resetTask(): Unit = {
    temptingPlayer = null
    temptedEntity.getNavigator.clearPathEntity()
    delayTemptCounter = 100
    _isTempted = false
  }

  override def updateTask(): Unit = {
    temptedEntity.getLookHelper.setLookPositionWithEntity(temptingPlayer, (temptedEntity.getHorizontalFaceSpeed + 20).toFloat, temptedEntity.getVerticalFaceSpeed.toFloat)

    if (temptedEntity.getDistanceSqToEntity(temptingPlayer) < 6.25D) temptedEntity.getNavigator.clearPathEntity()
    else temptedEntity.getNavigator.tryMoveToEntityLiving(temptingPlayer, speed)
  }
}