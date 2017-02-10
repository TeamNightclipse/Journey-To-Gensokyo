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

import net.katsstuff.journeytogensokyo.client.model.RedFairyModel
import net.katsstuff.journeytogensokyo.client.render.RenderFairy._
import net.katsstuff.journeytogensokyo.entity.living.EntityFairy
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.model.ModelBase
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation

object RenderFairy {

  final private val DeadTex = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_dead.png")

  final private val RedTex    = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_red.png")
  final private val BlueTex   = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_blue.png")
  final private val GreenTex  = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_green.png")
  final private val YellowTex = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_yellow.png")

  final private val MoonBlueTex   = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_blue.png")
  final private val MoonRedTex    = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_red.png")
  final private val MoonPurpleTex = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_purple.png")
  final private val MoonYellowTex = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_moon_yellow.png")

  final private val Gray = new ResourceLocation(LibMod.Id, "textures/entity/living/fairy_gray.png")
}

class RenderFairy(renderManager: RenderManager) extends RenderLiving[EntityFairy](renderManager, RedFairyModel, 0.5F) {

  override def doRender(entity: EntityFairy, x: Double, y: Double, z: Double, entityYaw: Float, partialTicks: Float): Unit = {
    mainModel = modelForEntity(entity)
    super.doRender(entity, x, y, z, entityYaw, partialTicks)
  }

  override def getEntityTexture(entity: EntityFairy): ResourceLocation = (entity.form: @switch) match {
    case -1 => DeadTex

    case 0 => RedTex
    case 1 => BlueTex
    case 2 => GreenTex
    case 3 => YellowTex

    case 10 => MoonBlueTex
    case 11 => MoonRedTex
    case 12 => MoonPurpleTex
    case 13 => MoonYellowTex

    case _ => Gray
  }

  private def modelForEntity(entity: EntityFairy): ModelBase = (entity.form: @switch) match {
    case 0 => RedFairyModel
  }
}
