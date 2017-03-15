/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.danmakucore.entity.living.ai.EntityAIMoveRanged
import net.katsstuff.danmakucore.entity.living.{EnumSpecies, IAllyDanmaku}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.handler.ConfigHandler.Spawns.SpawnEntry
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.{EntityLivingBase, IEntityLivingData}
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.{DifficultyInstance, EnumSkyBlock, World}

object EntityFairy {
  var counter = 0
  def nextCounter(): Byte = {
    if(counter == 3) counter = 0
    else counter += 1

    counter.toByte
  }
}
class EntityFairy(_world: World) extends EntityForm(_world) with Callable with IAllyDanmaku {

  setSize(0.5F, 1F)
  experienceValue = 5

  form = {
    if(world.isRemote) 0
    else EntityFairy.nextCounter()
  }

  phaseManager.addPhase(JTGPhases.StageEnemy.instantiate(phaseManager))
  phaseManager.getCurrentPhase.init()

  setSpeed(0.3D)
  setSpecies(EnumSpecies.FAIRY)

  setFlyingHeight(2)
  setEntityCallDistance(30)
  setMaxHP(2F)

  override def initEntityAI(): Unit = {
    tasks.addTask(0, new EntityAISwimming(this))
    tasks.addTask(2, new EntityAIMoveRanged(this, getSpeed, 16F))
    tasks.addTask(6, new EntityAIWander(this, getSpeed))
    tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 16F))
    tasks.addTask(7, new EntityAILookIdle(this))
    targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
  }

  override def onEntityCall(caller: EntityLivingBase, target: EntityLivingBase): Unit = {
    def distanceTo(entity: EntityLivingBase): Double = entity.getPositionVector.distanceTo(getPositionVector)
    if (getAttackTarget == null || distanceTo(getAttackTarget) > distanceTo(target)) {
      setAttackTarget(target)
    }
  }

  override def onInitialSpawn(difficulty: DifficultyInstance, livingData: IEntityLivingData): IEntityLivingData = {
    val superData = super.onInitialSpawn(difficulty, livingData)

    val groupData = superData match {
      case fairy: FairyGroupData => fairy
      case _ => FairyGroupData(form)
    }

    form = groupData.form

    groupData
  }

  override def isValidLightLevel: Boolean = {
    val blockpos = new BlockPos(this.posX, this.getEntityBoundingBox.minY, this.posZ)
    world.getLightFor(EnumSkyBlock.SKY, blockpos) > 8
  }

  override def getBlockPathWeight(pos: BlockPos): Float = world.getLightBrightness(pos) - 0.5F

  override def spawnEntry: SpawnEntry = ConfigHandler.spawns.fairy
  override def spawnBlockCheck(state: IBlockState): Boolean = {
    val spawnMaterial = Seq(Material.GRASS, Material.GROUND, Material.SAND)
    spawnMaterial.contains(state.getMaterial)
  }
}
case class FairyGroupData(form: Byte) extends IEntityLivingData