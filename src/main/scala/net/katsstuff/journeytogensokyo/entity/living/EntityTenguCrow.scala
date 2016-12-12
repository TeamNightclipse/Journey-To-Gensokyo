package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.ai.EntityAIMoveRanged
import net.katsstuff.danmakucore.entity.living.{EntityDanmakuMob, EnumSpecies}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.minecraft.block.material.Material
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World

class EntityTenguCrow(world: World) extends EntityDanmakuMob(world) {

	setSize(1.3F, 1.2F)
	experienceValue = 8

	phaseManager.addPhase(???)
	phaseManager.getCurrentPhase.init()

	setSpeed(0.6D)
	setFlyingHeight(3)
	setSpecies(EnumSpecies.YOUKAI_TENGU_CROW)

	setMaxHP(12F)
	override protected def initEntityAI(): Unit = {
		this.tasks.addTask(0, new EntityAISwimming(this))
		this.tasks.addTask(2, new EntityAIMoveRanged(this, getSpeed, 16F))
		this.tasks.addTask(6, new EntityAIWander(this, getSpeed))
		this.tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 16F))
		this.tasks.addTask(7, new EntityAILookIdle(this))
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget[EntityPlayer](this, classOf[EntityPlayer], true))
	}

	override def getMaxSpawnedInChunk: Int = 2

	override def getCanSpawnHere: Boolean = {
		val spawnChance = ConfigHandler.entry.spawnRateHard
		if(rand.nextInt(100) < spawnChance) {
			val x = MathHelper.floor_double(posX)
			val y = MathHelper.floor_double(getEntityBoundingBox.minY)
			val z = MathHelper.floor_double(posZ)
			val blockpos = new BlockPos(x, y, z)
			val spawnMaterial = Seq(Material.ROCK)
			spawnMaterial.contains(worldObj.getBlockState(blockpos.down).getMaterial) && worldObj.getLight(blockpos) > 8 && super.getCanSpawnHere
		} else false
	}

}
