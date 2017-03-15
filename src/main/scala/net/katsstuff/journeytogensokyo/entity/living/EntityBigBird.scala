package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.IAllyDanmaku
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class EntityBigBird(_world: World) extends EntityJTGDanmakuMob(_world) with IAllyDanmaku{

  setSize(1.3F, 1.2F)
  experienceValue = 8

  setFlyingHeight(3)
  setMaxHP(6F)

  override def isValidLightLevel: Boolean = true

  override def getBlockPathWeight(pos: BlockPos): Float = world.getLightBrightness(pos)

  override def spawnBlockCheck(state: IBlockState): Boolean = state.getMaterial == Material.ROCK
}
