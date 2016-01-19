/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.shot;

import katrix.journeyToGensokyo.plugin.thsc.ShotMovementHelper;
import katrix.journeyToGensokyo.reference.SpecialShotID;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class ShotHoming implements ISpecialShot {

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch (id) {
			case SpecialShotID.JTG_HOMING01:
				ShotMovementHelper.homing(shot, 18);
				break;
			case SpecialShotID.JTG_HOMING02:
				ShotMovementHelper.homing(shot, 18, 5.0F);
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
