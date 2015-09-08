/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.thaumcraft;

import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.item.JTGItem;

import net.minecraft.item.ItemStack;
import thKaguyaMod.init.THKaguyaItems;
import thaumcraft.api.ThaumcraftApi;

public class RegisterAspect {
	
	public static void postInit() {
		
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.gensokyoOreBlock), AspectListJTG.blockGensokyoOre);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.demonOreBlock), AspectListJTG.blockCelestialOre);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGBlock.celestialOreBlock), AspectListJTG.blockDemonOre);
    	
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoDustItem), AspectListJTG.itemGensokyoDust);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.demonDustItem), AspectListJTG.itemDemonDust);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.celestialDustItem), AspectListJTG.itemCelestialDust);
    	
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoIngotItem), AspectListJTG.itemGensokyoIngot);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.demonIngotItem), AspectListJTG.itemDemonIngot);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.celestialIngotItem), AspectListJTG.itemCelestialIngot);
    	
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldGensokyoSpellItem), AspectListJTG.itemGensokyoNote);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldCelestialSpellItem), AspectListJTG.itemCelestialNote);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.oldDemonSpellItem), AspectListJTG.itemDemonNote);
    	
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesRuinedItem), AspectListJTG.itemRuinedGensokyoNotes);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesPatItem), AspectListJTG.itemGensokyoNotesPat);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesDusItem), AspectListJTG.itemGensokyoNotesDus);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesItem), AspectListJTG.itemGensokyoNotes);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesImbItem), AspectListJTG.itemGensokyoNotesImb);
    	ThaumcraftApi.registerObjectTag(new ItemStack(JTGItem.gensokyoNotesArcItem), AspectListJTG.itemGensokyoNotesArc);
    	
    	ThaumcraftApi.registerObjectTag(new ItemStack(THKaguyaItems.point_item), AspectListJTG.itemPointItem);
    	ThaumcraftApi.registerObjectTag(new ItemStack(THKaguyaItems.power_item), AspectListJTG.itemPowerItem);
    	
    	ThaumcraftApi.registerEntityTag("THFairyIce", AspectListJTG.entityTHFairyIce);
    	ThaumcraftApi.registerEntityTag("THFairy", AspectListJTG.entityTHFairy);
    	ThaumcraftApi.registerEntityTag("SunflowerFairy", AspectListJTG.entitySunflowerFairy);
    	ThaumcraftApi.registerEntityTag("THPhantom", AspectListJTG.entityTHPhantom);
    	ThaumcraftApi.registerEntityTag("Cirno", AspectListJTG.entityCirno);
    	ThaumcraftApi.registerEntityTag("Rumia", AspectListJTG.entityRumia);
    	ThaumcraftApi.registerEntityTag("Toziko", AspectListJTG.entityToziko);
    	ThaumcraftApi.registerEntityTag("Sanae", AspectListJTG.entitySanae);
    	ThaumcraftApi.registerEntityTag("Hanabeeper", AspectListJTG.entityHanabeeper);
    	ThaumcraftApi.registerEntityTag("Rinnosuke", AspectListJTG.entityRinnosuke);
		
	}

}
