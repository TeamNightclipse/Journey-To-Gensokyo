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
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.item.EntityMiniHakkero;
import thKaguyaMod.init.THKaguyaConfig;

public class EntityMiniHakkeroDoubleJTG extends EntityMiniHakkero {

	public EntityMiniHakkeroDoubleJTG(World world) {
		super(world);
	}

	public EntityMiniHakkeroDoubleJTG(World world, EntityLivingBase EntityLivingBase, int da) {
		super(world, EntityLivingBase, da);

	}

	public EntityMiniHakkeroDoubleJTG(World world, EntityLivingBase EntityLivingBase, EntityLivingBase target) {

		this(world);

		user = EntityLivingBase;
		setPosition(user.posX - Math.sin(user.rotationYaw / 180F * Math.PI) * Math.cos(user.rotationPitch / 180F * Math.PI),
				user.posY - Math.sin(user.rotationPitch / 180F * Math.PI) + user.getEyeHeight() - 0.1D,
				user.posZ + Math.cos(user.rotationYaw / 180F * Math.PI) * Math.cos(user.rotationPitch / 180F * Math.PI));
		rotationYaw = user.rotationYaw;
		rotationPitch = user.rotationPitch;
		count = 0;
		worldObj.playSoundAtEntity(this, "thkaguyamod:masterspark", THKaguyaConfig.MasterSparkVol, 1.0F);
		Vec3 look1 = THShotLib.getVecFromAngle(rotationYaw + 10, rotationPitch);
		Vec3 look2 = THShotLib.getVecFromAngle(rotationYaw - 10, rotationPitch);
		THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), look1, THShotLib.rotate_Default(), 0.0F, 9999,
				LaserData.laser(24, 4.2F, 60.0F, 8.0F, 30, 120, 0), this, 1.0D, 0.0F);
		THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), look2, THShotLib.rotate_Default(), 0.0F, 9999,
				LaserData.laser(24, 4.2F, 60.0F, 8.0F, 30, 120, 0), this, 1.0D, 0.0F);
	}

}
