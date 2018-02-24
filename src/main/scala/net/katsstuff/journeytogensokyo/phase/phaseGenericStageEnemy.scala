/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * Journey To Gensokyo license: https://github.com/Katrix-/JTG/blob/DanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import scala.util.Random

import net.katsstuff.danmakucore.DanmakuCore
import net.katsstuff.danmakucore.danmaku.{DanmakuTemplate, DanmakuVariant}
import net.katsstuff.danmakucore.data.{MovementData, ShotData}
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.handler.ConfigHandler
import net.katsstuff.danmakucore.impl.shape.{ShapeArrow, ShapeCircle, ShapeRandomRing, ShapeRing, ShapeSphere, ShapeWide}
import net.katsstuff.danmakucore.item.ItemDanmaku
import net.katsstuff.danmakucore.item.ItemDanmaku.{Circle, Line, RandomRing, Ring, Sphere, Wide}
import net.katsstuff.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.danmakucore.lib.data.LibDanmakuVariants
import net.katsstuff.danmakucore.registry.DanmakuRegistry
import net.katsstuff.mirror.data.{Quat, Vector3}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.{DamageSource, ResourceLocation}

class PhaseTypeGenericStageEnemy extends PhaseType {
  val Patterns = Seq(Line, RandomRing, Wide, Circle, Ring, Sphere)

  val PatternAmount: Int = Patterns.length
  private val rand = new Random()

  override def instantiate(phaseManager: PhaseManager): Phase =
    instantiate(phaseManager, DanmakuRegistry.getRandomObject(classOf[DanmakuVariant], rand.self))
  def instantiate(phaseManager: PhaseManager, variant: DanmakuVariant): Phase = {

    val shot   = variant.getShotData.setMainColor(LibColor.randomSaturatedColor())
    val shape  = Patterns(rand.nextInt(PatternAmount))
    val amount = rand.nextInt(ConfigHandler.danmaku.danmakuLevel.getMultiplier * 4) + 1
    val width  = Math.min(10F, rand.nextFloat * 90F)
    new PhaseGenericStageEnemy(phaseManager, variant, shot, variant.getMovementData, shape, amount, width, this)
  }
}

class PhaseGenericStageEnemy(
    manager: PhaseManager,
    var variant: DanmakuVariant,
    var shot: ShotData,
    var movement: MovementData,
    var pattern: ItemDanmaku.Pattern,
    var amount: Int,
    var width: Float,
    val phaseType: PhaseTypeGenericStageEnemy
) extends Phase(manager) {

  private val NbtVariant  = "variant"
  private val NbtMovement = "speed"
  private val NbtPattern  = "shape"
  private val NbtAmount   = "amount"
  private val NbtWidth    = "width"
  private val NbtShotData = "shotData"
  private val Accuracy    = 5F

  private val shapeObj = {
    val distance = 0.1D
    val danmaku  = DanmakuTemplate.builder.setUser(getEntity).setShot(shot).setMovementData(movement).build
    pattern match {
      case ItemDanmaku.Line       => new ShapeArrow(danmaku, amount, distance, width)
      case ItemDanmaku.Circle     => new ShapeCircle(danmaku, amount, 0F, distance)
      case ItemDanmaku.RandomRing => new ShapeRandomRing(danmaku, amount, width, distance)
      case ItemDanmaku.Ring       => new ShapeRing(danmaku, amount, width, 0F, distance)
      case ItemDanmaku.Wide       => new ShapeWide(danmaku, amount, width, 0F, distance)
      case ItemDanmaku.Sphere     => new ShapeSphere(danmaku, amount, amount / 2, 0F, distance)
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
      val entityPos = new Vector3(entity)
      val forward   = Vector3.directionToEntity(entityPos, target)
      val baseLook  = Quat.lookRotation(forward, Vector3.Up) //TODO: Add inaccuracy here?
      entity.playSound(LibSounds.SHOT1, 1F, 1F)

      DanmakuCore.spawnDanmaku(shapeObj.draw(entityPos, baseLook, 0).spawnedDanmaku.toSeq)
    }
  }

  override def serializeNBT: NBTTagCompound = {
    val tag = super.serializeNBT
    tag.setString(NbtVariant, variant.fullNameString)
    tag.setTag(NbtMovement, movement.serializeNBT)
    tag.setByte(NbtPattern, ItemDanmaku.Pattern.idOf(pattern))
    tag.setInteger(NbtAmount, amount)
    tag.setFloat(NbtWidth, width)
    tag.setTag(NbtShotData, shot.serializeNBT)
    tag
  }

  override def deserializeNBT(tag: NBTTagCompound) {
    super.deserializeNBT(tag)
    variant = Option(DanmakuRegistry.DanmakuVariant.getValue(new ResourceLocation(tag.getString(NbtVariant))))
      .getOrElse(LibDanmakuVariants.DEFAULT_TYPE)
    pattern = ItemDanmaku.Pattern.fromId(tag.getByte(NbtPattern)).getOrElse(ItemDanmaku.Line)
    amount = tag.getInteger(NbtAmount)
    width = tag.getFloat(NbtWidth)
    shot = new ShotData(tag.getCompoundTag(NbtShotData))
    movement = MovementData.fromNBT(tag.getCompoundTag(NbtMovement))
  }

  override def dropLoot(source: DamageSource): Unit = {
    val stack  = ItemDanmaku.createStack(variant)
    val entity = getEntity

    stack.setCount(entity.getRNG.nextInt(5) + 2)
    ItemDanmaku.Amount.set(amount, stack)
    ItemDanmaku.Speed.set(movement.speedOriginal, stack)
    ItemDanmaku.setGravity(movement.gravity, stack)
    ItemDanmaku.DanPattern.set(pattern, stack)
    ShotData.serializeNBTItemStack(stack, shot)

    entity.entityDropItem(stack, 0F)
  }
}
