package com.katrix.journeyToGensokyo.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JTGItem {
	
	public static void preInit(){
		
    	oldGensokyoSpellItem = new BaseItem()
							.setUnlocalizedName("oldGensokyoSpell")
							.setTextureName("journeytogensokyo:oldGensokyoSpell");
    	oldDemonSpellItem = new BaseItem()
							.setUnlocalizedName("oldDemonSpell")
							.setTextureName("journeytogensokyo:oldDemonSpell");
    	oldCelestialSpellItem = new BaseItem()
							.setUnlocalizedName("oldCelestialSpell")
							.setTextureName("journeytogensokyo:oldCelestialSpell");

    	gensokyoIngotItem = new BaseItem()
							.setUnlocalizedName("gensokyoIngot")
							.setTextureName("journeytogensokyo:gensokyoIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	demonIngotItem = new BaseItem()
							.setUnlocalizedName("demonIngot")
							.setTextureName("journeytogensokyo:demonIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	celestialIngotItem = new BaseItem()
							.setUnlocalizedName("celestialIngot")
							.setTextureName("journeytogensokyo:celestialIngot")
							.setCreativeTab(CreativeTabs.tabMaterials);

    	gensokyoDustItem = new BaseItem()
							.setUnlocalizedName("gensokyoDust")
							.setTextureName("journeytogensokyo:gensokyoDust")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	demonDustItem = new BaseItem()
							.setUnlocalizedName("demonDust")
							.setTextureName("journeytogensokyo:demonDust")
							.setCreativeTab(CreativeTabs.tabMaterials);
    	celestialDustItem = new BaseItem()
							.setUnlocalizedName("celestialDust")
							.setTextureName("journeytogensokyo:celestialDust")
							.setCreativeTab(CreativeTabs.tabMaterials);

    	gensokyoNotesRuinedItem = new BaseItem()
							.setUnlocalizedName("gensokyoNotesRuined")
							.setTextureName("journeytogensokyo:gensokyoNotesRuined");
    	gensokyoNotesPatItem = new BaseItem()
							.setUnlocalizedName("gensokyoNotesPat")
							.setTextureName("journeytogensokyo:gensokyoNotesPat");
    	gensokyoNotesDusItem = new BaseItem()
							.setUnlocalizedName("gensokyoNotesDus")
							.setTextureName("journeytogensokyo:gensokyoNotesDus");
    	gensokyoNotesItem = new BaseItem()
							.setUnlocalizedName("gensokyoNotes")
							.setTextureName("journeytogensokyo:gensokyoNotes");
    	gensokyoNotesImbItem = new BaseItemEffect()
							.setUnlocalizedName("gensokyoNotesImb")
							.setTextureName("journeytogensokyo:gensokyoNotes");
    	gensokyoNotesArcItem = new BaseItemEffect()
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
