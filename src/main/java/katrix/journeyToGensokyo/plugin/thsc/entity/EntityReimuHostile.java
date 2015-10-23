/**
 * This class was created by <Katrix>, base on a class from Touhou Items Mod. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import static thKaguyaMod.DanmakuConstants.BOUND04;
import static thKaguyaMod.THShotLib.gravity_Default;
import static thKaguyaMod.THShotLib.rotate_Default;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import katrix.journeyToGensokyo.reference.SpecialShotID;
import katrix.journeyToGensokyo.util.LogHelper;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityDanmakuMob;
import thKaguyaMod.entity.shot.EntityOnmyoudama;
import thKaguyaMod.entity.spellcard.EntitySpellCard;
import thKaguyaMod.init.THKaguyaConfig;
import thKaguyaMod.init.THKaguyaItems;
import thKaguyaMod.item.ItemTHShot;

/** 楽園の素敵な巫女　博麗 霊夢 */
public class EntityReimuHostile extends EntityDanmakuMob implements IMob
{
	
	public double shotGap = 0.06D;
	
	public EntityReimuHostile(World world)
    {
        super(world);
        
        this.setSize(1.0F, 1.8F);
        
        this.experienceValue = 250;
        
        this.setDanmakuMobName("Reimu Hakurei");
        this.setSpecies(EntityDanmakuMob.SPECIES_HUMAN);
    	
    	this.setDanmakuPattern(NORMAL_ATTACK01);
    	this.setMaxHP(74.0F);
        this.setHealth(74.0F);
        this.setSpeed(0.4F);
        this.setAttackDistance(50.0D);
    	this.setDetectionDistance(0.0D);
    	this.setFlyingHeight(4);
    	this.isFlyingMode = true;
    	
    	this.isSpellCardMode = false;
    	this.attackInterval = 0;
    }
	
    public int getUsingSpellCardNo()
    {
    	switch(this.getDanmakuPattern())
    	{
    		case SPELLCARD_ATTACK01:
    			return EntitySpellCard.SC_REIMU_MusouFuuin;
    		default:
    			return -1;
    	}
    }
    
