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
import net.katsstuff.danmakucore.entity.living.{EntityDanmakuMob, EnumSpecies, IAllyDanmaku}
import net.katsstuff.journeytogensokyo.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.phase.JTGPhases
import net.minecraft.block.material.Material
import net.minecraft.entity.EnumCreatureAttribute
import net.minecraft.entity.ai.{EntityAIHurtByTarget, EntityAILookIdle, EntityAINearestAttackableTarget, EntityAISwimming, EntityAIWander}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.util.math.{BlockPos, MathHelper}
import net.minecraft.world.World

class EntityYinYang(world: World) extends EntityDanmakuMob(world) with IAllyDanmaku {

  setSize(0.5F, 0.5F)
  experienceValue = 3
  phaseManager.addPhase(JTGPhases.StageEnemy.instantiate(phaseManager))
  phaseManager.getCurrentPhase.init()

  setFlyingHeight(2)
  setSpecies(EnumSpecies.OTHERS)
  setMaxHP(2F)

  override def initEntityAI(): Unit = {
    this.tasks.addTask(0, new EntityAISwimming(this))
    this.tasks.addTask(3, new EntityAIMoveRanged(this, getSpeed, 8F))
    this.tasks.addTask(4, new EntityAIWander(this, getSpeed))
    this.tasks.addTask(5, new EntityAILookIdle(this))
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false))
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, classOf[EntityPlayer], true))
  }

  override def getCreatureAttribute: EnumCreatureAttribute = EnumCreatureAttribute.UNDEAD

  override def getMaxSpawnedInChunk: Int = 3

  override def getCanSpawnHere: Boolean = {
    val spawnChance = ConfigHandler.entry.spawnRateCommon
    if (rand.nextInt(100) < spawnChance) {
      val x             = MathHelper.floor_double(posX)
      val y             = MathHelper.floor_double(getEntityBoundingBox.minY)
      val z             = MathHelper.floor_double(posZ)
      val blockpos      = new BlockPos(x, y, z)
      val spawnMaterial = Seq(Material.GRASS, Material.GROUND, Material.SAND, Material.ROCK)
      spawnMaterial.contains(worldObj.getBlockState(blockpos.down).getMaterial) && super.getCanSpawnHere
    } else false
  }
}
