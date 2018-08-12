package net.katsstuff.journeytogensokyo.client.handler

import java.util.UUID

import scala.collection.JavaConverters._

import net.katsstuff.journeytogensokyo.network.{ServerDialogueBlock, ServerDialogueButton, ServerDialogueText}
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiUtilRenderComponents
import net.minecraft.util.text.ITextComponent

sealed trait ClientDialogueBlock
case class ClientDialogueButton(header: ITextComponent, content: Seq[(UUID, ITextComponent)])
    extends ClientDialogueBlock
case class ClientDialogueText(
    content: Seq[ITextComponent],
    displayTimeMs: Int,
    allowSkip: Boolean,
    answerId: Option[UUID]
) extends ClientDialogueBlock
object ClientDialogueText {

  def createSplit(
      text: ITextComponent,
      displayTimeMs: Int,
      allowSkip: Boolean,
      answerId: Option[UUID]
  ): ClientDialogueText = {
    val split = GuiUtilRenderComponents.splitText(text, 384, Minecraft.getMinecraft.fontRenderer, false, false)
    ClientDialogueText(split.asScala, displayTimeMs, allowSkip, answerId)
  }
}
object ClientDialogueBlock {

  def fromServer(block: ServerDialogueBlock): ClientDialogueBlock = block match {
    case ServerDialogueButton(header, content) =>
      ClientDialogueButton(header, content)
    case ServerDialogueText(content, displayTimeMs, allowSkip, answerId) =>
      ClientDialogueText.createSplit(content, displayTimeMs, allowSkip, answerId)
  }
}
