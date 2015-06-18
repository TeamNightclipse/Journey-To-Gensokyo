package com.katrix.journeyToGensokyo.crafting;

import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.handler.ConfigHandler;
import com.katrix.journeyToGensokyo.item.JTGItem;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaCrafting {
	
	public static void init() {
		
    	if(ConfigHandler.OresEnabled) {
    		GameRegistry.addSmelting(new ItemStack(JTGBlock.gensokyoOreBlock), new ItemStack(JTGItem.gensokyoIngotItem), 0.1f);
            GameRegistry.addSmelting(new ItemStack(JTGBlock.demonOreBlock), new ItemStack(JTGItem.demonIngotItem), 0.1f);
            GameRegistry.addSmelting(new ItemStack(JTGBlock.celestialOreBlock), new ItemStack(JTGItem.celestialIngotItem), 0.1f);
    	}

    	if(ConfigHandler.NotesEnabled) {
            GameRegistry.addRecipe(new ItemStack(JTGBlock.keyStoneBlock), " r ", "sss", "nnn",
                    's', Items.string, 'r', Blocks.stone, 'n', JTGItem.oldCelestialSpellItem);
    	}
    	else{
            GameRegistry.addRecipe(new ItemStack(JTGBlock.keyStoneBlock), " r ", "sss", "nnn",
                    's', Items.string, 'r', Blocks.stone, 'n', Items.paper);
    	}
    	
    	if(ConfigHandler.NotesEnabled) {
            GameRegistry.addRecipe(new ItemStack(JTGItem.gensokyoNotesPatItem), " n ", "nrn", " n ",
            		'r', JTGItem.gensokyoNotesRuinedItem, 'n', JTGItem.oldGensokyoSpellItem);
    	}

	}

}
