/**
 * This class was created by <Katrix>, based on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity.spellcard;

import static thKaguyaMod.DanmakuConstants.*;
import static thKaguyaMod.THShotLib.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.spellcard.THSpellCard;

import java.lang.Math;

import katrix.journeyToGensokyo.net.PacketHandler;
import katrix.journeyToGensokyo.net.PacketSmoothCamera;
import katrix.journeyToGensokyo.plugin.thsc.entity.EntityMiniHakkeroFinalJTG;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class THSC_FinalSpark extends THSpellCard
{
	//恋符「マスタースパーク」
	
	private Vec3 tgVec;
	
	public THSC_FinalSpark()
	{
		//setSpellCardName("");
		//setIconName("DoubleSparks");
		this.setNeedLevel(10);
		this.setRemoveTime(99);
		this.setEndTime(109);
		this.setOriginalUserName(MARISA);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void spellcard_main()
	{
		
		if(time == 1)
		{
			tgVec = user.getLookVec();
			EntityMiniHakkeroFinalJTG miniHakkero;
    			
    		miniHakkero = new EntityMiniHakkeroFinalJTG(world, user, target, 20, 10);
       		if(!world.isRemote)
       		{
        			world.spawnEntityInWorld(miniHakkero);//ミニ八卦炉を出す
       		}
		}
		if(time == 30)
		{
			if(user instanceof EntityPlayerMP){
				IMessage msg = new PacketSmoothCamera(true);
				PacketHandler.net.sendTo(msg, ((EntityPlayerMP) user));
			}
		}
		if(time >= 21 && time % 5 == 0)
		{
			tgVec = user.getLookVec();
			EntityMiniHakkeroFinalJTG miniHakkero;
    			
    		miniHakkero = new EntityMiniHakkeroFinalJTG(world, user, target, 0, 10);
       		if(!world.isRemote)
       		{
        			world.spawnEntityInWorld(miniHakkero);//ミニ八卦炉を出す
       		} 
		}
		if(time >= 30 && time < 99)
		{
			Vec3 backward = user.getLookVec();
			if(time % 2 == 0) {
				
		       	user.addVelocity(-backward.xCoord*0.2, -backward.yCoord*0.2, -backward.zCoord*0.2);
		    	((EntityPlayerMP) user).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(user));
		    	
			}
    		//EntityTHShot[] entityTHShot = new EntityTHShot[7];
    		double xVector1, yVector1, zVector1, xVector2, yVector2, zVector2, xVectorG, yVectorG, zVectorG, gRate, angleXZ = 0, angleY = 0, X1, Z1, X2, Z2;
			Vec3 lookAt = tgVec;
			int randLow = -2, randHigh = 2;
			lookAt.xCoord = -MathHelper.sin(user.rotationYaw / 180F * 3.141593F) * MathHelper.cos((user.rotationPitch + 90F) / 180F * 3.141593F);
    		lookAt.yCoord =	-MathHelper.sin((user.rotationPitch + 90F) / 180F * 3.141593F);
    		lookAt.zCoord =	 MathHelper.cos(user.rotationYaw / 180F * 3.141593F) * MathHelper.cos((user.rotationPitch + 90F) / 180F * 3.141593F);
			lookAt.rotateAroundY((float)Math.PI * 2);
			float angle = (float)time * 6F ;
			float angleSpan = 360F / 14F;
			//gRate = (double)(ticksExisted % 9) / 9D + 0.1D;
			gRate = 0.034 + 0.03D * Math.sin(angle / 180F *3.141593F);
			
			xVectorG = -MathHelper.sin(user.rotationYaw / 180F * 3.141593F) * MathHelper.cos(user.rotationPitch / 180F * 3.141593F) * gRate;
    		yVectorG = -MathHelper.sin(user.rotationPitch / 180F * 3.141593F) * gRate;
    		zVectorG =  MathHelper.cos(user.rotationYaw / 180F * 3.141593F) * MathHelper.cos(user.rotationPitch / 180F * 3.141593F) * gRate;
    	    	
    		for(int i = 0; i < 14; i++)
    	    	{
				angleXZ = angle;//横の角度　0=正面　+1ごとに左にずれていき360で正面に戻る
				angleY = 0;//縦の角度　0=正面　+1ごとに上にずれていき360で正面に戻る

				X1 =  Math.sin(angleXZ/ 180.0F * Math.PI) * Math.cos(user.rotationYaw/ 180.0F * Math.PI);
				Z1 =  Math.sin(angleXZ/ 180.0F * Math.PI) * Math.sin(user.rotationYaw/ 180.0F * Math.PI);
				X2 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin(angleY/ 180.0F * Math.PI) * Math.sin((user.rotationPitch + 90F)/ 180.0F * Math.PI) * Math.sin(user.rotationYaw/ 180.0F * Math.PI);
				Z2 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin(angleY/ 180.0F * Math.PI) * Math.sin((user.rotationPitch + 90F)/ 180.0F * Math.PI) * Math.cos(user.rotationYaw/ 180.0F * Math.PI);
				
				yVector1 = -Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin((user.rotationPitch + 90F - angleY)/ 180.0F * Math.PI);//Y方向　上下
				xVector1 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.cos(angleY/ 180.0F * Math.PI) * lookAt.xCoord + X1 - X2;//X方向　水平方向
				zVector1 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.cos(angleY/ 180.0F * Math.PI) * lookAt.zCoord + Z1 + Z2;//Z方向　水平方向
				
				ShotData shot = ShotData.shot(FORM_STAR, time % 7, 0.5F, 8.0F, 0, 55);
				THShotLib.createShot(user, card, pos_User(user.getLookVec(), 0.7D), angle(xVector1, yVector1, zVector1), 0F, 0.1D, 0.5D, 0.15D, gravity(xVectorG, yVectorG, zVectorG), shot);
    			/*entityTHShot[i] = new EntityTHShot(world, user, card, xVector, yVector, zVector,
    				0.2D, 0.3D, 0.05D, xVectorG, yVectorG, zVectorG, 8, THShotLib.STAR[0] + time % 7, 0.4F, 55);*/
    			angle += angleSpan;
    			/*if(!world.isRemote)
    			{
    				world.spawnEntityInWorld(entityTHShot[i]);
    			}*/
    		}
    		if(time == 98)
    		{
    			if(user instanceof EntityPlayerMP){
					IMessage msg = new PacketSmoothCamera(false);
					PacketHandler.net.sendTo(msg, ((EntityPlayerMP) user));
				}
    		}
		}
	}
}