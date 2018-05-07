package net.katsstuff.journeytogensokyo.handler

import net.katsstuff.journeytogensokyo.entity.EntityCamera
import net.minecraft.client.Minecraft
import net.minecraft.entity.Entity
import net.minecraftforge.client.event.{EntityViewRenderEvent, FOVUpdateEvent, RenderGameOverlayEvent, RenderHandEvent, RenderPlayerEvent}
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import net.minecraftforge.fml.relauncher.Side

object CameraHandler {

  private val mc                 = Minecraft.getMinecraft
  private var cameraView: Entity = _
  private var realView: Entity   = _
  private var realThirdPerson: Int = 0

  def setCamera(entity: Entity): Unit = {
    if(cameraView != null) {
      unsetCamera()
    }
    else {
      val camera = new EntityCamera(entity)
      camera.forceSpawn = true
      entity.world.spawnEntity(camera)
      cameraView = camera
      realThirdPerson = mc.gameSettings.thirdPersonView
    }
  }

  def unsetCamera(): Unit = {
    cameraView.setDead()
    cameraView = null
    useRealView()
    mc.gameSettings.thirdPersonView = realThirdPerson
  }

  private def useCameraView(): Unit = {
    if (cameraView != null) {
      mc.gameSettings.thirdPersonView = 0
      realView = mc.getRenderViewEntity
      mc.getRenderManager.renderViewEntity = cameraView
      mc.setRenderViewEntity(cameraView)
    }
  }

  private def useRealView(): Unit = {
    if (realView != null) {
      mc.getRenderManager.renderViewEntity = realView
      mc.setRenderViewEntity(realView)
      realView = null
    } else {
      mc.getRenderManager.renderViewEntity = realView
      mc.setRenderViewEntity(mc.player)
    }
  }

  @SubscribeEvent
  def onRenderTick(event: TickEvent.RenderTickEvent): Unit =
    if (cameraView != null) {
      if (event.phase == TickEvent.Phase.START) {
        cameraView.setPosition(cameraView.posX, cameraView.posY, cameraView.posZ + 0.0025)
        mc.gameSettings.thirdPersonView = 0
        useCameraView()
      }
      else {
        useRealView()
      }
    }

  @SubscribeEvent
  def onRenderPlayerPre(event: RenderPlayerEvent.Pre): Unit = {
    if (cameraView != null) {
      useRealView()
    }
  }

  @SubscribeEvent
  def onRenderPlayerPost(event: RenderPlayerEvent.Post): Unit = {
    if (cameraView != null) {
      useCameraView()
    }
  }

  @SubscribeEvent
  def onRenderOverlay(event: RenderGameOverlayEvent): Unit = {
    if (cameraView != null) {
      if (event.getType == RenderGameOverlayEvent.ElementType.BOSSHEALTH) {
        event match {
          case _: RenderGameOverlayEvent.Post => useRealView()
          case _                              =>
        }
      } else if (event.getType == RenderGameOverlayEvent.ElementType.AIR) {
        event match {
          case _: RenderGameOverlayEvent.Post => useCameraView()
          case _                              =>
        }
      } else if (event.getType == RenderGameOverlayEvent.ElementType.HOTBAR) {
        event match {
          case _: RenderGameOverlayEvent.Pre  => useRealView()
          case _: RenderGameOverlayEvent.Post => useCameraView()
          case _                              =>
        }
      }
    }
  }

  @SubscribeEvent
  def onRenderHand(event: RenderHandEvent): Unit = {
    if(cameraView != null) {
      event.setCanceled(true)
    }
  }

  @SubscribeEvent
  def onFov(event: EntityViewRenderEvent.FOVModifier): Unit = {
    if(cameraView != null) {
      event.setFOV(75F)
    }
  }

  @SubscribeEvent
  def onPlayerUpdate(event: TickEvent.PlayerTickEvent): Unit = {
    if(cameraView != null && event.side == Side.CLIENT && event.phase == TickEvent.Phase.START) {
      val player = event.player
      player.setPositionAndRotation(player.posX, player.posY, player.posZ, cameraView.rotationYaw, 0F)
    }
  }
}
