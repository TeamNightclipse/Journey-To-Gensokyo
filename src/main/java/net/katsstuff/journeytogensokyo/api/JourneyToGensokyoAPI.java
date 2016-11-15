/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.api;

import net.katsstuff.danmakucore.data.MovementData;
import net.katsstuff.danmakucore.data.ShotData;
import net.katsstuff.journeytogensokyo.api.recipe.CraftingManager;

public final class JourneyToGensokyoAPI {

	/**
	 * Register a new danmaku recipe. Run this in preInit.
	 *
	 * @param shot The ShotData that will be applied to the danmaku item.
	 * @param movementData The movement data that will be used for the danmaku item.
	 * It will only use what is at the time supported by the danmaku item.
	 * @param input The input for the recipe. Can be either an ItemStack, or an OreName.
	 */
	public static void addDanmakuRecipe(ShotData shot, MovementData movementData, Object input) {
		CraftingManager.addRecipeDanmaku(shot, movementData, input);
	}
}
