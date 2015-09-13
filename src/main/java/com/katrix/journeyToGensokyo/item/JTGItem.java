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
		
    	oldGensokyoSpellItem = new OldSpellcardItem()
							.setUnlocalizedName("oldGensokyoSpell");

    	gensokyoIngotItem = new GensokyoIngotItem()
							.setUnlocalizedName("gensokyoIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	gensokyoDustItem = new GensokyoDustItem()
							.setUnlocalizedName("gensokyoDust")
							.setCreativeTab(CreativeTabs.tabMaterials);

    	gensokyoNotesItem = new GensokyoNoteItem()
							.setUnlocalizedName("gensokyoNotes");
    	gensokyoNotesEffectItem = new GensokyoNoteEffectItem()
							.setUnlocalizedName("gensokyoNotesEffect");
    	
    	spawnEggHellRavenItem = new ItemSpawnEgg(EntityName.HELL_RAVEN, 0x2D2727, 0xFF2700)
    						.setUnlocalizedName("spawnEgg_" + EntityName.HELL_RAVEN)
    						.setTextureName("journeytogensokyo:spawn_egg");
    	spawnEggTenguCrowItem = new ItemSpawnEgg(EntityName.TENGU_CROW, 0x191616, 0x593A30)
							.setUnlocalizedName("spawnEgg_" + EntityName.TENGU_CROW)
							.setTextureName("journeytogensokyo:spawn_egg");
    	spawnEggTHFairyIceItem = new ItemSpawnEgg(EntityName.FAIRY_ICE, 0x3DFFEE, 0xA0A000)
							.setUnlocalizedName("spawnEgg_" + EntityName.FAIRY_ICE)
							.setTextureName("journeytogensokyo:spawn_egg");
    	spawnEggFairyNetherItem = new ItemSpawnEgg(EntityName.FAIRY_NETHER, 0x2D2727, 0xA0A000)
							.setUnlocalizedName("spawnEgg_" + EntityName.FAIRY_NETHER)
							.setTextureName("journeytogensokyo:spawn_egg");
    	spawnEggFairyEndItem = new ItemSpawnEgg(EntityName.FAIRY_END, 0x362060, 0xD3C95D)
							.setUnlocalizedName("spawnEgg_" + EntityName.FAIRY_END)
							.setTextureName("journeytogensokyo:spawn_egg");
    	spawnEggSunFlowerFairyEndItem = new ItemSpawnEgg(EntityName.FAIRY_SUNFLOWER_END, 0x1C1133, 0x828200)
							.setUnlocalizedName("spawnEgg_" + EntityName.FAIRY_SUNFLOWER_END)
							.setTextureName("journeytogensokyo:spawn_egg");
    	
    	GameRegistry.registerItem(oldGensokyoSpellItem, "oldGensokyoSpellItem");
    	
    	GameRegistry.registerItem(gensokyoIngotItem, "gensokyoIngotItem");
    	GameRegistry.registerItem(gensokyoDustItem, "gensokyoDustItem");
    	
    	GameRegistry.registerItem(gensokyoNotesItem, "gensokyoNotesItem");
    	GameRegistry.registerItem(gensokyoNotesEffectItem, "gensokyoNotesEffectItem");
    	
    	GameRegistry.registerItem(spawnEggTHFairyIceItem, "spawnEgg" + EntityName.FAIRY_ICE);
    	GameRegistry.registerItem(spawnEggHellRavenItem, "spawnEgg" + EntityName.HELL_RAVEN);
    	GameRegistry.registerItem(spawnEggTenguCrowItem, "spawnEgg" + EntityName.TENGU_CROW);
    	GameRegistry.registerItem(spawnEggFairyNetherItem, "spawnEgg" + EntityName.FAIRY_NETHER);
    	GameRegistry.registerItem(spawnEggFairyEndItem, "spawnEgg" + EntityName.FAIRY_END);
    	GameRegistry.registerItem(spawnEggSunFlowerFairyEndItem, "spawnEgg" + EntityName.FAIRY_SUNFLOWER_END);
		
	}
	
    public static Item oldGensokyoSpellItem;
    
    public static Item gensokyoIngotItem;
    public static Item gensokyoDustItem;
    
    public static Item gensokyoNotesItem;
    public static Item gensokyoNotesEffectItem;
    
    public static Item spawnEggTHFairyIceItem;
    public static Item spawnEggHellRavenItem;
    public static Item spawnEggTenguCrowItem;
    public static Item spawnEggFairyNetherItem;
    public static Item spawnEggFairyEndItem;
    public static Item spawnEggSunFlowerFairyEndItem;

}
