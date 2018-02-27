/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/devDanmakuCore/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.gui

import java.text.NumberFormat

import net.katsstuff.danmakucore.misc.Translatable
import net.katsstuff.danmakucore.scalastuff.TouhouHelper
import net.katsstuff.journeytogensokyo.container.ContainerDanmakuCrafting
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.katsstuff.mirror.data.Vector3
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class GuiDanmakuCrafting(invPlayer: InventoryPlayer, world: World, pos: BlockPos)
    extends GuiContainer(new ContainerDanmakuCrafting(invPlayer, world, pos)) {

  final val Texture      = new ResourceLocation(LibMod.Id, "textures/gui/danmaku_crafting_table.png")
  final val SpaceDivider = " : "
  final val White        = 0xFFFFFF

  xSize = 256
  ySize = 256

  private val container = inventorySlots.asInstanceOf[ContainerDanmakuCrafting]

  override protected def drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int): Unit = {
    def tupled(vector1: Vector3, vector2: Option[Vector3]) =
      Seq((vector1.x, vector2.map(_.x)), (vector1.y, vector2.map(_.y)), (vector1.z, vector2.map(_.z)))

    def draw(string: String, x: Int, y: Int, color: Int = White) = fontRenderer.drawString(string, x, y, color)

    def drawAll(x: Int, startY: Int, incrementY: Int, strings: Seq[String]): Int = {
      for (i <- strings.indices) draw(strings(i), x, startY + incrementY * i)
      startY + incrementY * strings.length
    }

    def i18n(string: String)                                   = I18n.format(string)
    def i18nPrefix(prefix: String)                             = (str: String) => i18n(s"$prefix.$str")
    def divided[A, B](first: A => String, second: B => String) = first(_: A) + SpaceDivider + second(_: B)

    def i18nTranslatable(translatable: Translatable) = i18n(translatable.unlocalizedName)

    val i18nDanmaku          = i18nPrefix("item.danmaku")
    val i18nDanmakuDivided   = divided(i18nDanmaku, i18nDanmaku)
    val i18nDanmakuTranslate = divided(i18nDanmaku, i18nTranslatable)
    val i18nCrafting         = i18nPrefix("crafting.danmaku")

    def i18nOptPlus[A](name: String, values: (A, Option[A])*)(implicit numeric: Numeric[A]) = {
      val builder   = new StringBuilder(i18n(name) + SpaceDivider)
      val formatter = NumberFormat.getNumberInstance

      def format(a: A): String = formatter.format(numeric.toDouble(a))

      if (values.size == 1) {
        val value  = values.head
        val before = format(value._1)
        val after  = value._2.filter(_ != 0).map(format)
        builder.append(s"$before${after.fold("")(s => s" + $s")}")
      } else {
        builder.append(s"(${values.map(t => format(t._1)).mkString(", ")})")
        if (!values.map(_._2).forall(opt => opt.isEmpty || opt.contains(0))) {
          builder.append(" + ")
          builder.append(s"(${values.map(_._2.fold(numeric.zero.toString)(format)).mkString(", ")})")
        }
      }

      builder.mkString
    }

    def i18nPlus[A](name: String, values: (A, A)*)(implicit numeric: Numeric[A]) =
      i18nOptPlus(name, values.map(t => t._1 -> Some(t._2)): _*)

    def i18nDanmakuOptPlus[A: Numeric](string: String, value: (A, Option[A])*) =
      i18nOptPlus(s"item.danmaku.$string", value: _*)

    def i18nDanmakuPlus[A: Numeric](string: String, value: (A, A)*) =
      i18nPlus(s"item.danmaku.$string", value: _*)

    def i18nCraftingPlus[A: Numeric](string: String, value: (A, Option[A])*) =
      i18nOptPlus(s"crafting.danmaku.$string", value: _*)

    draw(i18nCrafting("copy"), 18, 150, 0x404040)
    draw(i18nDanmaku("amount"), 54, 150, 0x404040)
    draw(i18nDanmaku("pattern"), 20, 184, 0x404040)
    draw(i18n("container.inventory"), 88, ySize - 96 + 2, 0x404040)

    container.createContext.foreach { ctx =>
      val current = ctx.shotCurrent
      val result  = ctx.shotResult

      val amountCurrent  = ctx.amountCurrent
      val amountCombined = ctx.amountCombined

      val endsAt = drawAll(
        x = 14,
        startY = 10,
        incrementY = 10,
        strings = Seq(
          i18nDanmakuTranslate("form", result.filter(_.form != null).fold(current.form)(_.form)),
          i18nDanmakuDivided(
            "mainColor",
            s"color.${result.filter(_.edgeColor != -1).fold(current.mainColor)(_.edgeColor)}"
          ),
          i18nDanmakuDivided(
            "secondaryColor",
            s"color.${result.filter(_.coreColor != -1).fold(current.secondaryColor)(_.coreColor)}"
          ),
          i18nDanmakuOptPlus("damage", current.damage -> result.map(_.damage)),
          i18nDanmakuOptPlus(
            "size",
            current.sizeX -> result.map(_.sizeX),
            current.sizeY -> result.map(_.sizeY),
            current.sizeZ -> result.map(_.sizeZ)
          ),
          i18nDanmakuOptPlus("speed", ctx.speedCurrent -> ctx.speedResult),
          i18nDanmakuOptPlus("gravity", tupled(ctx.gravityCurrent, ctx.gravityResult): _*),
          i18nDanmakuPlus("amount", amountCurrent -> (amountCombined - amountCurrent)),
          i18nDanmakuDivided(
            "pattern",
            "pattern." + ctx.patternResult(ctx.amountCombined).getOrElse(ctx.patternCurrent)
          ),
          i18nCraftingPlus("delay", current.delay -> result.map(_.delay)),
          i18nCraftingPlus("end", current.end     -> result.map(_.end)),
          i18nDanmakuTranslate("subentity", result.filter(_.subEntity != null).fold(current.subEntity)(_.subEntity))
        )
      )

      val currentScore  = TouhouHelper.getDanmakuCoreData(invPlayer.player).map(_.getScore).getOrElse(0)
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
