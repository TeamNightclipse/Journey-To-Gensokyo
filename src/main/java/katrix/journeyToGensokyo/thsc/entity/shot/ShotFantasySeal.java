/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.thsc.entity.shot;

import java.util.List;

import katrix.journeyToGensokyo.reference.SpecialShotID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;

public class ShotFantasySeal implements ISpecialShot {

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		switch(id)
		{
		case SpecialShotID.FANTASY_SEAL01:				
			if(shot.isShotEndTime())
			{				
				shot.setShotForm(THShotLib.FORM_CIRCLE);
				shot.shotSpecial = SpecialShotID.FANTASY_SEAL02;
				shot.setShotEndTime(10);
				shot.shotSpeed = 0.0;
				shot.shotLimitSpeed = 0.0;
				shot.shotAcceleration = 0.0;
				shot.reCreate();
				shot.delete();
			}
			break;
		case SpecialShotID.FANTASY_SEAL02:				
			if(shot.isShotEndTime())
			{				
				shot.setShotColor(THShotLib.RED);
				shot.shotSpecial = SpecialShotID.FANTASY_SEAL03;
				shot.setShotEndTime(10);
				shot.reCreate();
				shot.delete();
			}
			break;
		case SpecialShotID.FANTASY_SEAL03:				
			if(shot.isShotEndTime())
			{
				shot.setShotForm(THShotLib.FORM_AMULET);
				shot.shotSpecial = SpecialShotID.FANTASY_SEAL04;
				shot.setShotEndTime(30);
				
				if(shot.user.getAITarget() == null){
					homing(shot);
				}
				else{
					shot.angle = shot.angle_ToLiving(shot.user.getAITarget());
				}
				
				shot.shotSpeed = 0.75;
				shot.shotLimitSpeed = 0.0;
				shot.shotAcceleration = -0.04;
				shot.reCreate();
				shot.delete();
			}
		case SpecialShotID.FANTASY_SEAL04:				
			if(shot.isShotEndTime())
			{
				shot.setShotForm(THShotLib.FORM_CIRCLE);
				shot.shotSpecial = SpecialShotID.FANTASY_SEAL05;
				shot.setShotEndTime(10);
				shot.reCreate();
				shot.delete();
			}
			break;
		case SpecialShotID.FANTASY_SEAL05:				
			if(shot.isShotEndTime())
			{
				shot.setShotColor(THShotLib.PURPLE);;
				shot.shotSpecial = SpecialShotID.FANTASY_SEAL06;
				shot.setShotEndTime(10);
				shot.reCreate();
				shot.delete();
			}
		case SpecialShotID.FANTASY_SEAL06:				
			if(shot.isShotEndTime())
			{
				shot.setShotForm(THShotLib.FORM_AMULET);
				shot.shotSpecial = 0;
				shot.setShotEndTime(50);
				
				if(shot.user.getAITarget() == null){
					homing(shot);
				}
				else{
					shot.angle = shot.angle_ToLiving(shot.user.getAITarget());
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
	
	public void homing(EntityTHShot shot)
	{	
        @SuppressWarnings("rawtypes")
		List list = shot.worldObj.getEntitiesWithinAABBExcludingEntity(shot, shot.boundingBox.addCoord(shot.motionX, shot.motionY, shot.motionZ).expand(24.0D, 24.0D, 24.0D));//指定範囲内のEntityをリストに登録

		EntityLivingBase nearEntity = null;
		double nearDistance = 999.9D;
		float nearAngle = 180F;
		double nearValue = nearDistance * THShotLib.halfAbsSin(nearAngle / 180F * (float)Math.PI);
		Vec3 shotVec = shot.getShotVector();
		
		for (int j = 0; j < list.size(); j++)
        {
        	Entity entitys = (Entity)list.get(j);
        	if ( (entitys instanceof EntityLivingBase) == false || entitys instanceof EntityAnimal ||  entitys instanceof EntityVillager || entitys == shot.user)
            {
                continue;
            }
        	
        	EntityLivingBase entity1 = (EntityLivingBase)entitys;
        	
        	if(entity1.isDead)
        	{
        		continue;
        	}
        	
    		Vec3 shotPosVec = shot.pos();
    		Vec3 entityPosVec = Vec3.createVectorHelper(entity1.posX, entity1.posY + entity1.getEyeHeight(), entity1.posZ);
    		MovingObjectPosition movingObjectPosition = shot.worldObj.func_147447_a(shotPosVec, entityPosVec, false, true, false);
    		shotPosVec = shot.pos();
    		entityPosVec = Vec3.createVectorHelper(entity1.posX, entity1.posY + entity1.getEyeHeight(), entity1.posZ);
    		
        	if (movingObjectPosition != null && movingObjectPosition.entityHit == null)
        	{
        		continue;
        	}
        	
        	Vec3 targetVec = THShotLib.angle_ToPos(shotPosVec, entityPosVec);
        	float angleSpan = Math.abs(THShotLib.getVectorAndVectorAngle(shotVec, targetVec));
        	double toEntity1Distance = shot.getDistance(entity1.posX, entity1.posY + entity1.getEyeHeight(), entity1.posZ);
        	double value = toEntity1Distance * THShotLib.halfAbsSin(angleSpan / 180F * (float)Math.PI);
        	if(nearValue > value)
        	{
            	{
            		nearEntity = entity1;
            		nearAngle = angleSpan;
            		nearValue = value;
            		nearDistance = toEntity1Distance;
            	}
        	}
        }

		if(nearEntity != null)
		{
			shot.angle = shot.angle_ToLiving(nearEntity);
		}
	}

	@Override
	public boolean specialShot_hitBlock(World world, int id, EntityTHShot shot,
			MovingObjectPosition movingObjectPosition) {
		return false;
	}

	@Override
	public boolean specialShot_hitEntity(World world, int id,
			EntityTHShot shot, Entity entity_Hit) {
		return false;
	}

}
