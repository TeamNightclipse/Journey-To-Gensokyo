/**
 * This class was created by <Katrix>, base on a class from Touhou Items Mod. It's distributed as
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

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityTHFairy;
import thKaguyaMod.registry.DanmakuPatternRegistry;

public class EntityTHFairyIce extends EntityTHFairy
{

    public EntityTHFairyIce(World world)
    {
        super(world);
    	
    	experienceValue = 15;
		shotColor = (byte)(THShotLib.AQUA);
		
    	setForm((byte)1);
    	
        this.setMaxHP(10.0F);
        this.setHealth(10.0F);
        
    	this.setSpeed(0.6D);
    	this.setSpecies(EntityTHFairyIce.SPECIES_FAIRY, EntityTHFairyIce.SPECIES_FAIRY_ICE);
    	
    	this.setAttackDistance(12.0D);
    	this.setDetectionDistance(12.0D);
    	this.setFlyingHeight(3);
    }
    
    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData)
    {
        Object p_110161_1_1 = super.onSpawnWithEgg(entityLivingData);

        EntityFamiliarIce familiar = new EntityFamiliarIce(this.worldObj);
        familiar.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.worldObj.spawnEntityInWorld(familiar);
        familiar.mountEntity(this);

        return (IEntityLivingData)p_110161_1_1;
    }

    @Override
    protected void setPattern(int patternId)
    {
    	String patternKey = DanmakuPatternRegistry.pattern.get(patternId);
    	
    	setDanmakuPattern(DanmakuPatternRegistry.danmaku.get(patternKey));
    	danmakuSpan = DanmakuPatternRegistry.span.get(patternKey);
    	speedRate = DanmakuPatternRegistry.speed.get(patternKey);
    }
    
    @Override
    public int getMaxSpawnedInChunk()
    {
        return 3;
    }
    
    public static void postInit() {
    	
    	EntityRegistry.registerGlobalEntityID(EntityTHFairyIce.class, "THFairyIce", ConfigHandler.entityIdTHFairyIce, 0x3DFFEE, 0xA0A000);
    	EntityRegistry.registerModEntity(EntityTHFairyIce.class, "THFairyIce",  MobModID.ICE_FAIRY, JourneyToGensokyo.instance, 80, 1, true);
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.COLD)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SNOWY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			if (spawnbiomes.contains(biome)) {
				spawnbiomes.remove(biome);
			}
		}
		
		EntityRegistry.addSpawn(EntityTHFairyIce.class, 20, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
    	
    }

}
