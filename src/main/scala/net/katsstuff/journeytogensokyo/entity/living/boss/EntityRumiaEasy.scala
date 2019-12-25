package net.katsstuff.journeytogensokyo.entity.living.boss

import net.katsstuff.teamnightclipse.danmakucore.handler.{ConfigHandler => DanCoreConfigHandler}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.lib.LibEntityName
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.katsstuff.journeytogensokyo.spellcard.JTGSpellcards
import net.katsstuff.teamnightclipse.danmakucore.EnumDanmakuLevel
import net.katsstuff.teamnightclipse.danmakucore.entity.living.{TouhouCharacter, TouhouSpecies}
import net.katsstuff.teamnightclipse.danmakucore.entity.living.ai.{EntityAIMoveRanged, EntityAIWanderHover}
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.Phase
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibPhases
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.ai.{
  EntityAIFleeSun,
  EntityAIHurtByTarget,
  EntityAILookIdle,
  EntityAINearestAttackableTarget,
  EntityAISwimming,
  EntityAIWander,
  EntityAIWatchClosest
}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

class EntityRumiaEasy(_world: World) extends EntityJTGDanmakuBoss(_world) {

  setSize(0.5F, 1.2F)

  setMaxHP(40F)
  setHealth(getMaxHealth)

  setSpecies(TouhouSpecies.YOUKAI)
  setFlyingSpeed(0.3D)
  setGroundSpeed(0.2D)

  override def character: TouhouCharacter = TouhouCharacter.RUMIA

  override def initEntityAI(): Unit = {
    tasks.addTask(0, new EntityAISwimming(this))
    tasks.addTask(1, new EntityAIFleeSun(this, 1D))
    tasks.addTask(2, new EntityAIMoveRanged(this, 1D, 24F, 16F))
    tasks.addTask(4, new EntityAIWanderHover(this, 1D, 120))
    tasks.addTask(5, new EntityAIWander(this, 1D, 150))
    tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 24F))
    tasks.addTask(7, new EntityAILookIdle(this))
    targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
  }

  override def phaseList: Seq[Phase] = {
    DanCoreConfigHandler.danmaku.danmakuLevel match {
      case EnumDanmakuLevel.EASY | EnumDanmakuLevel.NORMAL =>
        Seq(
          JTGPhases.RUMIA_EASY_WARMUP_1.instantiate(phaseManager),
          JTGPhases.RUMIA_EASY_WARMUP_2.instantiate(phaseManager),
          LibPhases.SPELLCARD.instantiate(phaseManager, JTGSpellcards.NightBird),
          JTGPhases.RUMIA_EASY_WARMUP_3.instantiate(phaseManager),
          LibPhases.SPELLCARD.instantiate(phaseManager, JTGSpellcards.Demarcation)
        )
      case _ =>
        Seq(
          JTGPhases.RUMIA_EASY_WARMUP_1.instantiate(phaseManager),
          LibPhases.SPELLCARD.instantiate(phaseManager, JTGSpellcards.MoonlightRay),
          JTGPhases.RUMIA_EASY_WARMUP_2.instantiate(phaseManager),
          LibPhases.SPELLCARD.instantiate(phaseManager, JTGSpellcards.NightBird),
          JTGPhases.RUMIA_EASY_WARMUP_3.instantiate(phaseManager),
          LibPhases.SPELLCARD.instantiate(phaseManager, JTGSpellcards.Demarcation)
        )
    }
  }

  override def spawnEntry: ConfigHandler.Spawns.SpawnEntry = ConfigHandler.spawns.rumia_easy

  override def spawnBlockCheck(state: IBlockState): Boolean = {
    val spawnMaterial = Seq(Material.GRASS, Material.GROUND, Material.SAND)
    DanCoreConfigHandler.danmaku.danmakuLevel != EnumDanmakuLevel.PEACEFUL && spawnMaterial.contains(state.getMaterial)
  }

  override def lootTableName: String = LibEntityName.RumiaEasy
}
