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
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.entity.EnumCreatureAttribute
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

abstract class EntityYinYang(_world: World) extends EntityJTGDanmakuMob(_world) with EntityIsAlly {

  setSize(0.5F, 0.5F)
  experienceValue = 3
  phaseManager.addPhase(JTGPhases.StageEnemy.instantiate(phaseManager))
  phaseManager.currentPhase.init()

  setSpecies(TouhouSpecies.OTHERS)
  setMaxHP(2F)

  override def initEntityAI(): Unit = {
    this.tasks.addTask(0, new EntityAISwimming(this))
    this.tasks.addTask(3, new EntityAIMoveRanged(this, 1D, 8F, 6F))
    this.tasks.addTask(4, new EntityAIWanderHover(this, 1D, 120))
    this.tasks.addTask(5, new EntityAIWander(this, 1D, 150))
    this.tasks.addTask(6, new EntityAILookIdle(this))
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
  }

  override def getCreatureAttribute: EnumCreatureAttribute = EnumCreatureAttribute.UNDEAD
}
