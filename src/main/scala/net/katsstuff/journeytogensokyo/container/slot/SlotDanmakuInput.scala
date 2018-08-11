/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.container.slot

import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibItems
import net.katsstuff.journeytogensokyo.item.JTGItems
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack

class SlotDanmakuInput(
    inv: IInventory,
    index: Int,
    xPos: Int,
    yPos: Int,
    slotType: SlotDanmakuType,
    singleItem: Boolean
) extends Slot(inv, index, xPos, yPos) {

  override def isItemValid(stack: ItemStack): Boolean = {
    if (stack.isEmpty) return false

    slotType match {
      case SlotDanmakuType.Danmaku    => stack.getItem == LibItems.DANMAKU
      case SlotDanmakuType.BulletCore => stack.getItem == JTGItems.BulletCore
    }
  }

  override def getItemStackLimit(stack: ItemStack): Int = if (singleItem) 1 else super.getItemStackLimit(stack)
}

sealed trait SlotDanmakuType
object SlotDanmakuType {

  case object Danmaku    extends SlotDanmakuType
  case object BulletCore extends SlotDanmakuType
}
