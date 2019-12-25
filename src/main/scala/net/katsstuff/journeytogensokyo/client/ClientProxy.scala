/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client

import scala.reflect.ClassTag

import net.katsstuff.journeytogensokyo.CommonProxy
import net.katsstuff.journeytogensokyo.client.handler.ClientDialogueHandler
import net.katsstuff.journeytogensokyo.client.render.{RenderFairy, RenderHellRaven, RenderPhantom, RenderReimu, RenderRumia, RenderTenguCrow}
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.{ModelResourceLocation => MRL}
import net.minecraft.client.renderer.entity.{Render, RenderManager}
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.client.registry.{IRenderFactory, RenderingRegistry}
import net.minecraftforge.fml.common.event.{FMLServerStartingEvent, FMLServerStoppedEvent}
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.network.FMLNetworkEvent.{ClientConnectedToServerEvent, ClientDisconnectionFromServerEvent}

object ClientProxy {

  @SubscribeEvent
  def registerModels(event: ModelRegistryEvent): Unit = {
    import net.katsstuff.journeytogensokyo.block.JTGBlocks._
    import net.katsstuff.journeytogensokyo.item.JTGItems._

    registerItemBlock(DanmakuCrafting)
    registerItemBlock(GensokyoOre)
    registerItemBlock(MakaiOre)
    registerItemBlock(CelestialOre)

    registerItem(BulletCore)

    registerItem(GensokyoDust)
    registerItem(CelestialDust)
    registerItem(MakaiDust)

    registerItem(GensokyoCrystal)
    registerItem(MakaiCrystal)
    registerItem(CelestialCrystal)

    registerItem(GensokyoSpell)
    registerItem(MakaiSpell)
    registerItem(CelestialSpell)

    registerItem(GensokyoNotes)
    registerItem(PatchedGensokyoNotes)
  }

  private def registerItemBlock(block: Block, damage: Int = 0): Unit =
    registerItem(Item.getItemFromBlock(block), damage)

  def registerItem(item: Item, damage: Int = 0): Unit =
    ModelLoader.setCustomModelResourceLocation(item, damage, new MRL(item.getRegistryName, "inventory"))
}

class ClientProxy extends CommonProxy {

  val dialogueHandler = new ClientDialogueHandler

  override def registerRenderers(): Unit = {
    registerEntityRenderer(new RenderFairy(_))
    registerEntityRenderer(new RenderTenguCrow(_))
    registerEntityRenderer(new RenderHellRaven(_))
    registerEntityRenderer(new RenderPhantom(_))
    registerEntityRenderer(new RenderReimu(_))
    registerEntityRenderer(new RenderRumia(_))

    MinecraftForge.EVENT_BUS.register(dialogueHandler)
  }

  override def serverStarting(event: FMLServerStartingEvent): Unit =
    dialogueHandler.refresh()

  override def serverStopped(event: FMLServerStoppedEvent): Unit =
    dialogueHandler.refresh()

  @SubscribeEvent
  def onJoined(event: ClientConnectedToServerEvent): Unit =
    dialogueHandler.refresh()

  @SubscribeEvent
  def onQuit(event: ClientDisconnectionFromServerEvent): Unit =
    dialogueHandler.refresh()

  def registerEntityRenderer[A <: Entity: ClassTag](f: RenderManager => Render[A]): Unit = {
    val factory: IRenderFactory[A] = manager => f(manager)
    RenderingRegistry.registerEntityRenderingHandler(
      implicitly[ClassTag[A]].runtimeClass.asInstanceOf[Class[A]],
      factory
    )
  }
}
