package net.katsstuff.journeytogensokyo.item

import net.katsstuff.journeytogensokyo.handler.CameraHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.{ActionResult, EnumActionResult, EnumHand}
import net.minecraft.world.World

class ItemCamera extends ItemJTGBase("camera") {

  override def onItemRightClick(worldIn: World, player: EntityPlayer, hand: EnumHand): ActionResult[ItemStack] = {
    if (!worldIn.isRemote) {
      CameraHandler.setCamera(player)
    }

    ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand))
  }
}
