package net.katsstuff.journeytogensokyo.network

import net.katsstuff.journeytogensokyo.JourneyToGensokyo
import net.katsstuff.journeytogensokyo.client.ClientProxy
import net.katsstuff.journeytogensokyo.client.handler.ClientDialogueBlock
import net.katsstuff.teamnightclipse.mirror.network.scalachannel.{ClientMessageHandler, MessageConverter}
import net.minecraft.client.network.NetHandlerPlayClient

case class DialogueSendBlocksPacket(
    blocks: Seq[ServerDialogueBlock],
    nextBlock: Boolean
)
object DialogueSendBlocksPacket {

  implicit val converter: MessageConverter[DialogueSendBlocksPacket] = MessageConverter.mkDeriver[DialogueSendBlocksPacket].apply

  implicit val handler: ClientMessageHandler[DialogueSendBlocksPacket, Unit] =
    new ClientMessageHandler[DialogueSendBlocksPacket, Unit] {
      override def handle(netHandler: NetHandlerPlayClient, a: DialogueSendBlocksPacket): Option[Unit] = {
        scheduler.addScheduledTask(DialogueSendBlocksPacketRunnable(netHandler, a))
        None
      }
    }
}
case class DialogueSendBlocksPacketRunnable(netHandler: NetHandlerPlayClient, packet: DialogueSendBlocksPacket) extends Runnable {
  override def run(): Unit = {
    val handler = JourneyToGensokyo.proxy.asInstanceOf[ClientProxy].dialogueHandler
    for(block <- packet.blocks) {
      handler.addBlock(ClientDialogueBlock.fromServer(block))
    }

    if(packet.nextBlock) {
      handler.nextBlock()
    }
  }
}