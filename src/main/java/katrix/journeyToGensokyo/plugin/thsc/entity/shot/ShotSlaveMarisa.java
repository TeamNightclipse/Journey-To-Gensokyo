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
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMarisa;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class ShotSlaveMarisa implements ISpecialShot {

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch (id) {
			case LibSpecialShotId.SLAVE_MARISA01:
				THShotLib.createSphereShot(shot.user, shot.source, shot.pos(), shot.angle, 0F, 0.3D, 0.5D, 0.05D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_SMALLSTAR, shot.getShotColor(), 0 , 60), 3, 0D, 0F);
				break;
			case LibSpecialShotId.SLAVE_MARISA02:
				if(shot.ticksExisted % 2 == 0) {
					THShotLib.createSphereShot(shot.user, shot.source, shot.pos(), shot.angle, 0F, 0.3D, 0.5D, 0.05D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_SMALLSTAR, shot.getShotColor(), 0, 60), 2, 0D, 0F);
				}
				break;
			case LibSpecialShotId.SLAVE_MARISA03:
				if(shot.ticksExisted % 2 == 0) {
					THShotLib.createSphereShot(shot.user, shot.source, shot.pos(), shot.angle, 0F, 0.3D, 0.5D, 0.05D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_SMALLSTAR, THShotLib.RANDOM, 0, 60), 3, 0D, 0F);
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
		switch (id) {
			case LibSpecialShotId.SLAVE_MARISA11:
				if(shot.user instanceof EntityMarisa) {
					EntityMarisa marisa = (EntityMarisa)shot.user;
					marisa.perfect = false;
				}
				break;

			default:
				break;
		}
		return false;
	}
}
