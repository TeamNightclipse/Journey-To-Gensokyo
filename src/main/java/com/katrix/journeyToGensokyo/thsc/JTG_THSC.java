/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.thsc;

import com.katrix.journeyToGensokyo.handler.ConfigHandler;
import com.katrix.journeyToGensokyo.reference.ModInfo;
import com.katrix.journeyToGensokyo.reference.SpecialShotID;
import com.katrix.journeyToGensokyo.reference.SpellcardID;
import com.katrix.journeyToGensokyo.thsc.entity.EntityFamiliarIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;
import com.katrix.journeyToGensokyo.thsc.entity.EntitySunFlowerFairyEnd;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyEnd;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyIce;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTHFairyNether;
import com.katrix.journeyToGensokyo.thsc.entity.EntityTenguCrow;
import com.katrix.journeyToGensokyo.thsc.entity.shot.SeedShot;
import com.katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_DoubleSpark;
import com.katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_FinalSpark;

import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.registry.SpecialShotRegistry;
import thKaguyaMod.registry.SpellCardRegistry;

public class JTG_THSC {
	
	public static void preInit() {
		
		//Spell Cards
		SpellCardRegistry.registerSpellCard(THSC_DoubleSpark.class, ModInfo.MODID, "DoubleSpark", SpellcardID.DOUBLE_SPARK);
		SpellCardRegistry.registerSpellCard(THSC_FinalSpark.class, ModInfo.MODID, "FinalSpark", SpellcardID.FINAL_SPARK);
		

		SpecialShotRegistry.registerSpecialShot(SeedShot.class, SpecialShotID.SEED_LASER01);
	}
		
	public static void postInit() {
		//Entities
		EntityTHFairyIce.postInit();
		EntityFamiliarIce.postInit();
		EntityHellRaven.postInit();
		EntityTenguCrow.postInit();
		EntityTHFairyNether.postInit();
		EntityTHFairyEnd.postInit();
		EntitySunFlowerFairyEnd.postInit();
		
		if(THKaguyaConfig.spawnDanmakuMob && ConfigHandler.fixTHKaguyaSpawn) {
			
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
