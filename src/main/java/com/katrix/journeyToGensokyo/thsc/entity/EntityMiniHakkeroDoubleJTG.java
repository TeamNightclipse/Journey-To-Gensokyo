package com.katrix.journeyToGensokyo.thsc.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.LaserData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.item.EntityMiniHakkero;
import thKaguyaMod.init.THKaguyaConfig;

public class EntityMiniHakkeroDoubleJTG extends EntityMiniHakkero  {
	
	@SuppressWarnings("unused")
	private EntityLivingBase tgEntity;
	@SuppressWarnings("unused")
	private float circleAngle;
	@SuppressWarnings("unused")
	private int moveTexture;
	@SuppressWarnings("unused")
	private int damage;
	@SuppressWarnings("unused")
	private int lastTime;
	@SuppressWarnings("unused")
	private boolean isSpellCard;

	public EntityMiniHakkeroDoubleJTG(World world) {
		super(world);
	}
	
	public EntityMiniHakkeroDoubleJTG(World world, EntityLivingBase EntityLivingBase, int da) {
		super(world, EntityLivingBase, da);
	
	}
	
	public EntityMiniHakkeroDoubleJTG(World world, EntityLivingBase EntityLivingBase, EntityLivingBase target) {
		
        this(world);

    	user = EntityLivingBase;//使用者をuserに保存
        setPosition(user.posX - Math.sin(user.rotationYaw / 180F * 3.141593F) * Math.cos(user.rotationPitch / 180F * 3.141593F),
        			user.posY - Math.sin(user.rotationPitch / 180F * 3.141593F) + (double)user.getEyeHeight() - 0.10000000149011612D ,
					user.posZ + Math.cos(user.rotationYaw / 180F * 3.141593F) * Math.cos(user.rotationPitch / 180F * 3.141593F));//初期位置を設定(x,y,z)
    	rotationYaw = user.rotationYaw;
    	rotationPitch = user.rotationPitch;
    	tgEntity = target;
    	count = 0;
    	circleAngle = 0F;
    	moveTexture = 0;
    	damage = 1;
    	worldObj.playSoundAtEntity(this, "thkaguyamod:masterspark", THKaguyaConfig.MasterSparkVol, 1.0F);
    	lastTime = 0;
    	
    	isSpellCard = true;
    	
    	Vec3 look1 = THShotLib.getVecFromAngle(rotationYaw+10, rotationPitch);
    	Vec3 look2 = THShotLib.getVecFromAngle(rotationYaw-10, rotationPitch);
    	THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), look1,
    			THShotLib.rotate_Default(), 0.0F, 9999, LaserData.laser(24, 4.2F, 60.0F, 8.0F, 30, 120, 0), this, 1.0D, 0.0F);
    	THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), look2,
    			THShotLib.rotate_Default(), 0.0F, 9999, LaserData.laser(24, 4.2F, 60.0F, 8.0F, 30, 120, 0), this, 1.0D, 0.0F);
	}

}
