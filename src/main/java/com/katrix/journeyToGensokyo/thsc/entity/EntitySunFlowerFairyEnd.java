/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 * 
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package com.katrix.journeyToGensokyo.thsc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.katrix.journeyToGensokyo.JourneyToGensokyo;
import com.katrix.journeyToGensokyo.handler.ConfigHandler;
import com.katrix.journeyToGensokyo.reference.MobModID;
import com.katrix.journeyToGensokyo.reference.SpecialShotID;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.ShotData;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntitySunFlowerFairy;
import thKaguyaMod.init.THKaguyaConfig;

public class EntitySunFlowerFairyEnd extends EntitySunFlowerFairy {

	public EntitySunFlowerFairyEnd(World world) {
		super(world);
		
    	setDanmakuPattern(rand.nextInt(3) + 1);
        
    	this.setSpeed(0.7D);
    	this.setSpecies(EntityTHFairyEnd.SPECIES_FAIRY);
    	
    	this.setAttackDistance(16.0D);
    	this.setDetectionDistance(16.0D);
    	this.setFlyingHeight(4);
	}
	
    @Override
    public void danmakuPattern(int level)
    {
    	Vec3 angle;
    	angle = THShotLib.angle(rotationYaw,  rotationPitch);
    	ShotData shotData;
    	
		switch(getDanmakuPattern())
		{
			case NORMAL_ATTACK01:
				danmakuSpan = 30;
				shotForm = THShotLib.FORM_KUNAI;
				shotColor = THShotLib.BLUE;
				speedRate = 0.4F;
		    	shotData = ShotData.shot(shotForm, shotColor, 0, 80, special);

				danmaku01(angle, shotData, level);
				break;
			case NORMAL_ATTACK02:
				if(level == 1) danmakuSpan = 30;
				if(level == 2) danmakuSpan = 20;
				if(level == 3) danmakuSpan = 15;
				if(level == 4) danmakuSpan = 10;
		    	shotForm = THShotLib.FORM_CRYSTAL;
		    	speedRate = 0.1F;
		    	shotData = ShotData.shot(shotForm, shotColor, 0, 80, SpecialShotID.SEED_LASER01);
		    	
				danmaku02(angle, shotData, level);
				break;
			case NORMAL_ATTACK03:
				if(level == 1) danmakuSpan = 30;
				if(level == 2) danmakuSpan = 20;
				if(level == 3) danmakuSpan = 15;
				if(level == 4) danmakuSpan = 10;
		    	shotForm = THShotLib.FORM_CRYSTAL;
		    	speedRate = 0.1F;
		    	shotData = ShotData.shot(shotForm, shotColor, 0, 80, SpecialShotID.SEED_LASER01);
		    	
				danmaku03(angle, shotData, level);
				break;
			default:
				break;
		}
    }
    
    public void danmaku01(Vec3 angle, ShotData shotData, int level)
    {  	
		int num = 1;

		if(level == 1 || level == 2)
			num = 3;
			
			if(attackCounter == 0){
			THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
			angle = THShotLib.angle(rotationYaw,  rotationPitch+5);
			THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
			angle = THShotLib.angle(rotationYaw,  rotationPitch-5);
			THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);

	    	THShotLib.playShotSound(this);
			}
			
		if(level == 3){
			num = 5;
					
			if(attackCounter == 0 || attackCounter == 10 || attackCounter == 20){
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch+5);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch+10);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch-5);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch-10);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				
		    	THShotLib.playShotSound(this);
			}
		}
		
		if(level == 4){
			num = 7;
					
			if(attackCounter <= 4){
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch+5);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch+10);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch-5);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch-10);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				
		    	THShotLib.playShotSound(this);
			}
		}
	}
    
    public void danmaku02(Vec3 angle, ShotData shotData, int level)
    {  	
		int num = 3;
		if(level == 1) num = 1;
		if(level == 2) num = 3;
		if(level == 3) num = 5;
		if(level == 4) num = 5;
		
		if(attackCounter == 0){
			
	    	THShotLib.playShotSound(this);
			
			if(level != 4){
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
			}
			
			else{
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch+10);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
				angle = THShotLib.angle(rotationYaw,  rotationPitch-10);
				THShotLib.createWideShot(getShooter(), pos(), angle, (double)speedRate, shotData, num, 20.0f);
			}
		}
	}
    
    public void danmaku03(Vec3 angle, ShotData shotData, int level)
    {  	
		int num = 3;
		if(level == 1) num = 1;
		if(level == 2) num = 3;
		if(level == 3) num = 5;
		if(level == 4) num = 5;
		
		if(attackCounter == 0){
			THShotLib.createRandomRingShot(getShooter(), pos(), angle, speedRate, speedRate, 0.0D, shotData, num, 0.75D, 0.0f);
			
	    	THShotLib.playShotSound(this);
		}
	}
	
    @Override
    protected boolean canFairyCall()
    {
    	return true;
    }
    
    @Override
    protected double getFairyCallDistance()
    {
    	return 12.0D;
    }
	
    @Override
    public boolean getCanSpawnHere()
    {
    	if(rand.nextInt(100) < THKaguyaConfig.fairySpawnRate)
    	{
    		return false;
    	}
    	
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }
	
    public static void postInit() {
    	
    	EntityRegistry.registerGlobalEntityID(EntitySunFlowerFairyEnd.class, "SunFlowerFairyEnd", ConfigHandler.entityIdSunFlowerFairyEnd, 0x1C1133, 0x828200);
    	EntityRegistry.registerModEntity(EntitySunFlowerFairyEnd.class, "SunFlowerFairyEnd",  MobModID.SUNFLOWER_FAIRY_END, JourneyToGensokyo.instance, 80, 1, true);
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.END)));
		EntityRegistry.addSpawn(EntitySunFlowerFairyEnd.class, 5, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
    	
    }

}
