package net.katsstuff.journeytogensokyo.subentity

import net.katsstuff.journeytogensokyo.lib.LibSubEntityName
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.{SubEntity, SubEntityType}
import net.katsstuff.teamnightclipse.danmakucore.danmaku.{DanmakuState, DanmakuUpdate}
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}

class SubEntityTypeDelayedRotate extends SubEntityType(LibSubEntityName.DelayedRotate) {
  override def instantiate: SubEntity = new SubEntityDelayedRotate
}

class SubEntityDelayedRotate extends SubEntityDefault {

  override def subEntityTick(danmaku: DanmakuState): DanmakuUpdate = {
    val waitFor    = danmaku.shot.getSubEntityProperty("delayedRotateWait", 0D).toInt
    val newSpeed   = danmaku.shot.getSubEntityProperty("delayedRotateNewSpeed", danmaku.movement.speedOriginal)
    val rotateBy   = danmaku.shot.getSubEntityProperty("delayedRotateBy", 0D)
    val wrongOrder = danmaku.shot.getSubEntityProperty("delayedRotateWrongOrder", 0D).toInt != 0

    if (danmaku.ticksExisted == waitFor) {
      val rot = if(wrongOrder) {
        Quat.fromEuler(rotateBy.toFloat, 0F, 0F) * danmaku.orientation
      }
      else {
        danmaku.orientation * Quat.fromEuler(rotateBy.toFloat, 0F, 0F)
      }

      val newDirection   = rot * Vector3.Forward
      val newOrientation = rot

      super.subEntityTick(
        danmaku.copy(
          entity = danmaku.entity.copy(
            direction = newDirection,
            motion = newDirection * newSpeed,
            orientation = newOrientation,
            prevOrientation = newOrientation
          ),
          extra = danmaku.extra.copy(movement = danmaku.movement.setConstant(newSpeed))
        )
      )
    } else {
      super.subEntityTick(danmaku)
    }
  }
}
