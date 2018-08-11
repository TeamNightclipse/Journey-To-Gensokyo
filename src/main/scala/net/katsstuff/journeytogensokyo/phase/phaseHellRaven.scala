/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import java.util.concurrent.ThreadLocalRandom

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.teamnightclipse.danmakucore.item.ItemDanmaku
import net.katsstuff.teamnightclipse.danmakucore.lib.data.{LibItems, LibShotData}
import net.katsstuff.teamnightclipse.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.DanmakuCreationHelper
import net.katsstuff.journeytogensokyo.helper.Implicits._
import net.katsstuff.journeytogensokyo.helper.LogHelper
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource

class PhaseTypeHellRaven extends PhaseType {
  override def instantiate(manager: PhaseManager): Phase =
    new PhaseHellRaven(manager, ThreadLocalRandom.current().nextBoolean(), this)
}

class PhaseHellRaven(manager: PhaseManager, star: Boolean, val phaseType: PhaseTypeHellRaven) extends Phase(manager) {
  private val starShotData  = LibShotData.SHOT_KUNAI.copy(edgeColor = LibColor.COLOR_SATURATED_BLUE, end = 60)
  private val otherShotData = LibShotData.SHOT_SMALL.copy(edgeColor = LibColor.COLOR_SATURATED_BLUE)

  override def init(): Unit = {
    super.init()
    if (star) interval = 81 else interval = 45
  }

  override def serverUpdate(): Unit = {
    super.serverUpdate()
    val entity = getEntity
    val target = entity.getAttackTarget

    def moveLeftRight(): Unit = {
      val dir              = if (entity.getRNG.nextBoolean()) 1 else -1
      val Vector3(x, y, z) = entity.direction.rotate(Quat.fromEuler(dir * 45F, 0F, 0F)) / 2

      entity.motionX += x
      entity.motionY += y
      entity.motionZ += z
    }

    if (!isFrozen && target != null && entity.getEntitySenses.canSee(target)) {
      val entityPos = new Vector3(entity)
      val forward   = Vector3.directionToEntity(entityPos, target)
      if (star) {
        if (counter >= 20) {
          val template =
            DanmakuTemplate.builder
              .setUser(entity)
              .setShot(starShotData)
              .setDirection(forward)
              .setOrientation(Quat.lookRotation(forward, Vector3.Up))
              .setMovementData(0.3D * level.getMultiplier)
              .build
          //TODO: Use star shot when it's working again
          DanmakuCreationHelper.createSphereShot(
            template,
            4,
            Math.max(8, 2 * level.getMultiplier),
            0F,
            0.5D
          )
          entity.playSound(LibSounds.SHOT1, 1F, 1F)
        }

        if (isCounterStart) {
          moveLeftRight()
        }
      } else {
        if (counter % 10 == 0) {
          val num      = ((1 + level.getMultiplier) * 1.3).toInt
          val template = DanmakuTemplate.builder.setUser(entity).setShot(otherShotData).setDirection(forward)

          val toSpawn = for (i <- 1 until num) yield {
            template.setMovementData(0.3D * (i / 2D) * 2D).build.asEntity
          }
          DanmakuCore.spawnDanmaku(toSpawn)

          entity.playSound(LibSounds.SHOT1, 1F, 1F)
        }

        if (counter == 31) {
          moveLeftRight()
        }
      }
    }
  }

  override def dropLoot(source: DamageSource): Unit = {
    val stack  = new ItemStack(LibItems.DANMAKU)
    val entity = getEntity
    stack.setCount(entity.getRNG.nextInt(5) + 1)

    if (star) {
      ItemDanmaku.Amount.set(Math.max(5, entity.getRNG.nextInt(8) + 1), stack)
      ItemDanmaku.Speed.set(0.5D, stack)
      ItemDanmaku.DanPattern.set(ItemDanmaku.Sphere, stack)
      ShotData.serializeNBTItemStack(stack, starShotData)
    } else {
      ItemDanmaku.Amount.set(entity.getRNG.nextInt(5) + 1, stack)
      ItemDanmaku.Speed.set(0.3D, stack)
      ItemDanmaku.DanPattern.set(ItemDanmaku.Line, stack)
      ShotData.serializeNBTItemStack(stack, otherShotData)
    }
    //noinspection NameBooleanParameters
    ItemDanmaku.Custom.set(true, stack)

    entity.entityDropItem(stack, 0F)
  }
}
