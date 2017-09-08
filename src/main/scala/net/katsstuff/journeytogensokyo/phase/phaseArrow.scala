/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import net.katsstuff.danmakucore.data.{MovementData, Quat, RotationData, ShotData, Vector3}
import net.katsstuff.danmakucore.entity.danmaku.DanmakuTemplate
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.impl.shape.ShapeArrow
import net.minecraft.nbt.NBTTagCompound

class PhaseTypeShapeArrow extends PhaseType {

  override def instantiate(phaseManager: PhaseManager): Phase =
    new PhaseArrow(phaseManager, ShotData.DefaultShotData, MovementData.constant(0.4D), RotationData.none, 5, 1D, 1D, this)

  def instantiate(
      phaseManager: PhaseManager,
      shotData:     ShotData,
      movementData: MovementData,
      rotationData: RotationData,
      amount:       Int,
      distance:     Double,
      width:        Double
  ): Phase = new PhaseArrow(phaseManager, shotData, movementData, rotationData, amount, distance, width, this)
}

class PhaseArrow(
    manager:          PhaseManager,
    var shotData:     ShotData,
    var movementData: MovementData,
    var rotationData: RotationData,
    var amount:       Int,
    var distance:     Double,
    var width:        Double,
    val getType:      PhaseTypeShapeArrow
) extends Phase(manager) {

  private val NbtShotData     = "shotData"
  private val NbtMovementData = "movementData"
  private val NbtRotationData = "rotationData"
  private val NbtAmount       = "amount"
  private val NbtDistance     = "distance"
  private val NbtWidth        = "baseAngle"

  private var shape = createShape

  override def init(): Unit = {
    super.init()
    interval = 5
  }

  override def serverUpdate() {
    super.serverUpdate()
    val entity = getEntity
    val target = entity.getAttackTarget
    if (!isFrozen && isCounterStart && target != null && entity.getEntitySenses.canSee(target)) {
      val entityPos = new Vector3(entity)
      val forward = Vector3.directionToEntity(entityPos, target)

      shape.draw(entityPos, Quat.lookRotation(forward, Vector3.Up), 0)
    }
  }

  override def serializeNBT: NBTTagCompound = {
    val tag = super.serializeNBT
    tag.setTag(NbtShotData, shotData.serializeNBT)
    tag.setTag(NbtMovementData, movementData.serializeNBT)
    tag.setTag(NbtRotationData, rotationData.serializeNBT)
    tag.setInteger(NbtAmount, amount)
    tag.setDouble(NbtDistance, distance)
    tag.setDouble(NbtWidth, width)
    tag
  }

  override def deserializeNBT(tag: NBTTagCompound) {
    super.deserializeNBT(tag)
    shotData = new ShotData(tag.getCompoundTag(NbtShotData))
    movementData = MovementData.fromNBT(tag.getCompoundTag(NbtMovementData))
    rotationData = RotationData.fromNBT(tag.getCompoundTag(NbtRotationData))
    amount = tag.getInteger(NbtAmount)
    width = tag.getDouble(NbtWidth)
    distance = tag.getDouble(NbtDistance)

    shape = createShape
  }

  private def createShape: ShapeArrow = {
    val danmaku = DanmakuTemplate
      .builder()
      .setShot(shotData)
      .setMovementData(movementData)
      .setRotationData(rotationData)
      .setUser(getEntity)
      .build()
    new ShapeArrow(danmaku, amount, distance, width)
  }

}
