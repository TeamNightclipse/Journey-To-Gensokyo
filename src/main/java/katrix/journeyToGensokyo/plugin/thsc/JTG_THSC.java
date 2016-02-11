/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc;

import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.lib.LibMod;
import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import katrix.journeyToGensokyo.lib.LibSpellcardId;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityFamiliarIce;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityHellRaven;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMarisa;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroJTG;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityReimuHostile;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityStandardShot;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntitySunFlowerFairyEnd;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTHFairyEnd;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTHFairyIce;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTHFairyNether;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityTenguCrow;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityYukari;
import katrix.journeyToGensokyo.plugin.thsc.entity.shot.ShotFantasySeal;
import katrix.journeyToGensokyo.plugin.thsc.entity.shot.ShotHoming;
import katrix.journeyToGensokyo.plugin.thsc.entity.shot.ShotMissile;
import katrix.journeyToGensokyo.plugin.thsc.entity.shot.ShotSeed;
import katrix.journeyToGensokyo.plugin.thsc.entity.shot.ShotSlaveMarisa;
import katrix.journeyToGensokyo.plugin.thsc.entity.shot.ShotSpiritulip;
import katrix.journeyToGensokyo.plugin.thsc.entity.spellcard.THSC_CurseOfDreamsAndReality;
import katrix.journeyToGensokyo.plugin.thsc.entity.spellcard.THSC_DoubleSpark;
import katrix.journeyToGensokyo.plugin.thsc.entity.spellcard.THSC_FinalSpark;
import katrix.journeyToGensokyo.plugin.thsc.entity.spellcard.THSC_MeshLightDarkness;
import net.minecraftforge.common.MinecraftForge;
import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.registry.SpecialShotRegistry;
import thKaguyaMod.registry.SpellCardRegistry;

public class JTG_THSC {

	public static void preInit() {

		//Special Shots
		SpecialShotRegistry.registerSpecialShot(ShotSeed.class, LibSpecialShotId.SEED_LASER01);

		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, LibSpecialShotId.FANTASY_SEAL01);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, LibSpecialShotId.FANTASY_SEAL02);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, LibSpecialShotId.FANTASY_SEAL03);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, LibSpecialShotId.FANTASY_SEAL04);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, LibSpecialShotId.FANTASY_SEAL05);
		SpecialShotRegistry.registerSpecialShot(ShotFantasySeal.class, LibSpecialShotId.FANTASY_SEAL06);

		SpecialShotRegistry.registerSpecialShot(THSC_CurseOfDreamsAndReality.class, LibSpecialShotId.DREAMS_AND_REALITY01);
		SpecialShotRegistry.registerSpecialShot(THSC_CurseOfDreamsAndReality.class, LibSpecialShotId.DREAMS_AND_REALITY02);
		SpecialShotRegistry.registerSpecialShot(THSC_CurseOfDreamsAndReality.class, LibSpecialShotId.DREAMS_AND_REALITY03);
		SpecialShotRegistry.registerSpecialShot(THSC_CurseOfDreamsAndReality.class, LibSpecialShotId.DREAMS_AND_REALITY11);

		SpecialShotRegistry.registerSpecialShot(THSC_MeshLightDarkness.class, LibSpecialShotId.MESH_LASER01);

		SpecialShotRegistry.registerSpecialShot(ShotMissile.class, LibSpecialShotId.MISSILE01);

		SpecialShotRegistry.registerSpecialShot(ShotHoming.class, LibSpecialShotId.JTG_HOMING01);
		SpecialShotRegistry.registerSpecialShot(ShotHoming.class, LibSpecialShotId.JTG_HOMING02);
		
		SpecialShotRegistry.registerSpecialShot(ShotSlaveMarisa.class, LibSpecialShotId.SLAVE_MARISA01);
		SpecialShotRegistry.registerSpecialShot(ShotSlaveMarisa.class, LibSpecialShotId.SLAVE_MARISA02);
		SpecialShotRegistry.registerSpecialShot(ShotSlaveMarisa.class, LibSpecialShotId.SLAVE_MARISA03);
		
		SpecialShotRegistry.registerSpecialShot(ShotSpiritulip.class, LibSpecialShotId.SPIRITULIP01);

		//Spell Cards
		SpellCardRegistry.registerSpellCard(THSC_DoubleSpark.class, LibMod.MODID, "DoubleSpark", LibSpellcardId.DOUBLE_SPARK);
		SpellCardRegistry.registerSpellCard(THSC_FinalSpark.class, LibMod.MODID, "FinalSpark", LibSpellcardId.FINAL_SPARK);
		SpellCardRegistry.registerSpellCard(THSC_CurseOfDreamsAndReality.class, LibMod.MODID, "CurseOfDreamsAndReality", LibSpellcardId.DREAMS_AND_REALITY);
		SpellCardRegistry.registerSpellCard(THSC_MeshLightDarkness.class, LibMod.MODID, "MeshOfLightAndDarkness", LibSpellcardId.MESH_LIGHT_DARKNESS);
	}
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new EventDanmakuHit());
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
		EntityYukari.postInit();
		EntityStandardShot.postInit();
		EntityMiniHakkeroJTG.postInit();
		EntityMarisa.postInit();

		if (THKaguyaConfig.spawnDanmakuMob && ConfigHandler.fixTHKaguyaSpawn) {

			if (THKaguyaConfig.spawnFairy) {
				SpawnBiomeFixer.FairyFix();
			}

			if (THKaguyaConfig.spawnPhantom) {
				SpawnBiomeFixer.PhantomFix();
			}

			if (THKaguyaConfig.spawnHanabeeper) {
				SpawnBiomeFixer.HanabeeperFix();
			}

			if (THKaguyaConfig.spawnBoss) {
				SpawnBiomeFixer.CirnoFix();
				SpawnBiomeFixer.RumiaFix();
				SpawnBiomeFixer.TozikoFix();
				SpawnBiomeFixer.WriggleFix();
			}

			SpawnBiomeFixer.AmbientFix();
		}
	}
}
