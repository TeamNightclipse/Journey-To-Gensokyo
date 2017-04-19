/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import scala.annotation.switch
import scala.util.Random

import net.katsstuff.danmakucore.data.{MovementData, ShotData, Vector3}
import net.katsstuff.danmakucore.entity.danmaku.{DanmakuTemplate, DanmakuVariant}
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.handler.ConfigHandler
import net.katsstuff.danmakucore.helper.DanmakuHelper
import net.katsstuff.danmakucore.impl.shape.{ShapeArrow, ShapeCircle, ShapeRandomRing, ShapeRing, ShapeStar, ShapeWideShot}
import net.katsstuff.danmakucore.item.ItemDanmaku
import net.katsstuff.danmakucore.lib.data.LibItems
import net.katsstuff.danmakucore.registry.DanmakuRegistry
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.{DamageSource, ResourceLocation}

class PhaseTypeGenericStageEnemy extends PhaseType {

  final val ShapeAmount = 6
  private val rand      = new Random()

  override def instantiate(phaseManager: PhaseManager): Phase = instantiate(phaseManager, DanmakuRegistry.DANMAKU_VARIANT.getRandomObject(rand.self))
  def instantiate(phaseManager:          PhaseManager, variant: DanmakuVariant): Phase = {

    val shot   = variant.getShotData.copy(color = DanmakuHelper.randomSaturatedColor())
    val shape  = rand.nextInt(ShapeAmount)
    val amount = rand.nextInt(ConfigHandler.danmaku.danmakuLevel.getMultiplier * 4) + 1
    val width  = Math.min(10F, rand.nextFloat * 90F)
    new PhaseGenericStageEnemy(phaseManager, variant, shot, variant.getMovementData, shape, amount, width, this)
  }
}

class PhaseGenericStageEnemy(manager:      PhaseManager,
                      var variant: DanmakuVariant,
                      var shot:     ShotData,
                      var movement: MovementData,
                      var shape:    Int,
                      var amount:   Int,
                      var width:    Float,
                      val getType:  PhaseTypeGenericStageEnemy)
    extends Phase(manager) {

  private val NbtVariant  = "variant"
  private val NbtMovement = "speed"
  private val NbtShape    = "shape"
  private val NbtAmount   = "amount"
  private val NbtWidth    = "width"
  private val NbtShotData = "shotData"
  private val Accuracy    = 5F

  private val shapeObj = {
    val distance = 0.1D
    val danmaku  = DanmakuTemplate.builder.setUser(getEntity).setShot(shot).setMovementData(movement).build()
    (shape: @switch) match {
      case 0 => new ShapeArrow(danmaku, amount, distance, width)
      case 1 => new ShapeCircle(danmaku, amount, 0F, distance)
      case 2 => new ShapeRandomRing(danmaku, amount, width, distance)
      case 3 => new ShapeRing(danmaku, amount, width, 0F, distance)
      case 4 => new ShapeStar(danmaku, amount, width, 0F, distance)
      case 5 => new ShapeWideShot(danmaku, amount, width, 0F, distance)
    }
  }

  override def init() {
    super.init()
    interval = 30
  }

  override def serverUpdate() {
    super.serverUpdate()

    val entity = getEntity
    val target = entity.getAttackTarget

    if (isCounterStart && !isFrozen && target != null && entity.getEntitySenses.canSee(target)) {
      val angle = Vector3.angleLimitRandom(Vector3.angleToLiving(entity, target), Accuracy)
      DanmakuHelper.playShotSound(entity)

      shapeObj.drawForTick(new Vector3(entity), angle, 0)
    }
  }

  def getInterval: Int = interval

  def setInterval(interval: Int): Unit = this.interval = interval

  override def serializeNBT: NBTTagCompound = {
    val tag = super.serializeNBT
    tag.setString(NbtVariant, variant.getFullName.toString)
    tag.setTag(NbtMovement, movement.serializeNBT)
    tag.setInteger(NbtShape, shape)
    tag.setInteger(NbtAmount, amount)
    tag.setFloat(NbtWidth, width)
    tag.setTag(NbtShotData, shot.serializeNBT)
    tag
  }

  override def deserializeNBT(tag: NBTTagCompound) {
    super.deserializeNBT(tag)
    val variantKey = tag.getString(NbtVariant)
    variant = if(variantKey.nonEmpty) {
      DanmakuRegistry.DANMAKU_VARIANT.getValue(new ResourceLocation(variantKey))
    } else DanmakuRegistry.DANMAKU_VARIANT.getDefaultValue

    shape = tag.getInteger(NbtShape)
    amount = tag.getInteger(NbtAmount)
    width = tag.getFloat(NbtWidth)
    shot = new ShotData(tag.getCompoundTag(NbtShotData))
    movement = MovementData.fromNBT(tag.getCompoundTag(NbtMovement))
  }

  override def dropLoot(source: DamageSource): Unit = {
    val stack = new ItemStack(LibItems.DANMAKU)
    val entity = getEntity

    stack.stackSize = entity.getRNG.nextInt(5) + 1
    stack.setItemDamage(DanmakuRegistry.DANMAKU_VARIANT.getId(variant))
    ItemDanmaku.setAmount(stack, amount)
    ItemDanmaku.setSpeed(stack, movement.speedOriginal)
    ItemDanmaku.setGravity(stack, movement.gravity)
    ItemDanmaku.setPattern(stack, shape)
    ShotData.serializeNBTItemStack(stack, shot)

    entity.entityDropItem(stack, 0F)
  }
}
