/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.handler;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.item.JTGItem;

public class OreDictionaryHandler {
	
	public static void init(){
		
    	OreDictionary.registerOre("oreGensokyo", new ItemStack(JTGBlock.gensokyoOreBlock, 1, 0));
    	OreDictionary.registerOre("oreDemon", new ItemStack(JTGBlock.gensokyoOreBlock, 1, 1));
    	OreDictionary.registerOre("oreCelestial", new ItemStack(JTGBlock.gensokyoOreBlock, 1, 2));
    	
    	OreDictionary.registerOre("dustGensokyo", new ItemStack(JTGItem.gensokyoDustItem, 1, 0));
    	OreDictionary.registerOre("dustDemon", new ItemStack(JTGItem.gensokyoDustItem, 1, 1));
    	OreDictionary.registerOre("dustCelestial", new ItemStack(JTGItem.gensokyoDustItem, 1, 2));
    	
    	OreDictionary.registerOre("ingotGensokyo", new ItemStack(JTGItem.gensokyoIngotItem, 1, 0));
    	OreDictionary.registerOre("ingotDemon", new ItemStack(JTGItem.gensokyoIngotItem, 1, 1));
    	OreDictionary.registerOre("ingotCelestial", new ItemStack(JTGItem.gensokyoIngotItem, 1, 2));
    	
    	OreDictionary.registerOre("oreDemon", JTGBlock.compDemonOreBlock);
    	OreDictionary.registerOre("oreCelestial", JTGBlock.compCelestialOreBlock);
		
	}
}
