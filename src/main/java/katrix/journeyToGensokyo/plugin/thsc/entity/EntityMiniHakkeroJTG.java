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
import java.util.List;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.lib.LibEntityName;
import katrix.journeyToGensokyo.lib.LibMobID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.LaserData;
import thKaguyaMod.THKaguyaLib;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHSetLaser;
import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.init.THKaguyaItems;

public class EntityMiniHakkeroJTG extends Entity {

	private EntityLivingBase user;
	private Entity source;
	private boolean isSpellcard;
	private int delay;
	private int end;
	private boolean explode;
	private boolean doubleLaser;

	private float circleAngle = 0F;
	private List<EntityTHSetLaser> listLaser = new ArrayList<EntityTHSetLaser>();

	public static final String NBT_SPELLCARD = "isSpellcard";

	public EntityMiniHakkeroJTG(World world) {
		super(world);
		preventEntitySpawning = true;
		setSize(0.4F, 0.4F);
		yOffset = 0.0F;
	}

	public EntityMiniHakkeroJTG(World world, EntityLivingBase user, Entity source, boolean isSpellcard, int delay, int end, boolean explode,
			boolean doubleLaser) {
		this(world);
		this.user = user;
		this.source = source;
		this.isSpellcard = isSpellcard;
		this.delay = delay; //Normally 30
		this.end = end; //Normally 120
		this.explode = explode;
		this.doubleLaser = doubleLaser;
		Vec3 look = user.getLookVec();

		setPosition(user.posX - look.xCoord, user.posY - look.yCoord + user.getEyeHeight() - 0.1D, user.posZ - look.zCoord);
		rotationYaw = user.rotationYaw;
		rotationPitch = user.rotationPitch;
		worldObj.playSoundAtEntity(this, "thkaguyamod:masterspark", THKaguyaConfig.MasterSparkVol, 1.0F);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (!worldObj.isRemote && (user == null || ticksExisted >= delay + end)) {
			if (!isSpellcard) {
				THKaguyaLib.itemEffectFinish(this, user, THKaguyaItems.mini_hakkero);
			}
			else {
				setDead();
			}
			return;
		}

		if (ticksExisted == 1 && !worldObj.isRemote) {
			if (doubleLaser) {
				Vec3 look1 = THShotLib.getVecFromAngle(rotationYaw + 10, rotationPitch);
				Vec3 look2 = THShotLib.getVecFromAngle(rotationYaw - 10, rotationPitch);
				LaserData data = LaserData.laser(24, 4.2F, 60.0F, 8.0F, 30, 120, 0);
				listLaser.add(THShotLib.createLaserB(user, source, THShotLib.pos_Entity(this), look1, THShotLib.rotate_Default(), 0.0F, 9999, data, this, 1.0D,
						0.0F));
				listLaser.add(THShotLib.createLaserB(user, source, THShotLib.pos_Entity(this), look2, THShotLib.rotate_Default(), 0.0F, 9999, data, this, 1.0D,
						0.0F));
			}
			else {
				listLaser.add(THShotLib.createLaserB(user, source, THShotLib.pos_Entity(this), user.getLookVec(), THShotLib.rotate_Default(), 0F, 9999,
						LaserData.laser(24, 4.2F, 60.0F, 8.0F, delay, end, 0), this, 1D, 0F));
				if (explode) {
					for (EntityTHSetLaser laser : listLaser) {
						laser.shotSpecial = DanmakuConstants.EXPLOSION01;
					}
				}
			}
		}

		circleAngle += 4.7F;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	protected void entityInit() {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) {
		tag.setBoolean(NBT_SPELLCARD, isSpellcard);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) {
		isSpellcard = tag.getBoolean(NBT_SPELLCARD);
	}

	@Override
	public float getShadowSize() {
		return 0.5F;
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return 0xf000f0;
	}

	@Override
	public float getBrightness(float par1) {
		return 0.5F;
	}

	public float getCircleAngle() {
		return circleAngle;
	}


	public List<EntityTHSetLaser> getLaser() {
		return listLaser;
	}

	public static void postInit() {
		EntityRegistry.registerModEntity(EntityMiniHakkeroJTG.class, LibEntityName.MINI_HAKKERO_JTG, LibMobID.MINI_HAKKERO_JTG, JourneyToGensokyo.instance, 80,
				1, true);
	}
}
