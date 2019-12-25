package net.katsstuff.journeytogensokyo.subentity

import net.katsstuff.journeytogensokyo.lib.LibSubEntityName
import net.katsstuff.teamnightclipse.danmakucore.danmaku.{DanmakuState, DanmakuUpdate}
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.{SubEntity, SubEntityType}
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLiving

class SubEntityTypeDelayedHoming extends SubEntityType(LibSubEntityName.DelayedHoming) {
  override def instantiate: SubEntity = new SubEntityDelayedHoming
}

class SubEntityDelayedHoming extends SubEntityDefault {

  override def subEntityTick(danmaku: DanmakuState): DanmakuUpdate = {
    val waitFor  = danmaku.shot.getSubEntityProperty("delayedHomingWait", 0D).toInt
    val newSpeed = danmaku.shot.getSubEntityProperty("delayedHomingNewSpeed", danmaku.movement.speedOriginal)

    if (danmaku.ticksExisted == waitFor) {

      val newDirection = danmaku.user match {
        case Some(x: EntityLiving) =>
          val target = x.getAttackTarget
          if (target != null) {
            Vector3.directionToEntity(danmaku.pos, target)
          } else danmaku.direction

        case _ =>
          danmaku.source match {
            case Some(x: EntitySpellcard) =>
              x.spellCardEntity.target.fold(danmaku.direction)(Vector3.directionToEntity(danmaku.pos, _))
            case _ => danmaku.direction
          }
      }

      val newOrientation = Quat.orientationOfVec(newDirection)

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
