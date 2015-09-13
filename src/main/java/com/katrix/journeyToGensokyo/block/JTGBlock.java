/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.block;

import com.katrix.journeyToGensokyo.item.GensokyoOreBlockItem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class JTGBlock {
	
	public static void preInit() {
		
    	gensokyoOreBlock = new GensokyoOreBlock(Material.rock);
    	keyStoneBlock = new KeyStoneBlock(Material.rock)
							.setBlockName("keyStoneBlock")
							.setBlockTextureName("journeytogensokyo:keyStone");  	
    	
    	GameRegistry.registerBlock(gensokyoOreBlock, GensokyoOreBlockItem.class, "gensokyoOreBlock");
    	
    	GameRegistry.registerBlock(keyStoneBlock, "keyStoneBlock");
		
	}
	
    public static Block gensokyoOreBlock;

    public static Block keyStoneBlock;
    
}
