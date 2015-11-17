/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import thKaguyaMod.LaserData;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityFamiliar;
import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.item.ItemStandardShot;
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityStandardShot extends Entity {
	
	public EntityPlayer user;
	public int type;
	public int shotTimer;
	public int place;
	public float power;

	public EntityStandardShot(World world) {
		super(world);
		setSize(0.3F, 0.3F);
	}
	
	public EntityStandardShot(World world, EntityPlayer user, int type, int place, float power) {
		this(world);
		setType(type);
		this.user = user;
		this.place = place;
		this.power = power;
		Vec3 pos = getPos();
		setPositionAndRotation(pos.xCoord, pos.yCoord, pos.zCoord, user.rotationYaw,  user.rotationPitch);
	}
	
	@Override
    public void onUpdate()
    {
		if(user != null){
			if(user.getHeldItem() !=  null){
				if(!(user.getHeldItem().getItem() instanceof ItemStandardShot)){
					if(!worldObj.isRemote)
					{
						setDead();
					}
				}
			}
			else{
				if(!worldObj.isRemote)
				{
					setDead();
				}
			}
			
			Vec3 pos = getPos();
			setPositionAndRotation(pos.xCoord, pos.yCoord, pos.zCoord, user.rotationYaw,  user.rotationPitch);
			
			if(shotTimer != 0){
				shootDanmaku(user.isSneaking());
				shotTimer--;
			}
		}
		else{
			if(!worldObj.isRemote)
			{
				setDead();
			}
		}
    }
	
	public void shootDanmaku(boolean isSlowMode)
	{
		
		double speed = 0.7D;
		EntityFamiliar living = new EntityFamiliar(worldObj);
		
		switch(type)
		{
			case 0:
				ShotData shot0 = ShotData.shot(THShotLib.FORM_ARROW, THShotLib.PURPLE, 0.1F, 1.0F, 0, 40);
				THShotLib.createShot(user, living, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw+90, rotationPitch), 0.3D), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed*3, speed*3, speed*3, THShotLib.gravity_Zero(), shot0);
				THShotLib.createShot(user, living, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw-90, rotationPitch), 0.3D), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed*3, speed*3, speed*3, THShotLib.gravity_Zero(), shot0);
				break;
			case 1:
	    		if(isSlowMode)//低速モード
	    		{
	    			ShotData shot1 = ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.5F, 2.0F, 0, 60, THShotLib.HOMING01);
	    			THShotLib.createWideShot(user, living, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), speed*2, speed*2, speed*2, THShotLib.gravity_Zero(), shot1, 1, 20F, 1.0D, 0F);
		    	}
		    	else//高速モード
		    	{
		   			ShotData shot1 = ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.2F, 1.0F, 0, 60, THShotLib.HOMING01);
	    			THShotLib.createWideShot(user, living, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), speed, speed, speed, THShotLib.gravity_Zero(), shot1, 2, 40F, 0.5D, 0F);
		    	}
				break;
			case 2:
				THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), THShotLib.rotate_Default(), 0F, 9999, LaserData.laser(THShotLib.RED, 0.2F, 32F, 1.0F, 0, 0), this, 0.3D, 0.0D);
				break;
			case 3:
	   			ShotData shot1 = ShotData.shot(THShotLib.FORM_ARROW, THShotLib.PURPLE, 0.15F, 1.0F, 0, 60, THShotLib.EXPLOSION01);
				THShotLib.createShot(user, living, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed, speed, speed, THShotLib.gravity_Zero(), shot1);
				break;
			default:
				break;
		}
	}
	
	@Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

	@Override
	protected void entityInit() {}
	
	public void setType(int shotType){
		type = shotType;
	}
	
	public int getType(){
		return type;
	}
	
	public void setShotTimer(int timer){
		shotTimer = timer;
	}
	
	public int getShotTimer(){
		return shotTimer;
	}
	
	public void setPower(float playerPower) {
		power = playerPower;
	}
	
	public float getPower() {
		return power;
	}
	
	public Vec3 getPos() {
		int intPower = MathHelper.floor_float(power);
		switch(intPower){
			case 0:
				return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
			case 1:
				return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
			case 2:
				switch(place){
					case 0:
						return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5), THShotLib.angle(user.rotationYaw+90, user.rotationPitch), 0.75);
					case 1:
						return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5), THShotLib.angle(user.rotationYaw-90, user.rotationPitch), 0.75);
					default:
						break;
				}
			case 3:
				switch(place){
					case 0:
						return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
					case 1:
						return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5), THShotLib.angle(user.rotationYaw+90, user.rotationPitch), 1.0);
					case 2:
						return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5), THShotLib.angle(user.rotationYaw-90, user.rotationPitch), 1.0);
					default:
						break;
					}
			case 4:
				switch(place){
					case 0:
						return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5), THShotLib.angle(user.rotationYaw+90, user.rotationPitch), 0.5);
					case 1:
						return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5), THShotLib.angle(user.rotationYaw-90, user.rotationPitch), 0.5);
					case 2:
						return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), THShotLib.angle(user.rotationYaw+90, user.rotationPitch), 1.25);
					case 3:
						return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), THShotLib.angle(user.rotationYaw-90, user.rotationPitch), 1.25);
					default:
						break;
					}
				default:
					break;
		}
		return THShotLib.pos_Distance(THShotLib.pos_Entity(user, 1), user.getLookVec(), 1.5);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbtTagCompound) {}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbtTagCompound) {}
	
	public static void postInit() {
		
		EntityRegistry.registerModEntity(EntityStandardShot.class, EntityName.STANDARD_SHOT,  MobID.STANDARD_SHOT, JourneyToGensokyo.instance, 40, 1, true);
	}
}
