/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.spellcard;

import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroJTG;
import katrix.journeyToGensokyo.util.MathHelperJTG;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.spellcard.EntitySpellCard;
import thKaguyaMod.entity.spellcard.THSpellCard;

public class THSC_DoubleSpark extends THSpellCard {

	public THSC_DoubleSpark() {
		setNeedLevel(7);
		setRemoveTime(70);
		setEndTime(110);
		setOriginalUserName(MARISA);
	}

	@Override
	public void init(World worldObj, EntitySpellCard entitySpellCard, EntityLivingBase living_user, EntityLivingBase living_target, int spLevel) {
		super.init(worldObj, entitySpellCard, living_user, living_target, spLevel);
		EntityMiniHakkeroJTG miniHakkero = new EntityMiniHakkeroJTG(world, user, card, true, 30, 100, false, true);
		world.spawnEntityInWorld(miniHakkero);
	}

	@Override
	public void spellcard_main() {

		if (time >= 30 && time <= 100) {
			double xVector, yVector, zVector, angleXZ, X1, Z1, X2, Z2;
			int randLow = -2;
			int randHigh = 2;
			int pieces = 12;
			double speed = rand.nextInt(randHigh - randLow + 1) + randLow;

			Vec3 lookAt = THShotLib.angle(card.rotationYaw, card.rotationPitch + 90F);
			double angle = time * speed;
			double angleSpan = 360D / pieces;
			double gRate = 0.034 + 0.03D * MathHelperJTG.sin(Math.toRadians(angle));

			Vec3 gravity = THShotLib.getVecFromAngle(card.rotationYaw, card.rotationPitch, gRate);
			ShotData shot1 = ShotData.shot(DanmakuConstants.FORM_STAR, time % 7, 0.5F, 8.0F, 0, 55);
			ShotData shot2 = ShotData.shot(DanmakuConstants.FORM_STAR, time % 7, 0.35F, 8.0F, 0, 100);

			double cardYawRad = Math.toRadians(card.rotationYaw);
			double cardPitchRad = Math.toRadians(card.rotationPitch + 90);
			double cardYawSin = MathHelperJTG.sin(cardYawRad);
			double cardYawCos = MathHelperJTG.cos(cardYawRad);
			double cardPitchSin = MathHelperJTG.sin(cardPitchRad);

			double angleY = 0;
			double angleYRad = Math.toRadians(angleY);
			double angleYSin = MathHelperJTG.sin(angleYRad);
			double angleYCos = MathHelperJTG.cos(angleYRad);

			for (int i = 0; i < pieces; i++) {
				angleXZ = Math.toRadians(angle);
				double angleXZSin = MathHelperJTG.sin(angleXZ);
				double angleXZCos = MathHelperJTG.cos(angleXZ);

				X1 = angleXZSin * cardYawCos;
				Z1 = angleXZSin * cardYawSin;
				X2 = angleXZCos * angleYSin * cardPitchSin * cardYawSin;
				Z2 = angleXZCos * angleYSin * cardPitchSin * cardYawCos;

				yVector = -angleXZCos * MathHelperJTG.sin(cardPitchRad - angleYRad);
				xVector = angleXZCos * angleYCos * lookAt.xCoord + X1 - X2;
				zVector = angleXZCos * angleYCos * lookAt.zCoord + Z1 + Z2;
				Vec3 vecAngle = THShotLib.angle(xVector, yVector, zVector);

				if (i % 2 == 0) {
					THShotLib.createShot(user, card, pos_Card(), vecAngle, 0F, 0.1D, 0.5D, 0.15D, gravity, shot1);
				}
				THShotLib.createShot(user, card, pos_Card(), vecAngle, 0F, 0.1D, 0.6D, 0.1D, gravity, shot2);
				angle += angleSpan;
			}
		}
	}
}
