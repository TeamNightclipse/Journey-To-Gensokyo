package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.EnumSpecies
import net.katsstuff.danmakucore.entity.living.ai.EntityAIMoveRanged
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

class EntityHellRaven(world: World) extends EntityBigBird(world) {

  phaseManager.addPhase(JTGPhases.HellRaven.instantiate(phaseManager))
  phaseManager.getCurrentPhase.init()

  setSpeed(0.4D)
  setSpecies(EnumSpecies.ANIMAL_RAVEN_HELL)

  isImmuneToFire = true
  setMaxHP(6F)
  override protected def initEntityAI(): Unit = {
    this.tasks.addTask(0, new EntityAISwimming(this))
    this.tasks.addTask(2, new EntityAIMoveRanged(this, getSpeed, 24F))
    this.tasks.addTask(6, new EntityAIWander(this, getSpeed))
    this.tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 24F))
    this.tasks.addTask(7, new EntityAILookIdle(this))
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget[EntityPlayer](this, classOf[EntityPlayer], true))
  }
}
