package net.katsstuff.journeytogensokyo.entity.living.boss.phase

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate
import net.katsstuff.teamnightclipse.danmakucore.data.{MovementData, ShotData}
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.{Phase, PhaseManager, PhaseType}
import net.katsstuff.teamnightclipse.danmakucore.impl.shape.ShapeSphere
import net.katsstuff.teamnightclipse.danmakucore.lib.LibColor._
import net.katsstuff.teamnightclipse.danmakucore.lib.LibSounds
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData
import net.katsstuff.teamnightclipse.danmakucore.shape.ShapeHandler
import net.katsstuff.teamnightclipse.mirror.data.{Quat, Vector3}

object PhaseRumiaEasy {

  class Warmup1Type extends PhaseType {
    override def instantiate(phaseManager: PhaseManager): Phase = new Warmup1(phaseManager, this)
  }

  class Warmup2Type extends PhaseType {
    override def instantiate(phaseManager: PhaseManager): Phase = new Warmup2(phaseManager, this)
  }

  class Warmup3Type extends PhaseType {
    override def instantiate(phaseManager: PhaseManager): Phase = new Warmup3(phaseManager, this)
  }

  class Warmup1(manager: PhaseManager, val phaseType: PhaseType) extends Phase(manager) {
    interval = 220

    private def circleDanmaku(color: Int) =
      DanmakuTemplate.builder.setUser(entity).setShot(LibShotData.SHOT_CIRCLE.copy(edgeColor = color))

    private def sprayDanmaku(baseShot: ShotData) =
      DanmakuTemplate.builder.setUser(entity).setShot(baseShot)

    private def rainbowCircle(i: Int): ShotData = {
      val color = i % 6 match {
        case 0 => COLOR_SATURATED_BLUE
        case 1 => COLOR_SATURATED_MAGENTA
        case 2 => COLOR_SATURATED_GREEN
        case 4 => COLOR_SATURATED_YELLOW
        case _ => COLOR_SATURATED_RED
      }
      LibShotData.pellet(color).scaleSize(2F)
    }

    /*
    0 power up sound
    0 circle blue
    40 Charge pellet circle rainbow (blue, magenta, green, yellow, red)
    60 fire charge
    100 power up sound
    100 circle green
    110 circle yellow
    150 misc circle rainbow
    160 blue pellet crystal alternating, first but slow, little acceleration, pellet slightly faster than bullet
    163 red pellet crystal, pellet besides crystal, faster than blue, much more acceleration, hits speed limit little after passing blue
    167 green pellet crystal, pellet besides crystal, slowest, almost no acceleration and speed, pellet and crystal same speed
    170 yellow pellet crystal, pellet on top of crystal, slightly faster than blue, pellet much slower than crystal
    172 orange pellet crystal, pellet besides crystal, fastest of all, pellet somewhat faster than bullet
    210 power up sound
    210 circle blue
    220 circle red
    221 GOTO pellet circle random
     */

