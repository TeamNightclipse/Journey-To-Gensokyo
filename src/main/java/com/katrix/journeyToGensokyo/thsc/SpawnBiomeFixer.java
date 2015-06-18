package com.katrix.journeyToGensokyo.thsc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.katrix.journeyToGensokyo.util.LogHelper;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.entity.living.EntityCirno;
import thKaguyaMod.entity.living.EntityDanmakuCreeper;
import thKaguyaMod.entity.living.EntityRinnosuke;
import thKaguyaMod.entity.living.EntityRumia;
import thKaguyaMod.entity.living.EntitySakuya;
import thKaguyaMod.entity.living.EntitySanae;
import thKaguyaMod.entity.living.EntitySunFlowerFairy;
import thKaguyaMod.entity.living.EntityTHFairy;
import thKaguyaMod.entity.living.EntityTHPhantom;
import thKaguyaMod.entity.living.EntityToziko;
import thKaguyaMod.entity.living.EntityWriggle;

public class SpawnBiomeFixer {
	
	public static void FairyFix() {

		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.PLAINS)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.FOREST)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.MOUNTAIN)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.HILLS)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SANDY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SNOWY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.COLD)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SWAMP)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			if (spawnbiomes.contains(biome)) {
				spawnbiomes.remove(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for THFairy");
		EntityRegistry.addSpawn(EntityTHFairy.class,  30, 1, 6,EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
		
		LogHelper.info("JTG fixing spawn biomes for SunflowerFairy");
		EntityRegistry.addSpawn(EntitySunFlowerFairy.class,  30, 1, 6,EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void PhantomFix() {

		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.PLAINS)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.FOREST)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.MOUNTAIN)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.HILLS)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SANDY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SNOWY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.COLD)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SWAMP)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.BEACH)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.WATER)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.JUNGLE)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			if (spawnbiomes.contains(biome)) {
				spawnbiomes.remove(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for THPhantom");
		EntityRegistry.addSpawn(EntityTHPhantom.class,  20, 1, 3,EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void HanabeeperFix() {
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.SANDY)));
		
		LogHelper.info("JTG fixing spawn biomes for Hanabeeper");
		EntityRegistry.addSpawn(EntityDanmakuCreeper.class, 2, 1, 4, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void CirnoFix() {
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.COLD)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SNOWY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.MOUNTAIN)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			if (spawnbiomes.contains(biome)) {
				spawnbiomes.remove(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for Cirno");
		EntityRegistry.addSpawn(EntityCirno.class, 2, 1, 1, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void RumiaFix() {
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.FOREST)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.PLAINS)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for Rumia");
		EntityRegistry.addSpawn(EntityRumia.class, 4, 1, 1, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void TozikoFix() {
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.FOREST)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.PLAINS)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SWAMP)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for Toziko");
		EntityRegistry.addSpawn(EntityToziko.class, 10, 1, 1, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void WriggleFix() {
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.FOREST)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.JUNGLE)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.RIVER)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for Wriggle");
		EntityRegistry.addSpawn(EntityWriggle.class, 20, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
	
	public static void AmbientFix() {
		
		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.PLAINS)));
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.FOREST)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.MOUNTAIN)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.HILLS)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SANDY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SNOWY)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.COLD)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.SWAMP)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.BEACH)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.WATER)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.JUNGLE)) {
			if (!spawnbiomes.contains(biome)) {
				spawnbiomes.add(biome);
			}
		}
		for (BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			if (spawnbiomes.contains(biome)) {
				spawnbiomes.remove(biome);
			}
		}
		
		LogHelper.info("JTG fixing spawn biomes for Ambient mobs(Sanae, Sakuya, Rinnosuke)");
		EntityRegistry.addSpawn(EntitySanae.class, 1, 0, 1, EnumCreatureType.ambient, spawnbiomes.toArray(new BiomeGenBase[0]));
		EntityRegistry.addSpawn(EntitySakuya.class, 1, 0, 1, EnumCreatureType.ambient, spawnbiomes.toArray(new BiomeGenBase[0]));
		EntityRegistry.addSpawn(EntityRinnosuke.class, 1, 0, 1, EnumCreatureType.ambient, spawnbiomes.toArray(new BiomeGenBase[0]));
	}
}
