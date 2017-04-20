package net.katsstuff.journeytogensokyo.container.slot

import net.minecraft.inventory.{IInventory, Slot}

class SingleItemSlot(inv: IInventory, i: Int, xPos: Int, yPos: Int) extends Slot(inv, i, xPos, yPos) {

  override def getSlotStackLimit: Int = 1

}
