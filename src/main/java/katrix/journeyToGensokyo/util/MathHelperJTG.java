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

	//Thanks Mad for this Sin/Cos thingy
	static double[] table = null;
	static double[] table2 = null;
	static double step;
	static double invStep;
	static int size = 0;

	static {

		size = 5000; //TODO: Try finding optimal size
		table = new double[size];
		table2 = new double[size];
		step = 2d * Math.PI / size;
		invStep = 1.0f / step;
		for (int i = 0; i < size; ++i) {
			table[i] = Math.sin(step * i);
			table2[i] = Math.cos(step * i);
		}
	}

	/**
	 * Find a linear interpolation from the table
	 *
	 * @param ang angle in radians
	 * @return sin of angle a
	 */
	private final static double pi2 = Math.PI * 2;

	final public static double sin(double ang) {
		double rev = ang < 0 ? -1 : 1;
		double t = rev * ang % pi2;
		int indexA = (int)(t / step);
		int indexB = indexA + 1;
		if (indexB >= size)
			return table[indexA];
		double a = table[indexA];
		return rev * (a + (table[indexB] - a) * (t - indexA * step) * invStep);
	}

	final public static double cos(double ang) {
		double rev = ang < 0 ? -1 : 1;
		double t = rev * ang % pi2;
		int indexA = (int)(t / step);
		int indexB = indexA + 1;
		if (indexB >= size)
			return table2[indexA];
		double a = table2[indexA];
		return a + (table2[indexB] - a) * (t - indexA * step) * invStep;
	}



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
