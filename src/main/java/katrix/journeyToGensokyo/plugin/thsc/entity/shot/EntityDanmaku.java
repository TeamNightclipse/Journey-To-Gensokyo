package katrix.journeyToGensokyo.plugin.thsc.entity.shot;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.EntityShotMaterial;

public abstract class EntityDanmaku extends Entity implements IProjectile
{
    public EntityLivingBase shotUser;
    public Entity shotSource;
    private String shotUserName;
    
    public Vec3 shotAngle;
    
    public Vec3 shotRotate;
	public float shotRotationYawSpeed;
	public int shotRotationEnd;
    
    public double shotSpeed;
    public double shotAcceleration;
    public double shotSpeedLimit;
    public double shotSpeedLast;
    public Vec3 shotGravity;
    
    public float shotDamage;
    public float shotSize;
    public int shotColor;
    public int shotForm;
    public int shotDelayTime;
    public int shotEndTime;
    
	public double prevShotMotionX;
	public double prevShotMotionY;
	public double prevShotMotionZ;
    
    public EntityDanmaku(World world)
    {
        super(world);
        this.setSize(0.1F, 0.1F);
    }

    protected void entityInit() {}

    /**
     * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
     * length * 64 * renderDistanceWeight Args: distance
     */
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double p_70112_1_)
    {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
        d1 *= 64.0D;
        return p_70112_1_ < d1 * d1;
    }
    
	public EntityDanmaku(World world, EntityLivingBase user, Entity source,
			Vec3 pos, Vec3 angle, float slope, 
	    	Vec3 rotate, float rotationSpeed, int rotationEnd,
	    	double firstSpeed, double limitSpeed, double acceleration, Vec3 gravity,
	    	int form, int color, float size, float damage, int delay,int end)
	    {
	        super(world);
	    	
	    	this.shotUser = user;
	    	this.shotSource = source;
	    	
	    	setPosition(pos.xCoord, pos.yCoord, pos.zCoord);
	    	this.shotAngle = angle;
	    	setAngleZ(slope);
	    	
	    	this.shotRotate = rotate;
	    	this.shotRotationYawSpeed = rotationSpeed;
	    	this.shotRotationEnd = rotationEnd;
	    	
			this.shotSpeed = firstSpeed;
	    	this.shotAcceleration = acceleration;
	    	this.shotSpeedLimit = limitSpeed;
	    	shotSpeedLast = shotSpeed;
	    	
	    	this.shotGravity = gravity;
	    	
	        setSize(size, size);
	    	this.shotSize = size;
	    	this.shotDamage = damage;
	        this.shotColor = color;
	        this.shotForm = form;
	    	this.shotDelayTime = delay;
	    	this.shotEndTime = end;
	    	
	    	motionX = angle.xCoord * shotSpeed;
	    	motionY = angle.yCoord * shotSpeed;
	    	motionZ = angle.zCoord * shotSpeed;
	    	prevShotMotionX = motionX;
	    	prevShotMotionY = motionY;
	    	prevShotMotionZ = motionZ;
	    	
	    	updateYawAndPitch();
	        setRotation(rotationYaw, rotationPitch);
	    	prevRotationYaw = rotationYaw;
	    	prevRotationPitch = rotationPitch;
	    	
	    	setAnimationCount(-delay);
	    	
	    	updateAngle();
	}

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        
    	if(shotUser != null && !worldObj.isRemote && (shotUser.isDead) && shotUser instanceof EntityPlayer == false)
    	{
			shotFinishBonus();
			return;
    	}

        Vec3 pos = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        Vec3 posNew = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(pos, posNew);
        pos = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
        posNew = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (movingobjectposition != null)
        {
            posNew = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }

        if (!this.worldObj.isRemote)
        {
            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            EntityLivingBase user = this.getShotUser();

            for (int j = 0; j < list.size(); ++j)
            {
                Entity entity1 = (Entity)list.get(j);

                if (entity1.canBeCollidedWith() && entity1 != user)
                {
                    float f = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(pos, posNew);

                    if (movingobjectposition1 != null)
                    {
                        double d1 = pos.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D)
                        {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                movingobjectposition = new MovingObjectPosition(entity);
            }
        }

        if (movingobjectposition != null)
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.worldObj.getBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ) == Blocks.portal)
            {
                this.setInPortal();
            }
            else
            {
                this.onImpact(movingobjectposition);
            }
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

        for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f1) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;

        this.setPosition(this.posX, this.posY, this.posZ);
    }
    
	public void shotAcceleration()
	{
    	if( shotAcceleration > 0.0D && shotSpeed < shotSpeedLimit)
    	{
    		motionX += shotAngle.xCoord * shotAcceleration;
    		motionY += shotAngle.yCoord * shotAcceleration;
    		motionZ += shotAngle.zCoord * shotAcceleration;
    		
    		if( shotAcceleration > 0.0D && shotSpeed > shotSpeedLimit )
    		{
    			motionX = shotAngle.xCoord * shotSpeedLimit;
    			motionY = shotAngle.yCoord * shotSpeedLimit;
    			motionZ = shotAngle.zCoord * shotSpeedLimit;
    		}
    	}
    	
    	else if(shotAcceleration < 0.0D && shotSpeed > shotSpeedLimit)
    	{	
    		if(Math.abs(shotAcceleration) > shotSpeed - shotSpeedLimit)
    		{
    			motionX = shotAngle.xCoord * shotSpeedLimit;
        		motionY = shotAngle.yCoord * shotSpeedLimit;
        		motionZ = shotAngle.zCoord * shotSpeedLimit;
    		}
    		else
    		{
    			motionX += shotAngle.xCoord * shotAcceleration;
        		motionY += shotAngle.yCoord * shotAcceleration;
        		motionZ += shotAngle.zCoord * shotAcceleration;
    		}
    	}
	}
    
	protected void updateYawAndPitch()
	{
		rotationYaw = THShotLib.getYawFromVector(shotAngle.xCoord, shotAngle.zCoord);
		rotationPitch = THShotLib.getPitchFromVector(shotAngle.xCoord, shotAngle.yCoord, shotAngle.zCoord);
		setRotation(rotationYaw, rotationPitch);
	}
    
	public void updateGravityLevel()
	{
		motionX += shotGravity.xCoord;
		motionY += shotGravity.yCoord;
		motionZ += shotGravity.zCoord;
	}

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    @SideOnly(Side.CLIENT)
    public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_)
    {
        this.motionX = p_70016_1_;
        this.motionY = p_70016_3_;
        this.motionZ = p_70016_5_;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70016_3_, (double)f) * 180.0D / Math.PI);
        }
    }
    
	public void setAngleZ(float angle_Z)
	{
		dataWatcher.updateObject(16, Integer.valueOf((int)(angle_Z * 10000F)));
	}
    
	public void setAnimationCount(int count)
	{
		dataWatcher.updateObject(17, Integer.valueOf(count + 1000));
	}
	
	public void updateAngle()
	{	
    	float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
    	
    	if(!worldObj.isRemote)
    	{
    		rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
    		
    		for (rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D); 
    				rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
    		
        	for (rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D); 
        			rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
        }
        if(rotationYaw - prevRotationYaw > 180F)
        for (; rotationPitch - prevRotationPitch >= 180F; prevRotationPitch += 360F) { }
        for (; rotationYaw - prevRotationYaw < -180F; prevRotationYaw -= 360F) { }
        for (; rotationYaw - prevRotationYaw >= 180F; prevRotationYaw += 360F) { }
        rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 1.0F;
	}
    
	public void shotFinishBonus()
	{
		EntityShotMaterial shotMaterial = new EntityShotMaterial(worldObj, posX, posY, posZ);
		
		if(!worldObj.isRemote)
		{
			worldObj.spawnEntityInWorld(shotMaterial);
			setDead();
		}
	}

    /**
     * Called when this EntityDanmaku hits a block or entity.
     */
    protected abstract void onImpact(MovingObjectPosition p_70184_1_);

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbtTag)
    {
        if ((this.shotUserName == null || this.shotUserName.length() == 0) && this.shotUser != null && this.shotUser instanceof EntityPlayer)
        {
            this.shotUserName = this.shotUser.getCommandSenderName();
        }

        nbtTag.setString("ownerName", this.shotUserName == null ? "" : this.shotUserName);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbtTag)
    {
        this.shotUserName = nbtTag.getString("ownerName");

        if (this.shotUserName != null && this.shotUserName.length() == 0)
        {
            this.shotUserName = null;
        }
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    public EntityLivingBase getShotUser()
    {
        if (this.shotUser == null && this.shotUserName != null && this.shotUserName.length() > 0)
        {
            this.shotUser = this.worldObj.getPlayerEntityByName(this.shotUserName);
        }

        return this.shotUser;
    }
}