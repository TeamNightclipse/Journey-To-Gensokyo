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
import katrix.journeyToGensokyo.reference.SpecialShotID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityStandardShot extends Entity {
	
	private String userName;
	public int shotTimer;

	public EntityStandardShot(World world) {
		super(world);
		setSize(0.3F, 0.3F);
	}
	
	public EntityStandardShot(World world, EntityPlayer user, int type, int place, float power) {
		this(world);
		setType(type);
		setUser(user);
		setPlace(place);
		setPower(power);
		Vec3 pos = getPos();
		setPositionAndRotation(pos.xCoord, pos.yCoord, pos.zCoord, user.rotationYaw,  user.rotationPitch);
	}
	
	@Override
    public void onUpdate()
    {
		EntityPlayer user = getUser();
		
		if(!worldObj.isRemote){
			if(user != null){
				if(user.getHeldItem() !=  null){
					if(!(user.getHeldItem().getItem() instanceof ItemStandardShot)) {
						setDead();
					}

				}
				
				else{
					setDead();
				}
				
				Vec3 pos = getPos();
				setPositionAndRotation(pos.xCoord, pos.yCoord, pos.zCoord, user.rotationYaw,  user.rotationPitch);
				
				if(shotTimer != 0){
					shootDanmaku(user.isSneaking());
					shotTimer--;
				}
			}
			
			else{
				setDead();
			}
		}
    }
	
	public void shootDanmaku(boolean isSlowMode)
	{
		EntityPlayer user = getUser();
		float power = getPower();
		int place = getPlace();
		
		double speed = 0.7D;
		EntityFamiliar living = new EntityFamiliar(worldObj);
		
		switch(getType())
		{
			case 0:
				THShotLib.playShotSound(this);
				ShotData shot0 = ShotData.shot(THShotLib.FORM_ARROW, THShotLib.PURPLE, 0.1F, 1.0F+power/2, 0, 40);
				THShotLib.createShot(user, living, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw+90, rotationPitch), 0.3D), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed*3, speed*3, speed*3, THShotLib.gravity_Zero(), shot0);
				THShotLib.createShot(user, living, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw-90, rotationPitch), 0.3D), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed*3, speed*3, speed*3, THShotLib.gravity_Zero(), shot0);
				break;
			case 1:
				THShotLib.playShotSound(this);
	    		if(isSlowMode)
	    		{
	    			ShotData shot1 = ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.5F, 2.0F+power/2, 0, 60, THShotLib.HOMING01);
	    			
	    			if(power != 4F && place == 0){
		    			THShotLib.createShot(living, user, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0.3D), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed*2, speed*2, speed*2, THShotLib.gravity_Zero(), shot1);
	    			}
	    			else if(place == 0 || place == 1){
		    			THShotLib.createShot(living, user, THShotLib.pos_Distance(THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0.3D), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed*2, speed*2, speed*2, THShotLib.gravity_Zero(), shot1);
	    			}
		    	}
		    	else
		    	{
		   			ShotData shot1 = ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.2F, 1.0F+power/4, 0, 60, THShotLib.HOMING01);
	    			THShotLib.createShot(living, user, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed, speed, speed, THShotLib.gravity_Zero(), shot1);
		    	}
				break;
			case 2:
				THShotLib.createLaserB(user, this, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), THShotLib.rotate_Default(), 0F, 9999, LaserData.laser(THShotLib.RED, 0.2F, 16F, 2.0F+power/2, 0, 0), this, 0.3D, 0.0D);
				break;
			case 3:
				if(ticksExisted % 20 == 0){
					THShotLib.playShotSound(this);
		   			ShotData shot1 = ShotData.shot(THShotLib.FORM_SMALLSTAR, THShotLib.AQUA, 0.15F, 2.0F+power, 0, 60, SpecialShotID.MISSILE01);
					THShotLib.createShot(user, living, THShotLib.pos_Entity(this), THShotLib.angle(rotationYaw, rotationPitch), 0F, speed, speed, speed, THShotLib.gravity_Zero(), shot1);
				}
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
	
	public Vec3 getPos() {
		
		int place = getPlace();
		
		int intPower = MathHelper.floor_float(getPower());
		EntityPlayer userPlayer = getUser();
		boolean sneaking = userPlayer.isSneaking();
		if(sneaking){
			switch(intPower){
				case 0:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75);
				case 1:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75);
				case 2:
					switch(place){
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 0.5);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 0.5);
						default:
							break;
					}
				case 3:
					switch(place){
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 0.75);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 0.75);
						default:
							break;
						}
				case 4:
					switch(place){
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 0.35);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 0.75), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 0.35);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 0.75);
						case 3:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 0.75);
						default:
							break;
						}
				default:
					break;
			}
		}
		else{
			switch(intPower){
				case 0:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5);
				case 1:
					return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5);
				case 2:
					switch(place){
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 0.75);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 0.75);
						default:
							break;
					}
				case 3:
					switch(place){
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 1.0);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 1.0);
						default:
							break;
						}
				case 4:
					switch(place){
						case 0:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 0.5);
						case 1:
							return THShotLib.pos_Distance(THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 0.5);
						case 2:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), THShotLib.angle(userPlayer.rotationYaw+90, userPlayer.rotationPitch), 1.25);
						case 3:
							return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), THShotLib.angle(userPlayer.rotationYaw-90, userPlayer.rotationPitch), 1.25);
						default:
							break;
					}
				default:
					break;
			}
		}
		return THShotLib.pos_Distance(THShotLib.pos_Entity(userPlayer, 1), userPlayer.getLookVec(), 1.5);
	}
	
	@Override
    protected void entityInit()
    {
        this.dataWatcher.addObject(16, new Byte((byte)0)); //Type
        this.dataWatcher.addObject(17, new Byte((byte)0)); //Place
        this.dataWatcher.addObject(18, new Float((float)0.0F)); //Power
        this.dataWatcher.addObject(19, new String("")); //UserName
    }
	
    public void setType(int type)
    {
    	dataWatcher.updateObject(16, Byte.valueOf((byte)type));
    }
    
    public byte getType()
    {
    	return dataWatcher.getWatchableObjectByte(16);
    }
    
    public void setPlace(int place)
    {
    	dataWatcher.updateObject(17, Byte.valueOf((byte)place));
    }
    
    public byte getPlace()
    {
    	return dataWatcher.getWatchableObjectByte(17);
    }
    
    public void setPower(float power)
    {
    	dataWatcher.updateObject(18, Float.valueOf(power));
    }
    
    public float getPower()
    {
    	return dataWatcher.getWatchableObjectFloat(18);
    }
    
    public void setUser(EntityPlayer userPlayer)
    {    	
        userName = userPlayer.getCommandSenderName();
    	dataWatcher.updateObject(19, String.valueOf(this.userName == null ? "" : this.userName));
    }
    
    public EntityPlayer getUser()
    {
    	userName = dataWatcher.getWatchableObjectString(19);
    	EntityPlayer userPlayer = null;
    	
        if (this.userName != null && this.userName.length() > 0)
        {
        	userPlayer = this.worldObj.getPlayerEntityByName(this.userName);
        }

        return userPlayer;
    }

	@Override
	public void readEntityFromNBT(NBTTagCompound nbtTagCompound)
    {
		setType(nbtTagCompound.getByte("Type"));
		setPlace(nbtTagCompound.getByte("Place"));
		setPower(nbtTagCompound.getFloat("Power"));
		userName = nbtTagCompound.getString("UserName");
		
        if (this.userName != null && this.userName.length() == 0)
        {
        	setUser(worldObj.getPlayerEntityByName(this.userName));
            this.userName = null;
        }
    }

	@Override
	public void writeEntityToNBT(NBTTagCompound nbtTagCompound) {
		
        nbtTagCompound.setByte("Type", getType());
        nbtTagCompound.setByte("Place", getPlace());
        nbtTagCompound.setFloat("Power", getPower());
        
        if (getUser() != null)
        {
            this.userName = getUser().getCommandSenderName();
        }

        nbtTagCompound.setString("UserName", this.userName == null ? "" : this.userName);
	}
	
	public static void postInit() {
		
		EntityRegistry.registerModEntity(EntityStandardShot.class, EntityName.STANDARD_SHOT,  MobID.STANDARD_SHOT, JourneyToGensokyo.instance, 40, 1, true);
	}
}
