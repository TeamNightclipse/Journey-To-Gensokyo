package net.katsstuff.journeytogensokyo.client.handler

import java.util.UUID

import scala.collection.mutable

import net.katsstuff.journeytogensokyo.network.{DialogueAnswerPacket, JTGPacketHandler}
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.{Gui, GuiScreen}
import net.minecraft.client.renderer.GlStateManager
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent

class ClientDialogueHandler {

  private val mc         = Minecraft.getMinecraft
  private val blockQueue = mutable.Queue.empty[ClientDialogueBlock]

  private var currentBlock: ClientDialogueBlock = _

  private var currentBlockStartTime = 0L
  private var pauseStartTime        = 0L

  private var shootKeyLastDown = false

  private var framesSinceSkip = 0

  private var selectedIndex = 0

  @SubscribeEvent
  def renderDialogue(event: RenderGameOverlayEvent.Post): Unit = {
    if (event.getType == RenderGameOverlayEvent.ElementType.CHAT && currentBlock != null) {
      GlStateManager.pushMatrix()

      val res = event.getResolution

      GlStateManager.translate(32F, res.getScaledHeight - 96F, 0F)

      Gui.drawRect(0, 0, res.getScaledWidth - 64, 4 + 4 * mc.fontRenderer.FONT_HEIGHT, 0xC0000000)

      GlStateManager.translate(4F, 0F, 0F)

      currentBlock match {
        case ClientDialogueButton(header, content) =>
          val headerString = header.getFormattedText
          mc.fontRenderer.drawStringWithShadow(headerString, 0, 2, 0xFFFFFF)

          for (((id, text), i) <- content.zipWithIndex) {
            val s     = text.getFormattedText

            val color = if (Math.floorMod(selectedIndex, content.length) == i) 0xFF00FF else 0x808080
            mc.fontRenderer.drawStringWithShadow(s, 0, ((i + 1) * 9) + 2, color)
          }
        case ClientDialogueText(content, displayTimeMs, allowSkip, _) =>
          for ((text, i) <- content.zipWithIndex) {
            val s = text.getFormattedText
            mc.fontRenderer.drawStringWithShadow(s, 0, (i * 9) + 2, 0xFFFFFF)
          }

          val now = System.currentTimeMillis()
          if (!mc.isGamePaused) {
            if (pauseStartTime != 0) {
              val diff = now - pauseStartTime
              currentBlockStartTime += diff
              pauseStartTime = 0L
            }

            if (currentBlockStartTime + displayTimeMs < now) {
              nextBlock()
            }
          } else {
            if (pauseStartTime == 0) pauseStartTime = now
          }

          if (GuiScreen.isCtrlKeyDown && allowSkip) {
            framesSinceSkip += 1
            val fps          = Minecraft.getDebugFPS
            val maxFps       = 30
            val framesToSkip = if (fps > maxFps) fps / maxFps else 1
            if (framesSinceSkip >= framesToSkip) {
              nextBlock()
              framesSinceSkip = 0
            }
          }
      }

      GlStateManager.popMatrix()
    }
  }

  @SubscribeEvent
  def onKeyInput(event: InputEvent.KeyInputEvent): Unit = {
    val shoot = mc.gameSettings.keyBindAttack
    currentBlock match {
      case ClientDialogueButton(_, content) =>
        val up   = mc.gameSettings.keyBindForward
        val down = mc.gameSettings.keyBindBack

        if (up.isPressed) {
          selectedIndex -= 1
        }

        if (down.isPressed) {
          selectedIndex += 1
        }
      case _ =>
    }
  }

  @SubscribeEvent
  def onMouseInput(event: InputEvent.MouseInputEvent): Unit = {
    val shoot = mc.gameSettings.keyBindAttack

    if (shoot.isKeyDown) {
      if (!shootKeyLastDown) {
        shootKeyLastDown = true
        currentBlock match {
          case ClientDialogueButton(_, content) =>
            val id = content(Math.floorMod(selectedIndex, content.length))._1
            sendServerAnswerMessage(id)
          case _ =>
            nextBlock()
        }
      }
    } else if (shootKeyLastDown) {
      shootKeyLastDown = false
    }
  }

  def sendServerAnswerMessage(id: UUID): Unit =
    JTGPacketHandler.sendToServer(DialogueAnswerPacket(id))

  def addBlock(block: ClientDialogueBlock): Unit = {
    blockQueue.enqueue(block)
    if (currentBlock == null) nextBlock()
  }

  def nextBlock(): Unit = {
    currentBlock match {
      case ClientDialogueText(_, _, _, Some(id)) => sendServerAnswerMessage(id)
      case _                                     =>
    }

    if (blockQueue.nonEmpty) {
      currentBlock = blockQueue.dequeue()
      resetNumbers()
      currentBlockStartTime = System.currentTimeMillis()
    } else currentBlock = null
  }

  def refresh(): Unit = {
    blockQueue.clear()
    currentBlock = null
    shootKeyLastDown = false
    resetNumbers()
  }

  private def resetNumbers(): Unit = {
    currentBlockStartTime = 0
    pauseStartTime = 0
    framesSinceSkip = 0
    selectedIndex = 0
  }
}
