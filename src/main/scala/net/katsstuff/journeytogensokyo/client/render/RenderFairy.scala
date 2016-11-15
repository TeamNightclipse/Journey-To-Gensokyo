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
import net.katsstuff.journeytogensokyo.client.render.model.ModelFairy
import net.katsstuff.journeytogensokyo.entity.living.EntityFairy
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation

object RenderFairy {

	final private val HELL        = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_hell.png")

	final private val BLUE        = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_blue.png")
	final private val RED         = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_red.png")
	final private val GREEN       = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_green.png")
	final private val YELLOW      = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_yellow.png")

	final private val MOON_BLUE   = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_blue.png")
	final private val MOON_RED    = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_red.png")
	final private val MOON_PURPLE = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_purple.png")
	final private val MOON_YELLOW = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_yellow.png")

	final private val GRAY        = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_gray.png")
}

class RenderFairy(renderManager: RenderManager) extends RenderLiving[EntityFairy](renderManager, ModelFairy, 0.5F) {

	override def getEntityTexture(entity: EntityFairy): ResourceLocation = (entity.form: @switch) match {
		case -1 => HELL

		case 0 => BLUE
		case 1 => RED
		case 2 => GREEN
		case 3 => YELLOW

		case 10 => MOON_BLUE
		case 11 => MOON_RED
		case 12 => MOON_PURPLE
		case 13 => MOON_YELLOW

		case _ => GRAY
	}
}
