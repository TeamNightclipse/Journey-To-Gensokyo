/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.teamnightclipse.danmakucore.entity.living.EntityDanmakuMob
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.block.state.IBlockState
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class EntityJTGDanmakuMob(_world: World) extends EntityDanmakuMob(_world) {

  def spawnEntry: ConfigHandler.Spawns.SpawnEntry

  def spawnBlockCheck(state: IBlockState): Boolean

  override def getMaxSpawnedInChunk: Int = spawnEntry.maxInChunk

  def lootTableName: String

  override def getLootTable: ResourceLocation = new ResourceLocation(LibMod.Id, s"entities/$lootTableName")

  override def getCanSpawnHere: Boolean =
    if (rand.nextInt(100) <= spawnEntry.lastProbability) {
      spawnBlockCheck(world.getBlockState(new BlockPos(posX, getEntityBoundingBox.minY, posZ).down)) && super.getCanSpawnHere
    } else false
}
