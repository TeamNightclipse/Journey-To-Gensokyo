package net.katsstuff.journeytogensokyo.client.render

import net.katsstuff.journeytogensokyo.client.model.ModelHellRaven
import net.katsstuff.journeytogensokyo.entity.living.EntityHellRaven
import net.katsstuff.journeytogensokyo.lib.LibMod
import net.minecraft.client.renderer.entity.{RenderLiving, RenderManager}
import net.minecraft.util.ResourceLocation

class RenderHellRaven(renderManager: RenderManager) extends RenderLiving[EntityHellRaven](renderManager, ModelHellRaven, 0.5F) {
  protected def getEntityTexture(entity: EntityHellRaven) = new ResourceLocation(LibMod.Id, "textures/entity/mob/hell_raven.png")
}
