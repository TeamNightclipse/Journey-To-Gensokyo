package com.katrix.journeyToGensokyo.thsc;

import com.katrix.journeyToGensokyo.reference.ModInfo;
import com.katrix.journeyToGensokyo.thsc.entity.EntityFamiliarIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyNether;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTenguCrow;
import com.katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_DoubleSpark;
import com.katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_FinalSpark;

import thKaguyaMod.init.THKaguyaConfig;
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
		
		if(THKaguyaConfig.spawnDanmakuMob) {
			
			if(THKaguyaConfig.spawnFairy){
				SpawnBiomeFixer.FairyFix();
			}
			
			if(THKaguyaConfig.spawnPhantom){
				SpawnBiomeFixer.PhantomFix();
			}
			
			if(THKaguyaConfig.spawnHanabeeper){
				SpawnBiomeFixer.HanabeeperFix();
			}
			
			if(THKaguyaConfig.spawnBoss){
				SpawnBiomeFixer.CirnoFix();
				SpawnBiomeFixer.RumiaFix();
				SpawnBiomeFixer.TozikoFix();
				SpawnBiomeFixer.WriggleFix();
			}
			
			SpawnBiomeFixer.AmbientFix();
		}
	}
}
