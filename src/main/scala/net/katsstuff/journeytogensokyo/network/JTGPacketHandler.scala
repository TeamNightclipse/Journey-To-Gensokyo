package net.katsstuff.journeytogensokyo.network

import net.katsstuff.journeytogensokyo.lib.LibMod
import net.katsstuff.teamnightclipse.mirror.network.scalachannel.ScalaNetworkWrapper

object JTGPacketHandler extends ScalaNetworkWrapper(LibMod.Id) {
  private[journeytogensokyo] def load(): Unit = {
    registerMessages {
      for {
        _ <- registerMessage[DialogueAnswerPacket]
        _ <- registerMessage[DialogueSendBlocksPacket]
      } yield ()
    }
  }
}
