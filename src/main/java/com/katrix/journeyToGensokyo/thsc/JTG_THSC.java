package com.katrix.journeyToGensokyo.thsc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.katrix.journeyToGensokyo.reference.ModInfo;
import com.katrix.journeyToGensokyo.thsc.entity.EntityFamiliarIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyNether;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTenguCrow;
import com.katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_DoubleSpark;
import com.katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_FinalSpark;

import cpw.mods.fml.common.registry.EntityRegistry;
import thKaguyaMod.entity.living.EntityCirno;
import thKaguyaMod.registry.SpellCardRegistry;

public class JTG_THSC {
	
	public static void preInit() {
		
		//Spell Cards
		SpellCardRegistry.registerSpellCard(THSC_DoubleSpark.class, ModInfo.MODID, "DoubleSpark", 300);
		SpellCardRegistry.registerSpellCard(THSC_FinalSpark.class, ModInfo.MODID, "FinalSpark", 301);
	
	}
		
	public static void init() {
		//Entities
		EntityTHFairyIce.Init();
		EntityFamiliarIce.Init();
		EntityHellRaven.Init();
		EntityTenguCrow.Init();
		EntityTHFairyNether.Init();
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.COLD)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SNOWY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.MOUNTAIN)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			if (spawnbiomes.contains(biome)) {
				spawnbiomes.remove(biome);
			}
		}
		
		EntityRegistry.addSpawn(EntityCirno.class, 2, 1, 1, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
}
