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
import katrix.journeyToGensokyo.lib.LibEntityName;
import katrix.journeyToGensokyo.lib.LibMobID;
import katrix.journeyToGensokyo.lib.LibSpellcardId;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.shot.EntityTHLaser;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.spellcard.EntitySpellCard;
import thKaguyaMod.init.THKaguyaItems;
import thKaguyaMod.item.ItemTHShot;

public class EntityYukari extends EntityDanmakuMob {

	public EntityYukari(World world) {
		super(world);

		setSize(1.0F, 2.0F);

		experienceValue = 250;

		setDanmakuMobName("Yukari Yakumo");
		this.setSpecies(SPECIES_YOUKAI);

		setDanmakuPattern(NORMAL_ATTACK01);
		setMaxHP(100.0F);
		setHealth(100.0F);
		setSpeed(0.45F);
		setAttackDistance(20.0D);
		setDetectionDistance(20.0D);
		setFlyingHeight(2);
		isFlyingMode = true;

		isSpellCardMode = false;
		attackInterval = 0;

		setInvicibilityTimer(0);
	}

	@Override
	public int getUsingSpellCardNo() {
		switch (getDanmakuPattern()) {
			case SPELLCARD_ATTACK01:
				return EntitySpellCard.SC_YUKARI_HikouchuuNest; //Fantasy Nest "Flying-glowworm Nest"
			case SPELLCARD_ATTACK02:
				return LibSpellcardId.DREAMS_AND_REALITY; //Boundary "Curse of Dreams and Reality"
			case SPELLCARD_ATTACK03:
				return EntitySpellCard.SC_YUKARI_NijuuKokushichou; //Sinister Spirits "Double Black Death Butterfly"
			case SPELLCARD_ATTACK04:
				return LibSpellcardId.MESH_LIGHT_DARKNESS; //Boundary "Mesh of Light and Darkness"
			case SPELLCARD_ATTACK05:
				return EntitySpellCard.SC_YUKARI_Nami_to_Tubu_no_Kyoukai; //Boundary Sign "Boundary between Wave and Particle"
			default:
				return -1;
		}
	}

	@Override
	protected void onDeathUpdate() {
		switch (getDanmakuPattern()) {
			case NORMAL_ATTACK01:
				moveDanmakuAttack(SPELLCARD_ATTACK01, 10, 100.0F, 160);
				break;
			case SPELLCARD_ATTACK01:
				moveDanmakuAttack(NORMAL_ATTACK02, 10, 100.0F, 160);
				break;
			case NORMAL_ATTACK02:
				moveDanmakuAttack(SPELLCARD_ATTACK02, 10, 100.0F, 160);
				break;
			case SPELLCARD_ATTACK02:
				moveDanmakuAttack(NORMAL_ATTACK03, 10, 100.0F, 160);
				break;
			case NORMAL_ATTACK03:
				moveDanmakuAttack(SPELLCARD_ATTACK03, 10, 300.0F, 160);
				break;
			case SPELLCARD_ATTACK03:
				moveDanmakuAttack(NORMAL_ATTACK04, 10, 100.0F, 160);
				break;
			case NORMAL_ATTACK04:
				moveDanmakuAttack(SPELLCARD_ATTACK04, 10, 100.0F, 160);
				break;
			case SPELLCARD_ATTACK04:
				moveDanmakuAttack(NORMAL_ATTACK05, 10, 100.0F, 160);
				break;
			case NORMAL_ATTACK05:
				moveDanmakuAttack(SPELLCARD_ATTACK05, 10, 300.0F, 160);
				break;
			case SPELLCARD_ATTACK05:
				moveDanmakuAttack(ATTACK_END, 10, 0.0F, 160);
				break;
			default:
				if (deathTime % 6 == 0) {
					THShotLib.explosionEffect(worldObj, posX, posY, posZ, 1.0F + deathTime * 0.1F);
				}
				super.onDeathUpdate();
				break;
		}
	}

	@Override
	public void danmakuPattern(int level) {
		Vec3 look = getLookVec();
		switch (getDanmakuPattern()) {
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
			case NORMAL_ATTACK04:
				danmaku04(look, level);
				break;
			case SPELLCARD_ATTACK04:
				spellcard04(look, level);
				break;
			case NORMAL_ATTACK05:
				danmaku05(look, level);
				break;
			case SPELLCARD_ATTACK05:
				spellcard05(look, level);
				break;
			default:
				break;
		}
	}

