/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.crafting;

import cofh.api.modhelpers.ThermalExpansionHelper;

import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.item.JTGItem;

import net.minecraft.item.ItemStack;

public class TEOreCrafting {
	
	public static void init() {
		
    	ThermalExpansionHelper.addPulverizerRecipe(4000, new ItemStack(JTGBlock.gensokyoOreBlock, 1, 0), new ItemStack(JTGItem.gensokyoDustItem, 2, 0));
    	ThermalExpansionHelper.addPulverizerRecipe(4000, new ItemStack(JTGBlock.gensokyoOreBlock, 1, 1), new ItemStack(JTGItem.gensokyoDustItem, 2, 1), new ItemStack(JTGItem.gensokyoDustItem, 1, 0), 5);
    	ThermalExpansionHelper.addPulverizerRecipe(4000, new ItemStack(JTGBlock.gensokyoOreBlock, 1, 2), new ItemStack(JTGItem.gensokyoDustItem, 2, 2), new ItemStack(JTGItem.gensokyoDustItem, 1, 0), 5);
	}

}
