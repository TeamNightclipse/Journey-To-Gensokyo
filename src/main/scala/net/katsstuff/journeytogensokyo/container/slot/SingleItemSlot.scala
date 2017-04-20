/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.container.slot

import net.minecraft.inventory.{IInventory, Slot}

class SingleItemSlot(inv: IInventory, i: Int, xPos: Int, yPos: Int) extends Slot(inv, i, xPos, yPos) {

  override def getSlotStackLimit: Int = 1

}
