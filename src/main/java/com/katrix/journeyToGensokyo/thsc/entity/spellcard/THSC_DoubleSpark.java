/**
 * This class was created by <Katrix>, base on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.thsc.entity.spellcard;

import static thKaguyaMod.DanmakuConstants.*;
import static thKaguyaMod.THShotLib.*;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.spellcard.THSpellCard;

import java.lang.Math;

import com.katrix.journeyToGensokyo.thsc.entity.EntityMiniHakkeroDoubleJTG;

public class THSC_DoubleSpark extends THSpellCard
{
	//恋符「マスタースパーク」
	
	private Vec3 tgVec;
	
	public THSC_DoubleSpark()
	{
		//setSpellCardName("");
		//setIconName("DoubleSparks");
		this.setNeedLevel(7);
		this.setRemoveTime(99);
		this.setEndTime(109);
		this.setOriginalUserName(MARISA);
	}
	
	@Override
	public void spellcard_main()
	{
		if(time == 1)
		{
			tgVec = user.getLookVec();
			EntityMiniHakkeroDoubleJTG miniHakkero;
    			
    		miniHakkero = new EntityMiniHakkeroDoubleJTG(world, user, target);
       		if(!world.isRemote)
       		{
        			world.spawnEntityInWorld(miniHakkero);//ミニ八卦炉を出す
       		}
		}
		if(time >= 30 && time < 99)
		{
			//EntityTHShot[] entityTHShot = new EntityTHShot[7];
    		double xVector1, yVector1, zVector1, xVector2, yVector2, zVector2, xVectorG, yVectorG, zVectorG, gRate, angleXZ = 0, angleY = 0, X1, Z1, X2, Z2;
			Vec3 lookAt = tgVec;
			int randLow = -2, randHigh = 2;
			lookAt.xCoord = -MathHelper.sin(card.rotationYaw / 180F * 3.141593F) * MathHelper.cos((card.rotationPitch + 90F) / 180F * 3.141593F);
    		lookAt.yCoord =	-MathHelper.sin((card.rotationPitch + 90F) / 180F * 3.141593F);
    		lookAt.zCoord =	 MathHelper.cos(card.rotationYaw / 180F * 3.141593F) * MathHelper.cos((card.rotationPitch + 90F) / 180F * 3.141593F);
			lookAt.rotateAroundY((float)Math.PI * 2);
			//float angle = (float)Math.random()*time; //(float)time * 6F ;
			float angle = (float)time * (float)rand.nextInt((randHigh - randLow) + 1) + randLow;
			float angleSpan = 360F / 14F;
			//gRate = (double)(ticksExisted % 9) / 9D + 0.1D;
			gRate = 0.034 + 0.03D * Math.sin(angle / 180F *3.141593F);
			
			xVectorG = -MathHelper.sin(card.rotationYaw / 180F * 3.141593F) * MathHelper.cos(card.rotationPitch / 180F * 3.141593F) * gRate;
    		yVectorG = -MathHelper.sin(card.rotationPitch / 180F * 3.141593F) * gRate;
    		zVectorG =  MathHelper.cos(card.rotationYaw / 180F * 3.141593F) * MathHelper.cos(card.rotationPitch / 180F * 3.141593F) * gRate;
			
    		for(int i = 0; i < 14; i++)
    		{
				angleXZ = angle;//横の角度　0=正面　+1ごとに左にずれていき360で正面に戻る
				angleY = 0;//縦の角度　0=正面　+1ごとに上にずれていき360で正面に戻る

				X1 =  Math.sin(angleXZ/ 180.0F * Math.PI) * Math.cos(card.rotationYaw/ 180.0F * Math.PI);
				Z1 =  Math.sin(angleXZ/ 180.0F * Math.PI) * Math.sin(card.rotationYaw/ 180.0F * Math.PI);
				X2 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin(angleY/ 180.0F * Math.PI) * Math.sin((card.rotationPitch + 90F)/ 180.0F * Math.PI) * Math.sin(card.rotationYaw/ 180.0F * Math.PI);
				Z2 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin(angleY/ 180.0F * Math.PI) * Math.sin((card.rotationPitch + 90F)/ 180.0F * Math.PI) * Math.cos(card.rotationYaw/ 180.0F * Math.PI);
				
				yVector1 = -Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin((card.rotationPitch + 90F - angleY)/ 180.0F * Math.PI);//Y方向　上下
				xVector1 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.cos(angleY/ 180.0F * Math.PI) * lookAt.xCoord + X1 - X2;//X方向　水平方向
				zVector1 =  Math.cos(angleXZ/ 180.0F * Math.PI) * Math.cos(angleY/ 180.0F * Math.PI) * lookAt.zCoord + Z1 + Z2;//Z方向　水平方向
				
				yVector2 = (-Math.cos(angleXZ/ 180.0F * Math.PI) * Math.sin((card.rotationPitch + 90F - angleY)/ 180.0F * Math.PI));//Y方向　上下
				xVector2 = (Math.cos(angleXZ/ 180.0F * Math.PI) * Math.cos(angleY/ 180.0F * Math.PI) * lookAt.xCoord + X1 - X2);//X方向　水平方向
				zVector2 = (Math.cos(angleXZ/ 180.0F * Math.PI) * Math.cos(angleY/ 180.0F * Math.PI) * lookAt.zCoord + Z1 + Z2);//Z方向　水平方向
				
				if (i % 2 == 0) {
					ShotData shot1 = ShotData.shot(FORM_STAR, time % 7, 0.5F, 8.0F, 0, 55);
					THShotLib.createShot(user, card, pos_Card(), angle(xVector1, yVector1, zVector1), 0F, 0.1D, 0.3D, 0.1D, gravity(xVectorG, yVectorG, zVectorG), shot1);
				}
				ShotData shot2 = ShotData.shot(FORM_STAR, time % 7, 0.35F, 8.0F, 0, 100);
				THShotLib.createShot(user, card, pos_Card(), angle(xVector2, yVector2, zVector2), 0F, 0.1D, 0.6D, 0.1D, gravity(xVectorG, yVectorG, zVectorG), shot2);
    			/*entityTHShot[i] = new EntityTHShot(world, user, card, xVector, yVector, zVector,
    				0.2D, 0.3D, 0.05D, xVectorG, yVectorG, zVectorG, 8, THShotLib.STAR[0] + time % 7, 0.4F, 55);*/
    			angle += angleSpan;
    			/*if(!world.isRemote)
    			{
    				world.spawnEntityInWorld(entityTHShot[i]);
    			}*/
    		}
		}
	}
}
