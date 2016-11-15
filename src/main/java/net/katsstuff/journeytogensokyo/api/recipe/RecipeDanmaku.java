/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.api.recipe;

import java.util.List;

import net.katsstuff.danmakucore.data.MovementData;
import net.katsstuff.danmakucore.data.ShotData;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeDanmaku {

	private final ShotData shot;
	private final MovementData movement;
	private final Object input;

	RecipeDanmaku(ShotData outputShot, MovementData movement, Object input) {
		shot = outputShot;
		this.movement = movement;

		if(input instanceof ItemStack || input instanceof String) {
			this.input = input;
		}
		else throw new IllegalArgumentException("Invalid input");
	}

	public boolean matches(Slot slot) {
		if(slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			if(input instanceof String) {
				List<ItemStack> validOres = OreDictionary.getOres((String)input);
				for(ItemStack oreStack : validOres) {
					if(ItemStack.areItemStacksEqual(stack, oreStack)) return true;
				}
			}
			else {
				return ItemStack.areItemStacksEqual(stack, (ItemStack)input);
			}
		}
		return false;
	}

	public ShotData getOutputShotData() {
		return shot;
	}

	public MovementData getMovement() {
		return movement;
	}
}