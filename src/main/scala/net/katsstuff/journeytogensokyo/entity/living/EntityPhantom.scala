/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.TouhouSpecies
import net.katsstuff.danmakucore.entity.living.ai.EntityAIMoveRanged
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.handler.ConfigHandler.Spawns
import net.katsstuff.journeytogensokyo.lib.LibEntityName
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.katsstuff.mirror.client.particles.{GlowTexture, ParticleUtil}
import net.katsstuff.mirror.data.Vector3
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.ai.{EntityAIFleeSun, EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{EnumCreatureAttribute, IEntityLivingData}
import net.minecraft.world.{DifficultyInstance, World}

object EntityPhantom {
  var counter = 0
  def nextCounter(): Byte = {
    if (counter == 4) counter = 0
    else counter += 1

    counter.toByte
  }

  def formToColor(form: Byte): Int =
    form match {
      case 0 => 0xA0A0A0
      case 1 => 0xFF1818
      case 2 => 0x18FF18
      case 3 => 0x180FFF
      case _ => 0xFFFFFF
    }
}
class EntityPhantom(_world: World) extends EntityForm(_world) with EntityIsAlly {

  setSize(0.5F, 0.5F)
  experienceValue = 3

  form = {
    if (world.isRemote) 0
    else EntityPhantom.nextCounter()
  }

  phaseManager.addPhase(JTGPhases.StageEnemy.instantiate(phaseManager))
  phaseManager.currentPhase.init()

  setFlyingSpeed(0.2D)
  setSpecies(TouhouSpecies.PHANTOM)

  setMaxHP(2F)

  override def initEntityAI(): Unit = {
    this.tasks.addTask(0, new EntityAISwimming(this))
    //TODO this.tasks.addTask(2, new EntityAIRestrictSun(this))
    this.tasks.addTask(3, new EntityAIFleeSun(this, 1D))
    this.tasks.addTask(4, new EntityAIMoveRanged(this, 1D, 16F))
    this.tasks.addTask(6, new EntityAIWander(this, 1D))
    this.tasks.addTask(7, new EntityAILookIdle(this))
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
  }

  override def onInitialSpawn(difficulty: DifficultyInstance, livingData: IEntityLivingData): IEntityLivingData = {
    val superData = super.onInitialSpawn(difficulty, livingData)

    val groupData = superData match {
      case fairy: PhantomGroupData => fairy
      case _                       => PhantomGroupData(form)
    }

    form = groupData.form

    if (world.isAirBlock(getPosition.up(2))) {
      setPositionAndUpdate(posX, posY + 2, posZ)
    } else if (world.isAirBlock(getPosition.up(1))) {
      setPositionAndUpdate(posX, posY + 1, posZ)
    }

    groupData
  }

  override def onUpdate(): Unit = {
    super.onUpdate()
    if (world.isRemote) {
      val color = EntityPhantom.formToColor(form)
      val r     = (color >> 16 & 255) / 255.0F
      val g     = (color >> 8 & 255) / 255.0F
      val b     = (color & 255) / 255.0F
      val size  = 0.4F

      for (i <- 0 until 2) {
        val coeff = i / 2D
        val pos = Vector3(
          prevPosX + (posX - prevPosX) * coeff,
          0.2F + prevPosY + (posY - prevPosY) * coeff,
          prevPosZ + (posZ - prevPosZ) * coeff
        )
        val motion =
          Vector3(0.0125f * (rand.nextFloat - 0.5f), 0.075f * rand.nextFloat, 0.0125f * (rand.nextFloat - 0.5f))
        ParticleUtil.spawnParticleGlow(world, pos, motion, r, g, b, size * 15F, 40, GlowTexture.MOTE)
      }
    }
  }

  override def lootTableName: String            = LibEntityName.Phantom
  override def spawnEntry:    Spawns.SpawnEntry = ConfigHandler.spawns.phantom
  override def spawnBlockCheck(state: IBlockState): Boolean = {
    val spawnMaterial = Seq(Material.GRASS, Material.GROUND, Material.ROCK)
    spawnMaterial.contains(state.getMaterial)
  }

  override def getCreatureAttribute: EnumCreatureAttribute = EnumCreatureAttribute.UNDEAD
}
case class PhantomGroupData(form: Byte) extends IEntityLivingData
