/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.handler;

import net.katsstuff.journeytogensokyo.lib.LibModJ;
import net.minecraftforge.common.config.Config;

@SuppressWarnings("WeakerAccess")
@Config(modid = LibModJ.ID)
public class ConfigHandler {

	public static Spawns spawns = new Spawns();

	public static Behavior behavior = new Behavior();

	public static class Spawns {

		public SpawnEntry fairy = new SpawnEntry(15, 1, 3, 100, 3);
		public SpawnEntry tenguCrow = new SpawnEntry(5, 1, 2, 100, 2);
		public SpawnEntry hellRaven = new SpawnEntry(10, 1, 2, 100, 2);
		public SpawnEntry phantom = new SpawnEntry(10, 1, 2, 100, 2);
		public SpawnEntry reimu = new SpawnEntry(1, 1, 1, 100, 1);

		public static class SpawnEntry {

			public int weightedProbability;
			public int minAmount;
			public int maxAmount;
			public int lastProbability;
			public int maxInChunk;

			public SpawnEntry(int weightedProbability, int minAmount, int maxAmount, int lastProbability, int maxInChunk) {
				this.weightedProbability = weightedProbability;
				this.minAmount = minAmount;
				this.maxAmount = maxAmount;
				this.lastProbability = lastProbability;
				this.maxInChunk = maxInChunk;
			}
		}
	}

	public static class Behavior {

		public boolean neutralFairies = true;
	}
}
