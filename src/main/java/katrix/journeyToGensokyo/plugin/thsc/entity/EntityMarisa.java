/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.plugin.thsc.entity;

import java.util.List;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.lib.LibEntityName;
import katrix.journeyToGensokyo.lib.LibMobID;
import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import katrix.journeyToGensokyo.lib.LibSpellcardId;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.spellcard.EntitySpellCard;
import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.init.THKaguyaItems;
import thKaguyaMod.item.ItemTHShot;

public class EntityMarisa extends EntityDanmakuMob {

	public boolean perfect = true;

	public EntityMarisa(World world) {
		super(world);

		setSize(1.0F, 1.8F);

		experienceValue = 250;

		setDanmakuMobName("Marisa Kirisame");
		this.setSpecies(EntityDanmakuMob.SPECIES_HUMAN);

		setDanmakuPattern(NORMAL_ATTACK01);
		setMaxHP(60.0F);
		setHealth(60.0F);
		setSpeed(0.4F);
		setAttackDistance(20.0D);
		setDetectionDistance(0.0D);
		setFlyingHeight(0);
		isFlyingMode = false;

		isSpellCardMode = false;
		attackInterval = 0;
	}

	@Override
	public int getUsingSpellCardNo() {
		switch(getDanmakuPattern()) {
			case SPELLCARD_ATTACK01:
				return EntitySpellCard.SC_MARISA_StardustReverie;
			case SPELLCARD_ATTACK02:
				return EntitySpellCard.SC_MARISA_NonDirectionalLaser;
			case SPELLCARD_ATTACK03:
				return EntitySpellCard.SC_MARISA_MasterSpark;
			case SPELLCARD_ATTACK04:
				return LibSpellcardId.DOUBLE_SPARK;
			default:
				return -1;
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(!worldObj.isRemote && perfect) {
			int range = 3;
			@SuppressWarnings("unchecked")
			List<EntitySpellCard> listspellcard = worldObj.getEntitiesWithinAABB(EntitySpellCard.class, AxisAlignedBB.getBoundingBox(posX - range * 12,
					posY - range * 12, posZ - range * 12, posX + range * 12 + 1, posY + range * 12 + 1, posZ + range * 12 + 1));

			for(EntitySpellCard spellcard : listspellcard) {
				if(spellcard.user != this) {
					perfect = false;
					if(getDanmakuPattern() == SPELLCARD_ATTACK04) {
						moveDanmakuAttack(ATTACK_END, 90, 0F, 160);
					}
					break;
				}
			}
		}
	}

	@Override
	protected void onDeathUpdate() {
		switch(getDanmakuPattern()) {
			case NORMAL_ATTACK01:
				moveDanmakuAttack(SPELLCARD_ATTACK01, 40, 60.0F, 160);
				break;
			case SPELLCARD_ATTACK01:
				moveDanmakuAttack(NORMAL_ATTACK02, 90, 60.0F, 160);
				break;
			case NORMAL_ATTACK02:
				moveDanmakuAttack(SPELLCARD_ATTACK02, 40, 60.0F, 160);
				break;
			case SPELLCARD_ATTACK02:
				moveDanmakuAttack(NORMAL_ATTACK03, 90, 60.0F, 160);
				break;
			case NORMAL_ATTACK03:
				moveDanmakuAttack(SPELLCARD_ATTACK03, 40, 60.0F, 160);
				break;
			case SPELLCARD_ATTACK03:
				if(perfect) {
					moveDanmakuAttack(SPELLCARD_ATTACK04, 40, 60F, 160);
				}
				else {
					moveDanmakuAttack(ATTACK_END, 90, 0.0F, 160);
				}
				break;
			case SPELLCARD_ATTACK04:
				moveDanmakuAttack(ATTACK_END, 90, 0F, 160);
				break;
			default:
				if(deathTime % 6 == 0) {
					THShotLib.explosionEffect(worldObj, posX, posY, posZ, 1.0F + deathTime * 0.1F);
				}
				super.onDeathUpdate();
				break;
		}
	}


	@Override
	public void danmakuPattern(int level) {
		Vec3 look = getLookVec();
		switch(getDanmakuPattern()) {
			case NORMAL_ATTACK01:
				danmaku01(look, level);
				break;
			case SPELLCARD_ATTACK01:
				spellcard01(look, level);
				break;
			case NORMAL_ATTACK02:
				danmaku02(look, level);
				break;
			case SPELLCARD_ATTACK02:
				spellcard02(look, level);
				break;
			case NORMAL_ATTACK03:
				danmaku03(look, level);
				break;
			case SPELLCARD_ATTACK03:
				spellcard03(look, level);
				break;
			case SPELLCARD_ATTACK04:
				finalWord(look, level);
				break;
			default:
				break;
		}
	}

	private void danmaku01(Vec3 angle, int level) {
		playerNear();

		if(attackCounter == 1) {
			Vec3 look = getLookVec();
			Vec3 rotate = THShotLib.getVecFromAngle(rotationYaw, rotationPitch - 90F);
			Vec3 move = THShotLib.getVectorFromRotation(rotate.xCoord, rotate.yCoord, rotate.zCoord, look.xCoord, look.yCoord, look.zCoord, 90F);
			THShotLib.createShot(this, this, THShotLib.pos_Distance(this.pos(), getLookVec(), -5D), move, 0F, rotate, -7F, 9999, 0.5D, 0.5D, 0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_FAMILIAR, DanmakuConstants.RAINBOW, 0, 20 * level, LibSpecialShotId.SLAVE_MARISA01));
		}

		if(attackCounter >= 20) {
			attackCounter = 0;
		}
	}

