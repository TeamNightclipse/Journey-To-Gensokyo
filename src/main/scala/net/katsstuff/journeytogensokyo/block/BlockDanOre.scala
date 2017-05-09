/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.block

import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.boss.EntityDragon
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess

class BlockDanOre(name: String) extends BlockJTGBase(Material.ROCK, name) {
  setHarvestLevel("pickaxe", 2)
  setHardness(2.5F)

  override def canEntityDestroy(state: IBlockState, world: IBlockAccess, pos: BlockPos, entity: Entity): Boolean =
    if (entity.isInstanceOf[EntityDragon]) false
    else super.canEntityDestroy(state, world, pos, entity)
}
