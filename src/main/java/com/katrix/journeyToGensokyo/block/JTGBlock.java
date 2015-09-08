/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class JTGBlock {
	
	public static void preInit() {
		
    	gensokyoOreBlock = new GensokyoOreBlock(Material.rock)
							.setBlockName("gensokyoOreBlock")
							.setBlockTextureName("journeytogensokyo:gensokyoOre");
    	demonOreBlock = new GensokyoOreBlock(Material.rock)
							.setBlockName("demonOreBlock")
							.setBlockTextureName("journeytogensokyo:demonOre")
							.setLightLevel(0.625F);
    	celestialOreBlock = new GensokyoOreBlock(Material.rock)
							.setBlockName("celestialOreBlock")
							.setBlockTextureName("journeytogensokyo:celestialOre");
    	keyStoneBlock = new KeyStoneBlock(Material.rock)
							.setBlockName("keyStoneBlock")
							.setBlockTextureName("journeytogensokyo:keyStone");  	
    	
    	
    	
    	GameRegistry.registerBlock(gensokyoOreBlock, "gensokyoOreBlock");
    	GameRegistry.registerBlock(demonOreBlock, "demonOreBlock");
    	GameRegistry.registerBlock(celestialOreBlock, "celestialOreBlock");
    	GameRegistry.registerBlock(keyStoneBlock, "keyStoneBlock");
		
	}
	
    public static Block gensokyoOreBlock;
    public static Block demonOreBlock;
    public static Block celestialOreBlock;
    public static Block keyStoneBlock;
    
}
