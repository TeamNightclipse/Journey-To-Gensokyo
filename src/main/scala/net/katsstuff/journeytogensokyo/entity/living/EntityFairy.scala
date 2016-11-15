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
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World

class EntityFairy(world: World) extends EntityDanmakuMob(world) with Callable with EntityForm with IAllyDanmaku {

	setSize(0.6F, 1.5F)
	experienceValue = 5

	form = rand.nextInt(4).toByte
	phaseManager.setCurrentPhase(JTGPhases.StageEnemy.instantiate(phaseManager))

	setSpeed(0.3D)
	setSpecies(EnumSpecies.FAIRY)

	setFlyingHeight(2)
	setEntityCallDistance(30)
	setMaxHP(2F)

	override def initEntityAI(): Unit = {
		this.tasks.addTask(0, new EntityAISwimming(this))
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D, 20))
		this.tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 8.0F))
		this.tasks.addTask(7, new EntityAILookIdle(this))
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
	}

	override def onEntityCall(caller: EntityLivingBase, target: EntityLivingBase): Unit = {
		def distanceTo(entity: EntityLivingBase): Double = entity.getPositionVector.distanceTo(getPositionVector)
		if(getAttackTarget == null || distanceTo(getAttackTarget) > distanceTo(target)) {
			setAttackTarget(target)
		}
	}

	override def getMaxSpawnedInChunk: Int = 3

	override def getCanSpawnHere: Boolean = {
		val spawnChance = ConfigHandler.entry.spawnRate
		if(rand.nextInt(100) < spawnChance) {
			val x = MathHelper.floor_double(posX)
			val y = MathHelper.floor_double(getEntityBoundingBox.minY)
			val z = MathHelper.floor_double(posZ)
			val blockpos = new BlockPos(x, y, z)
			val spawnBlocks = Seq(Blocks.GRASS, Blocks.DIRT, Blocks.SAND)
			return spawnBlocks.contains(worldObj.getBlockState(blockpos.down).getBlock) && worldObj.getLight(blockpos) > 8 && super.getCanSpawnHere
		}

		false
	}
}