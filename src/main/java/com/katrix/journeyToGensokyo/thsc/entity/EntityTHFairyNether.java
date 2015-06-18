package com.katrix.journeyToGensokyo.thsc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.katrix.journeyToGensokyo.JourneyToGensokyo;
import com.katrix.journeyToGensokyo.handler.ConfigHandler;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityTHFairy;
import thKaguyaMod.init.THKaguyaConfig;

public class EntityTHFairyNether extends EntityTHFairy {

	public EntityTHFairyNether(World world) {
		super(world);
		
		if(rand.nextInt(2) == 1)
		{
			this.setForm((byte)0);
		}
		else
		{
			setHealth(2.0F);
			setDetectionDistance(8.0D);
			setAttackDistance(2.0D);
			setFlyingHeight(2);
			setSpeed(0.03D);
			//setDanmakuPattern((byte)-1);
			setDanmakuPattern(0);
			danmakuSpan = 50 - (THKaguyaConfig.danmakuLevel * 10);
			speedRate = 0.2F;
			shotForm = (byte)(THShotLib.LIGHT[0] / 8);
			shotColor = (byte)(THShotLib.RED);
			this.setForm((byte)-1);
		}
	}
	
    @Override
    public boolean getCanSpawnHere()
    {
    	//妖精のスポーンレートよりランダム値が低いならスポーンしない
    	if(rand.nextInt(100) < THKaguyaConfig.fairySpawnRate)
    	{
    		return false;
    	}
    	
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }
    
    public static void Init() {
    	
    	EntityRegistry.registerGlobalEntityID(EntityTHFairyNether.class, "THFairyNether", ConfigHandler.entityIdTHFairyNether, 0x2D2727, 0xA0A000);
    	EntityRegistry.registerModEntity(EntityTHFairyNether.class, "THFairyNether",  2, JourneyToGensokyo.instance, 80, 1, true);
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.NETHER)));
		
		EntityRegistry.addSpawn(EntityTHFairyNether.class, 20, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
    	
    }

}
