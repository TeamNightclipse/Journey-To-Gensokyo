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
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class ShotSpiritulip implements ISpecialShot {

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch (id) {
			case LibSpecialShotId.SPIRITULIP01:
				if (shot.isShotEndTime()) {
					spawnDanmaku(shot);
				}
				break;
			default:
				break;
		}
	}

	@Override
	public boolean specialShot_hitBlock(World world, int id, EntityTHShot shot, MovingObjectPosition movingObjectPosition) {
		switch (id) {
			case LibSpecialShotId.SPIRITULIP01:
				spawnDanmaku(shot);
				return false;
			default:
				return false;
		}
	}

	@Override
	public boolean specialShot_hitEntity(World world, int id, EntityTHShot shot, Entity entity_Hit) {
		switch (id) {
			case LibSpecialShotId.SPIRITULIP01:
				spawnDanmaku(shot);
				return false;
			default:
				return false;
		}
	}
	
	private void spawnDanmaku(EntityTHShot shot) {
		ShotData shotData = ShotData.shot(DanmakuConstants.FORM_BIG, shot.getShotColor(), 0, 60, LibSpecialShotId.JTG_HOMING01);
		THShotLib.createSphereShot(shot.user, shot.source, shot.pos(), THShotLib.angle_Random(), 0F, 0.2D, 0.8D, 0.2D, THShotLib.gravity_Zero(),
				shotData, 8, 0D, 0.0f);
	}
}
