/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JTGItem {
	
	public static void preInit(){
		
    	oldGensokyoSpellItem = new JTGBaseItem()
							.setUnlocalizedName("oldGensokyoSpell")
							.setTextureName("journeytogensokyo:oldGensokyoSpell");
    	oldDemonSpellItem = new JTGBaseItem()
							.setUnlocalizedName("oldDemonSpell")
							.setTextureName("journeytogensokyo:oldDemonSpell");
    	oldCelestialSpellItem = new JTGBaseItem()
							.setUnlocalizedName("oldCelestialSpell")
							.setTextureName("journeytogensokyo:oldCelestialSpell");

    	gensokyoIngotItem = new JTGBaseItem()
							.setUnlocalizedName("gensokyoIngot")
							.setTextureName("journeytogensokyo:gensokyoIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	demonIngotItem = new JTGBaseItem()
							.setUnlocalizedName("demonIngot")
							.setTextureName("journeytogensokyo:demonIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	celestialIngotItem = new JTGBaseItem()
							.setUnlocalizedName("celestialIngot")
							.setTextureName("journeytogensokyo:celestialIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);

    	gensokyoDustItem = new JTGBaseItem()
							.setUnlocalizedName("gensokyoDust")
							.setTextureName("journeytogensokyo:gensokyoDust")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	demonDustItem = new JTGBaseItem()
							.setUnlocalizedName("demonDust")
							.setTextureName("journeytogensokyo:demonDust")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	celestialDustItem = new JTGBaseItem()
							.setUnlocalizedName("celestialDust")
							.setTextureName("journeytogensokyo:celestialDust")
							.setCreativeTab(CreativeTabs.tabMaterials);

    	gensokyoNotesRuinedItem = new JTGBaseItem()
							.setUnlocalizedName("gensokyoNotesRuined")
							.setTextureName("journeytogensokyo:gensokyoNotesRuined");
    	gensokyoNotesPatItem = new JTGBaseItem()
							.setUnlocalizedName("gensokyoNotesPat")
							.setTextureName("journeytogensokyo:gensokyoNotesPat");
    	gensokyoNotesDusItem = new JTGBaseItem()
							.setUnlocalizedName("gensokyoNotesDus")
							.setTextureName("journeytogensokyo:gensokyoNotesDus");
    	gensokyoNotesItem = new JTGBaseItem()
							.setUnlocalizedName("gensokyoNotes")
							.setTextureName("journeytogensokyo:gensokyoNotes");
    	gensokyoNotesImbItem = new JTGItemEffect()
							.setUnlocalizedName("gensokyoNotesImb")
							.setTextureName("journeytogensokyo:gensokyoNotes");
    	gensokyoNotesArcItem = new JTGItemEffect()
							.setUnlocalizedName("gensokyoNotesArc")
							.setTextureName("journeytogensokyo:gensokyoNotesArc");
    	
    	GameRegistry.registerItem(oldGensokyoSpellItem, "oldGensokyoSpellItem");
    	GameRegistry.registerItem(oldDemonSpellItem, "oldDemonSpellItem");
    	GameRegistry.registerItem(oldCelestialSpellItem, "oldCelestialSpellItem");
    	
    	GameRegistry.registerItem(gensokyoIngotItem, "gensokyoIngotItem");
    	GameRegistry.registerItem(demonIngotItem, "demonIngotItem");
    	GameRegistry.registerItem(celestialIngotItem, "celestialIngotItem");
    	
    	GameRegistry.registerItem(gensokyoDustItem, "gensokyoDustItem");
    	GameRegistry.registerItem(demonDustItem, "demonDustItem");
    	GameRegistry.registerItem(celestialDustItem, "celestialDustItem");
    	
    	GameRegistry.registerItem(gensokyoNotesRuinedItem, "gensokyoNotesRuinedItem");
    	GameRegistry.registerItem(gensokyoNotesPatItem, "gensokyoNotesPatItem");
    	GameRegistry.registerItem(gensokyoNotesDusItem, "gensokyoNotesDusItem");
    	GameRegistry.registerItem(gensokyoNotesItem, "gensokyoNotesItem");
    	GameRegistry.registerItem(gensokyoNotesImbItem, "gensokyoNotesImbItem");
    	GameRegistry.registerItem(gensokyoNotesArcItem, "gensokyoNotesArcItem");
		
	}
	
    public static Item oldGensokyoSpellItem;
    public static Item oldDemonSpellItem;
    public static Item oldCelestialSpellItem;
    
    public static Item gensokyoIngotItem;
    public static Item demonIngotItem;
    public static Item celestialIngotItem;
    
    public static Item gensokyoDustItem;
    public static Item demonDustItem;
    public static Item celestialDustItem;
    
    public static Item gensokyoNotesRuinedItem;
    public static Item gensokyoNotesPatItem;
    public static Item gensokyoNotesDusItem;
    public static Item gensokyoNotesItem;
    public static Item gensokyoNotesImbItem;
    public static Item gensokyoNotesArcItem;

}
