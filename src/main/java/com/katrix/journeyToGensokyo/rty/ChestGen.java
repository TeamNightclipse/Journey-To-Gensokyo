package com.katrix.journeyToGensokyo.rty;

import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.katrix.journeyToGensokyo.item.JTGItem;

public class ChestGen {
	
	public static void preInit(){
    
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.researchNotesRuinedItem, 0, 1, 1, 5));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.gensokyoNoteItem, 0, 1, 2, 10));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.demonNoteItem, 0, 1, 2, 10));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.celestialNoteItem, 0, 1, 2, 10));
	}

}