    override def serverUpdate(): Unit = {
      super.serverUpdate()
      interval = 220

      val target = entity.getAttackTarget

      lazy val userOrient = {
        val forward = if (target != null) Vector3.directionToEntity(entity, target) else Vector3.directionEntity(entity)
        Quat.orientationOfVec(forward)
      }

      if (!isFrozen && target != null && entity.getEntitySenses.canSee(target)) {
        counter match {
          case 0 =>
            entity.playSound(LibSounds.ENEMY_POWER, 1F, 1F)
            createLagCircle(COLOR_SATURATED_BLUE)
          case 60 =>
            val amount  = 5 * level.getMultiplier
            val danmaku = DanmakuTemplate.builder.setUser(entity).setMovementData(0.05D, 0.5D, 0.01D)

            val allSpawnedDanmaku = (0 until 5).flatMap { i =>
              val orient = userOrient * Quat.fromAxisAngle(Vector3.Up, i * 5F)
              val shape = new ShapeSphere(
                danmaku
                  .setShot(rainbowCircle(i))
                  .setMovementData(0.05D, 0.5D, 0.01D + (0.001D * i))
                  .build,
                amount,
                amount / 2,
                0F,
                0.05D
              )
              shape.draw(entity.pos, orient, 0).spawnedDanmaku
            }
            DanmakuCore.spawnDanmaku(allSpawnedDanmaku)

          case 100 =>
            entity.playSound(LibSounds.ENEMY_POWER, 1F, 1F)
            createLagCircle(COLOR_SATURATED_GREEN)
          case 110 => createLagCircle(COLOR_SATURATED_YELLOW)
          case 160 =>
            createSprayCircle(
              COLOR_SATURATED_BLUE,
              MovementData.noGravity(0.05D, 0.05D, 0.4D, 0.05D),
              MovementData.noGravity(0.05D, 0.06D, 0.45D, 0.05D)
            )
          case 163 =>
            createSprayCircle(
              COLOR_SATURATED_RED,
              MovementData.noGravity(0.05D, 0.075D, 0.6D, 0.07D),
              MovementData.noGravity(0.05D, 0.070D, 0.65D, 0.07D)
            )
          case 167 =>
            createSprayCircle(
              COLOR_SATURATED_GREEN,
              MovementData.noGravity(0.05D, 0.05D, 0.3D, 0.02D),
              MovementData.noGravity(0.05D, 0.05D, 0.3D, 0.02D)
            )
          case 170 =>
            createSprayCircle(
              COLOR_SATURATED_YELLOW,
              MovementData.noGravity(0.05D, 0.05D, 0.45D, 0.05D),
              MovementData.noGravity(0.05D, 0.05D, 0.3D, 0.05D)
            )
          case 172 =>
            createSprayCircle(
              COLOR_SATURATED_ORANGE,
              MovementData.noGravity(0.05D, 0.075D, 0.8D, 0.05D),
              MovementData.noGravity(0.05D, 0.08D, 0.85D, 0.08D)
            )
          case 210 => createLagCircle(COLOR_SATURATED_BLUE)
          case 220 => createLagCircle(COLOR_SATURATED_RED)
          case _   =>
        }
      }
    }

    private def createLagCircle(color: Int): Unit = {
      val danmakuBuilder = circleDanmaku(color)
      val shotSpeed      = 0.4D
      val rings          = 4 * level.getMultiplier
      val bands          = rings / 2

      val amount = 2 + level.getMultiplier
      val orient = Quat.orientationOf(entity)
      val danmaku = (1 to amount).flatMap { i =>
        val danmaku = danmakuBuilder.setMovementData(shotSpeed / amount * i).build
        new ShapeSphere(danmaku, rings, bands, 0, 0.25D).draw(entity.pos, orient, 0).spawnedDanmaku
      }
      DanmakuCore.spawnDanmaku(danmaku)
    }

    private def createSprayCircle(
        color: Int,
        crystalMovement: MovementData,
        pelletMovement: MovementData
    ): Unit = {
      val crystalDanmaku =
        sprayDanmaku(LibShotData.SHOT_CRYSTAL1.setEdgeColor(color)).setMovementData(crystalMovement).build
      val pelletDanmaku = sprayDanmaku(LibShotData.pellet(color).scaleSize(2F)).setMovementData(pelletMovement).build
      val orient        = Quat.orientationOf(entity)
      val amount        = level.getMultiplier * 8
      val angle         = entity.getRNG.nextGaussian().toFloat * 90
      val crystals = new ShapeSphere(crystalDanmaku, amount, amount / 2, 0, 0.25D)
        .draw(entity.pos, orient, 0)
        .spawnedDanmaku
        .toSeq
      val pellets = new ShapeSphere(pelletDanmaku, amount, amount / 2, angle, 0.25D)
        .draw(entity.pos, orient, 0)
        .spawnedDanmaku
        .toSeq
      DanmakuCore.spawnDanmaku(crystals ++ pellets)
    }
  }

  class Warmup2(manager: PhaseManager, val phaseType: PhaseType) extends Phase(manager) {
    override def serverUpdate(): Unit =
      super.serverUpdate()
  }

  class Warmup3(manager: PhaseManager, val phaseType: PhaseType) extends Phase(manager) {
    override def serverUpdate(): Unit =
      super.serverUpdate()
  }
}
