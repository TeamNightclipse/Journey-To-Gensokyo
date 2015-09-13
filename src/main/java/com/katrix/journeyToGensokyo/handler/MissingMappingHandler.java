package com.katrix.journeyToGensokyo.handler;

import java.util.List;

import com.katrix.journeyToGensokyo.block.JTGBlock;
import com.katrix.journeyToGensokyo.item.GensokyoOreBlockItem;
import com.katrix.journeyToGensokyo.item.JTGItem;
import com.katrix.journeyToGensokyo.reference.ModInfo;
import com.katrix.journeyToGensokyo.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import cpw.mods.fml.common.registry.GameRegistry.Type;

public class MissingMappingHandler {
	
	public static void MissingMappings(FMLMissingMappingsEvent event) {
		List<MissingMapping> mappings = event.get();
		for(MissingMapping mapping : mappings){
			if(mapping.type == Type.ITEM){
				//remapItem(mapping, compareItem(mapping));
				compareItem(mapping);
			}
			else{
				//remapBlock(mapping, compareBlock(mapping));
				compareBlock(mapping);
			}
		}
	}
	
	public static void remapItem(MissingMapping mapping, Item target){
		mapping.remap(target);
	}
	
	public static void remapBlock(MissingMapping mapping, Block target){
		mapping.remap(target);
	}
	
	public static Item compareItem(MissingMapping mapping){
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "gensokyoNotesImbItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesEffectItem;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "gensokyoNotesArcItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesEffectItem;
		}
		
		
		
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "gensokyoNotesRuinedItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "gensokyoNotesPatItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "gensokyoNotesDusItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoNotesItem;
		}
		
		
		
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "oldDemonSpellItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.oldGensokyoSpellItem;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "oldCelestialSpellItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.oldGensokyoSpellItem;
		}
		
		
		
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "demonDustItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoDustItem;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "celestialDustItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoDustItem;
		}
		
		
		
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "demonIngotItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoIngotItem;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "celestialIngotItem"){
			LogHelper.info("Found: " + mapping.name);
			return JTGItem.gensokyoIngotItem;
		}
		
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "demonOreBlock"){
			LogHelper.info("Found: " + mapping.name);
			return GensokyoOreBlockItem.getItemFromBlock(JTGBlock.gensokyoOreBlock);
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "celestialOreBlock"){
			LogHelper.info("Found: " + mapping.name);
			return GensokyoOreBlockItem.getItemFromBlock(JTGBlock.gensokyoOreBlock);
		}
		LogHelper.info(mapping.name.substring(ModInfo.MODID.length()+1));
		return null;
	}
	
	public static Block compareBlock(MissingMapping mapping){
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "celestialOreBlock"){
			LogHelper.info("Found: " + mapping.name);
			return JTGBlock.gensokyoOreBlock;
		}
		if(mapping.name.substring(ModInfo.MODID.length()+1) == "demonOreBlock"){
			LogHelper.info("Found: " + mapping.name);
			return JTGBlock.gensokyoOreBlock;
		}
		LogHelper.info(mapping.name.substring(ModInfo.MODID.length()+1));
		return null;
	}
}
