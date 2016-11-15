/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.container.slot

import net.katsstuff.danmakucore.lib.data.LibItems
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack

class SlotDanmakuInput(inv: IInventory, index: Int, xPos: Int, yPos: Int, slotType: SlotDanmakuType) extends Slot(inv, index, xPos, yPos) {

	override def isItemValid(stack: ItemStack): Boolean = {
		if(stack == null) return false

		slotType match {
			case SlotDanmakuType.Danmaku => stack.getItem == LibItems.DANMAKU
		}
	}
}

sealed trait SlotDanmakuType
object SlotDanmakuType {

	case object Danmaku extends SlotDanmakuType
}