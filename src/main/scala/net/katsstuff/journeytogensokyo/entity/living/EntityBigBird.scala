package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.{EntityDanmakuMob, IAllyDanmaku}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.minecraft.block.material.Material
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World

class EntityBigBird(world: World) extends EntityDanmakuMob(world) with IAllyDanmaku{

  setSize(1.3F, 1.2F)
  experienceValue = 8

  setFlyingHeight(3)

  override def getMaxSpawnedInChunk: Int = 2

  override def getCanSpawnHere: Boolean = {
    val spawnChance = ConfigHandler.spawnRateHard
    if (rand.nextInt(100) < spawnChance) {
      val x             = MathHelper.floor_double(posX)
      val y             = MathHelper.floor_double(getEntityBoundingBox.minY)
      val z             = MathHelper.floor_double(posZ)
      val blockpos      = new BlockPos(x, y, z)
      val spawnMaterial = Seq(Material.ROCK)
      spawnMaterial.contains(worldObj.getBlockState(blockpos.down).getMaterial) && worldObj.getLight(blockpos) > 8 && super.getCanSpawnHere
    } else false
  }
}
