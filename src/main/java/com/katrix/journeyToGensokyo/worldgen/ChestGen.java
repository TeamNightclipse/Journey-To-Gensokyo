/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.worldgen;

import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.katrix.journeyToGensokyo.item.JTGItem;

public class ChestGen {
	
	public static void preInit(){
    
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.gensokyoNotesItem, 0, 1, 1, 5));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.oldGensokyoSpellItem, 0, 1, 2, 10));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.oldGensokyoSpellItem, 1, 1, 2, 10));
    	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(JTGItem.oldGensokyoSpellItem, 2, 1, 2, 10));
	}

}
