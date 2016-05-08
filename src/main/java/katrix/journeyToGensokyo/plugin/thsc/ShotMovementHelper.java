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
import java.util.Optional;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;

public class ShotMovementHelper {

	public static void homing(final EntityTHShot shot, double range) {
		Optional<EntityLivingBase> nearEntity = getNearestEntity(shot, range);
		nearEntity.ifPresent(e -> shot.angle = shot.angle_ToLiving(e));
	}

	public static void homing(EntityTHShot shot, double range, float homingLevel) {
		Optional<EntityLivingBase> nearEntity = getNearestEntity(shot, range);

		if(nearEntity.isPresent()) {
			Vec3 targetVec = THShotLib.angle_ToPos(shot.pos(), THShotLib.pos_Living(nearEntity.get()));
			Vec3 rotate = THShotLib.getOuterProduct(shot.getShotVector(), targetVec);
			float rotateAngle = THShotLib.getVectorAndVectorAngle(shot.getShotVector(), targetVec);
			if (rotateAngle > homingLevel) {
				rotateAngle = homingLevel;
			}
			else if (rotateAngle < -homingLevel) {
				rotateAngle = -homingLevel;
			}
			shot.angle = THShotLib.getVectorFromRotation(rotate, shot.angle, rotateAngle);
			if (!shot.worldObj.isRemote) {
				shot.shotAcceleration();
			}
		}
	}

	private static Optional<EntityLivingBase> getNearestEntity(EntityTHShot shot, double range) {
		@SuppressWarnings("unchecked")
		List<Entity> list = shot.worldObj.getEntitiesWithinAABBExcludingEntity(shot,
				shot.boundingBox.addCoord(shot.motionX, shot.motionY, shot.motionZ).expand(range, range, range));

		EntityLivingBase nearEntity = null;
		double nearValue = 999.9D * THShotLib.halfAbsSin((float)Math.PI);
		Vec3 shotVec = shot.getShotVector();

		for(Entity entityListEntry : list) {
			if((entityListEntry instanceof EntityLivingBase) && !(entityListEntry instanceof EntityAnimal)
					&& !(entityListEntry instanceof EntityVillager) && entityListEntry != shot.user) {

				EntityLivingBase living = (EntityLivingBase)entityListEntry;
				if(!living.isDead) {
					Vec3 shotPosVec = shot.pos();
					Vec3 entityPosVec = THShotLib.pos_Living(living);
					MovingObjectPosition movingObjectPosition = shot.worldObj.func_147447_a(shotPosVec, entityPosVec, false, true, false);
					shotPosVec = shot.pos();
					entityPosVec = THShotLib.pos_Living(living);

					if(movingObjectPosition == null || movingObjectPosition.entityHit != null) {
						Vec3 targetVec = THShotLib.angle_ToPos(shotPosVec, entityPosVec);
						float angleSpan = Math.abs(THShotLib.getVectorAndVectorAngle(shotVec, targetVec));
						double toEntity1Distance = shot.getDistance(living.posX, living.posY + living.getEyeHeight(), living.posZ);
						double value = toEntity1Distance * THShotLib.halfAbsSin(angleSpan / 180F * (float)Math.PI);
						if(nearValue > value) {
							nearEntity = living;
							nearValue = value;
						}
					}
				}
			}
		}

		return Optional.ofNullable(nearEntity);
	}
}
