/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;

public class ShotMovementHelper {

	public static void homing(EntityTHShot shot, double range) {
		EntityLivingBase nearEntity = getNearestEntity(shot, range);

		if (nearEntity != null) {
			shot.angle = shot.angle_ToLiving(nearEntity);
		}
	}

	public static void homing(EntityTHShot shot, double range, float homingLevel) {
		EntityLivingBase nearEntity = getNearestEntity(shot, range);

		if (nearEntity != null) {
			Vec3 targetVec = THShotLib.angle_ToPos(shot.pos(), THShotLib.pos_Living(nearEntity));
			Vec3 rotate = THShotLib.getOuterProduct(shot.getShotVector(), targetVec);
			float rotateAngle = THShotLib.getVectorAndVectorAngle(shot.getShotVector(), targetVec);
			if (rotateAngle > homingLevel) {
				rotateAngle = homingLevel;
			}
			else if (rotateAngle < -homingLevel) {
				rotateAngle = -homingLevel;
			}
			Vec3 newVec = THShotLib.getVectorFromRotation(rotate, shot.angle, rotateAngle);
			shot.angle = newVec;
			if (!shot.worldObj.isRemote) {
				shot.shotAcceleration();
			}
		}
	}

	private static EntityLivingBase getNearestEntity(EntityTHShot shot, double range) {
		@SuppressWarnings("rawtypes")
		List list = shot.worldObj.getEntitiesWithinAABBExcludingEntity(shot,
				shot.boundingBox.addCoord(shot.motionX, shot.motionY, shot.motionZ).expand(range, range, range));

		EntityLivingBase nearEntity = null;
		double nearDistance = 999.9D;
		float nearAngle = 180F;
		double nearValue = nearDistance * THShotLib.halfAbsSin(nearAngle / 180F * (float)Math.PI);
		Vec3 shotVec = shot.getShotVector();

		for (int j = 0; j < list.size(); j++) {
			Entity entitys = (Entity)list.get(j);
			if (entitys instanceof EntityLivingBase == false || entitys instanceof EntityAnimal || entitys instanceof EntityVillager || entitys == shot.user) {
				continue;
			}

			EntityLivingBase entity1 = (EntityLivingBase)entitys;

			if (entity1.isDead) {
				continue;
			}

			Vec3 shotPosVec = shot.pos();
			Vec3 entityPosVec = THShotLib.pos_Living(entity1);
			MovingObjectPosition movingObjectPosition = shot.worldObj.func_147447_a(shotPosVec, entityPosVec, false, true, false);
			shotPosVec = shot.pos();
			entityPosVec = THShotLib.pos_Living(entity1);

			if (movingObjectPosition != null && movingObjectPosition.entityHit == null) {
				continue;
			}

			Vec3 targetVec = THShotLib.angle_ToPos(shotPosVec, entityPosVec);
			float angleSpan = Math.abs(THShotLib.getVectorAndVectorAngle(shotVec, targetVec));
			double toEntity1Distance = shot.getDistance(entity1.posX, entity1.posY + entity1.getEyeHeight(), entity1.posZ);
			double value = toEntity1Distance * THShotLib.halfAbsSin(angleSpan / 180F * (float)Math.PI);
			if (nearValue > value) {
				{
					nearEntity = entity1;
					nearAngle = angleSpan;
					nearValue = value;
					nearDistance = toEntity1Distance;
				}
			}
		}

		return nearEntity;
	}
}
