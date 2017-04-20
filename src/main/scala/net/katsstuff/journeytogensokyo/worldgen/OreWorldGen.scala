package net.katsstuff.journeytogensokyo.worldgen

import java.util.Random

import net.katsstuff.journeytogensokyo.block.JTGBlocks
import net.minecraft.block.state.pattern.BlockMatcher
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.chunk.{IChunkGenerator, IChunkProvider}
import net.minecraft.world.gen.feature.WorldGenMinable
import net.minecraftforge.fml.common.IWorldGenerator

object OreWorldGen {

  object GensokyoGenMinable  extends WorldGenMinable(JTGBlocks.GensokyoOre.getDefaultState, 8)
  object MakaiGenMinable     extends WorldGenMinable(JTGBlocks.MakaiOre.getDefaultState, 8, BlockMatcher.forBlock(Blocks.NETHERRACK))
  object CelestialGenMinable extends WorldGenMinable(JTGBlocks.CelestialOre.getDefaultState, 8, BlockMatcher.forBlock(Blocks.END_STONE))

  object GensokyoOreGen  extends GenMineableWrapper(4, 32, 0, GensokyoGenMinable)
  object MakaiOreGen     extends GenMineableWrapper(4, 128, 0, MakaiGenMinable)
  object CelestialOreGen extends GenMineableWrapper(4, 128, 0, CelestialGenMinable)

  class GenMineableWrapper(blockCount: Int, maxHeight: Int, minHeight: Int, minable: WorldGenMinable) extends IWorldGenerator {
    override def generate(
        random:         Random,
        chunkX:         Int,
        chunkZ:         Int,
        world:          World,
        chunkGenerator: IChunkGenerator,
        chunkProvider:  IChunkProvider
    ): Unit = {
      val chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16)
      for (i <- 0 until blockCount) {
        val blockpos = chunkPos.add(random.nextInt(16), random.nextInt(maxHeight - minHeight) + minHeight, random.nextInt(16))
        minable.generate(world, random, blockpos)
      }
    }
  }

}
