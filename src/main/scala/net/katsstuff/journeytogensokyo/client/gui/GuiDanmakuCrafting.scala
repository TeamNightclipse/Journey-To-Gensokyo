/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.gui

import net.katsstuff.danmakucore.data.Vector3
import net.katsstuff.danmakucore.handler.ConfigHandler
import net.katsstuff.journeytogensokyo.container.ContainerDanmakuCrafting
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class GuiDanmakuCrafting(invPlayer: InventoryPlayer, world: World, pos: BlockPos) extends GuiContainer(new ContainerDanmakuCrafting(invPlayer, world,
	pos)) {

	final val Texture      = new ResourceLocation(LibMod.Id, "textures/gui/danmaku_crafting_table.png")
	final val SpaceDivider = " : "
	final val White        = 0xFFFFFF

	xSize = 256
	ySize = 256

	private val container = inventorySlots.asInstanceOf[ContainerDanmakuCrafting]

	override protected def drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int) {
		def toTuple(vector1: Vector3, vector2: Vector3) = Seq((vector1.x, vector2.x), (vector1.y, vector2.y), (vector1.z, vector2.z))
		def draw(string: String, x: Int, y: Int, color: Int = White) = fontRendererObj.drawString(string, x, y, color)
		def i18n(string: String) = I18n.format(string)
		def i18nDanmaku(string: String) = i18n(s"item.danmaku.$string")
		def i18nDanmaku2(string1: String, string2: String) = i18nDanmaku(string1) + SpaceDivider + i18nDanmaku(string2)
		def i18nDanmakuValue(string: String, value: (_, _)*) = {
			val builder = new StringBuilder(i18nDanmaku(string))

			value.foreach(t => builder.append(SpaceDivider, t._1))
			builder.append(" + ")
			value.foreach(t => builder.append(SpaceDivider, t._2))

			builder.mkString
		}

		draw(i18n("crafting.danmaku.copy"), 18, 150, 4210752)
		draw(i18nDanmaku("amount"), 54, 150, 4210752)
		draw(i18nDanmaku("pattern"), 20, 184, 4210752)
		draw(i18n("container.inventory"), 88, ySize - 96 + 2, 4210752)


		container.danmaku match {
			case Some(stack) =>
				val multiplier = stack.stackSize
				val current = container.shotCurrent(stack)

				val amountCurrent = container.amountCurrent(stack)
				val amountResult = container.amountResult(stack)
				val amountTotal = {
					val maxNumber = ConfigHandler.danmaku.danmakuMaxNumber
					val total = amountCurrent + amountResult
					if(total > maxNumber) maxNumber else total
				}

				draw(i18nDanmakuValue("amount", (amountCurrent, amountResult)), 14, 70)

				container.recipe match {
					case Some(recipe) =>
						val result = container.shotResult(multiplier, recipe)

						draw(i18nDanmaku2("form", s"form.${if(result.form == null) current.form else result.form}"), 14, 10)
						draw(i18nDanmaku2("color", s"color.${if(result.color == -1) current.color else result.color}"), 14, 20)
						draw(i18nDanmakuValue("damage", (current.damage, result.damage)), 14, 30)
						draw(i18nDanmakuValue("size", (current.sizeX, result.sizeX), (current.sizeY, result.sizeY), (current.sizeZ, result.sizeZ)), 14, 40)
						draw(i18nDanmakuValue("speed", (container.speedCurrent(stack), container.speedResult(multiplier, recipe))), 14, 50)
						draw(i18nDanmakuValue("gravity", toTuple(container.gravityCurrent(stack), container.gravityResult(multiplier, recipe)): _*), 14, 60)
						draw(i18nDanmaku2("pattern", "pattern." + container.getPattern(amountTotal, stack)), 14, 80)
						draw(i18nDanmakuValue("delay", (current.delay, result.delay)), 14, 90)
						draw(i18nDanmakuValue("end", (current.end, result.end)), 14, 100)
						draw(i18nDanmaku2("subentity", s"subentity.${if(result.subEntity == null) current.subEntity else result.subEntity}"), 14, 110)
					case None =>
						val gravity = container.gravityCurrent(stack)

						draw(i18nDanmaku2("form", s"form.${current.form}"), 14, 10)
						draw(i18nDanmaku2("color", s"color.${current.color}"), 14, 20)
						draw(i18nDanmaku("damage") + s" ${current.damage}", 14, 30)
						draw(i18nDanmaku("size") + s" ${current.sizeX}, ${current.sizeY}, ${current.sizeZ}", 14, 40)
						draw(i18nDanmaku("speed") + s" ${container.speedCurrent(stack)}", 14, 50)
						draw(i18nDanmaku("gravity") + s" ${gravity.x}, ${gravity.y}, ${gravity.z}", 14, 60)
						draw(i18nDanmaku2("pattern", "pattern." + container.getPattern(amountTotal, stack)), 14, 80)
						draw(i18nDanmaku("delay" + s" ${current.delay}"), 14, 90)
						draw(i18nDanmaku("end" + s" ${current.end}"), 14, 100)
						draw(i18nDanmaku2("subentity", s"subentity.${current.subEntity}"), 14, 110)
				}
			case None =>
		}
	}

	protected def drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F)
		mc.getTextureManager.bindTexture(Texture)
		val startX = (width - xSize) / 2
		val startY = (height - ySize) / 2
		drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize)
	}
}
