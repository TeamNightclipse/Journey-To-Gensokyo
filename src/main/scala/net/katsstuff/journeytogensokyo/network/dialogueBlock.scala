package net.katsstuff.journeytogensokyo.network
import java.util.UUID

import net.katsstuff.teamnightclipse.mirror.network.scalachannel.{Discriminator, MessageConverter}
import net.minecraft.util.text.ITextComponent

sealed trait ServerDialogueBlock
case class ServerDialogueButton(header: ITextComponent, content: Seq[(UUID, ITextComponent)]) extends ServerDialogueBlock
case class ServerDialogueText(content: ITextComponent, displayTimeMs: Int, allowSkip: Boolean, answerId: Option[UUID])
  extends ServerDialogueBlock
object ServerDialogueText {

  implicit val converter: MessageConverter[ServerDialogueText]    = MessageConverter.mkDeriver[ServerDialogueText].apply
  implicit val discriminator: Discriminator[ServerDialogueButton] = Discriminator(1.toByte)
}
object ServerDialogueBlock {

  implicit val buttonConverter: MessageConverter[ServerDialogueButton]  = MessageConverter.mkDeriver[ServerDialogueButton].apply
  implicit val buttonDiscriminator: Discriminator[ServerDialogueButton] = Discriminator(0.toByte)

  implicit val textConverter: MessageConverter[ServerDialogueText]  = MessageConverter.mkDeriver[ServerDialogueText].apply
  implicit val textDiscriminator: Discriminator[ServerDialogueText] = Discriminator(1.toByte)

  implicit val converter: MessageConverter[ServerDialogueBlock] = MessageConverter.mkDeriver[ServerDialogueBlock].apply
}
