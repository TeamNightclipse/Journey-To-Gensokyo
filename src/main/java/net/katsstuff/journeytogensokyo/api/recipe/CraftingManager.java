/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.api.recipe;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import net.katsstuff.danmakucore.data.MovementData;
import net.katsstuff.danmakucore.data.ShotData;
import net.minecraft.inventory.Slot;
import scala.Option;

public class CraftingManager {

	private static final List<IRecipeDanmaku> RECIPE_DANMAKU = new ArrayList<>();

	public static RecipeDanmakuItem addItemRecipeDanmaku(ShotData shotOutput, MovementData movementData, Object input, int scoreCost) {
		RecipeDanmakuItem recipe = new RecipeDanmakuItem(shotOutput, movementData, input, scoreCost);
		addItemRecipeDanmaku(recipe);
		return recipe;
	}

	public static void addItemRecipeDanmaku(RecipeDanmakuItem recipe) {
		addRecipeDanmaku(recipe);
	}

	public static void  addRecipeDanmaku(IRecipeDanmaku recipe) {
		RECIPE_DANMAKU.add(recipe);
	}

	public static Option<IRecipeDanmaku> findMatchingRecipeDanmaku(Slot slot) {
		return RECIPE_DANMAKU.stream().filter(recipe -> recipe.matches(slot)).findFirst().map(Option::apply).orElse(Option.empty());
	}

	/**
	 * @return Returns an Immutable list of all the recipes.
	 */
	public static List<IRecipeDanmaku> getRecipes() {
		return ImmutableList.copyOf(RECIPE_DANMAKU);
	}
}
