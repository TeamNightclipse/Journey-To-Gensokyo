/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.phase

import net.katsstuff.danmakucore.data.{Quat, ShotData, Vector3}
import net.katsstuff.danmakucore.entity.danmaku.DanmakuTemplate
import net.katsstuff.danmakucore.entity.living.EntityDanmakuMob
import net.katsstuff.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.danmakucore.helper.{DanmakuCreationHelper, DanmakuHelper, TouhouHelper}
import net.katsstuff.danmakucore.item.ItemDanmaku
import net.katsstuff.danmakucore.lib.LibColor
import net.katsstuff.danmakucore.lib.data.{LibItems, LibShotData}
import net.katsstuff.journeytogensokyo.helper.FlyingRandomPositionGenerator
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource

class PhaseTypeTengu extends PhaseType {
  override def instantiate(manager: PhaseManager): Phase = new PhaseTengu(manager, this)
}

class PhaseTengu(manager: PhaseManager, val getType: PhaseTypeTengu) extends Phase(manager) {

  var cooldown         = 0
  var charge           = 0
  private val shotData = LibShotData.SHOT_SMALL.copy(color = LibColor.COLOR_SATURATED_YELLOW)

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
      val forward = Vector3.directionToEntity(entityPos, target)
      entity.faceEntity(target, 30F, 30F)
      if (counter % 12 == 0) {
        val template = DanmakuTemplate
          .builder()
          .setUser(entity)
          .setDirection(Vector3.directionToLiving(entity, target))
          .setShot(shotData)
          .setMovementData(0.4D)
          .build()

        DanmakuCreationHelper.createRandomRingShot(Quat.lookRotation(forward, Vector3.Up), template, 3 * level.getMultiplier, 40F, 0.5D)
        DanmakuHelper.playShotSound(entity)
      }

      if (charge > 0) doCharge(entity, target) else moveAround(entity, target)
    }
  }

  override protected def useFreeze(): Boolean = false

  private def doCharge(entity: EntityDanmakuMob, target: EntityLivingBase): Unit = {
    if (counter % 12 == 0) {
      if (charge < 3) {
        charge += 1
        createChargeSphere(entity)
      } else {
        val direction @ Vector3(x, y, z) = Vector3.directionToLiving(entity, target) * (entity.getSpeed * 2.5D)
        entity.motionX += x
        entity.motionY += y
        entity.motionZ += z

        val template = DanmakuTemplate
          .builder()
          .setUser(entity)
          .setDirection(direction.normalize)
          .setShot(shotData.setColor(LibColor.COLOR_SATURATED_RED).scaleSize(2F))
          .setMovementData(entity.getSpeed * 1.2D)
          .build()

        entity.world.spawnEntity(template.asEntity())
        charge = 0
      }
    }
  }

  private def moveAround(entity: EntityDanmakuMob, target: EntityLivingBase): Unit = {
    if (isCounterStart) {
      if (cooldown > 0) cooldown -= 1

      if (cooldown == 0 && !entity.hasPath) {

        if (entity.getRNG.nextInt(3) == 0) {
          cooldown = 3
          charge = 1
          createChargeSphere(entity)
        } else {
          val targetVec = FlyingRandomPositionGenerator.findRandomTarget(entity, 4, 1)
          if (targetVec != null) {
            val path = entity.getNavigator.getPathToXYZ(targetVec.x, targetVec.y, targetVec.z)
            if (path != null) {
              if (entity.getNavigator.setPath(path, entity.getSpeed)) {
                cooldown = 2
              }
            }
          }
        }
      }
    }
  }

  private def createChargeSphere(entity: EntityDanmakuMob): Unit = {
    TouhouHelper.createChargeSpherePacket(new Vector3(entity), entity, 50 * charge, 2D, 10D, 1F, 0.1F, 0.1F, 40)
  }

  override def dropLoot(source: DamageSource): Unit = {
    val stack  = new ItemStack(LibItems.DANMAKU)
    val entity = getEntity

    stack.setCount(entity.getRNG.nextInt(5) + 1)
    ItemDanmaku.AMOUNT.set(entity.getRNG.nextInt(5) + 1, stack)
    ItemDanmaku.SPEED.set(0.4D, stack)
    ItemDanmaku.setPattern(stack, ItemDanmaku.Pattern.RANDOM_RING)
    ShotData.serializeNBTItemStack(stack, shotData)
    //noinspection NameBooleanParameters
    ItemDanmaku.CUSTOM.set(true, stack)

    entity.entityDropItem(stack, 0F)
  }
}
