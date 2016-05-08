/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package katrix.journeyToGensokyo.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class MathHelperJTG {

	public static float getAngleMax180(float angle) {
		angle %= 360F;
		if (angle > 180F) {
			angle -= 360F;
		}
		else if (angle < -180) {
			angle += 360F;
		}
		return angle;
	}

	public static float getAngleAndAngleSpan(float angleA, float angleB) {
		angleA = getAngleMax180(angleA);
		angleB = getAngleMax180(angleB);

		if (angleA == 0.0F)
			return angleB;
		else if (angleA > 0.0F) {
			if (angleB > angleA - 180F)
				return angleB - angleA;
			else
				return angleB - angleA + 360F;
		}
		else {
			if (angleB < angleA + 180F)
				return angleB - angleA;
			else
				return angleB - angleA - 360F;
		}
	}

	public static float getEntityAndEntityAngleSpanYaw(Entity entityA, Entity entityB) {
		float angleA = getAngleMax180(entityA.rotationYaw);
		float angleB = (float)toRad(Math.atan2(entityB.posX - entityA.posX, entityB.posZ - entityA.posZ));
		return getAngleAndAngleSpan(angleA, angleB);
	}

	public static float getEntityAndEntityAngleSpanPitch(Entity entityA, Entity entityB) {
		double distanceX = entityB.posX - entityA.posX;
		double distanceY = entityB.posY - entityA.posY;
		double distanceZ = entityB.posZ - entityA.posZ;
		double distanceXZ = Math.sqrt(distanceX * distanceX + distanceZ * distanceZ);
		float angleA = getAngleMax180(entityA.rotationPitch);
		float angleB = (float)(Math.atan2(distanceY, distanceXZ) / Math.PI * 180F);
		return getAngleAndAngleSpan(angleA, angleB);
	}

	public static double halfAbsSin(float angle) {
		angle = angle * 0.5F;
		return Math.abs(Math.sin(angle));
	}

	public static double getPosYFromEye(EntityLivingBase living, double yAdjustment) {
		return living.posY + living.getEyeHeight() + Math.sin(toRad(living.rotationPitch)) * yAdjustment + yAdjustment;
	}

	public static double getPosYFromEye(EntityLivingBase living) {
		return living.posY + living.getEyeHeight() + Math.sin(toRad(living.rotationPitch)) * -0.5D + Math.cos(toRad(living.rotationPitch)) * -0.5D;
	}

	public static double toRad(double deg) {
		return deg / 180.0D * Math.PI;
	}

	public static double toDeg(double deg) {
		return deg * 180.0D / Math.PI;
	}
}
