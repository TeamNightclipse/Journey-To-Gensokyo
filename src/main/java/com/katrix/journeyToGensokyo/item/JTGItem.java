/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.item;

import com.katrix.journeyToGensokyo.reference.EntityName;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JTGItem {
	
	public static void preInit(){
		
    	oldGensokyoSpellItem = new ItemOldSpellcard();

    	gensokyoIngotItem = new ItemGensokyoIngot()
							.setCreativeTab(CreativeTabs.tabMaterials);
    	gensokyoDustItem = new ItemGensokyoDust()
							.setCreativeTab(CreativeTabs.tabMaterials);

    	gensokyoNotesItem = new ItemGensokyoNote();
    	
    	spawnEggItem = new ItemSpawnEgg().setTextureName("journeytogensokyo:spawn_egg");
    						ItemSpawnEgg.addMapping(EntityName.HELL_RAVEN, 0x2D2727, 0xFF2700);
    						ItemSpawnEgg.addMapping(EntityName.TENGU_CROW, 0x191616, 0x593A30);
    						ItemSpawnEgg.addMapping(EntityName.FAIRY_ICE, 0x3DFFEE, 0xA0A000);
    						ItemSpawnEgg.addMapping(EntityName.FAIRY_NETHER, 0x2D2727, 0xA0A000);
    						ItemSpawnEgg.addMapping(EntityName.FAIRY_END, 0x362060, 0xD3C95D);
    						ItemSpawnEgg.addMapping(EntityName.FAIRY_SUNFLOWER_END, 0x1C1133, 0x828200);
    	
    	GameRegistry.registerItem(oldGensokyoSpellItem, "oldGensokyoSpellItem");
    	
    	GameRegistry.registerItem(gensokyoIngotItem, "gensokyoIngotItem");
    	GameRegistry.registerItem(gensokyoDustItem, "gensokyoDustItem");
    	
    	GameRegistry.registerItem(gensokyoNotesItem, "gensokyoNotesItem");
    	
    	GameRegistry.registerItem(spawnEggItem, "spawnEggJTG");
		
	}
	
    public static Item oldGensokyoSpellItem;
    
    public static Item gensokyoIngotItem;
    public static Item gensokyoDustItem;
    
    public static Item gensokyoNotesItem;
    
    public static Item spawnEggItem;

}
