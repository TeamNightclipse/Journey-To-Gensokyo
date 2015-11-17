/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.spellcard;

import katrix.journeyToGensokyo.plugin.thsc.ShotMovementHelper;
import katrix.journeyToGensokyo.reference.SpecialShotID;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.shot.EntityTHShot;
import thKaguyaMod.entity.shot.ISpecialShot;
import thKaguyaMod.entity.spellcard.THSpellCard;
import thKaguyaMod.init.THKaguyaConfig;

public class THSC_CurseOfDreamsAndReality extends THSpellCard implements ISpecialShot {
	
	public THSC_CurseOfDreamsAndReality()
	{
		this.setNeedLevel(4);
		this.setRemoveTime(50);
		this.setEndTime(160);
		this.setOriginalUserName(YUKARI);
	}

	@Override
	public void spellcard_main(){
		
		if(time == 1){
			THShotLib.playShotSound(card);
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw+45, user.rotationPitch), 0F, 0.35D, 0.35D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_BIG, THShotLib.BLUE, 0, 15, SpecialShotID.DREAMS_AND_REALITY01));
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw-45, user.rotationPitch), 0F, 0.35D, 0.35D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_BIG, THShotLib.BLUE, 0, 15, SpecialShotID.DREAMS_AND_REALITY11));
		}
		
		if(time == 50){
			THShotLib.playShotSound(card);
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw-45, user.rotationPitch), 0F, 0.35D, 0.35D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_BIG, THShotLib.BLUE, 0, 15, SpecialShotID.DREAMS_AND_REALITY01));
			THShotLib.createShot(user, card, pos_User(), THShotLib.angle(user.rotationYaw+45, user.rotationPitch), 0F, 0.35D, 0.35D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_BIG, THShotLib.BLUE, 0, 15, SpecialShotID.DREAMS_AND_REALITY11));
		}
	}

	@Override
	public void specialShot_move(World world, int id, EntityTHShot shot) {
		int danLevel = THKaguyaConfig.danmakuLevel;
		switch(id)
		{
			case SpecialShotID.DREAMS_AND_REALITY01:
				if(shot.isShotEndTime()){
					THShotLib.playShotSound(shot);
					THShotLib.createShot(shot.user, shot.source, shot.pos(), shot.angle, 0F, 0.0D, 0.0D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.MASK_FORM, THShotLib.MASK_COLOR, 0, 10, SpecialShotID.DREAMS_AND_REALITY02));
				}
				break;
			case SpecialShotID.DREAMS_AND_REALITY02:
				if(shot.ticksExisted % 2 == 0){
					THShotLib.playShotSound(shot);
					THShotLib.createSphereShot(shot.user, shot.source, shot.pos(), THShotLib.angle(shot.rotationYaw + shot.ticksExisted*5, shot.rotationPitch), 0f, 0.35D, 0.35D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_RICE, THShotLib.AQUA, 0, 5, SpecialShotID.DREAMS_AND_REALITY03), 4*danLevel, 0.1D, 0f);
				}
				break;
			case SpecialShotID.DREAMS_AND_REALITY03:
				if(shot.isShotEndTime()){
					if(shot.user instanceof EntityDanmakuMob){
						EntityDanmakuMob danmakuMob = (EntityDanmakuMob)shot.user;
						
						if(danmakuMob.getTarget() != null){
							shot.angle = shot.angle_ToLiving(danmakuMob.getTarget());
						}
					}
					else{
						ShotMovementHelper.homing(shot, 24);
					}
					THShotLib.playShotSound(shot);
					THShotLib.createShot(shot.user, shot.source, shot.pos(), shot.angle, 0F, 0.45D, 0.45D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_RICE, THShotLib.AQUA));
				}
				break;
			case SpecialShotID.DREAMS_AND_REALITY11:
				if(shot.isShotEndTime()){
					THShotLib.playShotSound(shot);
					
					
					for(int i = -1; i < 3; i+=2){
						for(int j = -1; j < 3; j+=2){
							for(int k = -1; k < 3; k+=2){
								THShotLib.createSphereShot(shot.user, shot.source, THShotLib.pos(shot.posX+i, shot.posY+j, shot.posZ+k), shot.angle, 0f, 0.2D, 0.2D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_SCALE, THShotLib.AQUA), 4*danLevel, 0.1D, 0F);
							}
						}
					}
					
					
					for(int i = -2; i < 4; i+=2){
						for(int j = -2; j < 4; j+=2){
							for(int k = -2; k < 4; k+=2){
								THShotLib.createSphereShot(shot.user, shot.source, THShotLib.pos(shot.posX+i, shot.posY+j, shot.posZ+k), shot.angle, 0f, 0.2D, 0.2D, 0.0D, THShotLib.gravity_Zero(), ShotData.shot(THShotLib.FORM_SCALE, THShotLib.GREEN), 4*danLevel, 0.1D, 0F);
							}
						}
					}
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
