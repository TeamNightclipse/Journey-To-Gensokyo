package com.katrix.journeyToGensokyo.worldgen;

import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.katrix.journeyToGensokyo.item.JTGItem;

public class ChestGen {
	
	public static void preInit(){
    
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.gensokyoNotesRuinedItem, 0, 1, 1, 5));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.oldGensokyoSpellItem, 0, 1, 2, 10));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.oldCelestialSpellItem, 0, 1, 2, 10));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.oldDemonSpellItem, 0, 1, 2, 10));
	}

}
