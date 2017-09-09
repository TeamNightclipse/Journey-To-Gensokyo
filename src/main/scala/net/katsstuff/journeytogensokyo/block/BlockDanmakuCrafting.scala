/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.block

import net.katsstuff.journeytogensokyo.JourneyToGensokyo
import net.katsstuff.journeytogensokyo.lib.{LibBlockName, LibGuiId}
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.{AxisAlignedBB, BlockPos}
import net.minecraft.util.{EnumFacing, EnumHand}
import net.minecraft.world.{IBlockAccess, World}
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class BlockDanmakuCrafting extends BlockJTGBase(Material.WOOD, LibBlockName.DanmakuCrafting) {

  protected val BoundingBoxAABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D)

  override def onBlockActivated(
      world: World,
      pos: BlockPos,
      state: IBlockState,
      player: EntityPlayer,
      hand: EnumHand,
      side: EnumFacing,
      hitX: Float,
      hitY: Float,
      hitZ: Float
  ): Boolean = {
    if (!world.isRemote) {
      player.openGui(JourneyToGensokyo, LibGuiId.DanmakuCraftingGui, world, pos.getX, pos.getY, pos.getZ)
    }
    true
  }

  override def getCollisionBoundingBox(blockState: IBlockState, worldIn: IBlockAccess, pos: BlockPos): AxisAlignedBB =
    BoundingBoxAABB

  @SideOnly(Side.CLIENT)
  override def getSelectedBoundingBox(state: IBlockState, worldIn: World, pos: BlockPos): AxisAlignedBB =
    BoundingBoxAABB.offset(pos)

  override def isOpaqueCube(state: IBlockState) = false
  override def isFullCube(state: IBlockState)   = false
}