	private void spellcard01(Vec3 angle, int level) {

		if(attackCounter == 1) {
			useSpellCard(EntitySpellCard.SC_MARISA_StardustReverie);
		}

		if(attackCounter >= 100) {
			attackCounter = 0;
		}
	}

	private void danmaku02(Vec3 angle, int level) {
		playerNear();

		if(attackCounter == 1) {
			Vec3 look = getLookVec();
			Vec3 rotate = THShotLib.getVecFromAngle(rotationYaw, rotationPitch - 90F);
			Vec3 move = THShotLib.getVectorFromRotation(rotate.xCoord, rotate.yCoord, rotate.zCoord, look.xCoord, look.yCoord, look.zCoord, 90F);
			THShotLib.createShot(this, this, THShotLib.pos_Distance(this.pos(), getLookVec(), -3D), move, 0F, rotate, -5F, 9999, 0.5D, 0.5D, 0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_FAMILIAR, DanmakuConstants.RAINBOW, 0, 20 * level, LibSpecialShotId.SLAVE_MARISA02));
		}
		else if(attackCounter == 10) {
			Vec3 look = getLookVec();
			Vec3 rotate = THShotLib.getVecFromAngle(rotationYaw, rotationPitch - 90F);
			Vec3 move = THShotLib.getVectorFromRotation(rotate.xCoord, rotate.yCoord, rotate.zCoord, look.xCoord, look.yCoord, look.zCoord, 90F);
			THShotLib.createShot(this, this, THShotLib.pos_Distance(this.pos(), getLookVec(), -5D), move, 0F, rotate, -8F, 9999, 0.5D, 0.5D, 0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_FAMILIAR, DanmakuConstants.RAINBOW, 0, 20 * level, LibSpecialShotId.SLAVE_MARISA02));
		}

		if(attackCounter >= 20) {
			attackCounter = 0;
		}
	}

	private void spellcard02(Vec3 angle, int level) {

		if(ticksExisted % 3 == 0) {
			Vec3 angle1 = THShotLib.angle(360F / 100F * attackCounter, rotationPitch);
			THShotLib.createCircleShot(this, this.pos(), angle1, 0.5D, ShotData.shot(DanmakuConstants.FORM_STAR, DanmakuConstants.RAINBOW, 0, 60), 4 * level);
		}

		if(attackCounter == 1) {
			useSpellCard(EntitySpellCard.SC_MARISA_NonDirectionalLaser);
		}

		if(attackCounter >= 110) {
			attackCounter = 0;
		}
	}

	private void danmaku03(Vec3 angle, int level) {
		playerNear();

		if(attackCounter == 1) {
			Vec3 look = getLookVec();
			Vec3 rotate = THShotLib.getVecFromAngle(rotationYaw, rotationPitch - 90F);
			Vec3 move = THShotLib.getVectorFromRotation(rotate.xCoord, rotate.yCoord, rotate.zCoord, look.xCoord, look.yCoord, look.zCoord, 90F);
			THShotLib.createShot(this, this, THShotLib.pos_Distance(this.pos(), getLookVec(), -5D), move, 0F, rotate, -7F, 9999, 0.5D, 0.5D, 0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_FAMILIAR, DanmakuConstants.YELLOW, 0, 20 * level, LibSpecialShotId.SLAVE_MARISA03));
		}

		if(attackCounter >= 10) {
			attackCounter = 0;
		}
	}

	private void spellcard03(Vec3 angle, int level) {

		if(attackCounter == 1) {
			useSpellCard(EntitySpellCard.SC_MARISA_MasterSpark);
		}

		if(attackCounter >= 110) {
			attackCounter = 0;
		}
	}

	private void finalWord(Vec3 angle, int level) {

		if(attackCounter == 1) {
			useSpellCard(LibSpellcardId.DOUBLE_SPARK);
		}

		if(attackCounter >= 110) {
			attackCounter = 0;
		}
	}

	private void playerNear() {
		int range = 4;
		@SuppressWarnings("unchecked")
		List<EntityPlayer> players = worldObj.getEntitiesWithinAABB(EntityPlayer.class,
				AxisAlignedBB.getBoundingBox(posX - range, posY - range, posZ - range, posX + range + 1, posY + range + 1, posZ + range + 1));
		for(EntityPlayer player : players) {
			Vec3 vectorToPlayer = THShotLib.angle_ToPos(pos(), pos(player));
			ShotData shot = ShotData.shot(DanmakuConstants.FORM_SMALLSTAR, DanmakuConstants.RED);
			THShotLib.createWideShot(this, pos(), vectorToPlayer, 0.6D, shot, 5, 30F);
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		if(!(damageSource.getSourceOfDamage() instanceof EntityTHShot)) {
			perfect = false;
			if(getDanmakuPattern() == SPELLCARD_ATTACK04) {
				moveDanmakuAttack(ATTACK_END, 90, 0F, 160);
			}
		}
		if(!damageSource.isMagicDamage()) {
			amount *= 0.5F;
		}
		isFlyingMode = true;
		setFlyingHeight(4);
		return super.attackEntityFrom(damageSource, amount);
	}

	@Override
	protected boolean canFairyCall() {
		return false;
	}

	/**
	 * Reduces damage, depending on potions
	 */
	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float damage) {
		damage = super.applyPotionDamageCalculations(damageSource, damage);

		if(isEntityInvulnerable()) {
			damage = (float)(damage * 0.05D);
		}

		return damage;
	}

	@Override
	protected void dropFewItems(boolean hasBeenAttackedByPlayer, int lootingLevel) {
		super.dropFewItems(hasBeenAttackedByPlayer, lootingLevel);

		if(hasBeenAttackedByPlayer && isSpellCardAttack()) {
			int j = 40;
			int k;
			Vec3 vec3;
			float yaw;
			float pitch;

			for(k = 0; k < j; k += 2) {
				yaw = 360F / j * k;
				pitch = MathHelper.sin((float)(Math.toRadians(yaw) * 4F)) * 20F - 60F;
				vec3 = THShotLib.getVecFromAngle(yaw, pitch);
				this.dropPointItem(this.pos(), vec3);

				yaw = 360F / j * (k + 1);
				pitch = MathHelper.cos((float)(Math.toRadians(yaw) * 4F)) * 20F - 60F;
				vec3 = THShotLib.getVecFromAngle(yaw, pitch);
				this.dropPowerUpItem(this.pos(), vec3);
			}

			dropShotItem(ItemTHShot.STAR, 8 + rand.nextInt(2) + lootingLevel, 5, 32, DanmakuConstants.BLUE, 0, 0, 2);
			dropShotItem(ItemTHShot.SMALLSTAR, 9 + rand.nextInt(2) + lootingLevel, 5, 32, DanmakuConstants.RED, 0, 0, 2);
		}

		if(hasBeenAttackedByPlayer && getDanmakuPattern() == SPELLCARD_ATTACK03) {
			this.dropItem(THKaguyaItems.marisa_hat, 1);
		}
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean getCanSpawnHere() {
		if(rand.nextInt(100) < THKaguyaConfig.fairySpawnRate && rand.nextInt(100) < 90 || !super.getCanSpawnHere()) return false;

		int range = 64;
		@SuppressWarnings("unchecked") List<EntityMarisa> marisas = worldObj.getEntitiesWithinAABB(EntityReimuHostile.class,
				AxisAlignedBB.getBoundingBox(posX - range, posY - range, posZ - range, posX + range + 1, posY + range + 1, posZ + range + 1));
		return marisas.size() < 1 && worldObj.difficultySetting != EnumDifficulty.PEACEFUL;

	}

	public static void postInit() {
		EntityRegistry.registerModEntity(EntityMarisa.class, LibEntityName.MARISA, LibMobID.MARISA, JourneyToGensokyo.instance, 80, 1, true);

		if(THKaguyaConfig.spawnBoss && ConfigHandler.newBossesSpawn) {
			EntityRegistry.addSpawn(EntityMarisa.class, 1, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.FOREST));
		}
	}
}
