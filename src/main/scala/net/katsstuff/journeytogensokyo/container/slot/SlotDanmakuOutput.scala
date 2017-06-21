/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.container.slot

import net.katsstuff.danmakucore.capability.IDanmakuCoreData
import net.katsstuff.danmakucore.helper.TouhouHelper
import net.katsstuff.journeytogensokyo.container.ContainerDanmakuCrafting
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{IInventory, InventoryCrafting, SlotCrafting}
import net.minecraft.item.ItemStack
import net.katsstuff.journeytogensokyo.helper.Implicits._

class SlotDanmakuOutput(
    container:   ContainerDanmakuCrafting,
    player:      EntityPlayer,
    ingredients: IInventory,
    matrix:      InventoryCrafting,
    inv:         IInventory,
    index:       Int,
    xPos:        Int,
    yPos:        Int
) extends SlotCrafting(player, matrix, inv, index, xPos, yPos) {

  override def onTake(playerIn: EntityPlayer, stack: ItemStack): ItemStack = {
    for {
      ctx <- container.createContext
      data <- TouhouHelper.getDanmakuCoreData(playerIn).toOption
      requiredScore = ctx.requiredScore
      if data.getScore >= requiredScore
    } {

      ctx.recipe.foreach { _ =>
        ingredients.setInventorySlotContents(3, ItemStack.EMPTY)
      }
      TouhouHelper.changeAndSyncPlayerData((data: IDanmakuCoreData) => data.addScore(-requiredScore), playerIn)
    }

    matrix.clear()
    ingredients.setInventorySlotContents(0, ItemStack.EMPTY)
    ingredients.setInventorySlotContents(1, ItemStack.EMPTY)
    ingredients.setInventorySlotContents(2, ItemStack.EMPTY)

    stack
  }
}
