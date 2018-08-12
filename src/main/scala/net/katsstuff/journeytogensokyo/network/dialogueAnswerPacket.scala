package net.katsstuff.journeytogensokyo.network

import java.util.UUID

import net.katsstuff.journeytogensokyo.handler.DialogueActions
import net.katsstuff.teamnightclipse.mirror.network.scalachannel.{MessageConverter, ServerMessageHandler}
import net.minecraft.network.NetHandlerPlayServer

case class DialogueAnswerPacket(id: UUID)
object DialogueAnswerPacket {
  implicit val converter: MessageConverter[DialogueAnswerPacket] =
    MessageConverter.mkDeriver[DialogueAnswerPacket].apply

  implicit val handler: ServerMessageHandler[DialogueAnswerPacket, Unit] =
    new ServerMessageHandler[DialogueAnswerPacket, Unit] {
      override def handle(netHandler: NetHandlerPlayServer, a: DialogueAnswerPacket): Option[Unit] = {
        scheduler.addScheduledTask(DialogueAnswerPacketRunnable(netHandler, a))
        None
      }
    }
}
case class DialogueAnswerPacketRunnable(netHandler: NetHandlerPlayServer, packet: DialogueAnswerPacket)
    extends Runnable {
  override def run(): Unit = DialogueActions.runAnswerAction(packet.id)
}
