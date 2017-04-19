package net.katsstuff.journeytogensokyo.block

import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.boss.EntityDragon
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess

class BlockDanOre(name: String) extends BlockJTGBase(Material.ROCK, name) {
  setHarvestLevel("pickaxe", 2)

  override def canEntityDestroy(state: IBlockState, world: IBlockAccess, pos: BlockPos, entity: Entity): Boolean =
    if (entity.isInstanceOf[EntityDragon]) false
    else super.canEntityDestroy(state, world, pos, entity)
}
