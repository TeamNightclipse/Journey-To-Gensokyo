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