    @Override
    protected void onDeathUpdate()
    {
    	switch(getDanmakuPattern())
    	{
    		case NORMAL_ATTACK01:
    			setFlyingHeight(2);
    			moveDanmakuAttack(SPELLCARD_ATTACK01, 40, 60.0F, 160);
    			break;
    		case SPELLCARD_ATTACK01:
    			moveDanmakuAttack(ATTACK_END, 90, 0.0F, 160);
    			break;
    		default:
    			if(deathTime % 6 == 0)
    			{
    				THShotLib.explosionEffect(worldObj, posX, posY, posZ, 1.0F + deathTime * 0.1F);
    			}
    			super.onDeathUpdate();
    			break;
    	}
    }

    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    }

    
    @Override
    public void danmakuPattern(int level)
    {
    	Vec3 look = this.getLookVec();
    	switch(getDanmakuPattern())
    	{
    		case NORMAL_ATTACK01:
    			danmaku01(look, level);
    			break;
    		case SPELLCARD_ATTACK01:
    			spellcard01(look, level);
    			break;
    		default:
    			break;
    	}
    }
    
    private void danmaku01(Vec3 angle, int level)
    {
		if(attackCounter == 2 || attackCounter == 4 || attackCounter == 6)
		{
			THShotLib.createCircleShot(this, pos(), angle, 0.3D, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.WHITE, 0.2f, 0.5f), 8*level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw+attackCounter, rotationPitch), 0.12D, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.2f, 0.5f), 8*level);
			for(int i = 4; i <= 6; i++){
				THShotLib.createShot(this, pos(), THShotLib.angle(rotationYaw+attackCounter*2, rotationPitch), 0.05D*i, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.WHITE, 0.3f, 0.5f));
			}
		}
		
		if(attackCounter < 30 && attackCounter % 2 == 0) {
			if(!worldObj.isRemote)
			{
				worldObj.spawnEntityInWorld(new EntityOnmyoudama(worldObj, this, this, THShotLib.pos_Distance(pos(), THShotLib.angle(rotationYaw+attackCounter*12, rotationPitch), 2.0D), THShotLib.angle(rotationYaw+attackCounter*12, rotationPitch), 0F, rotate_Default(), 0F, 9999, 0.5D, 1.8D, 0.0D, gravity_Default(), THShotLib.RED, 1.2F, 2.0F, 0, 180, BOUND04));//陰陽玉を出現させる
			}
		}
		
		if(attackCounter == 30)
		{
		    this.move(THShotLib.angle_Random(), 0.6D, 10);
		}
		
		if(attackCounter == 42 || attackCounter == 44 || attackCounter == 46)
		{
			THShotLib.createCircleShot(this, pos(), angle, 0.15D, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.WHITE, 0.2f, 0.5f), 8*level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw+(attackCounter-40), rotationPitch), 0.25D, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.2f, 0.5f), 8*level);
			for(int i = 4; i <= 6; i++){
				THShotLib.createShot(this, pos(), THShotLib.angle(rotationYaw+(attackCounter-40)*2, rotationPitch), 0.05D*i, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.3f, 0.5f));
			}
		}
		
		if(attackCounter == 48 || attackCounter == 50 || attackCounter == 52)
		{
			THShotLib.createCircleShot(this, pos(), angle, 0.3D, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.WHITE, 0.15f, 0.5f), 8*level);
			THShotLib.createCircleShot(this, pos(), THShotLib.angle(rotationYaw+(attackCounter-48), rotationPitch), 0.12D, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.RED, 0.2f, 0.5f), 8*level);
		}
		
		if(attackCounter < 70 && attackCounter > 40 && attackCounter % 2 == 0) {
			if(!worldObj.isRemote)
			{
				worldObj.spawnEntityInWorld(new EntityOnmyoudama(worldObj, this, this, THShotLib.pos_Distance(pos(), THShotLib.angle(rotationYaw-attackCounter*12, rotationPitch), 2.0D), THShotLib.angle(rotationYaw-attackCounter*12, rotationPitch), 0F, rotate_Default(), 0F, 9999, 0.5D, 1.8D, 0.0D, gravity_Default(), THShotLib.RED, 1.2F, 2.0F, 0, 180, BOUND04));//陰陽玉を出現させる
			}
		}
		
		if(attackCounter == 70)
		{
		    this.move(THShotLib.angle_Random(), 0.6D, 10);
		}
		
		if(attackCounter >= 80)
		{
			attackCounter = 0;
		}
    }
    
    private void spellcard01(Vec3 angle, int level)
    {
    	
		if(attackCounter == 1)
		{
			this.useSpellCard(EntitySpellCard.SC_REIMU_MusouFuuin);
		}
		
		for(int k = 1; k<= 8; k++){
			if(attackCounter == 20+k*(level/2))
			{
				for(int i = 1; i<=5; i++){
					for(int j = -1; j<=1; j++){
						THShotLib.playShotSound(this);
						THShotLib.createShot(this, pos(), THShotLib.angle(rotationYaw+(j*6.0f)+(360/8)*k, rotationPitch), shotGap*i, ShotData.shot(THShotLib.FORM_AMULET, THShotLib.WHITE, 0.2f, 0.5f, 0, 20, SpecialShotID.FANTASY_SEAL01));
					}
				}
			}
		}
		
		if(attackCounter >= 100)
		{
			attackCounter = 0;
		}
    }
    
    @Override
    protected boolean canFairyCall()
    {
    	return false;
    }
    
    /**
     * Reduces damage, depending on potions
     */
    @Override
    protected float applyPotionDamageCalculations(DamageSource damageSource, float damage)
    {
        damage = super.applyPotionDamageCalculations(damageSource, damage);

        if (isEntityInvulnerable())
        {
            damage = (float)((double)damage * 0.05D);
        }

        return damage;
    }

    @Override
    protected void updateAITasks()
    {
        super.updateAITasks();
    }
	
	@Override
	protected void dropFewItems(boolean hasBeenAttackedByPlayer, int lootingLevel)
    {
		super.dropFewItems(hasBeenAttackedByPlayer, lootingLevel);
		
		if( hasBeenAttackedByPlayer && this.isSpellCardAttack() )
		{
	        int j = 40;//this.rand.nextInt(15) + this.rand.nextInt(1 + par2);
	        int k;
	        Vec3 vec3;
	        float yaw, pitch;
	
	        for (k = 0; k < j; k+=2)
	        {
	        	yaw = 360F / (float)j * (float)k;
	        	pitch = MathHelper.sin( yaw / 180F * 3.141593F * 4F) * 20F - 60F;
	        	vec3 = THShotLib.getVecFromAngle(yaw, pitch, 1.0F);
	        	this.dropPointItem(this.pos(), vec3);
	        	yaw = 360F / (float)j * (float)(k + 1);
	        	pitch = MathHelper.cos( yaw / 180F * 3.141593F * 4F) * 20F - 60F;
	        	vec3 = THShotLib.getVecFromAngle(yaw, pitch, 1.0F);
	        	this.dropPowerUpItem(this.pos(), vec3);
	        }
	        
	        this.dropShotItem(ItemTHShot.TALISMAN, 17 + rand.nextInt(2) + lootingLevel, 5, 32, THShotLib.RED, 0, 0, 2);
		}
        if( hasBeenAttackedByPlayer && getDanmakuPattern() == SPELLCARD_ATTACK01)
        {
        	this.dropItem(THKaguyaItems.hakurei_miko_stick, 1);
        }
    }
	
	@Override
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }
    
	@Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

	@Override
    public boolean getCanSpawnHere()
    {
    	if(rand.nextInt(100) < THKaguyaConfig.fairySpawnRate && rand.nextInt(100) < 90 || super.getCanSpawnHere() == false)
    	{
    		return false;
    	}
    	
    	int range = 64;
		@SuppressWarnings("unchecked")
		List<EntityReimuHostile> reimus = worldObj.getEntitiesWithinAABB(EntityReimuHostile.class, AxisAlignedBB.getBoundingBox(this.posX - range, this.posY - range, this.posZ - range, this.posX + range + 1, this.posY + range + 1, this.posZ + range + 1));
		if (reimus.size() >= 1) 
    	{
    		return false;
    	}
    	
    	return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }
	
    public static void postInit() {
    	
    	EntityRegistry.registerModEntity(EntityReimuHostile.class, EntityName.REIMU_HOSTILE,  MobID.REIMU_HOSTILE, JourneyToGensokyo.instance, 80, 1, true);
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.FOREST)));	
		
		if(THKaguyaConfig.spawnBoss && ConfigHandler.newBossesSpawn){
			EntityRegistry.addSpawn(EntityReimuHostile.class, 1, 1, 1, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
		}
    }
}