	private void danmaku01(Vec3 angle, int level) {
		if (attackCounter == 1) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), angle, 0.3D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.PURPLE, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 12 * level);
		}

		else if (attackCounter == 2) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), angle, 0.31D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.PURPLE, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 12 * level);
			THShotLib.createCircleShot(this, pos(), angle, 0.5D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.PURPLE, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 12 * level);
		}
		if (attackCounter >= 10) {
			attackCounter = 0;
		}
	}

	private void spellcard01(Vec3 angle, int level) {
		if (attackCounter == 1) {
			useSpellCard(EntitySpellCard.SC_YUKARI_HikouchuuNest);
		}

		if (attackCounter >= 170) {
			attackCounter = 0;
		}
	}

	private void danmaku02(Vec3 angle, int level) {
		if (attackCounter == 1) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), angle, 0.3D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.PURPLE, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 12 * level);
		}

		else if (attackCounter == 2) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), angle, 0.4D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 12 * level);
			THShotLib.createCircleShot(this, pos(), angle, 0.5D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 12 * level);
		}

		if (attackCounter >= 10) {
			attackCounter = 0;
		}
	}

	private void spellcard02(Vec3 angle, int level) {
		if (attackCounter == 1) {
			useSpellCard(LibSpellcardId.DREAMS_AND_REALITY);
		}

		if (attackCounter >= 130) {
			attackCounter = 0;
		}
	}

	private void danmaku03(Vec3 angle, int level) {
		if (attackCounter == 1) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), angle, 0.3D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 14.0f, 0, 60), 32 * level);
			THShotLib.createCircleShot(this, pos(), angle, 0.6D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 14.0f, 0, 60), 32 * level);
		}

		if (attackCounter >= 20) {
			attackCounter = 0;
		}
	}

	private void spellcard03(Vec3 angle, int level) {
		if (attackCounter == 1) {
			useSpellCard(EntitySpellCard.SC_YUKARI_NijuuKokushichou);
		}

		if (attackCounter >= 150) {
			attackCounter = 0;
		}
	}

	private void danmaku04(Vec3 angle, int level) {
		if (attackCounter % 2 == 0) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter * 5, rotationPitch), 0.3D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.GREEN, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 2 * level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter * 5, rotationPitch), 0.4D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.GREEN, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 2 * level);
		}

		if (attackCounter % 2 != 0) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw - attackCounter * 5, rotationPitch), 0.3D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 2 * level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw - attackCounter * 5, rotationPitch), 0.4D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 6.0f, 0, 60), 2 * level);
		}

		if (attackCounter >= 60) {
			attackCounter = 0;
		}
	}

	private void spellcard04(Vec3 angle, int level) {
		if (attackCounter == 1) {
			useSpellCard(LibSpellcardId.MESH_LIGHT_DARKNESS);
		}

		if (attackCounter >= 100) {
			attackCounter = 0;
		}
	}

	private void danmaku05(Vec3 angle, int level) {
		if (attackCounter % 3 == 0) {
			THShotLib.playShotSound(this);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter * 5, rotationPitch), 0.4D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 9.0f, 0, 50), 4 * level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter * 5, rotationPitch), 0.5D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 9.0f, 0, 50), 4 * level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw + attackCounter * 5, rotationPitch), 0.6D,
					ShotData.shot(DanmakuConstants.FORM_KUNAI, DanmakuConstants.AQUA, THShotLib.SIZE[DanmakuConstants.FORM_KUNAI], 9.0f, 0, 50), 4 * level);
		}

		if (attackCounter >= 60) {
			attackCounter = 0;
		}
	}

	private void spellcard05(Vec3 angle, int level) {
		if (attackCounter == 1) {
			useSpellCard(EntitySpellCard.SC_YUKARI_Nami_to_Tubu_no_Kyoukai);
		}

		if (attackCounter >= 300) {
			attackCounter = 0;
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (!worldObj.isRemote) {
			int range = 4;
			int invicibilityTimer = getInvicibilityTimer();

			@SuppressWarnings("unchecked")
			List<EntityTHShot> listShot = worldObj.getEntitiesWithinAABB(EntityTHShot.class,
					AxisAlignedBB.getBoundingBox(posX - range, posY - range, posZ - range, posX + range + 1, posY + range + 1, posZ + range + 1));

			for(EntityTHShot shots : listShot) {
				if(shots.source instanceof EntitySpellCard && shots.user != this) {
					invicibilityTimer += 3;
				}
			}

			@SuppressWarnings("unchecked")
			List<EntityTHLaser> listLaser = worldObj.getEntitiesWithinAABB(EntityTHLaser.class,
					AxisAlignedBB.getBoundingBox(posX - range, posY - range, posZ - range, posX + range + 1, posY + range + 1, posZ + range + 1));

			for(EntityTHLaser lasers : listLaser) {
				if(lasers.source instanceof EntitySpellCard && lasers.user != this) {
					invicibilityTimer += 3;
				}
			}

			@SuppressWarnings("unchecked")
			List<EntitySpellCard> listspellcard = worldObj.getEntitiesWithinAABB(EntitySpellCard.class, AxisAlignedBB.getBoundingBox(posX - range * 12,
					posY - range * 12, posZ - range * 12, posX + range * 12 + 1, posY + range * 12 + 1, posZ + range * 12 + 1));

			for(EntitySpellCard spellcards : listspellcard) {
				if(spellcards.user != this) {
					invicibilityTimer += 3;
				}
			}

			if (invicibilityTimer > 0) {
				if (invicibilityTimer > 28) {
					invicibilityTimer = 28;
				}
				invicibilityTimer--;
			}

			setInvicibilityTimer(invicibilityTimer);
		}
	}

	@Override
	public boolean isEntityInvulnerable() {
		return getInvicibilityTimer() > 0;
	}

	@Override
	protected boolean canFairyCall() {
		return false;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(20, 0); //invicibilityTimer
		dataWatcher.addObject(21, (byte)0); //isAgressive
	}

	private void setInvicibilityTimer(int timer) {
		dataWatcher.updateObject(20, timer);
	}

	public int getInvicibilityTimer() {
		return dataWatcher.getWatchableObjectInt(20);
	}

	private void setIsAgressive(byte agressive) {
		dataWatcher.updateObject(21, agressive);
	}

	public byte getIsAgressive() {
		return dataWatcher.getWatchableObjectByte(21);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbtTagCompound) {
		super.readEntityFromNBT(nbtTagCompound);
		setInvicibilityTimer(nbtTagCompound.getInteger("InvicibilityTimer"));
		setIsAgressive(nbtTagCompound.getByte("IsAgressive"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbtTagCompound) {
		super.writeEntityToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("InvicibilityTimer", getInvicibilityTimer());
		nbtTagCompound.setByte("IsAgressive", getIsAgressive());
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float damage) {
		damage = super.applyPotionDamageCalculations(damageSource, damage);

		if (isEntityInvulnerable()) {
			damage = (float)(damage * 0.05D);
		}

		return damage;
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		if (!damageSource.isMagicDamage()) {
			amount *= 0.5F;
		}

		if (amount > 6F) {
			amount = 6F;
		}

		isFlyingMode = true;
		setFlyingHeight(4);
		setIsAgressive((byte)1);
		return super.attackEntityFrom(damageSource, amount);
	}

	@Override
	protected void dropFewItems(boolean hasBeenAttackedByPlayer, int lootingLevel) {
		super.dropFewItems(hasBeenAttackedByPlayer, lootingLevel);

		if (hasBeenAttackedByPlayer && isSpellCardAttack()) {
			int j = 40;
			int k;
			Vec3 vec3;
			float yaw;
			float pitch;

			for (k = 0; k < j; k += 2) {
				yaw = 360F / j * k;
				pitch = (MathHelper.sin((float)(yaw / 180F * Math.PI * 4F)) * 20F - 60F);
				vec3 = THShotLib.getVecFromAngle(yaw, pitch, 1.0F);
				this.dropPointItem(this.pos(), vec3);
				yaw = 360F / j * (k + 1);
				pitch = (MathHelper.cos((float)(yaw / 180F * Math.PI * 4F)) * 20F - 60F);
				vec3 = THShotLib.getVecFromAngle(yaw, pitch, 1.0F);
				this.dropPowerUpItem(this.pos(), vec3);
			}

			dropShotItem(ItemTHShot.KUNAI, 17 + rand.nextInt(2) + lootingLevel, 5, 32, DanmakuConstants.BLUE, 0, 0, 2);
		}
		if (hasBeenAttackedByPlayer && getDanmakuPattern() == SPELLCARD_ATTACK05) {
			this.dropItem(THKaguyaItems.gapFoldingUmbrella, 1);
			this.dropItem(THKaguyaItems.gap, 16);
		}
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return false;
	}

	public static void postInit() {
		EntityRegistry.registerModEntity(EntityYukari.class, LibEntityName.YUKARI, LibMobID.YUKARI, JourneyToGensokyo.instance, 80, 1, true);
	}
}