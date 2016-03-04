/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import katrix.journeyToGensokyo.block.JTGBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OreGen implements IWorldGenerator {

	private WorldGenerator genGensoOre;
	private WorldGenerator genMakaiOre;
	private WorldGenerator genCelestialOre;

	public OreGen() {
		genGensoOre = new WorldGenMinable(JTGBlock.gensokyoOreBlock, 0, 4, Blocks.stone);
		genMakaiOre = new WorldGenMinable(JTGBlock.gensokyoOreBlock, 1, 4, Blocks.netherrack);
		genCelestialOre = new WorldGenMinable(JTGBlock.gensokyoOreBlock, 2, 4, Blocks.end_stone);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
			case 0: //Overworld
				runGenerator(genGensoOre, world, random, chunkX, chunkZ, 3, 0, 32);
				break;
			case -1: //Nether
				runGenerator(genMakaiOre, world, random, chunkX, chunkZ, 8, 0, 128);
				break;
			case 1: //End
				runGenerator(genCelestialOre, world, random, chunkX, chunkZ, 8, 0, 128);
				break;
			default:
				break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, x, y, z);
		}
	}
}