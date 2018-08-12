/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouSpecies
import net.katsstuff.teamnightclipse.danmakucore.entity.living.ai.{EntityAIMoveRanged, EntityAIWanderHover}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.handler.ConfigHandler.Spawns.SpawnEntry
import net.katsstuff.journeytogensokyo.lib.LibEntityName
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

class EntityHellRaven(_world: World) extends EntityBigBird(_world) {

  phaseManager.addPhase(JTGPhases.HellRaven.instantiate(phaseManager))
  phaseManager.currentPhase.init()

  setFlyingSpeed(0.4D)
  setGroundSpeed(0.2D)
  setSpecies(TouhouSpecies.ANIMAL_RAVEN_HELL)

  isImmuneToFire = true
  override protected def initEntityAI(): Unit = {
    this.tasks.addTask(0, new EntityAISwimming(this))
    this.tasks.addTask(2, new EntityAIMoveRanged(this, 1D, 24F, 16F))
    this.tasks.addTask(4, new EntityAIWanderHover(this, 1D, 120))
    this.tasks.addTask(6, new EntityAIWander(this, 1D, 200))
    this.tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 24F))
    this.tasks.addTask(7, new EntityAILookIdle(this))
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget[EntityPlayer](this, classOf[EntityPlayer], true))
  }
  override def lootTableName: String     = LibEntityName.HellRaven
  override def spawnEntry:    SpawnEntry = ConfigHandler.spawns.hellRaven
}
