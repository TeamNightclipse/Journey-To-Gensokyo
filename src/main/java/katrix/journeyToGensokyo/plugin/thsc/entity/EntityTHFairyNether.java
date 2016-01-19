/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */

package katrix.journeyToGensokyo.plugin.thsc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cpw.mods.fml.common.registry.EntityRegistry;
import katrix.journeyToGensokyo.JourneyToGensokyo;
import katrix.journeyToGensokyo.handler.ConfigHandler;
import katrix.journeyToGensokyo.reference.EntityName;
import katrix.journeyToGensokyo.reference.MobID;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import thKaguyaMod.DanmakuConstants;
import thKaguyaMod.THShotLib;
import thKaguyaMod.entity.living.EntityTHFairy;
import thKaguyaMod.init.THKaguyaConfig;

public class EntityTHFairyNether extends EntityTHFairy {

	public EntityTHFairyNether(World world) {
		super(world);

		if (rand.nextInt(2) == 1) {
			setForm((byte)0);
		}
		else {
			setHealth(2.0F);
			setDetectionDistance(8.0D);
			setAttackDistance(2.0D);
			setFlyingHeight(2);
			setSpeed(0.03D);
			setDanmakuPattern(0);
			danmakuSpan = 50 - THKaguyaConfig.danmakuLevel * 10;
			speedRate = 0.2F;
			shotForm = (byte)(THShotLib.LIGHT[0] / 8);
			shotColor = (byte)DanmakuConstants.RED;
			setForm((byte)-1);
		}
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 3;
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		if (!damageSource.isMagicDamage()) {
			amount *= 0.5F;
		}
		return super.attackEntityFrom(damageSource, amount);
	}

	@Override
	public boolean getCanSpawnHere() {
		if (rand.nextInt(100) < THKaguyaConfig.fairySpawnRate)
			return false;

		return worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
	}

	public static void postInit() {

		EntityRegistry.registerModEntity(EntityTHFairyNether.class, EntityName.FAIRY_NETHER, MobID.FAIRY_NETHER, JourneyToGensokyo.instance, 80, 1, true);

		List<BiomeGenBase> spawnbiomes = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeDictionary.getBiomesForType(Type.NETHER)));

		if (THKaguyaConfig.spawnDanmakuMob && ConfigHandler.newFariesSpawn) {
			EntityRegistry.addSpawn(EntityTHFairyNether.class, 20, 1, 3, EnumCreatureType.monster, spawnbiomes.toArray(new BiomeGenBase[0]));
		}
	}
}
