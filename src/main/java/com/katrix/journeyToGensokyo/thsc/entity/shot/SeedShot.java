/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.thsc.entity.shot;

import static thKaguyaMod.DanmakuConstants.FORM_LIGHT;

import com.katrix.journeyToGensokyo.reference.SpecialShotID;

import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.LaserData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class SeedShot implements ISpecialShot {

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch(id)
		{
		case SpecialShotID.SEED_LASER01:				
			if(shot.ticksExisted == 20)
			{				
				shot.shotAcceleration = 0.05D;
				shot.shotLimitSpeed = 10.0D;
				shot.shotSpeed = 1.0D;
				shot.setShotSize(0.1f);
				
				shot.setShotForm(FORM_LIGHT);
				shot.updateMotion();
			}
			
			if(shot.ticksExisted > 20)
			{	
				LaserData laserdata = LaserData.laser(shot.getShotColor(), 0.05f, 2000000.0f, shot.damageRate);
				THShotLib.createLaserA(shot.user, shot, shot.pos_Shot(), shot.angle, 0.6d, 1.0d, 0.1d, shot.gravity, laserdata);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public boolean specialShot_hitBlock(World world, int id, EntityTHShot shot,
			MovingObjectPosition movingObjectPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean specialShot_hitEntity(World world, int id,
			EntityTHShot shot, Entity entity_Hit) {
		// TODO Auto-generated method stub
		return false;
	}
}
