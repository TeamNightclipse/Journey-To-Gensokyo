/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.gui

import net.katsstuff.danmakucore.data.Vector3
import net.katsstuff.danmakucore.helper.TouhouHelper
import net.katsstuff.danmakucore.misc.ITranslatable
import net.katsstuff.journeytogensokyo.container.ContainerDanmakuCrafting
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.katsstuff.journeytogensokyo.helper.Implicits._
import net.katsstuff.journeytogensokyo.helper.LogHelper

class GuiDanmakuCrafting(invPlayer: InventoryPlayer, world: World, pos: BlockPos)
    extends GuiContainer(new ContainerDanmakuCrafting(invPlayer, world, pos)) {

  final val Texture      = new ResourceLocation(LibMod.Id, "textures/gui/danmaku_crafting_table.png")
  final val SpaceDivider = " : "
  final val White        = 0xFFFFFF

  xSize = 256
  ySize = 256

  private val container = inventorySlots.asInstanceOf[ContainerDanmakuCrafting]

  override protected def drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int) {
    def toTuple(vector1: Vector3, vector2: Option[Vector3]) =
      Seq((vector1.x, vector2.map(_.x)), (vector1.y, vector2.map(_.y)), (vector1.z, vector2.map(_.z)))
    def draw(string: String, x: Int, y: Int, color: Int = White) = fontRendererObj.drawString(string, x, y, color)
    def drawAll(x: Int, startY: Int, incrementY: Int, strings: Seq[String]): Int = {
      for (i <- strings.indices) draw(strings(i), x, startY + incrementY * i)
      startY + incrementY * strings.length
    }

    def i18n(string: String)                           = I18n.format(string)
    def i18nPrefix(prefix: String)                     = (str: String) => i18n(s"$prefix.$str")
    def i18nDouble[A, B](first: A => String, second: B => String) = first(_: A) + SpaceDivider + second(_: B)

    def i18nTranslatable(translatable: ITranslatable) = i18n(translatable.getUnlocalizedName)

    val i18nDanmaku = i18nPrefix("item.danmaku")
    val i18nDanmaku2 = i18nDouble(i18nDanmaku, i18nDanmaku)
    val i18nDanmakuTranslate = i18nDouble(i18nDanmaku, i18nTranslatable)
    val i18nCrafting = i18nPrefix("crafting.danmaku")

    def i18nValue(string: String, value: (_, Option[_])*) = {
      val builder = new StringBuilder(i18n(string) + SpaceDivider)

      if (value.size == 1) {
        builder.append(s"${value.head._1}${value.head._2.fold("")(snd => s" + $snd")}")
        //LogHelper.info(builder.toString())
      } else {
        builder.append(s"(${value.map(_._1).mkString(", ")})")
        if(!value.map(_._2).forall(_.isEmpty)) {
          builder.append(" + ")
          builder.append(s"(${value.map(_._2.fold("0")(_.toString)).mkString(", ")})")
        }
      }

      builder.mkString
    }

    def i18nDanmakuValue(string: String, value: (_, Option[_])*) = i18nValue(s"item.danmaku.$string", value: _*)
    def i18nCraftingValue(string: String, value: (_, Option[_])*) = i18nValue(s"crafting.danmaku.$string", value: _*)

    draw(i18nCrafting("copy"), 18, 150, 0x404040)
    draw(i18nDanmaku("amount"), 54, 150, 0x404040)
    draw(i18nDanmaku("pattern"), 20, 184, 0x404040)
    draw(i18n("container.inventory"), 88, ySize - 96 + 2, 0x404040)

    container.createContext.foreach { ctx =>
      val current = ctx.shotCurrent
      val result  = ctx.shotResult

      val amountCurrent  = ctx.amountCurrent
      val amountCombined = ctx.amountCombined

      val endsAt = drawAll(14, 10, 10,
        Seq(
          i18nDanmakuTranslate("form", result.filter(_.form != null).fold(current.form)(_.form)),
          i18nDanmaku2("color", s"color.${result.filter(_.color != -1).fold(current.color)(_.color)}"),
          i18nDanmakuValue("damage", current.damage -> result.map(_.damage)),
          i18nDanmakuValue("size", current.sizeX -> result.map(_.sizeX), current.sizeY -> result.map(_.sizeY), current.sizeZ -> result.map(_.sizeZ)),
          i18nDanmakuValue("speed", ctx.speedCurrent -> ctx.speedResult),
          i18nDanmakuValue("gravity", toTuple(ctx.gravityCurrent, ctx.gravityResult): _*),
          i18nDanmakuValue("amount", amountCurrent -> amountCombined.map(_ - amountCurrent)),
          i18nDanmaku2("pattern", "pattern." + ctx.patternResult(ctx.usedAmount).getOrElse(ctx.patternCurrent)),
          i18nCraftingValue("delay", current.delay -> result.map(_.delay)),
          i18nCraftingValue("end", current.end     -> result.map(_.end)),
          i18nDanmakuTranslate("subentity", result.filter(_.subEntity != null).fold(current.subEntity)(_.subEntity))
        )
      )

      val currentScore  = TouhouHelper.getDanmakuCoreData(invPlayer.player).toOption.map(_.getScore).getOrElse(0)
      val requiredScore = ctx.requiredScore
      val color         = if (currentScore >= requiredScore) 0x00FF00 else 0xFF0000

      draw(i18n("crafting.danmaku.scoreCost") + SpaceDivider + requiredScore, 14, endsAt, color)
    }
  }

  protected def drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
    GlStateManager.color(1F, 1F, 1F, 1F)
    mc.getTextureManager.bindTexture(Texture)
    val startX = (width - xSize) / 2
    val startY = (height - ySize) / 2
    drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize)
  }
}
