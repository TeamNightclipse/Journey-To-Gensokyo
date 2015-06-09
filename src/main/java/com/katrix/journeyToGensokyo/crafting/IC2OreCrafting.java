package com.katrix.journeyToGensokyo.crafting;

import net.minecraft.item.ItemStack;

import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.item.JTGItem;

import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;

public class IC2OreCrafting {
	
	public static void init() {
		
    	Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(JTGBlock.gensokyoOreBlock), 1), null, new ItemStack(JTGItem.gensokyoDustItem, 2));
    	Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(JTGBlock.demonOreBlock), 1), null, new ItemStack(JTGItem.demonDustItem, 2));
    	Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(JTGBlock.celestialOreBlock), 1), null, new ItemStack(JTGItem.celestialDustItem, 2));
	}

}
