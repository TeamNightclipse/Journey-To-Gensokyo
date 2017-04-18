/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.block

import net.katsstuff.journeytogensokyo.lib.{LibBlockName, LibGuiId}
import net.katsstuff.journeytogensokyo.{JTGCreativeTab, JourneyToGensokyo}
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.math.{AxisAlignedBB, BlockPos}
import net.minecraft.util.{EnumFacing, EnumHand}
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class BlockDanmakuCrafting extends BlockJTGBase(Material.WOOD, LibBlockName.DanmakuCrafting) {

  protected val BoundingBoxAABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D)

  setCreativeTab(JTGCreativeTab)

  override def onBlockActivated(world:    World,
                                pos:      BlockPos,
                                state:    IBlockState,
                                player:   EntityPlayer,
                                hand:     EnumHand,
                                heldItem: ItemStack,
                                side:     EnumFacing,
                                hitX:     Float,
                                hitY:     Float,
                                hitZ:     Float): Boolean = {
    if (!world.isRemote) {
      player.openGui(JourneyToGensokyo, LibGuiId.DanmakuCraftingGui, world, pos.getX, pos.getY, pos.getZ)
    }
    true
  }

  override def getCollisionBoundingBox(blockState: IBlockState, worldIn: World, pos: BlockPos) = BoundingBoxAABB

  @SideOnly(Side.CLIENT)
  override def getSelectedBoundingBox(state: IBlockState, worldIn: World, pos: BlockPos): AxisAlignedBB = BoundingBoxAABB.offset(pos)

  override def isOpaqueCube(state: IBlockState) = false
  override def isFullCube(state: IBlockState) = false
}
