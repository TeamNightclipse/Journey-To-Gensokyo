/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.spellcard;

import katrix.journeyToGensokyo.lib.LibSpecialShotId;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.LaserData;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;
import thKaguyaMod.entity.spellcard.THSpellCard;

public class THSC_MeshLightDarkness extends THSpellCard implements ISpecialShot {

	public THSC_MeshLightDarkness() {
		setNeedLevel(5);
		setRemoveTime(50);
		setEndTime(150);
		setOriginalUserName(YUKARI);
	}

	@Override
	public void spellcard_main() {
		if (time == 1) {
			THShotLib.playShotSound(card);
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 0f, 0.55D, 0.55D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_BIG, DanmakuConstants.BLUE));
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 0f, 0.55D, 0.55D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_BIG, DanmakuConstants.RED));
			for (int i = 1; i < 20; i++) {
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 0.0f, 9999, 0.2D * i * 0.15,
						0.2D * i * 0.15, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.BLUE), 2, 0.2D, 180f / i);
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 0.0f, 9999, 0.2D * i * 0.15,
						0.2D * i * 0.15, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RED), 2, 0.2D, 180f / i);
			}
			for (int i = 1; i < 5; i++) {
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 0.0f, 9999, 0.3D * i * 0.25,
						0.23 * i * 0.25, 0.0D, THShotLib.gravity_Zero(),
						ShotData.shot(DanmakuConstants.FORM_LIGHT, DanmakuConstants.BLUE, 0.5f, THShotLib.DAMAGE[DanmakuConstants.FORM_LIGHT] * 2), 2, 0.2D,
						90 / i);
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 0.0f, 9999, 0.3D * i * 0.25,
						0.23 * i * 0.25, 0.0D, THShotLib.gravity_Zero(),
						ShotData.shot(DanmakuConstants.FORM_LIGHT, DanmakuConstants.RED, 0.5f, THShotLib.DAMAGE[DanmakuConstants.FORM_LIGHT] * 2), 2, 0.2D,
						90 / i);
			}
		}

		if (time > 1 && time < 20 && time % 2 == 0) {
			THShotLib.playShotSound(card);
			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 2.0D * time),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw + (45 + 90), user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RED, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));
			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 2.0D * time),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RED, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));

			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 2.0D * time),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw - (45 + 90), user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.BLUE, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));
			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 2.0D * time),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.BLUE, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));

		}

		if (time == 50) {
			THShotLib.playShotSound(card);
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 0f, 0.55D, 0.55D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_BIG, DanmakuConstants.RED));
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 0f, 0.55D, 0.55D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_BIG, DanmakuConstants.BLUE));
			for (int i = 1; i < 20; i++) {
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 0.0f, 9999, 0.2D * i * 0.15,
						0.2D * i * 0.15, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RED), 2, 0.2D, 180f / i);
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 0.0f, 9999, 0.2D * i * 0.15,
						0.2D * i * 0.15, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.BLUE), 2, 0.2D, 180f / i);
			}
			for (int i = 1; i < 5; i++) {
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 0.0f, 9999, 0.3D * i * 0.25,
						0.23 * i * 0.25, 0.0D, THShotLib.gravity_Zero(),
						ShotData.shot(DanmakuConstants.FORM_LIGHT, DanmakuConstants.RED, 0.5f, THShotLib.DAMAGE[DanmakuConstants.FORM_LIGHT] * 2), 2, 0.2D,
						90 / i);
				THShotLib.createRandomRingShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 0.0f, 9999, 0.3D * i * 0.25,
						0.23 * i * 0.25, 0.0D, THShotLib.gravity_Zero(),
						ShotData.shot(DanmakuConstants.FORM_LIGHT, DanmakuConstants.BLUE, 0.5f, THShotLib.DAMAGE[DanmakuConstants.FORM_LIGHT] * 2), 2, 0.2D,
						90 / i);
			}
		}

		if (time > 50 && time < 70 && time % 2 == 0) {
			THShotLib.playShotSound(card);
			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 2.0D * (time - 50)),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw + (45 + 90), user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.BLUE, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));
			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 2.0D * (time - 50)),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(),
					ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.BLUE, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));

			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 2.0D * (time - 50)),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw - (45 + 90), user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RED, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));
			THShotLib.createShot(user, card, THShotLib.pos_Distance(pos_User(), THShotLib.angle(user.rotationYaw - 45, user.rotationPitch), 2.0D * (time - 50)),
					THShotLib.angle_LimitRandom(THShotLib.angle(user.rotationYaw + 45, user.rotationPitch), 30F), 0F, 0.0D, 0.0D, 0.0D,
					THShotLib.gravity_Zero(), ShotData.shot(DanmakuConstants.FORM_MEDIUM, DanmakuConstants.RED, 0.5F, 8.0F, 0, 60, LibSpecialShotId.MESH_LASER01));
		}
	}

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch (id) {
			case LibSpecialShotId.MESH_LASER01:
				if (shot.ticksExisted == 1) {
					THShotLib.createLaserB(shot.user, shot.source, shot.pos(), shot.angle, THShotLib.rotate_Default(), 0F, 9999,
							LaserData.laser(shot.getShotColor(), 0.5F, 20F, shot.shotDamage, 20, shot.getShotEndTime()), shot, 1.0D, 0.0D);
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
