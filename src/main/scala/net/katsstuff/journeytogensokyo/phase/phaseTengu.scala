/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import net.katsstuff.danmakucore.DanmakuCore
import net.katsstuff.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.danmakucore.data.ShotData
import net.katsstuff.danmakucore.entity.living.EntityDanmakuMob
import net.katsstuff.danmakucore.entity.living.ai.FlyingRandomPositionGenerator
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.item.ItemDanmaku
import net.katsstuff.danmakucore.lib.data.{LibItems, LibShotData}
import net.katsstuff.danmakucore.lib.{LibColor, LibSounds}
import net.katsstuff.danmakucore.scalastuff.{DanmakuCreationHelper, TouhouHelper}
import net.katsstuff.mirror.data.{Quat, Vector3}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource

class PhaseTypeTengu extends PhaseType {
  override def instantiate(manager: PhaseManager): Phase = new PhaseTengu(manager, this)
}

class PhaseTengu(manager: PhaseManager, val phaseType: PhaseTypeTengu) extends Phase(manager) {

  var cooldown         = 0
  var charge           = 0
  private val shotData = LibShotData.SHOT_SMALL.copy(edgeColor = LibColor.COLOR_SATURATED_YELLOW)

  override def init(): Unit = {
    super.init()
    interval = 24
  }

  override def serverUpdate(): Unit = {
    super.serverUpdate()

    val entity = getEntity
    val target = entity.getAttackTarget

    if (!isFrozen && target != null && entity.getEntitySenses.canSee(target)) {
      val entityPos = new Vector3(entity)
      val forward   = Vector3.directionToEntity(entityPos, target)
      entity.faceEntity(target, 30F, 30F)
      if (counter % 12 == 0) {
        val template = DanmakuTemplate.builder
          .setUser(entity)
          .setDirection(Vector3.directionToLiving(entity, target))
          .setShot(shotData)
          .setOrientation(Quat.lookRotation(forward, Vector3.Up))
          .setMovementData(0.4D)
          .build

        DanmakuCreationHelper.createRandomRingShot(template, 3 * level.getMultiplier, 40F, 0.5D)
        entity.playSound(LibSounds.SHOT1, 1F, 1F)
      }

      if (charge > 0) doCharge(entity, target) else moveAround(entity, target)
    }
  }

  override protected def useFreeze: Boolean = false

  private def doCharge(entity: EntityDanmakuMob, target: EntityLivingBase): Unit = {
    if (counter % 12 == 0) {
      if (charge < 3) {
        charge += 1
        createChargeSphere(entity)
      } else {
        val direction @ Vector3(x, y, z) = Vector3.directionToLiving(entity, target) * (entity.getFlyingSpeed * 3.5D)
        if(!entity.isFlying) {
          entity.motionY += 0.35F
        }
        entity.motionX += x
        entity.motionY += y
        entity.motionZ += z

        val template = DanmakuTemplate.builder
          .setUser(entity)
          .setDirection(direction.normalize)
          .setShot(shotData.setMainColor(LibColor.COLOR_SATURATED_RED).scaleSize(3F))
          .setMovementData(entity.getFlyingSpeed * 1.2D)
          .build

        DanmakuCore.spawnDanmaku(Seq(template.asEntity))
        charge = 0
      }
    }
  }

  private def moveAround(entity: EntityDanmakuMob, target: EntityLivingBase): Unit = {
    if (isCounterStart) {
      if (cooldown > 0) cooldown -= 1

      if (cooldown == 0) {
        if (entity.getRNG.nextInt(3) == 0) {
          cooldown = 3
          charge = 1
          createChargeSphere(entity)
        } else {
          val targetVec = FlyingRandomPositionGenerator.findRandomTarget(entity, 4, 1)
          if (targetVec != null) {
            val path = entity.getNavigator.getPathToXYZ(targetVec.x, targetVec.y, targetVec.z)
            if (path != null) {
              if (entity.getNavigator.setPath(path, 1D)) {
                cooldown = 2
              }
            }
          }
        }
      }
    }
  }

  private def createChargeSphere(entity: EntityDanmakuMob): Unit =
    TouhouHelper.createChargeSpherePacket(
      packetCenter = new Vector3(entity),
      entity = entity,
      amount = 150 * charge,
      offset = 2D,
      divSpeed = 5D,
      r = 1F,
      g = 0.1F,
      b = 0.1F,
      lifetime = 40
    )

  override def dropLoot(source: DamageSource): Unit = {
    val stack  = new ItemStack(LibItems.DANMAKU)
    val entity = getEntity

    stack.setCount(entity.getRNG.nextInt(5) + 1)
    ItemDanmaku.Amount.set(entity.getRNG.nextInt(5) + 1, stack)
    ItemDanmaku.Speed.set(0.4D, stack)
    ItemDanmaku.DanPattern.set(ItemDanmaku.RandomRing, stack)
    ShotData.serializeNBTItemStack(stack, shotData)
    //noinspection NameBooleanParameters
    ItemDanmaku.Custom.set(true, stack)

    entity.entityDropItem(stack, 0F)
  }
}
