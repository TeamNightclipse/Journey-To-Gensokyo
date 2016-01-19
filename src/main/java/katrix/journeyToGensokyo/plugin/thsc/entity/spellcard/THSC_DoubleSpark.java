/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.spellcard;

import static thKaguyaMod.DanmakuConstants.FORM_STAR;

import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroDoubleJTG;
import net.minecraft.util.Vec3;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.spellcard.THSpellCard;

public class THSC_DoubleSpark extends THSpellCard {

	private Vec3 tgVec;

	public THSC_DoubleSpark() {
		setNeedLevel(7);
		setRemoveTime(70);
		setEndTime(109);
		setOriginalUserName(MARISA);
	}

	@Override
	public void spellcard_main() {
		if (time == 1) {
			EntityMiniHakkeroDoubleJTG miniHakkero;

			tgVec = THShotLib.getVecFromAngle(card.rotationYaw, card.rotationPitch + 90);
			miniHakkero = new EntityMiniHakkeroDoubleJTG(world, user, target);

			if (!world.isRemote) {
				world.spawnEntityInWorld(miniHakkero);
			}
		}
		if (time >= 30 && time < 99) {
			int randLow = -2, randHigh = 2;
			float angle = time * rand.nextInt(randHigh - randLow + 1) + randLow;
			float angleSpan = 360F / 14F;

			double gRate = 0.034 + 0.03D * Math.sin(angle / 180F * Math.PI);
			Vec3 vectorG = THShotLib.getVecFromAngle(card.rotationYaw, card.rotationPitch);
			vectorG = THShotLib.getVectorMultiply(vectorG, gRate);

			for (int i = 0; i < 14; i++) {

				double X1, X2, Z1, Z2;

				double angleXZ = angle / 180.0F * Math.PI;
				double angleY = 0 / 180.0F * Math.PI;
				float cardYaw = (float)(card.rotationYaw / 180.0F * Math.PI);
				float cardPitch = (float)((card.rotationPitch + 90F) / 180.0F * Math.PI);

				X1 = Math.sin(angleXZ) * Math.cos(cardYaw);
				Z1 = Math.sin(angleXZ) * Math.sin(cardYaw);
				X2 = Math.cos(angleXZ) * Math.sin(angleY) * Math.sin(cardPitch) * Math.sin(cardYaw);
				Z2 = Math.cos(angleXZ) * Math.sin(angleY) * Math.sin(cardPitch) * Math.cos(cardYaw);

				double yVector1 = -Math.cos(angleXZ) * Math.sin(cardPitch - angleY);
				double xVector1 = Math.cos(angleXZ) * Math.cos(angleY) * tgVec.xCoord + X1 - X2;
				double zVector1 = Math.cos(angleXZ) * Math.cos(angleY) * tgVec.zCoord + Z1 + Z2;

				if (i % 2 == 0) {
					ShotData shot1 = ShotData.shot(FORM_STAR, time % 7, 0.5F, 8.0F, 0, 55);
					THShotLib.createShot(user, card, pos_Card(), angle(xVector1, yVector1, zVector1), 0F, 0.1D, 0.3D, 0.1D, vectorG, shot1);
				}
				ShotData shot2 = ShotData.shot(FORM_STAR, time % 7, 0.35F, 8.0F, 0, 100);
				THShotLib.createShot(user, card, pos_Card(), angle(xVector1, yVector1, zVector1), 0F, 0.1D, 0.6D, 0.1D, vectorG, shot2);
				angle += angleSpan;
			}
		}
	}
}
