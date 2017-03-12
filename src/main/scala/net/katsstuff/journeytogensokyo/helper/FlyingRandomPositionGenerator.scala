package net.katsstuff.journeytogensokyo.helper

import javax.annotation.Nullable

import net.katsstuff.danmakucore.entity.living.EntityDanmakuMob
import net.minecraft.util.math.{BlockPos, MathHelper, Vec3d}

object FlyingRandomPositionGenerator {
  private var staticVector = Vec3d.ZERO
  @Nullable
  def findRandomTarget(entity: EntityDanmakuMob, xz: Int, y: Int): Vec3d =
    findRandomTargetBlock(entity, xz, y, null)

  @Nullable
  def findRandomTargetBlockTowards(entity: EntityDanmakuMob, xz: Int, y: Int, target: Vec3d): Vec3d = {
    staticVector = target.subtract(entity.posX, entity.posY, entity.posZ)
    findRandomTargetBlock(entity, xz, y, staticVector)
  }

  @Nullable
  def findRandomTargetBlockAwayFrom(entity: EntityDanmakuMob, xz: Int, y: Int, awayFrom: Vec3d): Vec3d = {
    staticVector = new Vec3d(entity.posX, entity.posY, entity.posZ).subtract(awayFrom)
    findRandomTargetBlock(entity, xz, y, staticVector)
  }

  @Nullable private def findRandomTargetBlock(entity: EntityDanmakuMob, xz: Int, y: Int, @Nullable targetVec3: Vec3d) = {
    val navigate = entity.getNavigator
    val rand     = entity.getRNG
    var flag     = false
    var xDest        = 0D
    var yDest        = 0D
    var zDest        = 0D
    var weight        = -99999.0F

    var j1 = 0
    while (j1 < 10) {
      {
        val xMod = rand.nextInt(2 * xz + 1) - xz
        val yMod = rand.nextInt(2 * y + 1) - y
        val zMod = rand.nextInt(2 * xz + 1) - xz
        if (targetVec3 == null || xMod * targetVec3.xCoord + zMod * targetVec3.zCoord >= 0.0D) {
          val blockpos1 = new BlockPos(xMod + entity.posX, yMod + entity.posY, zMod + entity.posZ)
          if (navigate.canEntityStandOnPos(blockpos1) || entity.worldObj.isAirBlock(blockpos1)) {
            val currentWeight = entity.getBlockPathWeight(blockpos1)
            if (currentWeight > weight) {
              weight = currentWeight
              xDest = xMod
              yDest = yMod
              zDest = zMod
              flag = true
            }
          }
        }
      }
      { j1 += 1; j1 }
    }
    if (flag) new Vec3d(xDest + entity.posX, yDest + entity.posY, zDest + entity.posZ)
    else null
  }
}
