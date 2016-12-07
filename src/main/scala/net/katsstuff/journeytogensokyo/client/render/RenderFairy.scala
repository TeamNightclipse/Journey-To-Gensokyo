/*
 * This class was created by <Katrix>. It's distributed as
 * part of the Journey To Gensokyo Mod. Get the Source Code in github:
 * https://github.com/Katrix-/JTG
 *
 * Journey To Gensokyo is Open Source and distributed under the
 * a modifed Botania license: https://github.com/Katrix-/JTG/blob/master/LICENSE.md
 */
package net.katsstuff.journeytogensokyo.client.render

import scala.annotation.switch

import net.katsstuff.journeytogensokyo.client.render.RenderFairy._
import net.katsstuff.journeytogensokyo.entity.living.EntityFairy
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation

object RenderFairy {

	final private val Dead = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_dead.png")

	final private val Blue   = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_blue.png")
	final private val Red    = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_red.png")
	final private val Green  = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_green.png")
	final private val Yellow = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_yellow.png")

	final private val MoonBlue   = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_blue.png")
	final private val MoonRed    = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_red.png")
	final private val MoonPurple = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_purple.png")
	final private val MoonYellow = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_yellow.png")

	final private val Gray = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_gray.png")
}

class RenderFairy(renderManager: RenderManager) extends RenderLiving[EntityFairy](renderManager, ModelFairy, 0.5F) {

	override def getEntityTexture(entity: EntityFairy): ResourceLocation = (entity.form: @switch) match {
		case -1 => Dead

		case 0 => Blue
		case 1 => Red
		case 2 => Green
		case 3 => Yellow

		case 10 => MoonBlue
		case 11 => MoonRed
		case 12 => MoonPurple
		case 13 => MoonYellow

		case _ => Gray
	}
}
