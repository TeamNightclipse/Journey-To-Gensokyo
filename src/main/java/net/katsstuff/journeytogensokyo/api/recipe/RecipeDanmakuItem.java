/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.api.recipe;

import net.katsstuff.danmakucore.data.MovementData;
import net.katsstuff.danmakucore.data.ShotData;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeDanmakuItem implements IRecipeDanmaku {

	private final ShotData shot;
	private final MovementData movement;
	private final Object input;
	private final int scoreCost;

	RecipeDanmakuItem(ShotData outputShot, MovementData movement, Object input, int scoreCost) {
		shot = outputShot;
		this.movement = movement;
		this.scoreCost = scoreCost;

		if(input instanceof ItemStack || input instanceof String) {
			this.input = input;
		}
		else throw new IllegalArgumentException("Invalid input");
	}

	public boolean matches(Slot slot) {
		if(slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			if(input instanceof String) {
				if(OreDictionary.containsMatch(false, OreDictionary.getOres((String)input), stack)) {
					return true;
				}
			}
			else {
				return ItemStack.areItemStacksEqual(stack, (ItemStack)input);
			}
		}

		return false;
	}

	@Override
	public int scoreCost() {
		return scoreCost;
	}

	@Override
	public MovementData outputMovement() {
		return movement;
	}

	@Override
	public ShotData outputShotData() {
		return shot;
	}
}