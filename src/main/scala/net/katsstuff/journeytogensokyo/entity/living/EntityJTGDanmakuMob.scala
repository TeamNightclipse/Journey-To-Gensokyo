package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.EntityDanmakuMob
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.minecraft.block.state.IBlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class EntityJTGDanmakuMob(world: World) extends EntityDanmakuMob(world) {

  def spawnEntry: ConfigHandler.Spawns.SpawnEntry

  def spawnBlockCheck(state: IBlockState): Boolean

  override def getMaxSpawnedInChunk: Int = spawnEntry.maxInChunk

  override def getCanSpawnHere: Boolean = {
    if (rand.nextInt(100) <= spawnEntry.lastProbability) {
      spawnBlockCheck(worldObj.getBlockState(new BlockPos(posX, getEntityBoundingBox.minY, posZ).down)) && super.getCanSpawnHere
    } else false
  }
}
