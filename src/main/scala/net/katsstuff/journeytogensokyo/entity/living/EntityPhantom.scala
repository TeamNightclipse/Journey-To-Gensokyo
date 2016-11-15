/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.{EntityDanmakuMob, EnumSpecies, IAllyDanmaku}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.entity.EnumCreatureAttribute
import net.minecraft.entity.ai.{EntityAIFleeSun, EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAIRestrictSun, EntityAISwimming, EntityAIWander}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World

class EntityPhantom(world: World) extends EntityDanmakuMob(world) with IAllyDanmaku {

	setSize(0.5F, 0.5F)
	experienceValue = 3
	phaseManager.setCurrentPhase(JTGPhases.StageEnemy.instantiate(phaseManager))

	setFlyingHeight(3)
	setSpecies(EnumSpecies.PHANTOM)
	setMaxHP(2F)

	override def initEntityAI(): Unit = {
		this.tasks.addTask(0, new EntityAISwimming(this))
		this.tasks.addTask(2, new EntityAIRestrictSun(this))
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D))
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D, 50))
		this.tasks.addTask(5, new EntityAILookIdle(this))
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
	}

	override def getCreatureAttribute: EnumCreatureAttribute = EnumCreatureAttribute.UNDEAD

	override def getMaxSpawnedInChunk: Int = 3

	override def getCanSpawnHere: Boolean = {
		val spawnChance = ConfigHandler.entry.spawnRate
		if(rand.nextInt(100) < spawnChance) {
			val x = MathHelper.floor_double(posX)
			val y = MathHelper.floor_double(getEntityBoundingBox.minY)
			val z = MathHelper.floor_double(posZ)
			val blockpos: BlockPos = new BlockPos(x, y, z)
			val spawnBlocks = Seq(Blocks.GRASS, Blocks.DIRT, Blocks.SAND, Blocks.STONE)
			return spawnBlocks.contains(worldObj.getBlockState(blockpos.down).getBlock) && super.getCanSpawnHere
		}

		false
	}
}
