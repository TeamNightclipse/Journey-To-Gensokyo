/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.LaserData;
import thKaguyaMod.THKaguyaLib;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.item.EntityMiniHakkero;
import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.init.THKaguyaItems;

public class EntityMiniHakkeroFinalJTG extends EntityMiniHakkero {

	private int lastTime;
	private boolean isSpellCard;

	public EntityMiniHakkeroFinalJTG(World world) {
		super(world);
	}

	public EntityMiniHakkeroFinalJTG(World world, EntityLivingBase EntityLivingBase, int da) {
		super(world, EntityLivingBase, da);

	}

	public EntityMiniHakkeroFinalJTG(World world, EntityLivingBase EntityLivingBase, EntityLivingBase target, int delay, int duration) {

		this(world);

		user = EntityLivingBase;//使用者をuserに保存
		setPosition(user.posX - Math.sin(user.rotationYaw / 180F * 3.141593F) * Math.cos(user.rotationPitch / 180F * 3.141593F),
				user.posY - Math.sin(user.rotationPitch / 180F * 3.141593F) + user.getEyeHeight() - 0.10000000149011612D,
				user.posZ + Math.cos(user.rotationYaw / 180F * 3.141593F) * Math.cos(user.rotationPitch / 180F * 3.141593F));//初期位置を設定(x,y,z)
		rotationYaw = user.rotationYaw;
		rotationPitch = user.rotationPitch;
		count = 0;
		worldObj.playSoundAtEntity(this, "thkaguyamod:masterspark", THKaguyaConfig.MasterSparkVol, 1.0F);
		lastTime = 0;

		isSpellCard = true;

		Vec3 look = THShotLib.getVecFromAngle(rotationYaw, rotationPitch);
		THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), look, THShotLib.rotate_Default(), 0.0F, 9999,
				LaserData.laser(24, 8.5F, 60.0F, 12.0F, delay, duration, 0), this, 1.0D, 0.0F);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (!worldObj.isRemote && user == null) {
			if (!isSpellCard) {
				THKaguyaLib.itemEffectFinish(this, user, THKaguyaItems.mini_hakkero);
			}
			else {
				if (!worldObj.isRemote) {
					setDead();
				}
			}
			return;
		}

		if (ticksExisted <= lastTime)
			return;

		if (ticksExisted > lastTime) {
			lastTime = ticksExisted;
		}
		//時間で消滅
		if (ticksExisted >= 10) {
			if (!worldObj.isRemote) {
				if (!isSpellCard) {
					THKaguyaLib.itemEffectFinish(this, user, THKaguyaItems.mini_hakkero);
				}
				else {
					if (!worldObj.isRemote) {
						setDead();
					}
				}
			}
		}
	}

}
