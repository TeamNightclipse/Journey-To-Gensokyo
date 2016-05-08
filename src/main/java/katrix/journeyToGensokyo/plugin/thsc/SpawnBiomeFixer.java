/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.util.LogHelper;
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

	public static void fairyFix() {
		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.PLAINS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.HILLS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SANDY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SNOWY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.COLD));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SWAMP));

		for(BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			spawnBiomes.remove(biome);
		}

		BiomeGenBase[] arrayBiomes = spawnBiomes.toArray(new BiomeGenBase[0]);

		LogHelper.info("JTG fixing spawn biomes for THFairy");
		EntityRegistry.addSpawn(EntityTHFairy.class, 30, 1, 6, EnumCreatureType.monster, arrayBiomes);

		LogHelper.info("JTG fixing spawn biomes for SunflowerFairy");
		EntityRegistry.addSpawn(EntitySunFlowerFairy.class, 30, 1, 6, EnumCreatureType.monster, arrayBiomes);
	}

	public static void phantomFix() {
		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.PLAINS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.FOREST));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.HILLS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SANDY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SNOWY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.COLD));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SWAMP));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.BEACH));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.WATER));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.JUNGLE));

		for(BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			spawnBiomes.remove(biome);
		}

		LogHelper.info("JTG fixing spawn biomes for THPhantom");
		EntityRegistry.addSpawn(EntityTHPhantom.class, 20, 1, 3, EnumCreatureType.monster, spawnBiomes.toArray(new BiomeGenBase[0]));
	}

	public static void hanabeeperFix() {
		LogHelper.info("JTG fixing spawn biomes for Hanabeeper");
		EntityRegistry.addSpawn(EntityDanmakuCreeper.class, 2, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SANDY));
	}

	public static void cirnoFix() {
		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.COLD));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SNOWY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));

		for(BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			spawnBiomes.remove(biome);
		}

		LogHelper.info("JTG fixing spawn biomes for Cirno");
		EntityRegistry.addSpawn(EntityCirno.class, 2, 1, 1, EnumCreatureType.monster, spawnBiomes.toArray(new BiomeGenBase[0]));
	}

	public static void rumiaFix() {
		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.FOREST));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.PLAINS));

		LogHelper.info("JTG fixing spawn biomes for Rumia");
		EntityRegistry.addSpawn(EntityRumia.class, 4, 1, 1, EnumCreatureType.monster, spawnBiomes.toArray(new BiomeGenBase[0]));
	}

	public static void tozikoFix() {
		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.FOREST));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.PLAINS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SWAMP));

		LogHelper.info("JTG fixing spawn biomes for Toziko");
		EntityRegistry.addSpawn(EntityToziko.class, 10, 1, 1, EnumCreatureType.monster, spawnBiomes.toArray(new BiomeGenBase[0]));
	}

	public static void wriggleFix() {
		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.FOREST));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.RIVER));

		LogHelper.info("JTG fixing spawn biomes for Wriggle");
		EntityRegistry.addSpawn(EntityWriggle.class, 20, 1, 3, EnumCreatureType.monster, spawnBiomes.toArray(new BiomeGenBase[0]));
	}

	public static void ambientFix() {

		Set<BiomeGenBase> spawnBiomes = new HashSet<>();
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.PLAINS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.FOREST));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.HILLS));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SANDY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SNOWY));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.COLD));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.SWAMP));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.BEACH));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.WATER));
		Collections.addAll(spawnBiomes, BiomeDictionary.getBiomesForType(Type.JUNGLE));

		for(BiomeGenBase biome : BiomeDictionary.getBiomesForType(Type.END)) {
			spawnBiomes.remove(biome);
		}

		BiomeGenBase[] arrayBiomes = spawnBiomes.toArray(new BiomeGenBase[0]);

		LogHelper.info("JTG fixing spawn biomes for Ambient mobs(Sanae, Sakuya, Rinnosuke)");
		EntityRegistry.addSpawn(EntitySanae.class, 1, 0, 1, EnumCreatureType.ambient, arrayBiomes);
		EntityRegistry.addSpawn(EntitySakuya.class, 1, 0, 1, EnumCreatureType.ambient, arrayBiomes);
		EntityRegistry.addSpawn(EntityRinnosuke.class, 1, 0, 1, EnumCreatureType.ambient, arrayBiomes);
	}
}