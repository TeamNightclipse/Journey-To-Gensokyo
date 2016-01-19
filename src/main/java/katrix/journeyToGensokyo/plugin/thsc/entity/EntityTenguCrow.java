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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
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
import thKaguyaMod.init.THKaguyaItems;

public class EntityTenguCrow extends EntityTHFairy {

	public EntityTenguCrow(World world) {
		super(world);

		setMaxHP(10.0F);
		setHealth(10.0F);

		shotColor = DanmakuConstants.YELLOW;
		setDanmakuPattern(rand.nextInt(2) + 1);

		setSpeed(0.5D);
		this.setSpecies(EntityDanmakuMob.SPECIES_YOUKAI, EntityDanmakuMob.SPECIES_YOUKAI_TENGU_CROW);

		setSize(1.3F, 1.2F);
		lastTime = 0;

		experienceValue = 10;

		lostTarget = 0;
		isFlyingMode = true;

		setAttackDistance(16.0D);
		setDetectionDistance(16.0D);
		setFlyingHeight(4);
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
	public void danmakuPattern(int level) {
		Vec3 angle;
		angle = THShotLib.angle(rotationYaw, rotationPitch);
		Vec3 accurateAngle = angle;
		angle = THShotLib.angle_LimitRandom(angle, THKaguyaConfig.danmakuAccuracy);
		ShotData shotData;
		int pattern;
		//System.out.println("Danmaku pattern is:  " + getDanmakuPattern());

		switch (getDanmakuPattern()) {
			case NORMAL_ATTACK01:
				danmakuSpan = 12;
				shotForm = DanmakuConstants.FORM_SMALL;
				speedRate = 0.3F;
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, special);
				pattern = 10;

				danmaku01(angle, accurateAngle, shotData, level, pattern);
				break;
			case NORMAL_ATTACK02:
				danmakuSpan = 12;
				shotForm = DanmakuConstants.FORM_SMALL;
				speedRate = 0.3F;
				shotData = ShotData.shot(shotForm, shotColor, 0, 80, special);
				pattern = 1;

				danmaku02(angle, accurateAngle, shotData, level, pattern);
				break;
			default:
				break;
		}
	}

	public void danmaku01(Vec3 angle, Vec3 accurateAngle, ShotData shotData, int level, int d) {
		float shotSpan = (d + 1F) * (level / 2);
		int num = (d / 100 + 1) * (level / 2);
		if (level == 1) {
			shotSpan = 1.0f;
		}
		if (level == 1) {
			num = 1;
		}
		if (attackCounter % 6 == 0) {
			THShotLib.createRandomRingShot(getShooter(), pos(), angle, speedRate, shotData, num, shotSpan);

			THShotLib.playShotSound(this);
		}

		if (attackCounter == 0) {

			int randMov = rand.nextInt(4);

			if (randMov == 0) {
				moveRight(rand.nextDouble() * 0.5D + 0.5D, 12);
			}
			else if (randMov == 1) {
				moveLeft(rand.nextDouble() * 0.5D + 0.5D, 12);
			}
			else if (randMov == 2) {
				moveForward(rand.nextDouble() * 0.1D + 0.1D, 12);
			}
			else if (randMov == 3) {
				if (rand.nextInt(2) == 0) {
					THShotLib.createShot(getShooter(), pos(), accurateAngle, 0.9F,
							ShotData.shot(DanmakuConstants.FORM_WIND, DanmakuConstants.RED, 0.8F, 1.0F, 0, 25));
					moveForward(rand.nextDouble() * 0.2D + 3.0D, 20);

					THShotLib.playShotSound(this);
				}
			}
		}
	}

	public void danmaku02(Vec3 angle, Vec3 accurateAngle, ShotData shotData, int level, int d) {
		int num = d + 1 * level;
		if (attackCounter % 8 == 0) {
			THShotLib.createRandomRingShot(getShooter(), pos(), angle, speedRate, shotData, num, 90F);

			THShotLib.playShotSound(this);
		}

		if (attackCounter == 0) {

			int randMov = rand.nextInt(4);

			if (randMov == 0) {
				moveRight(rand.nextDouble() * 0.5D + 0.5D, 12);
			}
			else if (randMov == 1) {
				moveLeft(rand.nextDouble() * 0.5D + 0.5D, 12);
			}
			else if (randMov == 2) {
				moveForward(rand.nextDouble() * 0.1D + 0.1D, 12);
			}
			else if (randMov == 3) {
				if (rand.nextInt(2) == 0) {
					THShotLib.createShot(getShooter(), pos(), accurateAngle, 0.9F,
							ShotData.shot(DanmakuConstants.FORM_WIND, DanmakuConstants.RED, 0.8F, 1.0F, 0, 25));
					moveForward(rand.nextDouble() * 0.2D + 3.0D, 20);

					THShotLib.playShotSound(this);
				}
			}
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
		return false;
	}

	@Override
	protected double getFairyCallDistance() {
		return 0.0D;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}

	@Override
	protected Item getDropItem() {
		return THKaguyaItems.power_item;
	}

	@Override
	protected void dropFewItems(boolean hasBeenAttackedByPlayer, int lootingLevel) {
		if (hasBeenAttackedByPlayer) {
			this.dropPowerUpItem(rand.nextInt(5) + rand.nextInt(3 + lootingLevel));
			this.dropPointItem(rand.nextInt(5) + rand.nextInt(3 + lootingLevel));
		}
	}

	@Override
	public boolean getCanSpawnHere() {
		if (rand.nextInt(100) < THKaguyaConfig.fairySpawnRate)
			return false;

		return worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
	}

	public static void postInit() {

		EntityRegistry.registerModEntity(EntityTenguCrow.class, LibEntityName.TENGU_CROW, LibMobID.TENGU_CROW, JourneyToGensokyo.instance, 80, 1, true);

		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.MOUNTAIN)));

		if (THKaguyaConfig.spawnDanmakuMob && ConfigHandler.newMobsSpawn) {
			EntityRegistry.addSpawn(EntityTenguCrow.class, 15, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
		}
	}
}
