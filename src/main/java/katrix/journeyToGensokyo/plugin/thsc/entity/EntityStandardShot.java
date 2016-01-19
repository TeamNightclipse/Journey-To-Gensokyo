/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.item.ItemStandardShot;
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import katrix.journeyToGensokyo.reference.SpecialShotID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.LaserData;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityFamiliar;

public class EntityStandardShot extends Entity {

	public EntityPlayer user;
	private String userName;
	public float power;
	private int place;
	public int shotTimer;

	public EntityStandardShot(World world) {
		super(world);
		setSize(0.3F, 0.3F);
	}

	public EntityStandardShot(World world, EntityPlayer user, int type, int place, float power) {
		this(world);
		setType(type);
		this.user = user;
		this.place = place;
		this.power = power;
		Vec3 pos = getPos();
		setPositionAndRotation(pos.xCoord, pos.yCoord, pos.zCoord, user.rotationYaw, user.rotationPitch);
	}

	@Override
	public void onUpdate() {

		if (!worldObj.isRemote) {
			if (user != null) {
				if (user.getHeldItem() != null) {
					if (!(user.getHeldItem().getItem() instanceof ItemStandardShot)) {
						setDead();
					}

				}

				else {
					setDead();
				}

				Vec3 pos = getPos();
				setPositionAndRotation(pos.xCoord, pos.yCoord, pos.zCoord, user.rotationYaw, user.rotationPitch);

				if (shotTimer != 0) {
					shootDanmaku(user.isSneaking());
					shotTimer--;
				}
			}

			else {
				setDead();
			}
		}
	}

	public void shootDanmaku(boolean isSlowMode) {

		double speed = 0.7D;
		EntityFamiliar living = new EntityFamiliar(worldObj);

		switch (getType()) {
			case 0:
				THShotLib.playShotSound(this);
				ShotData needle = ShotData.shot(DanmakuConstants.FORM_ARROW, DanmakuConstants.PURPLE, 0.1F, 1.0F + power / 2, 0, 40);
				THShotLib.createShot(user, living, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw + 90, rotationPitch), 0.3D),
						THShotLib.angle(rotationYaw, rotationPitch), 0F, speed * 3, speed * 3, speed * 3, THShotLib.gravity_Zero(), needle);
				THShotLib.createShot(user, living, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw - 90, rotationPitch), 0.3D),
						THShotLib.angle(rotationYaw, rotationPitch), 0F, speed * 3, speed * 3, speed * 3, THShotLib.gravity_Zero(), needle);
				break;
			case 1:
				THShotLib.playShotSound(this);
				if (isSlowMode) {
					ShotData homing1 = ShotData.shot(DanmakuConstants.FORM_AMULET, DanmakuConstants.RED, 0.5F, 2.0F + power / 2, 0, 60,
							SpecialShotID.JTG_HOMING01);

					if (power != 4F && place == 0) {
						THShotLib.createShot(user, living,
								THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0.3D),
								THShotLib.angle(rotationYaw, rotationPitch), 0F, speed * 2, speed * 2, speed * 2, THShotLib.gravity_Zero(), homing1);
					}
					else if (place == 0 || place == 1) {
						THShotLib.createShot(user, living,
								THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0.3D),
								THShotLib.angle(rotationYaw, rotationPitch), 0F, speed * 2, speed * 2, speed * 2, THShotLib.gravity_Zero(), homing1);
					}
				}
				else {
					ShotData homing2 = ShotData.shot(DanmakuConstants.FORM_AMULET, DanmakuConstants.RED, 0.2F, 1.0F + power / 4, 0, 60,
							SpecialShotID.JTG_HOMING02);
					THShotLib.createShot(user, living, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed, speed, speed,
							THShotLib.gravity_Zero(), homing2);
				}
				break;
			case 2:
				THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), THShotLib.rotate_Default(), 0F,
						9999, LaserData.laser(DanmakuConstants.RED, 0.2F, 16F, 2.0F + power / 2, 0, 0), this, 0.3D, 0.0D);
				break;
			case 3:
				if (ticksExisted % 20 == 0) {
					THShotLib.playShotSound(this);
					ShotData missile = ShotData.shot(DanmakuConstants.FORM_SMALLSTAR, DanmakuConstants.AQUA, 0.15F, 2.0F + power, 0, 60,
							SpecialShotID.MISSILE01);
					THShotLib.createShot(user, living, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed, speed, speed,
							THShotLib.gravity_Zero(), missile);
				}
				break;
			default:
				break;
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	public Vec3 getPos() {

		int intPower = MathHelper.floor_float(power);
		boolean sneaking = user.isSneaking();
		if (sneaking) {
			switch (intPower) {
				case 0:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75);
				case 1:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75);
				case 2:
					switch (place) {
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75),
									THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 0.5);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75),
									THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 0.5);
						default:
							break;
					}
				case 3:
					switch (place) {
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75),
									THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 0.75);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75),
									THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 0.75);
						default:
							break;
					}
				case 4:
					switch (place) {
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75),
									THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 0.35);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 0.75),
									THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 0.35);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 0.75);
						case 3:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 0.75);
						default:
							break;
					}
				default:
					break;
			}
		}
		else {
			switch (intPower) {
				case 0:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
				case 1:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
				case 2:
					switch (place) {
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5),
									THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 0.75);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5),
									THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 0.75);
						default:
							break;
					}
				case 3:
					switch (place) {
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5),
									THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 1.0);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5),
									THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 1.0);
						default:
							break;
					}
				case 4:
					switch (place) {
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5),
									THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 0.5);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5),
									THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 0.5);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), THShotLib.angle(user.rotationYaw + 90, user.rotationPitch), 1.25);
						case 3:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), THShotLib.angle(user.rotationYaw - 90, user.rotationPitch), 1.25);
						default:
							break;
					}
				default:
					break;
			}
		}
		return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
	}

	@Override
	protected void entityInit() {
		dataWatcher.addObject(16, new Byte((byte)0)); //Type
	}

	public void setType(int type) {
		dataWatcher.updateObject(16, Byte.valueOf((byte)type));
	}

	public byte getType() {
		return dataWatcher.getWatchableObjectByte(16);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbtTagCompound) {
		setType(nbtTagCompound.getByte("Type"));
		place = nbtTagCompound.getByte("Place");
		power = nbtTagCompound.getFloat("Power");
		userName = nbtTagCompound.getString("UserName");

		if (userName != null && userName.length() == 0) {
			user = worldObj.getPlayerEntityByName(userName);
			userName = null;
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbtTagCompound) {

		nbtTagCompound.setByte("Type", getType());
		nbtTagCompound.setByte("Place", (byte)place);
		nbtTagCompound.setFloat("Power", power);

		if (user != null) {
			userName = user.getCommandSenderName();
		}

		nbtTagCompound.setString("UserName", userName == null ? "" : userName);
	}

	public static void postInit() {

		EntityRegistry.registerModEntity(EntityStandardShot.class, EntityName.STANDARD_SHOT, MobID.STANDARD_SHOT, JourneyToGensokyo.instance, 40, 1, true);
	}
}
