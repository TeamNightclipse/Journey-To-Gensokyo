package net.katsstuff.journeytogensokyo.shape

import net.katsstuff.teamnightclipse.danmakucore.danmaku.{DanmakuState, DanmakuTemplate}
import net.katsstuff.teamnightclipse.danmakucore.lib.LibSounds
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.DanmakuHelper
import net.katsstuff.teamnightclipse.danmakucore.shape.{Shape, ShapeResult}
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}

class ShapeWideSlow(
    template: DanmakuTemplate,
    amount: Int,
    wideAngle: Float,
    baseAngle: Float,
    distance: Double,
    time: Int,
    reverseDirection: Boolean
) extends Shape {

  private val amountPerTick       = amount.toDouble / time
  private val lastTickExtraAmount = amount.toDouble % time

  private val stepSize = {
    val base = wideAngle / (amount - 1)
    if (reverseDirection) -base else base
  }

  private var partialAccumulator = 0D
  private var amountDone         = 0D

  private var rotateAngle = {
    val base = wideAngle / 2D
    if (reverseDirection) base + baseAngle else -base - baseAngle
  }

  override def draw(pos: Vector3, orientation: Quat, tick: Int): ShapeResult = {
    if (!template.world.isRemote) {
      val builder = template.toBuilder
      DanmakuHelper.playSoundAt(template.world, template.pos, LibSounds.SHOT1, 0.05F, 1F)

      val isLastTick    = tick + 1 >= time
      val toSpawnDouble = if (isLastTick) amountPerTick + lastTickExtraAmount else amountPerTick
      partialAccumulator += toSpawnDouble - toSpawnDouble.toInt

      val toSpawn = toSpawnDouble.toInt + partialAccumulator.toInt
      partialAccumulator -= partialAccumulator.toInt

      val tickRes = for (_ <- 0 until toSpawn) yield {
        val rotate = orientation * template.orientation * Quat.fromAxisAngle(Vector3.Up, rotateAngle)
        builder.direction = Vector3.Forward.rotate(rotate)
        builder.pos = pos.offset(builder.direction, distance)
        builder.orientation = rotate
        rotateAngle += stepSize

        builder.build.asEntity
      }
      amountDone += amountPerTick

      if (isLastTick) ShapeResult.done(tickRes.toSet) else ShapeResult.notDone(tickRes.toSet)
    } else ShapeResult.done(Set.empty[DanmakuState])
  }
}
