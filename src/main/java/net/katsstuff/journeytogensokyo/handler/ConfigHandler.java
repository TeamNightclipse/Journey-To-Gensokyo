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

	public static class Spawns {

		public Fairy fairy = new Fairy();
		public TenguCrow tenguCrow = new TenguCrow();
		public HellRaven hellRaven = new HellRaven();
		public Phantom phantom = new Phantom();

		public static class Fairy implements SpawnEntry {
			public int weightedProbability = 20;
			public int minAmount = 2;
			public int maxAmount = 6;
			public int lastProbability = 100;
			public int maxInChunk = 6;

			@Override
			public int weightedProbability() {
				return weightedProbability;
			}

			@Override
			public int minAmount() {
				return minAmount;
			}

			@Override
			public int maxAmount() {
				return maxAmount;
			}

			@Override
			public int lastProbability() {
				return lastProbability;
			}

			@Override
			public int maxInChunk() {
				return maxInChunk;
			}
		}

		public static class TenguCrow implements SpawnEntry {
			public int weightedProbability = 20;
			public int minAmount = 1;
			public int maxAmount = 3;
			public int lastProbability = 100;
			public int maxInChunk = 3;

			@Override
			public int weightedProbability() {
				return weightedProbability;
			}

			@Override
			public int minAmount() {
				return minAmount;
			}

			@Override
			public int maxAmount() {
				return maxAmount;
			}

			@Override
			public int lastProbability() {
				return lastProbability;
			}

			@Override
			public int maxInChunk() {
				return maxInChunk;
			}
		}

		public static class HellRaven implements SpawnEntry {
			public int weightedProbability = 20;
			public int minAmount = 1;
			public int maxAmount = 3;
			public int lastProbability = 100;
			public int maxInChunk = 3;

			@Override
			public int weightedProbability() {
				return weightedProbability;
			}

			@Override
			public int minAmount() {
				return minAmount;
			}

			@Override
			public int maxAmount() {
				return maxAmount;
			}

			@Override
			public int lastProbability() {
				return lastProbability;
			}

			@Override
			public int maxInChunk() {
				return maxInChunk;
			}
		}

		public static class Phantom implements SpawnEntry {
			public int weightedProbability = 30;
			public int minAmount = 2;
			public int maxAmount = 6;
			public int lastProbability = 100;
			public int maxInChunk = 6;

			@Override
			public int weightedProbability() {
				return weightedProbability;
			}

			@Override
			public int minAmount() {
				return minAmount;
			}

			@Override
			public int maxAmount() {
				return maxAmount;
			}

			@Override
			public int lastProbability() {
				return lastProbability;
			}

			@Override
			public int maxInChunk() {
				return maxInChunk;
			}
		}

		public interface SpawnEntry {

			int weightedProbability();
			int minAmount();
			int maxAmount();

			int lastProbability();
			int maxInChunk();
		}
	}
}
