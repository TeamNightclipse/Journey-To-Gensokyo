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
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import katrix.journeyToGensokyo.reference.SpecialShotID;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityXPOrb;
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
import thKaguyaMod.entity.living.EntityTHFairy;
import thKaguyaMod.init.THKaguyaConfig;

public class EntityTHFairyEnd extends EntityTHFairy {

	public EntityTHFairyEnd(World world) {
		super(world);

		experienceValue = 15;

		setMaxHP(5.0F);
		setHealth(5.0F);

		setForm((byte)(rand.nextInt(3) + 1));

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

		switch (getForm()) {
			case NORMAL_ATTACK01:
				danmakuSpan = 30;
				shotForm = DanmakuConstants.FORM_KUNAI;
				shotColor = DanmakuConstants.BLUE;
				speedRate = 0.4F;
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, special);

				danmaku01(angle, shotData, level);
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
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, SpecialShotID.SEED_LASER01);

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
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, SpecialShotID.SEED_LASER01);

				danmaku03(angle, shotData, level);
				break;
			default:
				break;
		}
	}

	public void danmaku01(Vec3 angle, ShotData shotData, int level) {
		int num = 1;

		if (level == 1 || level == 2) {
			num = 3;
		}

		if (attackCounter == 0) {
			THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
			angle = THShotLib.angle(rotationYaw, rotationPitch + 5);
			THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
			angle = THShotLib.angle(rotationYaw, rotationPitch - 5);
			THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);

			THShotLib.playShotSound(this);
		}

		if (level == 3) {
			num = 5;

			if (attackCounter == 0 || attackCounter == 10 || attackCounter == 20) {
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch + 5);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch + 10);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch - 5);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch - 10);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);

				THShotLib.playShotSound(this);
			}
		}

		if (level == 4) {
			num = 7;

			if (attackCounter <= 4) {
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch + 5);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch + 10);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch - 5);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw, rotationPitch - 10);
				THShotLib.createWideShot(getShooter(), pos(), angle, speedRate, shotData, num, 20.0f);

				THShotLib.playShotSound(this);
			}
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
	protected void onDeathUpdate() {
		++deathTime;

		if (deathTime == 20) {
			int i;

			if (!worldObj.isRemote && (recentlyHit > 0 || isPlayer()) && func_146066_aG() && worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
				i = getExperiencePoints(attackingPlayer);

				while (i > 0) {
					int j = EntityXPOrb.getXPSplit(i);
					i -= j;
					worldObj.spawnEntityInWorld(new EntityXPOrb(worldObj, posX, posY, posZ, j));
				}
			}

			setDead();

			for (i = 0; i < 20; ++i) {
				double d2 = rand.nextGaussian() * 0.02D;
				double d0 = rand.nextGaussian() * 0.02D;
				double d1 = rand.nextGaussian() * 0.02D;
				worldObj.spawnParticle("explode", posX + rand.nextFloat() * width * 2.0F - width, posY + rand.nextFloat() * height,
						posZ + rand.nextFloat() * width * 2.0F - width, d2, d0, d1);
			}
		}

		if (deathTime == 7) {
			THShotLib.explosionEffect2(worldObj, posX, posY, posZ, 1.0F + deathTime * 0.1F);
			THShotLib.banishExplosion(this, 5.0F, 5.0F);
		}
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
		return 3;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (rand.nextInt(100) < THKaguyaConfig.fairySpawnRate)
			return false;

		return worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
	}


	public static void postInit() {

		EntityRegistry.registerModEntity(EntityTHFairyEnd.class, EntityName.FAIRY_END, MobID.FAIRY_END, JourneyToGensokyo.instance, 80, 1, true);

		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.END)));

		if (THKaguyaConfig.spawnDanmakuMob && ConfigHandler.newFariesSpawn) {
			EntityRegistry.addSpawn(EntityTHFairyEnd.class, 10, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
		}
	}
}
