/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.lib.LibEntityName;
import katrix.journeyToGensokyo.lib.LibMobID;
import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.living.EntitySunFlowerFairy;
import thKaguyaMod.init.THKaguyaConfig;

public class EntitySunFlowerFairyEnd extends EntitySunFlowerFairy {

	public EntitySunFlowerFairyEnd(World world) {
		super(world);

		setDanmakuPattern(rand.nextInt(3) + 1);

		setSpeed(0.7D);
		this.setSpecies(EntityDanmakuMob.SPECIES_FAIRY);

		setAttackDistance(16.0D);
		setDetectionDistance(16.0D);
		setFlyingHeight(4);
	}

	@Override
	public void danmakuPattern(int level) {
		Vec3 angle;
		angle = THShotLib.angle(rotationYaw, rotationPitch);
		angle = THShotLib.angle_LimitRandom(angle, THKaguyaConfig.danmakuAccuracy);
		ShotData shotData;

		switch (getDanmakuPattern()) {
			case NORMAL_ATTACK01:
				danmakuSpan = 10;
				shotForm = DanmakuConstants.FORM_STAR;
				shotColor = DanmakuConstants.RANDOM;
				speedRate = 0.2F;
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, special);

				danmaku01(angle, shotData, speedRate, level);
				break;
			case NORMAL_ATTACK02:
				if (level == 1) {
					danmakuSpan = 30;
				}
				if (level == 2) {
					danmakuSpan = 20;
				}
				if (level == 3) {
					danmakuSpan = 15;
				}
				if (level == 4) {
					danmakuSpan = 10;
				}
				shotForm = DanmakuConstants.FORM_CRYSTAL;
				speedRate = 0.1F;
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, LibSpecialShotId.SEED_LASER01);

				danmaku02(angle, shotData, level);
				break;
			case NORMAL_ATTACK03:
				if (level == 1) {
					danmakuSpan = 30;
				}
				if (level == 2) {
					danmakuSpan = 20;
				}
				if (level == 3) {
					danmakuSpan = 15;
				}
				if (level == 4) {
					danmakuSpan = 10;
				}
				shotForm = DanmakuConstants.FORM_CRYSTAL;
				speedRate = 0.1F;
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, LibSpecialShotId.SEED_LASER01);

				danmaku03(angle, shotData, level);
				break;
			default:
				break;
		}
	}

	public void danmaku01(Vec3 angle, ShotData shotData, float speedRate, int level) {
		int num = level;

		if (attackCounter == 0) {
			THShotLib.playShotSound(this);
			THShotLib.createRandomRingShot(getShooter(), getShooter(), pos(), angle, 0.0f, 0, speedRate, 0.4D, 0.05D, gravity_Zero(), shotData, num, 0.5D,
					20.0F);
		}
	}

	public void danmaku02(Vec3 angle, ShotData shotData, int level) {
		int num = 3;
		if (level == 1) {
			num = 1;
		}
		if (level == 2) {
			num = 3;
		}
		if (level == 3) {
			num = 5;
		}
		if (level == 4) {
			num = 5;
		}

		if (attackCounter == 0) {

			THShotLib.playShotSound(this);

			if (level != 4) {
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
			}

			else {
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch + 10);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch - 10);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
			}
		}
	}

	public void danmaku03(Vec3 angle, ShotData shotData, int level) {
		int num = 3;
		if (level == 1) {
			num = 1;
		}
		if (level == 2) {
			num = 3;
		}
		if (level == 3) {
			num = 5;
		}
		if (level == 4) {
			num = 5;
		}

		if (attackCounter == 0) {
			THShotLib.createRandomRingShot(getShooter(), pos(), angle, speedRate, speedRate, 0.0D, shotData, num, 0.75D, 0.0f);

			THShotLib.playShotSound(this);
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		if (!damageSource.isMagicDamage()) {
			amount *= 0.5F;
		}
		return super.attackEntityFrom(damageSource, amount);
	}

	@Override
	protected boolean canFairyCall() {
		return true;
	}

	@Override
	protected double getFairyCallDistance() {
		return 12.0D;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (rand.nextInt(100) < THKaguyaConfig.fairySpawnRate)
			return false;

		return worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
	}

	public static void postInit() {

		EntityRegistry.registerModEntity(EntitySunFlowerFairyEnd.class, LibEntityName.FAIRY_SUNFLOWER_END, LibMobID.FAIRY_SUNFLOWER_END, JourneyToGensokyo.instance,
				80, 1, true);

		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.END)));

		if (THKaguyaConfig.spawnDanmakuMob && ConfigHandler.newFariesSpawn) {
			EntityRegistry.addSpawn(EntitySunFlowerFairyEnd.class, 5, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
		}
	}
}
