/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.shot;

import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import katrix.journeyToGensokyo.plugin.thsc.ShotMovementHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class ShotFantasySeal implements ISpecialShot {

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch (id) {
			case LibSpecialShotId.FANTASY_SEAL01:
				if (shot.isShotEndTime()) {
					shot.setShotForm(DanmakuConstants.FORM_CIRCLE);
					shot.shotSpecial = LibSpecialShotId.FANTASY_SEAL02;
					shot.setShotEndTime(10);
					shot.shotSpeed = 0.0;
					shot.shotLimitSpeed = 0.0;
					shot.shotAcceleration = 0.0;
					shot.reCreate();
					shot.delete();
				}
				break;
			case LibSpecialShotId.FANTASY_SEAL02:
				if (shot.isShotEndTime()) {
					shot.setShotColor(DanmakuConstants.RED);
					shot.shotSpecial = LibSpecialShotId.FANTASY_SEAL03;
					shot.setShotEndTime(10);
					shot.reCreate();
					shot.delete();
				}
				break;
			case LibSpecialShotId.FANTASY_SEAL03:
				if (shot.isShotEndTime()) {
					shot.setShotForm(DanmakuConstants.FORM_AMULET);
					shot.shotSpecial = LibSpecialShotId.FANTASY_SEAL04;
					shot.setShotEndTime(30);

					if (shot.user instanceof EntityDanmakuMob) {
						EntityDanmakuMob danmakuMob = (EntityDanmakuMob)shot.user;

						if (danmakuMob.getTarget() != null) {
							shot.angle = shot.angle_ToLiving(danmakuMob.getTarget());
						}
					}
					else {
						ShotMovementHelper.homing(shot, 24);
					}

					shot.shotSpeed = 0.75;
					shot.shotLimitSpeed = 0.0;
					shot.shotAcceleration = -0.04;
					shot.reCreate();
					shot.delete();
				}
				break;
			case LibSpecialShotId.FANTASY_SEAL04:
				if (shot.isShotEndTime()) {
					shot.setShotForm(DanmakuConstants.FORM_CIRCLE);
					shot.shotSpecial = LibSpecialShotId.FANTASY_SEAL05;
					shot.setShotEndTime(10);
					shot.reCreate();
					shot.delete();
				}
				break;
			case LibSpecialShotId.FANTASY_SEAL05:
				if (shot.isShotEndTime()) {
					shot.setShotColor(DanmakuConstants.PURPLE);
					shot.shotSpecial = LibSpecialShotId.FANTASY_SEAL06;
					shot.setShotEndTime(10);
					shot.reCreate();
					shot.delete();
				}
				break;
			case LibSpecialShotId.FANTASY_SEAL06:
				if (shot.isShotEndTime()) {
					shot.setShotForm(DanmakuConstants.FORM_AMULET);
					shot.shotSpecial = 0;
					shot.setShotEndTime(50);

					if (shot.user instanceof EntityDanmakuMob) {
						EntityDanmakuMob danmakuMob = (EntityDanmakuMob)shot.user;

						if (danmakuMob.getTarget() != null) {
							shot.angle = shot.angle_ToLiving(danmakuMob.getTarget());
						}
					}
					else {
						ShotMovementHelper.homing(shot, 24);
					}

					shot.shotSpeed = 0.3;
					shot.shotLimitSpeed = 0.3;
					shot.shotAcceleration = 0.0;
					shot.reCreate();
					shot.delete();
				}
				break;
			default:
				break;
		}
	}

	@Override
	public boolean specialShot_hitBlock(World world, int id, EntityTHShot shot, MovingObjectPosition movingObjectPosition) {
		return false;
	}

	@Override
	public boolean specialShot_hitEntity(World world, int id, EntityTHShot shot, Entity entity_Hit) {
		return false;
	}

}
