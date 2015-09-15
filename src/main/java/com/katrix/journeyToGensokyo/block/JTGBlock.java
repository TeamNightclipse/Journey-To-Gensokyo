/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.block;

import com.katrix.journeyToGensokyo.item.ItemGensokyoOreBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class JTGBlock {
	
	public static void preInit() {
		
    	gensokyoOreBlock = new BlockGensokyoOre(Material.rock);
    	keyStoneBlock = new BlockKeyStone(Material.rock)
							.setBlockName("keyStoneBlock")
							.setBlockTextureName("journeytogensokyo:keyStone");
    	
    	GameRegistry.registerBlock(gensokyoOreBlock, ItemGensokyoOreBlock.class, "gensokyoOreBlock");
    	
    	GameRegistry.registerBlock(keyStoneBlock, "keyStoneBlock");
    	
    	compDemonOreBlock = new BlockJTGBase(Material.rock)
							.setBlockName("demonOreBlock")
							.setBlockTextureName("journeytogensokyo:demonOre");  
    	compCelestialOreBlock = new BlockJTGBase(Material.rock)
							.setBlockName("celestialOreBlock")
							.setBlockTextureName("journeytogensokyo:celestialOre");
    	
    	GameRegistry.registerBlock(compDemonOreBlock, "demonOreBlock");
    	GameRegistry.registerBlock(compCelestialOreBlock, "celestialOreBlock");
		
	}
	
    public static Block gensokyoOreBlock;

    public static Block keyStoneBlock;
    
    public static Block compDemonOreBlock;
    public static Block compCelestialOreBlock;
}
