package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.EnumSpecies
import net.katsstuff.journeytogensokyo.entity.living.ai.EntityAIMoveRangedTengu
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.handler.ConfigHandler.Spawns.SpawnEntry
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.block.BlockGrass
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.world.World

class EntityTenguCrow(_world: World) extends EntityBigBird(_world) {

  phaseManager.addPhase(JTGPhases.Tengu.instantiate(phaseManager))
  phaseManager.getCurrentPhase.init()

  setSpeed(1D)
  setSpecies(EnumSpecies.YOUKAI_TENGU_CROW)

  override def spawnBlockCheck(state: IBlockState): Boolean =
    super.spawnBlockCheck(state) || (state.getBlock == Blocks.GRASS && state.getValue(BlockGrass.SNOWY))

  override protected def initEntityAI(): Unit = {
    this.tasks.addTask(0, new EntityAISwimming(this))
    this.tasks.addTask(2, new EntityAIMoveRangedTengu(this, getSpeed, 24F))
    this.tasks.addTask(6, new EntityAIWander(this, getSpeed))
    this.tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 24F))
    this.tasks.addTask(7, new EntityAILookIdle(this))
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget[EntityPlayer](this, classOf[EntityPlayer], true))
  }
  override def spawnEntry: SpawnEntry = ConfigHandler.spawns.tenguCrow
}
