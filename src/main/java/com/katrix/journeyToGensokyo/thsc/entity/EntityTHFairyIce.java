 package com.katrix.journeyToGensokyo.thsc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.katrix.journeyToGensokyo.Config;
import com.katrix.journeyToGensokyo.JourneyToGensokyo;

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

/** ひまわり妖精 */
public class EntityTHFairyIce extends EntityTHFairy
{

    public EntityTHFairyIce(World world)
    {
        super(world);
        
        this.setSize(0.6F, 1.5F);//MOBの当たり判定の大きさ 横奥行き、高さ、大きさ
    	
    	experienceValue = 15;//経験値の量
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
    
    //一つのチャンクに湧く最大数
    @Override
    public int getMaxSpawnedInChunk()
    {
        return 5;
    }
    
    public static void Init() {
    	
    	EntityRegistry.registerGlobalEntityID(EntityTHFairyIce.class, "THFairyIce", Config.entityIdTHFairyIce, 0x3DFFEE, 0xA0A000);
    	EntityRegistry.registerModEntity(EntityTHFairyIce.class, "THFairyIce",  1, JourneyToGensokyo.instance, 80, 1, true);
		
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
