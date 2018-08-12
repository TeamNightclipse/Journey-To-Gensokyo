package net.katsstuff.journeytogensokyo.entity.living

import net.katsstuff.journeytogensokyo.handler.DialogueActions
import net.katsstuff.journeytogensokyo.network.{DialogueSendBlocksPacket, JTGPacketHandler, ServerDialogueButton, ServerDialogueText}
import net.katsstuff.teamnightclipse.danmakucore.entity.living.ai.EntityAIWanderHover
import net.katsstuff.teamnightclipse.danmakucore.entity.living.{EntityDanmakuCreature, TouhouSpecies}
import net.minecraft.entity.INpc
import net.minecraft.entity.ai.{EntityAILookIdle, EntityAISwimming, EntityAIWander, EntityAIWatchClosest}
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.util.text.TextComponentString
import net.minecraft.util.{DamageSource, EnumHand}
import net.minecraft.world.World

class EntityReimuNPC(_world: World) extends EntityDanmakuCreature(_world) with INpc {

  setSize(0.5F, 1.2F)

  setSpecies(TouhouSpecies.HUMAN)
  setFlyingSpeed(0.3D)
  setGroundSpeed(0.2D)

  override def initEntityAI(): Unit = {
    tasks.addTask(0, new EntityAISwimming(this))
    tasks.addTask(4, new EntityAIWander(this, 1D, 120))
    tasks.addTask(4, new EntityAIWanderHover(this, 1D, 140))
    tasks.addTask(6, new EntityAIWatchClosest(this, classOf[EntityPlayer], 16F))
    tasks.addTask(7, new EntityAILookIdle(this))
  }

  override def isEntityInvulnerable(source: DamageSource): Boolean = true

  override def getIsInvulnerable: Boolean = true

  override def canBeLeashedTo(player: EntityPlayer): Boolean = false

  override def processInteract(player: EntityPlayer, hand: EnumHand): Boolean = {
    if (!world.isRemote) {
      player match {
        case player: EntityPlayerMP =>
          val string = "Zero one two three four five six seven eight nine " +
            "ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen " +
            "twenty twenty-one twenty-two twenty-three twenty-four twenty-five twenty-six twenty-seven twenty-eight twenty-nine"
          val single = false
          val choice = true

          if (choice) {
            val first  = new TextComponentString("Hey you, I got a question for you")
            val header = new TextComponentString("Can I ask you a question?")

            val yesId = DialogueActions.newAction {
              val yesText = new TextComponentString("That's very kind of you. Thanks")
              val newData = Seq(
                ServerDialogueText(
                  yesText,
                  5000,
                  allowSkip = true,
                  Some(DialogueActions.newAction(println("Interaction done with yes")))
                )
              )
              JTGPacketHandler.sendTo(DialogueSendBlocksPacket(newData, nextBlock = true), player)
            }
            val noId = DialogueActions.newAction {
              val noText = new TextComponentString("Wow, rude.")
              val newData = Seq(
                ServerDialogueText(
                  noText,
                  5000,
                  allowSkip = true,
                  Some(DialogueActions.newAction(println("Interaction done with no")))
                )
              )
              JTGPacketHandler.sendTo(DialogueSendBlocksPacket(newData, nextBlock = true), player)
            }

            val buttons = Seq(
              yesId -> new TextComponentString("Of course you can"),
              noId  -> new TextComponentString("For the fun of it, no.")
            )

            val data =
              Seq(ServerDialogueText(first, 10000, allowSkip = true, None), ServerDialogueButton(header, buttons))
            JTGPacketHandler.sendTo(DialogueSendBlocksPacket(data, nextBlock = false), player)
          } else if (single) {
            val content = new TextComponentString(string)
            val data    = Seq(ServerDialogueText(content, 500000, allowSkip = true, None))
            JTGPacketHandler.sendTo(DialogueSendBlocksPacket(data, nextBlock = false), player)
          } else {
            val words = string.split(' ')
            val data = for (word <- words) yield {
              val content = new TextComponentString(word)
              ServerDialogueText(content, 10000, allowSkip = true, None)
            }
            JTGPacketHandler.sendTo(DialogueSendBlocksPacket(data, nextBlock = false), player)
          }
        case _ =>
      }
    }

    true
  }
}
