/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thKaguyaMod.init.THKaguyaItems;

public class DanmakuHelper {

	public static int searchInventoryPowerItem(EntityPlayer player, int reduce, int type) {
		ItemStack[] inventory = player.inventory.mainInventory;
		for (int i = 0; i < inventory.length; i++) {
			ItemStack slot = inventory[i];
			if (slot != null && slot.getItem() == THKaguyaItems.power_item && slot.getItemDamage() == type) {
				reduce = reducePowerItem(slot, reduce, player, i);

				if (reduce <= 0)
					return reduce;
			}
		}
		return reduce;
	}

	public static int reducePowerItem(ItemStack slot, int reduce, EntityPlayer player, int pos) {
		while (reduce > 0) {
			if (slot.getItemDamage() == 0) {
				slot.stackSize--;
				reduce--;
			}
			else {
				if (reduce < 10) {
					slot.stackSize--;
					ItemStack newStack = new ItemStack(THKaguyaItems.power_item, 10, 0);
					if (!player.inventory.addItemStackToInventory(newStack)) {
						player.entityDropItem(newStack, 0F);
					}

					reduce = searchInventoryPowerItem(player, reduce, 0);
				}
				else {
					slot.stackSize--;
					reduce -= 10;
				}
			}

			if (slot.stackSize <= 0) {
				player.inventory.mainInventory[pos] = null;
				return reduce;
			}
		}
		return reduce;
	}

}
