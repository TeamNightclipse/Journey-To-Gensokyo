/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.thsc;

import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.reference.ModInfo;
import katrix.journeyToGensokyo.reference.SpecialShotID;
import katrix.journeyToGensokyo.reference.SpellcardID;
import katrix.journeyToGensokyo.thsc.entity.EntityFamiliarIce;
import katrix.journeyToGensokyo.thsc.entity.EntityHellRaven;
import katrix.journeyToGensokyo.thsc.entity.EntityReimuHostile;
import katrix.journeyToGensokyo.thsc.entity.EntitySunFlowerFairyEnd;
import katrix.journeyToGensokyo.thsc.entity.EntityTHFairyEnd;
import katrix.journeyToGensokyo.thsc.entity.EntityTHFairyIce;
import katrix.journeyToGensokyo.thsc.entity.EntityTHFairyNether;
import katrix.journeyToGensokyo.thsc.entity.EntityTenguCrow;
import katrix.journeyToGensokyo.thsc.entity.shot.ShotFantasySeal;
import katrix.journeyToGensokyo.thsc.entity.shot.ShotSeed;
import katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_DoubleSpark;
import katrix.journeyToGensokyo.thsc.entity.spellcard.THSC_FinalSpark;
import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.registry.SpecialShotRegistry;
import thKaguyaMod.registry.SpellCardRegistry;

public class JTG_THSC {
	
	public static void preInit() {
		
		//Spell Cards
		SpellCardRegistry.registerSpellCard(THSC_DoubleSpark.class, ModInfo.MODID, "DoubleSpark", SpellcardID.DOUBLE_SPARK);
		SpellCardRegistry.registerSpellCard(THSC_FinalSpark.class, ModInfo.MODID, "FinalSpark", SpellcardID.FINAL_SPARK);
		

		SpecialShotRegistry.registerSpecialShot(ShotSeed.class, SpecialShotID.SEED_LASER01);
		
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, SpecialShotID.FANTASY_SEAL01);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, SpecialShotID.FANTASY_SEAL02);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, SpecialShotID.FANTASY_SEAL03);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, SpecialShotID.FANTASY_SEAL04);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, SpecialShotID.FANTASY_SEAL05);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, SpecialShotID.FANTASY_SEAL06);
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
		EntityReimuHostile.postInit();
		
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
