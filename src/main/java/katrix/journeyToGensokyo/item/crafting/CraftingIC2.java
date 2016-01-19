/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.item.crafting;

import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import katrix.journeyToGensokyo.block.JTGBlock;
import katrix.journeyToGensokyo.item.JTGItem;
import net.minecraft.item.ItemStack;

public class CraftingIC2 {

	public static void init() {

		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 0), 1), null,
				new ItemStack(JTGItem.gensokyoDustItem, 2, 0));
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 1), 1), null,
				new ItemStack(JTGItem.gensokyoDustItem, 2, 1));
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(JTGBlock.gensokyoOreBlock, 1, 2), 1), null,
				new ItemStack(JTGItem.gensokyoDustItem, 2, 2));
	}
}
